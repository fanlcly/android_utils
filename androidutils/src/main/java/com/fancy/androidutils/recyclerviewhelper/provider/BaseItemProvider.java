package com.fancy.androidutils.recyclerviewhelper.provider;

import android.content.Context;

import com.fancy.androidutils.recyclerviewhelper.base.BaseViewHolder;

import java.util.List;

/**
 * file explain
 *
 * @author fanlei
 * @version 1.0 2018\12\5 0005
 * @since JDK 1.7
 */
public abstract class BaseItemProvider <T,V extends BaseViewHolder> {

    public Context mContext;
    public List<T> mData;

    //子类须重写该方法返回viewType
    //Rewrite this method to return viewType
    public abstract int viewType();

    //子类须重写该方法返回layout
    //Rewrite this method to return layout
    public abstract int layout();

    public abstract void convert(V helper, T data, int position);

    //子类若想实现条目点击事件则重写该方法
    //Subclasses override this method if you want to implement an item click event
    public void onClick(V helper, T data, int position){};

    //子类若想实现条目长按事件则重写该方法
    //Subclasses override this method if you want to implement an item long press event
    public boolean onLongClick(V helper, T data, int position){return false;};
}
