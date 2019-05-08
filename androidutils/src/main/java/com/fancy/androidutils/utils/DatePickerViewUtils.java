package com.fancy.androidutils.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.fancy.androidutils.R;

import java.util.Calendar;

/**
 * 日期滚轮工具类
 *
 * @author fanlei
 * @version 1.0 2018\12\5 0005
 * @since JDK 1.7
 */
public class DatePickerViewUtils {
    private static DatePickerViewUtils instance;
    private static float lineSpacingMultiplier = 2F;  // 条目间距倍数 默认1.6
    private static final String EMPTY = "";    // 空字符串

    private DatePickerViewUtils() {
    }


    public static DatePickerViewUtils getInstance() {
        if (instance == null) {
            synchronized (DatePickerViewUtils.class) {
                if (instance == null) {
                    instance = new DatePickerViewUtils();
                }
            }
        }
        return instance;
    }


    /**
     * 获取通用的样式
     *
     * @param listener 回调监听
     * @param start    开始
     * @param end      结束
     * @param select   默认选中
     */
    public void getDateView(Context mContext, OnTimeSelectListener listener, Calendar start, Calendar end, Calendar select) {
        // 日期选择器
        TimePickerView pvTime = new TimePickerBuilder(mContext, listener)
                .isCyclic(false)  //是否循环滚动
                .setType(new boolean[]{true, true, true, false, false, false})   // 只显示年月日
                .isCenterLabel(true)  // 每项item全部都带有label
                .setContentTextSize(20)    // 滚轮文字大小
                .setTitleBgColor(ContextCompat.getColor(mContext, R.color.bg_b1b1b2))  // 标题背景颜色
                .setCancelColor(ContextCompat.getColor(mContext, R.color.text_666666)) // 取消按钮文字颜色
                .setSubmitColor(ContextCompat.getColor(mContext, R.color.text_037BFF))   // 确定按钮文字颜色
                .setDividerColor(ContextCompat.getColor(mContext, R.color.divide_c6c6c6))  // 分隔线颜色
                .setRangDate(start, end)
                .setOutSideCancelable(false)
                .setLabel(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)
                .setDate(select)   // 默认选中
                .setLineSpacingMultiplier(lineSpacingMultiplier)
                .build();
        pvTime.show();
    }


    /**
     * 获取未来的日期，（从当天到2088-12-31）
     *
     * @param mContext
     * @param listener
     * @param select
     */
    public void getAfterDateView(Context mContext, OnTimeSelectListener listener, Calendar select) {
        getAfterDateView(mContext, 2088, listener, select);
    }


    /**
     * 获取未来的日期，（从当天到endTime）
     *
     * @param mContext
     * @param endYear
     * @param listener
     * @param select
     */
    public void getAfterDateView(Context mContext, int endYear, OnTimeSelectListener listener, Calendar select) {
        Calendar startDate = Calendar.getInstance(); // 最小值
        Calendar endDate = Calendar.getInstance(); // 最大值
        endDate.set(endYear, 11, 31);  // 最小值
        getDateView(mContext, listener, startDate, endDate, select);
    }


    /**
     * 获取过去的日期（从1900到当天）
     *
     * @param mContext
     * @param listener
     * @param select
     */
    public void getBeforeDateView(Context mContext, OnTimeSelectListener listener, Calendar select) {
        getBeforeDateView(mContext, 1900, listener, select);
    }


    /**
     * 获取过去的日期（从startYear到当天）
     *
     * @param mContext
     * @param startYear
     * @param listener
     * @param select
     */
    public void getBeforeDateView(Context mContext, int startYear, OnTimeSelectListener listener, Calendar select) {
        Calendar startDate = Calendar.getInstance(); // 最小值
        startDate.set(startYear, 0, 31);  // 最小值
        Calendar endDate = Calendar.getInstance(); // 最大值
        getDateView(mContext, listener, startDate, endDate, select);
    }


}
