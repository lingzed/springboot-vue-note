package com.ling.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 字符工具类
 */
public class StrUtil {
    /**
     * 判空
     * "\t", "\n", "\r", null, "", "    ", "null", "  null   ",  均返回 true
     *
     * @param str 判空字符
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty() || str.trim().equals("null");
    }

    /**
     * 生成随机字符(数字+字母)
     *
     * @param len 生成的字符长度
     * @return
     */
    public static String getRandomStr(Integer len) {
        return RandomStringUtils.random(len, true, true);
    }

    /**
     * 生成随机字符(数字)
     * 保证重复率 < 1%, 若生成 1000 条随机字符, 则 len >= 8
     * 保证重复率 < 1%, 若生成 10000 条随机字符, 则 len >= 10
     * 保证重复率 < 1%, 若生成 100000 条随机字符, 则 len >= 12
     * 保证重复率 < 1%, 若生成 1000000 条随机字符, 则 len >= 14
     *
     * @param len 生成的字符长度
     * @return
     */
    public static String getRandomNum(Integer len) {
        return RandomStringUtils.random(len, false, true);
    }
}
