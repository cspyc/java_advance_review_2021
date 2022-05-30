package com.interview;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author pi
 * @date 2022/05/16 21:35:26
 **/
public class AlgorithmExerciseTest {

    private static AlgorithmExercise algorithmExercise;

    @BeforeAll
    public static void initialObject() {
        algorithmExercise = new AlgorithmExercise();
    }

    /**
     * 描述
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * 输入描述：
     * <p>
     * 输入一行，代表要计算的字符串，非空，长度小于5000。
     * 输出描述：
     * <p>
     * 输出一个整数，表示输入字符串最后一个单词的长度。
     *
     * @throws Exception
     */
    @Test
    public void should_count_last_word_length() {
        String testInputString = "hello nowcoder";
        int length = algorithmExercise.countLastWordLength(testInputString);
        int expectedResultLength = 8;
        Assertions.assertThat(length).isEqualTo(expectedResultLength);
    }

    @Test
    public void should_should_throw_exception_message_when_input_string_is_illegal() {
        Throwable throwable = assertThrows(NullPointerException.class, () -> {
            algorithmExercise.countLastWordLength("");
        });

        assertAll(
                () -> assertEquals("输入的字符串不能为空", throwable.getMessage())
        );
    }

    @Test
    public void should_throw_null_exception_message_when_input_string_is_empty() throws Exception {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            algorithmExercise.countLastWordLength("");
        });
        assertAll(() -> assertEquals("输入的字符串不能为空", exception.getMessage()));
    }

    @Test
    public void should_throw_input_string_is_too_long() throws Exception {
        StringBuffer sb = new StringBuffer(5100);
        for (int i = 0; i <= 5000; i++) {
            sb.append("a");
        }
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            algorithmExercise.countLastWordLength(sb.toString());
        });
        assertAll(() ->
                assertEquals("输入的字符串太长，不能超过5000", exception.getMessage())
        );
    }

    /**
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     * <p>
     * 数据范围： 1≤n≤1000 1 \le n \le 1000 \ 1≤n≤1000
     * 输入描述：
     * <p>
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
     * 输出描述：
     * <p>
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     */

    @Test
    public void should_count_a_char_in_a_string() throws Exception {
        String testString = "ABCabc";
        String matchChar = "A";
        int exceptedResult = 2;
        int actualResult = algorithmExercise.countCharInString(testString, matchChar);
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void should_count_a_char_in_a_cj() throws Exception {
        String testString = "c";
        String matchChar = "j";
        int exceptedResult = 0;
        int actualResult = algorithmExercise.countCharInString(testString, matchChar);
        assertEquals(exceptedResult, actualResult);
    }

    /**
     * 描述
     * <p>
     * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述：
     * <p>
     * 连续输入字符串(每个字符串长度小于等于100)
     * 输出描述：
     * <p>
     * 依次输出所有分割后的长度为8的新字符串
     * 示例1
     * 输入：
     * abc
     * 输出：
     * abc00000
     */
    @Test
    public void should_fill_with_0_where_str_length_less_than_8() throws Exception {
        String testInputStr = "abc";
        String expectedResult = "abc00000";
        List<String> actualStr = algorithmExercise.outputStringSplitByLength8(testInputStr);

        assertEquals(expectedResult, actualStr.get(0));
    }

    @Test
    public void should_split_str_if_length_more_than_8() throws Exception {
        String testInputStr = "abc1234567";
        List<String> actualStrList = algorithmExercise.outputStringSplitByLength8(testInputStr);
        String expectedStr_1 = "abc12345";
        String expectedStr_2 = "67000000";

        assertEquals(expectedStr_1,actualStrList.get(0));
        assertEquals(expectedStr_2,actualStrList.get(1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        String convertToStr = String.valueOf(a);
        HashMap<String, String> existedNum = new HashMap<>();
        StringBuffer result = new StringBuffer();
        for (int i = convertToStr.length() - 1; i >= 0; i--) {
            char readChar = convertToStr.charAt(i);
            String readString = String.valueOf(readChar);
            String cachedStr = existedNum.get(readString);

            if (cachedStr == null) {
                existedNum.put(readString, readString);
                result.append(readString);
            }

        }
        System.out.println(result.toString());

    }
}
