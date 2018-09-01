package cn.com.git.common.utils;


import java.util.UUID;


public final class CodecUtil {

    /**
     * 获取32位唯一主键
     * @return
     */
    public static String get32UUID(){
        /**
         *	UUID  可用于产生唯一的主键ID,且总是字符串
         *	随机,字符串长度固定,以便于存入数据库
         */
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

}
