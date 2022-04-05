package com.basicgrammer.netprogramming.homework;

import java.io.*;
import java.net.Socket;

/**
 * @author pi
 * @date 2021/05/15 10:08:35
 **/
public class IoStreamUtil {

    public String receiveMessageByBufferedReader(InputStream inputStream) throws IOException {
        String allContent = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String readContent = "";
        while ((readContent = br.readLine()) != null) {
            allContent += readContent;
        }
        return allContent;
    }

    public void sendMessageByBufferedWriter(OutputStream outputStream, String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(message);
    }
}
