package com.fancy.androidutils.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @Description: 最多显示屏幕的60%的线性布局+
 * @Author: fanlei
 * @CreateDate: 2020/8/24 10:51
 * @Version: 1.0
 */
public class MaxLinearLayout  extends LinearLayout {
    public MaxLinearLayout(Context context) {
        super(context);
    }

    public MaxLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int max = (int) (getResources().getDisplayMetrics().heightPixels * 0.6);
        if (MeasureSpec.getSize(heightMeasureSpec) > max) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(max, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
