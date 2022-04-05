package com.basicgrammer.stringbuffer;

/**
 * @author Pi
 * @date 2021-04-16 16:23
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        //需求：输入商品名称和商品价格，要求打印效果示例，使用前面学习的方法完成：
        //  商品名   商品价格
        //   手机     123,543.59
        //要求：价格的小数点前面每三位用逗号隔开
        System.out.println("商品名\t商品价格");
        System.out.println(showGoodInfo("手机", "3456789.59"));

        System.out.println("===========格式化方法2===================");
        System.out.println(showGoodInfo2("电脑", 12332131.11));

    }

    private static String showGoodInfo(String goodsName, String goodsPrice) {
        String result = "";
        if (goodsPrice != null) {
            String[] prices = goodsPrice.split("\\.");
            String pointLeft = prices[0];
            //第一个插入点
            int firstInsertIndex = goodsPrice.length() % 3;
            //除第一个插入点后，还需要插入的个数
            int splitCount = pointLeft.length() / 3 - 1;
            StringBuffer priceBuffer = new StringBuffer(pointLeft);
            if (firstInsertIndex > 0) {
                priceBuffer.insert(firstInsertIndex, ",");
            }
            for (int i = 0; i < splitCount; i++) {
                priceBuffer.insert(firstInsertIndex + 1 + 3, ",");
            }
            result = goodsName + "\t" + priceBuffer.toString() + "." + prices[1];
        }
        return result;
    }

    private static String showGoodInfo2(String goodName, double goodsPrice) {
        String result = "";

        String formatPrice = String.format("%,f", goodsPrice);
        result = goodName + "\t" + formatPrice;
        return result;
    }
}
