package com.hy.zhan.springbootwarship.utils;

import com.hy.zhan.springbootwarship.config.DateFormatConfig;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.hy.zhan.springbootwarship.consts.DateUnit.DAY;

/**
 * author :  HyJame
 * date  :   2020/1/14
 * desc :    what
 */
public class LocalTimeUtils {

    /**
     * @param time such as "10:45:00"
     * @return timestamp
     */
    public static long string2Timestamp(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConfig.TIME_FORMAT);
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(time, formatter);
            return localTime.toSecondOfDay();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param timestamp 时间戳
     * @return format string, such as "10:45:00"
     */
    public static String timestamp2TimeString(long timestamp) {

        if (timestamp > DAY) {
            timestamp = timestamp % DAY;
        }

        if (timestamp == DAY) {
            return "24:00:00";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConfig.TIME_FORMAT);
        LocalTime localTime = LocalTime.ofSecondOfDay(timestamp);
        return formatter.format(localTime);
    }
}
