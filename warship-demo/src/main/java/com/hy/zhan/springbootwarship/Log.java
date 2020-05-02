package com.hy.zhan.springbootwarship;

/**
 * author :  HyJame
 * date  :   2020/3/6
 * desc :    what
 */
//@Component
//public class Log {
//
//    private static Logger logger = LoggerFactory.getLogger(Log.class);
//
//    private static boolean enable;
//    private static String level;
//
//    @Value("${warship.log.enable}")
//    public void setEnable(boolean enable) {
//        enable = enable;
//    }
//
//    @Value("${warship.log.level}")
//    public void setLevel(String level) {
//        level = level;
//    }
//
//    public static void show(String msg) {
//        Condition.ifTrue(enable, () -> {
//            switch (level) {
//                case "warn":
//                    logger.warn(msg);
//                    break;
//                case "info":
//                    logger.info(msg);
//                    break;
//                case "debug":
//                    logger.debug(msg);
//                    break;
//                case "error":
//                    logger.error(msg);
//                    break;
//            }
//        });
//    }
//
//    public static void warn(String msg) {
//        Condition.ifTrue(enable, () -> logger.warn(msg));
//    }
//
//    public static void debug(String msg) {
//        Condition.ifTrue(enable, () -> logger.debug(msg));
//    }
//
//    public static void info(String msg) {
//        Condition.ifTrue(enable, () -> logger.info(msg));
//    }
//
//    public static void error(String msg) {
//        Condition.ifTrue(enable, () -> logger.error(msg));
//    }
//}
