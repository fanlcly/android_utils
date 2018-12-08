package com.fancy.androidutils.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关工具类
 *
 * @author fanlei
 * @version 1.0 2018\12\3 0003
 * @since JDK 1.7
 */
public class DateUtils {


    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     **/
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm
     **/
    public static final String DF_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式：yyyy-MM-dd
     **/
    public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式：HH:mm:ss
     **/
    public static final String DF_HH_MM_SS = "HH:mm:ss";

    /**
     * 日期格式：HH:mm
     **/
    public static final String DF_HH_MM = "HH:mm";

    private DateUtils() {
        throw new UnsupportedOperationException("no instantiate");
    }

    /**
     * 将时间戳以yyyy-MM-dd HH:mm:ss格式化成时间字符串
     *
     * @param dateL 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(long dateL) {
        return formatDateTime(dateL, DF_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将时间戳以formater格式化成时间字符串
     *
     * @param dateL 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(long dateL, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(new Date(dateL));
    }


    /**
     * 将Date对象以yyyy-MM-dd HH:mm:ss格式化成时间字符串
     *
     * @param date 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(Date date) {
        return formatDateTime(date, DF_YYYY_MM_DD_HH_MM_SS);
    }


    /**
     * 将Date对象以formater格式化成时间字符串
     *
     * @param date     Date对象
     * @param formater 时间对应格式  例如: yyyy-MM-dd
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(Date date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(date);
    }


    /**
     * 将Calendar对象以formater格式化成时间字符串
     *
     * @param calendar
     * @return
     */
    public static String formatDateTime(Calendar calendar) {
        return formatDateTime(calendar, DF_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将Calendar对象以formater格式化成时间字符串
     *
     * @param calendar
     * @param formater 时间对应格式  例如: yyyy-MM-dd
     * @return
     */
    public static String formatDateTime(Calendar calendar, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(calendar.getTime());
    }

    /**
     * 将日期字符串转成Date对象（时间对应格式：yyyy-MM-dd HH:mm:ss）
     *
     * @param strDate 字符串日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date parseDate(String strDate) {
        return parseDate(strDate, DF_YYYY_MM_DD_HH_MM_SS);
    }


    /**
     * 将日期字符串转成Date对象
     *
     * @param strDate 日期字符串  例如: 2016-03-09
     * @param formate 时间对应格式  例如: yyyy-MM-dd
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date parseDate(String strDate, String formate) {
        DateFormat dateFormat = new SimpleDateFormat(formate);
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnDate;

    }


    /**
     * 将日期字符串转成Calendar对象
     *
     * @param strDate 日期字符串  （默认时间对应格式：yyyy-MM-dd HH:mm:ss）
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Calendar parseCalendar(String strDate) {
        return parseCalendar(strDate, DF_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将日期字符串转成Calendar对象
     *
     * @param strDate 日期字符串  例如: 2016-03-09
     * @param formate 时间对应格式  例如: yyyy-MM-dd
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Calendar parseCalendar(String strDate, String formate) {
        Date date = parseDate(strDate, formate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * 获取当前时间 格式：2013-04-22 10:37:00
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate() {
        return getCurrentDate(DF_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取当前时间 格式自定（如: 2013-04-22 10:37）
     *
     * @param formater
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate(String formater) {
        SimpleDateFormat format = new SimpleDateFormat(formater);
        return format.format(Calendar.getInstance().getTime());
    }


    /**
     * 时间字符串转为时间戳
     *
     * @param timeStr 时间 例如: 2013-04-22 10:37:00
     * @return
     */
    public static long getTimeStamp(String timeStr) {
        return getTimeStamp(timeStr, DF_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 时间字符串转为时间戳
     *
     * @param timeStr 时间 例如: 2016-03-09
     * @param format  时间对应格式  例如: yyyy-MM-dd
     * @return
     */
    public static long getTimeStamp(String timeStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(timeStr);
            long timeStamp = date.getTime();
            return timeStamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取时间与当前时间的间隔（如：2天前，1分钟前...）
     *
     * @param timestamp 过去的某个时间值
     * @return
     */
    public static String converTime(long timestamp) {
        long currentSeconds = System.currentTimeMillis() / 1000;
        long timeGap = currentSeconds - timestamp;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > 24 * 60 * 60) {// 1天以上
            timeStr = timeGap / (24 * 60 * 60) + "天前";
        } else if (timeGap > 60 * 60) {// 1小时-24小时
            timeStr = timeGap / (60 * 60) + "小时前";
        } else if (timeGap > 60) {// 1分钟-59分钟
            timeStr = timeGap / 60 + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }


}
