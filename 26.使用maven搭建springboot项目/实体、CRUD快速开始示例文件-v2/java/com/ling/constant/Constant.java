package com.ling.constant;

/**
 * 常量类
 */
public final class Constant {
    // 图片验证码常量
    public static final String CHECK_CODE = "CHECK_CODE";               // 图片验证码key
    public static final String CHECK_CODE_EMAIL = "CHECK_CODE_EMAIL";   // 发送邮箱的图片验证码key

    // 数字常量
    public static final int NUM_0 = 0;
    public static final int NUM_1 = 1;
    public static final int NUM_2 = 2;
    public static final int NUM_3 = 3;
    public static final int NUM_5 = 5;
    public static final int NUM_10 = 10;
    public static final int NUM_15 = 15;

    // 时间常量 (以毫秒为单位)
    public static final long MIN_1_TO_MILLIS = 60000L;     // 1分钟毫秒值
    public static final long MIN_2_TO_MILLIS = 120000L;     // 2分钟毫秒值
    public static final long MIN_3_TO_MILLIS = 180000L;     // 3分钟毫秒值
    public static final long MIN_5_TO_MILLIS = 300000L;     // 5分钟毫秒值
    public static final long MIN_10_TO_MILLIS = 600000;    // 10分钟毫秒值
    public static final long MIN_15_TO_MILLIS = 900000L;    // 15分钟毫秒值

    // 小时和天的时间常量
    public static final long HOUR_1_TO_MILLIS = 3600000L;   // 1小时毫秒值
    public static final long DAY_1_TO_MILLIS = 86400000L;   // 1天毫秒值
    public static final long WEEK_1_TO_MILLIS = 604800000L; // 1周毫秒值

    // 字节大小常量
    public static final long BYTE = 1L;             // 字节
    public static final long KB = 1024L;            // 千字节
    public static final long MB = 1048576L;         // 兆字节
    public static final long GB = 1073741824L;      // 吉字节
    public static final long TB = 1099511627776L;   // 太字节

    // 文件扩展名常量
    public static final String FILE_EXTENSION_TXT = ".txt";   // 文本文件扩展名
    public static final String FILE_EXTENSION_PDF = ".pdf";   // PDF文件扩展名
    public static final String FILE_EXTENSION_JPG = ".jpg";   // 图片文件扩展名
    public static final String FILE_EXTENSION_PNG = ".png";   // 图片文件扩展名

    // 文件路径常量
    public static final String TEMP_FILE_PATH = "/tmp/";      // 临时文件路径


    private Constant() {

    }
}
