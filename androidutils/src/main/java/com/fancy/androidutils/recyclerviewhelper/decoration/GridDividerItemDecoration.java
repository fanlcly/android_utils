package com.fancy.androidutils.recyclerviewhelper.decoration;

import android.content.Context;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import com.fancy.androidutils.R;

/**
 * GridView的基本分割线
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class GridDividerItemDecoration extends DividerItemDecoration {

    private final int column;
    private final int color;
    private final float width;

    public GridDividerItemDecoration(Context context, int column) {
        this(context, column, R.color.transparent, 5);
    }

    public GridDividerItemDecoration(Context context, int column, @ColorRes int color, float width) {
        super(context);
        this.column = column;
        this.color = color;
        this.width = width;
    }

    @Override
    public Divider getDivider(int itemPosition) {
        Divider divider;
        if (itemPosition % column == column - 1) {
            //每一行最后一个只显示bottom
            divider = new DividerBuilder()
                    .setBottomSideLine(true, ContextCompat.getColor(context, color), width, 0, 0)
                    .create();
        } else {
            //每一行除了最后一个显示rignt和bottom
            divider = new DividerBuilder()
                    .setRightSideLine(true, ContextCompat.getColor(context, color), width, 0, 0)
                    .setBottomSideLine(true, ContextCompat.getColor(context, color), width, 0, 0)
                    .create();
        }

        return divider;
    }
}

