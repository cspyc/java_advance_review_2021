package com.basicgrammer.netprogramming.socket.tcpfilecopy;

import com.basicgrammer.base.Input;

import java.io.*;

/**
 * @author pi
 * @date 2021/05/14 15:03:22
 **/
public class StreamUtils {

    public static void readFromInputStreamAndWriteToOutputStream(BufferedInputStream bufferedInputStream,
                                                                 BufferedOutputStream bufferedOutputStream,
                                                                 InputStream inputStream,
                                                                 OutputStream outputStream) throws IOException {
        bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedOutputStream = new BufferedOutputStream(outputStream);
        int readLength = 0;
        byte[] readCache = new byte[1024];
        while ((readLength = bufferedInputStream.read(readCache)) != -1) {
            bufferedOutputStream.write(readCache, 0, readLength);
        }
        bufferedOutputStream.flush();
    }

    public static byte[] readDataIntoByteArray(InputStream inputStream) throws IOException {
        //创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b)) != -1) {
            //将读入的内容写到字节数组输出流中
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    public static String streamToString(InputStream inputStream) throws IOException {
        //创建读取字符流对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String content = "";
        while ((content = bufferedReader.readLine()) != null) {
            charArrayWriter.write(content);
        }
        return charArrayWriter.toString();
    }
}
