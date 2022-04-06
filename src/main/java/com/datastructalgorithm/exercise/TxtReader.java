package com.datastructalgorithm.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pi
 * @date 2021/07/01 16:57:49
 **/
public class TxtReader {
    private String filePath;

    public TxtReader(String filePath) {
        this.filePath = filePath;
    }

    public String readFile() {
        FileReader fileReader = null;
        char[] readChar = new char[1024];
        String result = null;
        try {
            fileReader = new FileReader(this.filePath);
            int readLength = 0;
            while ((readLength = fileReader.read(readChar)) != -1) {
                result = new String(readChar, 0, readLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public List<String> readFileLineByLine() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<String> result = new ArrayList<>();
        try {
            fileReader = new FileReader(this.filePath);
            bufferedReader = new BufferedReader(fileReader);
            String lineString = null;
            while ((lineString = bufferedReader.readLine()) != null) {
                result.add(lineString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
