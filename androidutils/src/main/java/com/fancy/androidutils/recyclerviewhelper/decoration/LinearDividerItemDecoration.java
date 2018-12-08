package com.fancy.androidutils.recyclerviewhelper.decoration;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.fancy.androidutils.R;

/**
 * 基本的线型分割线
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class LinearDividerItemDecoration extends DividerItemDecoration {

    private final int color;
    private final float width;
    private final float startPadding;
    private final float endPadding;

    public LinearDividerItemDecoration(Context context) {
        this(context, R.color.divide_c6c6c6, 0.5f);
    }

    public LinearDividerItemDecoration(Context context, @ColorRes int color, float width) {
        this(context, color, width, 0, 0);
    }

    public LinearDividerItemDecoration(Context context, @ColorRes int color, float width, float startPadding, float endPadding) {
        super(context);
        this.color = color;
        this.width = width;
        this.startPadding = startPadding;
        this.endPadding = endPadding;
    }


    @Nullable
    @Override
    public Divider getDivider(int itemPosition) {
        Divider divider = null;
        switch (itemPosition) {
            case 0:
                divider = new DividerBuilder()
                        .setBottomSideLine(false, ContextCompat.getColor(context, color), width, startPadding, endPadding)
                        .create();
                break;
            default:
                divider = new DividerBuilder()
                        .setTopSideLine(true, ContextCompat.getColor(context, color), width, startPadding, endPadding)
                        .create();
                break;
        }
        return divider;

    }
}
