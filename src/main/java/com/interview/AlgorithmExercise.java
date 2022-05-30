package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pi
 * @date 2022/05/16 21:37:09
 **/
public class AlgorithmExercise {

    public int countLastWordLength(String testInputString) {
        if (testInputString == null || "".equals(testInputString)) {
            throw new NullPointerException("输入的字符串不能为空");
        }
        if (testInputString.length() > 5000) {
            throw new IndexOutOfBoundsException("输入的字符串太长，不能超过5000");
        }
        String[] splitWords = testInputString.split(" ");
        String lastWord = splitWords[splitWords.length - 1];
        int wordLength = lastWord.length();
        return wordLength;
    }

    public int countCharInString(String inputString, String matchChar) {
        Pattern pattern = Pattern.compile(matchChar, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        int result = 0;
        while (matcher.find()) {
            result++;
        }
        return result;
    }

    public List<String> outputStringSplitByLength8(String testInputStr) {
        int splitLength = 8;
        List<String> stringsWhenLengthLessThan8 = getStringsWhenLengthLessThan8(testInputStr, splitLength);

        if (stringsWhenLengthLessThan8.size() > 0) {
            return stringsWhenLengthLessThan8;
        }

        return getStringWhenLengthMoreThan8(testInputStr, splitLength);
    }

    private List<String> getStringWhenLengthMoreThan8(String testInputStr, int splitLength) {
        List<String> result = new ArrayList<>();
        int inputStringLength = testInputStr.length();
        int loop = inputStringLength / splitLength;
        int baseIndex = 0;
        for (int i = 1; i <= loop; i++) {
            String subString = testInputStr.substring(baseIndex, splitLength * loop);
            baseIndex += (splitLength + 1);
            result.add(subString);
        }
        int remainStringCount = inputStringLength % splitLength;
        String remainString = testInputStr.substring(inputStringLength - remainStringCount, inputStringLength);
        List<String> remainStringFilledTo8 = getStringsWhenLengthLessThan8(remainString, splitLength);
        result.addAll(remainStringFilledTo8);
        return result;
    }

    private List<String> getStringsWhenLengthLessThan8(String testInputStr, int splitLength) {
        List<String> result = new ArrayList<>();
        if (testInputStr.length() < splitLength) {
            StringBuilder buffer = new StringBuilder(testInputStr);
            for (int i = 0; i < splitLength - testInputStr.length(); i++) {
                buffer.append("0");
            }
            result.add(buffer.toString());
        }
        return result;
    }
}
