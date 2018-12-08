package com.fancy.androidutils.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

import java.util.List;

/**
 * 单列滚轮的工具类
 *
 * @author fanlei
 * @version 1.0 2018\12\4 0004
 * @since JDK 1.7
 */
public class SinglePickerViewUtils {
    private static SinglePickerViewUtils instance;


    private SinglePickerViewUtils() {
        throw new UnsupportedOperationException("no instantiate");
    }


    public static SinglePickerViewUtils getInstance() {
        if (instance == null) {
            synchronized (SinglePickerViewUtils.class) {
                if (instance == null) {
                    instance = new SinglePickerViewUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 单列数据滚轮样式
     *
     * @param context
     * @param data
     * @param view
     */
    public <T> void showWheelView(final Context context, final List<T> data, final TextView view) {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = data.get(options1).toString();
                view.setText(tx);
            }
        })
                .setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .setSubCalSize(18)//确定和取消文字大小
                .setTitleSize(20)//标题文字大小
                .setContentTextSize(18)//滚轮文字大小
                .setCyclic(false, false, false)//循环与否
                .build();
        pvOptions.setPicker(data);
        pvOptions.show();
    }




}
