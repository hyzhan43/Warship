package com.hy.zhan.springbootwarship.utils;

import com.hy.zhan.springbootwarship.config.DateFormatConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * author :  HyJame
 * date  :   2020/1/14
 * desc :    localDate 工具类
 */
public class LocalDateUtils {

    /**
     * 获得某天最小时间
     *
     * @param time such as "2019-11-09"
     * @return timestamp 返回当天 2019-11-09 00:00:00 时间戳
     */
    public static long getStartOfDay(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConfig.DATE_FORMAT);
        try {
            LocalDateTime localDateTime = LocalDate.parse(time, formatter).atStartOfDay();
            return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
