package com.oj.judge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StreamUtil {
    private static Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static String getOutPut(InputStream inputStream) {
        StringBuilder result = new StringBuilder("");
        try {
            byte[] buffer = new byte[1024];
            int length = 0;
            if (inputStream != null) {
                while ((length = inputStream.read(buffer)) != -1) {
                    result.append(new String(buffer, 0, length));
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return result.toString();
    }


    public static String setInPut(OutputStream outputStream, String inputFilePath) {
        StringBuilder sb = new StringBuilder();
        BufferedOutputStream bufferedOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            fileInputStream = new FileInputStream(inputFilePath);
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(buffer)) != -1) {
                sb.append(new String(buffer,0,length));
                bufferedOutputStream.write(buffer, 0, length);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
