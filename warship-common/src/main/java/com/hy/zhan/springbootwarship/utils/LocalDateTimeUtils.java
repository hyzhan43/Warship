package com.hy.zhan.springbootwarship.utils;

import com.hy.zhan.springbootwarship.config.DateFormatConfig;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * author :  HyJame
 * date  :   2020/1/14
 * desc :    what
 */
public class LocalDateTimeUtils {

    /**
     * 获得某天最小时间
     *
     * @param timestamp (日期+时间)时间戳  such as "2019-11-09 10:00:00" 时间戳
     * @return 返回当天 2019-11-09 00:00:00 时间戳
     */
    public static long getStartOfDay(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.toEpochSecond(ZoneOffset.of("+8"));
    }



    /**
     * @param time such as "2019-11-09 10:45:00"
     * @return timestamp
     */
    public static long string2Timestamp(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConfig.DATE_TIME_FORMAT);
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(time, formatter);
            return dateTime.toEpochSecond(ZoneOffset.of("+8"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param timestamp (日期 + 时间)时间戳
     * @return format string, such as "2019-11-09 10:45:00"
     */
    public static String timestamp2String(long timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConfig.DATE_TIME_FORMAT);
        return formatter.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault()));
    }


    public static long ceil(long timestamp) {
        int surplus = (int) (timestamp % 60);

        if (surplus > 0) {
            return timestamp + (60 - timestamp % 60);
        }

        return timestamp;
    }

    public static long floor(long timestamp) {
        int surplus = (int) (timestamp % 60);

        if (surplus > 0) {
            return timestamp - timestamp % 60;
        }

        return timestamp;
    }
}
