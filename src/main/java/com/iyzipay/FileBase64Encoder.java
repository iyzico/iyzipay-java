package com.iyzipay;

import com.iyzipay.exception.FileEncodingException;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileBase64Encoder {

    private FileBase64Encoder() {
    }

    public static String encode(String filePath) {
        FileInputStream fileInputStream = null;
        byte[] fileContent;

        try {
            File file = new File(filePath);
            fileContent = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileContent);
        } catch (IOException e) {
            throw new FileEncodingException("File content couldn't be read", e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new FileEncodingException("File resource couldn't be released", e);
                }
            }
        }

        return DatatypeConverter.printBase64Binary(fileContent);
    }
}