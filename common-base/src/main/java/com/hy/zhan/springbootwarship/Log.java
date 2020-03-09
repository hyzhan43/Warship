package com.hy.zhan.springbootwarship;

import com.hy.zhan.springbootwarship.common.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * author :  HyJame
 * date  :   2020/3/6
 * desc :    what
 */
public class Log {

    @Value("${warship.log.enable}")
    private static boolean enable;

    private static Logger logger = LoggerFactory.getLogger(Log.class);

    public static void warn(String msg) {
        Condition.ifTrue(enable, () -> logger.warn(msg));
    }

    public static void debug(String msg) {
        Condition.ifTrue(enable, () -> logger.debug(msg));
    }

    public static void info(String msg) {
        Condition.ifTrue(enable, () -> logger.info(msg));
    }

    public static void error(String msg) {
        Condition.ifTrue(enable, () -> logger.error(msg));
    }
}
