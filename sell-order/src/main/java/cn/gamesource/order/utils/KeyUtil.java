package cn.gamesource.order.utils;

import java.util.Random;

/**
 * 生成唯一的主键;
 *
 * @author: LEIYU
 */
public class KeyUtil {

    /**
     * 生成唯一的主键;
     * 时间戳+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 1000000;
        return String.valueOf(System.currentTimeMillis() + number);
    }

}
