package com.basicgrammer.iostream;

/**
 * @author Pi
 * @date 2021-05-09 15:38
 */
public class TestBufferedDecorator {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFile();
        //bufferedReader_.readFile();
        //Serializable
        //Externalizable
        //ObjectInputStream
        //ObjectOutputStream
        //这次希望通过 BufferedReader_ 多次读取字符串
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.readStrings(5);
    }
}

abstract class Reader_ {
    void readFile() {
    }

    void readString() {
    }
}

class StringReader_ extends Reader_ {

    void readString() {
        System.out.println("读取字符串");
    }
}

class FileReader_ extends Reader_ {
    void readFile() {
        System.out.println("读取文件");
    }
}

class BufferedReader_ extends Reader_ {
    Reader_ reader_;

    //接收Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    void readFile() {//封装一层
        reader_.readFile();
    }

    @Override
    void readString() {//封装一层
        reader_.readString();
    }

    //让方法更加灵活， 多次读取文件, 或者加缓冲byte[] ....
    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展 readString, 批量处理字符串数据
    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
