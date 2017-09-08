package com.iyzipay;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IyzipaySSLSocketFactory extends SSLSocketFactory {

    private static final IyzipaySSLSocketFactory instance = new IyzipaySSLSocketFactory();
    private static final String TLS_V12_PROTOCOL = "TLSv1.2";

    private SSLSocketFactory defaultFactory;
    private boolean tlsv12Supported;

    static IyzipaySSLSocketFactory getInstance() {
        return instance;
    }

    private IyzipaySSLSocketFactory() {
        this.defaultFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        setTlsV12IfSupported();
    }

    private boolean isTlsv12Supported() {
        return tlsv12Supported;
    }

    private void setTlsV12IfSupported() {
        String[] supportedProtocols = new String[0];
        try {
            supportedProtocols = SSLContext.getDefault().getSupportedSSLParameters().getProtocols();
        } catch (NoSuchAlgorithmException ignored) {
        }

        for (String protocol : supportedProtocols) {
            if (protocol.equals(TLS_V12_PROTOCOL)) {
                this.tlsv12Supported = true;
            }
        }
    }

    private Socket prepareSocket(Socket socket) {
        if (!(socket instanceof SSLSocket)) {
            return socket;
        }

        SSLSocket sslSocket = (SSLSocket) socket;

        Set<String> enabledProtocols = new HashSet<String>(Arrays.asList(sslSocket.getEnabledProtocols()));
        if (isTlsv12Supported()) {
            enabledProtocols.add(TLS_V12_PROTOCOL);
        }

        sslSocket.setEnabledProtocols(enabledProtocols.toArray(new String[0]));
        return sslSocket;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return this.defaultFactory.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return this.defaultFactory.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return prepareSocket(this.defaultFactory.createSocket(socket, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return prepareSocket(this.defaultFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return prepareSocket(this.defaultFactory.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return prepareSocket(this.defaultFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return prepareSocket(this.defaultFactory.createSocket(address, port, localAddress, localPort));
    }
}