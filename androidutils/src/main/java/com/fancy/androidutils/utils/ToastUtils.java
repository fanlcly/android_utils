package com.fancy.androidutils.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.fancy.androidutils.R;


/**
 * @Description: ToastUtils
 * @Author: fanlei
 * @CreateDate: 2019/9/3 9:14
 * @Version: 1.0
 */
public class ToastUtils {


    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Context context;
    // Toast对象
    private static Toast toast;
    // 文字显示的颜色 <color name="white">#FFFFFFFF</color>
    private static int messageColor = R.color.white;

    /**
     * 在Application中初始化ToastUtils.init(this)
     *
     * @param context
     */
    public static void init(Context context) {
        ToastUtils.context = context.getApplicationContext();
    }

    /**
     * 发送Toast,默认LENGTH_SHORT
     *
     * @param resId
     */
    public static void showRes(int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    /**
     * 发送Toast,默认LENGTH_SHORT
     *
     * @param text
     */
    public static void show(String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    /**
     * 发送Toast,默认LENGTH_SHORT
     *
     * @param str
     */
    public static void show(int str) {
        showToast(context, String.valueOf(str), Toast.LENGTH_SHORT);
    }

    private static void showToast(Context context, String massage, int duration) {
        massage = massage == null ? "" : massage;
        // 设置显示文字的颜色
        SpannableString spannableString = new SpannableString(massage);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, messageColor));
        spannableString.setSpan(colorSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (toast == null) {
            toast = Toast.makeText(context, spannableString, duration);
        } else {
            toast.cancel();
            toast = Toast.makeText(context, spannableString, duration);
        }
        // 设置显示的背景
        View view = toast.getView();
        view.setBackgroundResource(R.drawable.toast_frame_style);
        // 设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移200个单位，
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
        toast.show();
    }

    /**
     * 在UI界面隐藏或者销毁前取消Toast显示
     */
    public static void cancel() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }
}
