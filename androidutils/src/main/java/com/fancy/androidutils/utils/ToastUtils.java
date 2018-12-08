package com.fancy.androidutils.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast 工具类
 *
 * @author fanlei
 * @version 1.0 2018\5\31 0031
 * @since JDK 1.7
 */
public class ToastUtils {

    private Toast mToast;
    private static ToastUtils mToastUtils;

    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    private ToastUtils(Context context) {
        mToast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
    }

    public static synchronized ToastUtils init(Context context) {
        if (null == mToastUtils) {
            mToastUtils = new ToastUtils(context);
        }
        return mToastUtils;
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void show(int toastMsg) {
        mToast.setText(String.valueOf(toastMsg));
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param toastMsg
     */
    public void show(String toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 取消toast，在activity的destory方法中调用
     */
    public void destory() {
        if (null != mToast) {
            mToast.cancel();
            mToast = null;
        }
        mToastUtils = null;
    }
}
