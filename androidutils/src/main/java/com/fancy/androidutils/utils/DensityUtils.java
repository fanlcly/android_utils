package com.fancy.androidutils.utils;

import android.content.Context;

/**
 * 常用单位转换的辅助类
 *
 * @author fanlei
 * @version 1.0 2018\12\3 0003
 * @since JDK 1.7
 */
public class DensityUtils {

    private DensityUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
