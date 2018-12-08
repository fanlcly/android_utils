package com.fancy.androidutils.adapter;

import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.fancy.androidutils.R;
import com.fancy.androidutils.recyclerviewhelper.base.BaseQuickAdapter;
import com.fancy.androidutils.recyclerviewhelper.base.BaseViewHolder;

import java.util.List;

/**
 * 数组集合适配器
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class ArrayAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public ArrayAdapter(@Nullable List data) {
        super(R.layout.item_single_array, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        helper.setText(R.id.text_view, item.toString());
    }
}
