package com.fancy.android_utils.adapter;


import androidx.annotation.Nullable;

import com.fancy.android_utils.R;
import com.fancy.androidutils.recyclerviewhelper.base.BaseQuickAdapter;
import com.fancy.androidutils.recyclerviewhelper.base.BaseViewHolder;

import java.util.List;

/**
 * file explain
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class GridAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public GridAdapter(@Nullable List data) {
        super(R.layout.item_single_array, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        helper.setText(R.id.text_view, item.toString());
    }
}
