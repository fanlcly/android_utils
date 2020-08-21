package com.fancy.androidutils.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.IntDef;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fancy.androidutils.R;

/**
 * dialog基类
 *
 * @author fanlei
 * @version 1.0 2019/5/5 0005
 * @since JDK 1.8
 */
public class BaseDialog extends Dialog {
    protected Context mContext;

    public BaseDialog(Context context) {
        this(context, 0);

    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除对话框的标题
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0x00000000);
        getWindow().setBackgroundDrawable(gradientDrawable);//设置对话框边框背景（也可以设置主题），不然对话框会有黑边
        dimAmount(0.4f);
    }

    public BaseDialog contentView(@LayoutRes int layoutResID) {
        getWindow().setContentView(layoutResID);
        return this;
    }


    public BaseDialog contentView(@NonNull View view) {
        getWindow().setContentView(view);
        return this;
    }

    public BaseDialog contentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        getWindow().setContentView(view, params);
        return this;
    }

    public BaseDialog layoutParams(@Nullable ViewGroup.LayoutParams params) {
        getWindow().setLayout(params.width, params.height);
        return this;
    }


    /**
     * 点击外面是否能dissmiss
     *
     * @param canceledOnTouchOutside
     * @return
     */
    public BaseDialog canceledOnTouchOutside(boolean canceledOnTouchOutside) {
        setCanceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    /**
     * 位置
     *
     * @param gravity
     * @return
     */
    public BaseDialog gravity(int gravity) {
        getWindow().setGravity(gravity);
        return this;

    }

    /**
     * 偏移
     *
     * @param x
     * @param y
     * @return
     */
    public BaseDialog offset(int x, int y) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.x = x;
        layoutParams.y = y;

        return this;
    }

    /*
     * 设置背景阴影,必须setContentView之后调用才生效
     */
    public BaseDialog dimAmount(float dimAmount) {

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = dimAmount;
        return this;
    }


    /*
     *动画类型
     */
    public BaseDialog animType(@AnimInType int animInType) {


        switch (animInType) {
            case CENTER:
                getWindow().setWindowAnimations(R.style.dialog_zoom);

                break;
            case LEFT:
                getWindow().setWindowAnimations(R.style.dialog_anim_left);

                break;
            case TOP:
                getWindow().setWindowAnimations(R.style.dialog_anim_top);

                break;
            case RIGHT:
                getWindow().setWindowAnimations(R.style.dialog_anim_right);

                break;
            case BOTTOM:
                getWindow().setWindowAnimations(R.style.dialog_anim_bottom);

                break;
        }
        return this;
    }


    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int TOP = 2;
    public static final int RIGHT = 3;
    public static final int BOTTOM = 4;

    @IntDef(value = {CENTER, LEFT, TOP, RIGHT, BOTTOM})
    public @interface AnimInType {

    }

}
