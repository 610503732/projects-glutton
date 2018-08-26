package cn.com.git.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 *<b>描述：</b>
 *      用一句话描述该类的功能
 * @author  作者 zhangzhenfu
 * @version 版本号 2016-3-29 下午5:18:48
 * @since 适用版本
 */
public class DateUtil {

    public static Date date = null;

    public static DateFormat dateFormat = null;

    public static Calendar calendar = null;

    /**
     * 功能描述：返回年份
     *
     * @param date
     *            Date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 功能描述：返回月份
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日份
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分钟
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫秒
     *
     * @param date
     *            日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 格式化输出日期（默认格式）<br>
     * <b>描述：</b>
     *      使用默认的日期的格式（yyyy-MM-dd HH:mm:ss），格式化日期，并返回日期字符串
     * @param date
     *          Date 日期
     * @return
     *          String 格式化后的日期字符串 （yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDate(Date date){
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化输出日期（指定格式）<br>
     * <b>描述：</b>
     *      通过指定的格式，格式化日期，并返回日期字符串
     * @param date
     *          Date 日期
     * @param format
     *          String 日期格式 （例： yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String formatDate(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                dateFormat = new SimpleDateFormat(format);
                result = dateFormat.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 格式化日期（默认格式）<br>
     * <b>描述：</b>
     *      将日期字符串，通过默认的日期格式（yyyy-MM-dd），解析成日期对像
     * @param dateStr
     *          String 日期字符串
     * @return
     *          Date 解析的日期对象 （yyyy-MM-dd）
     */
    public static Date parseDate(String dateStr){
        return parseDate(dateStr, "yyyy-MM-dd");
    }

    /**
     * 格式化日期（指定格式）<br>
     * <b>描述：</b>
     *      将日期字符串，通过指定的日期格式，解析成日期对像
     * @param dateStr
     *          String 日期字符串
     * @param format
     *          String 日期格式
     * @return
     *          Date 解析的日期对象
     */
    public static Date parseDate(String dateStr, String format) {
        try {

            if(format==null || "".equals(format)){
                throw new Exception("日期格式化格式不正确！");
            }
            dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(dateStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当月第一天<br>
     * <b>描述：</b>
     *      获取指定月份的第一天的日期对象
     * @param date
     *          Date 源日期对象
     * @return
     *          Date 当月第一天日期对象
     */
    public static Date getMonthBegin(Date date) {
        return parseDate(formatDate(date, "yyyy-MM") + "-01" , "yyyy-MM-dd");
    }

    /**
     * 获取当月最后一天<br>
     * <b>描述：</b>
     *      获取当月的最后一天的日期对象
     * @param date
     *          Date 源日期对象
     * @return
     *          Date 当月最后一天日期对象
     */
    public static Date getMonthEnd(Date date) {
        date = getMonthBegin(date);
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }


    public static void main(String[] args) {

    }

    /**
     * 日期相加<br>
     * <b>描述：</b>
     *      为日期加上指定天数
     * @param date
     *          Date 日期
     * @param day
     *          int 天数
     * @return
     *          Date 相加后日期
     */
    public static Date addDate(Date date, int day) {
        calendar = Calendar.getInstance();
        long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * 日期相减<br>
     * <b>描述：</b>
     *      日期减去指定天数
     * @param date
     *          Date 日期
     * @param day
     *          int 天数
     * @return
     *          Date 相减后日期
     */
    public static Date subDate(Date date,int day){
        calendar = Calendar.getInstance();
        long millis = getMillis(date) - ((long) day) * 24 * 3600 * 1000;
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * 相隔天数<br>
     * <b>描述：</b>
     *      返回两个日期的相隔天数
     * @param dateOne
     * @param dateTwo
     * @return
     */
    public static int betweenDate(Date dateOne,Date dateTwo){
        return (int) ((getMillis(dateOne) - getMillis(dateTwo)) / (24 * 3600 * 1000));
    }

    /**
     * 判断日期大小<br>
     * <b>描述：</b>
     *      通过获取两个日期的毫秒数值差，判断两个日期的大小
     * @param dateOne
     * @param dateTwo
     * @return 1：大于
     *         0：等于
     *        -1：小于
     */
    public static int compareDate(Date dateOne,Date dateTwo){
        long l = getMillis(dateOne) - getMillis(dateTwo) ;
        if(l < 0) return -1 ;
        if(l > 0) return 1 ;
        return 0;
    }
}
