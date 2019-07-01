package com.marksman.architectures.base.constant;

import java.math.BigDecimal;

/**
 * @author Wei Laibao
 * @date 2019/7/1 16:41
 * @description 数字常量
 **/
public class NumberConstant {

    /**
     * BigDecimal(0)
     */
    public static final BigDecimal BIG_DECIMAL_0 = new BigDecimal(0);

    /**
     * BigDecimal(100)
     */
    public static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);

    /**
     * BigDecimal(100)
     */
    public static final BigDecimal BIG_DECIMAL_1000 = new BigDecimal(1000);

    /**
     * BigDecimal(10000)
     */
    public static final BigDecimal BIG_DECIMAL_10000 = new BigDecimal(10000);

    /**
     * 默认分页参数开始页
     */
    public static final int DEFAULT_PAGE_INDEX = 1;

    /**
     * 默认分页参数页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 一分钟的秒数
     */
    public static final int MINUTE_SECONDS = 60;

    /**
     * 一个小时的秒数
     */
    public static final int HOUR_SECONDS = 60 * 60;

    /**
     * 一天小时的秒数
     */
    public static final long DAY_SECONDS = 60 * 60 * 1000 * 24;
}
