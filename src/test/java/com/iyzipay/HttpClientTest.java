package com.iyzipay;

import com.iyzipay.exception.HttpClientException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class HttpClientTest {

    private ServerSocket plaintextServer;

    @Before
    public void start_plaintext_endpoint() throws IOException {
        plaintextServer = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
        Thread acceptor = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!plaintextServer.isClosed()) {
                    try {
                        respond_with_plaintext(plaintextServer.accept());
                    } catch (IOException ignored) {
                        // endpoint is stopped
                    }
                }
            }
        });
        acceptor.setDaemon(true);
        acceptor.start();
    }

    @After
    public void stop_plaintext_endpoint() throws IOException {
        plaintextServer.close();
    }

    @Test
    public void should_use_configured_ssl_socket_factory_for_connections() {
        RecordingSSLSocketFactory recordingFactory = new RecordingSSLSocketFactory();
        Options options = new Options();
        options.setSslSocketFactory(recordingFactory);

        try {
            HttpClient.create(options).get(endpoint(), null, IyzipayResource.class);
            fail("expected the request to fail after the stub factory was used");
        } catch (HttpClientException expected) {
            assertTrue("configured ssl socket factory should be used", recordingFactory.invoked);
        }
    }

    @Test
    public void should_use_configured_ssl_socket_factory_verbatim() {
        RecordingSSLSocketFactory recordingFactory = new RecordingSSLSocketFactory();
        Options options = new Options();
        options.setSslSocketFactory(recordingFactory);

        try {
            HttpClient.create(options).get(endpoint(), null, IyzipayResource.class);
            fail("expected the request to fail after the stub factory was used");
        } catch (HttpClientException expected) {
            assertFalse("sdk must not alter configured protocols or cipher suites", recordingFactory.socket.alteredBySdkShim);
        }
    }

    @Test
    public void should_keep_default_tls_path_when_no_factory_configured() {
        try {
            HttpClient.create(new Options()).get(endpoint(), null, IyzipayResource.class);
            fail("expected the TLS handshake against a plaintext endpoint to fail");
        } catch (HttpClientException expected) {
            assertNotNull(expected.getCause());
            assertTrue("default TLS path should be used", containsSslException(expected.getCause()));
        }
    }

    @Test
    public void should_include_cause_chain_in_failure_message() {
        try {
            HttpClient.create(new Options()).get(endpoint(), null, IyzipayResource.class);
            fail("expected the TLS handshake against a plaintext endpoint to fail");
        } catch (HttpClientException expected) {
            assertNotNull(expected.getCause());
            String message = expected.getMessage();
            Throwable current = expected.getCause();
            while (current != null) {
                assertTrue("message should include " + current.getClass().getSimpleName(), message.contains(current.getClass().getSimpleName()));
                current = current.getCause();
            }
        }
    }

    @Test
    public void should_attach_original_failure_as_cause_for_non_tls_errors() throws IOException {
        int closedPort = closed_port();

        try {
            HttpClient.create(new Options()).get("https://127.0.0.1:" + closedPort + "/", null, IyzipayResource.class);
            fail("expected the connection to be refused");
        } catch (HttpClientException expected) {
            assertNotNull(expected.getCause());
            assertTrue("original failure should be attached as cause", expected.getCause() instanceof IOException);
        }
    }

    private int closed_port() throws IOException {
        ServerSocket probe = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"));
        int port = probe.getLocalPort();
        probe.close();
        return port;
    }

    private boolean containsSslException(Throwable throwable) {
        Throwable current = throwable;
        while (current != null) {
            if (current instanceof SSLException) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }

    private String endpoint() {
        return "https://127.0.0.1:" + plaintextServer.getLocalPort() + "/";
    }

    private void respond_with_plaintext(Socket socket) {
        try {
            OutputStream output = socket.getOutputStream();
            output.write("HTTP/1.1 400 Bad Request\r\n\r\n".getBytes("US-ASCII"));
            output.flush();
        } catch (IOException ignored) {
            // best effort
        } finally {
            close_quietly(socket);
        }
    }

    private void close_quietly(Socket socket) {
        try {
            socket.close();
        } catch (IOException ignored) {
            // best effort
        }
    }

    static class RecordingSSLSocketFactory extends SSLSocketFactory {

        final RecordingSSLSocket socket = new RecordingSSLSocket();
        boolean invoked;

        @Override
        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override
        public Socket createSocket() {
            invoked = true;
            return socket;
        }

        @Override
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) {
            invoked = true;
            return this.socket;
        }

        @Override
        public Socket createSocket(String host, int port) {
            invoked = true;
            return socket;
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) {
            invoked = true;
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress host, int port) {
            invoked = true;
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) {
            invoked = true;
            return socket;
        }
    }

    static class RecordingSSLSocket extends SSLSocket {

        boolean alteredBySdkShim;

        @Override
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override
        public String[] getEnabledCipherSuites() {
            return new String[0];
        }

        @Override
        public void setEnabledCipherSuites(String[] suites) {
            alteredBySdkShim |= calledBySdkShim();
        }

        @Override
        public String[] getSupportedProtocols() {
            return new String[]{"TLSv1.2"};
        }

        @Override
        public String[] getEnabledProtocols() {
            return new String[]{"TLSv1.2"};
        }

        @Override
        public void setEnabledProtocols(String[] protocols) {
            alteredBySdkShim |= calledBySdkShim();
        }

        @Override
        public SSLSession getSession() {
            return null;
        }

        @Override
        public void addHandshakeCompletedListener(HandshakeCompletedListener listener) {
        }

        @Override
        public void removeHandshakeCompletedListener(HandshakeCompletedListener listener) {
        }

        @Override
        public void startHandshake() throws IOException {
            throw new IOException("stub ssl handshake");
        }

        @Override
        public void setUseClientMode(boolean mode) {
        }

        @Override
        public boolean getUseClientMode() {
            return true;
        }

        @Override
        public void setNeedClientAuth(boolean need) {
        }

        @Override
        public boolean getNeedClientAuth() {
            return false;
        }

        @Override
        public void setWantClientAuth(boolean want) {
        }

        @Override
        public boolean getWantClientAuth() {
            return false;
        }

        @Override
        public boolean getEnableSessionCreation() {
            return false;
        }

        @Override
        public void setEnableSessionCreation(boolean flag) {
        }

        private boolean calledBySdkShim() {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                if ("com.iyzipay.IyzipaySSLSocketFactory".equals(element.getClassName())) {
                    return true;
                }
            }
            return false;
        }
    }
}
