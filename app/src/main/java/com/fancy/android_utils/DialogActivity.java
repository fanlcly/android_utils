package com.fancy.android_utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.fancy.android_utils.R;
import com.fancy.androidutils.utils.DensityUtils;
import com.fancy.androidutils.widget.AlertView;
import com.fancy.androidutils.widget.BaseDialog;
import com.fancy.androidutils.widget.LoadingView;

/**
 * @Description: java类作用描述
 * @Author: fanlei
 * @CreateDate: 2020/8/21 14:17
 * @Version: 1.0
 */
public class DialogActivity extends AppCompatActivity {
    private DialogActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        this.mActivity = this;

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertView(mActivity).setMsg("带两个按钮的弹窗")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertView(mActivity).setMsg("带一个按钮的弹窗")
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        // 左边弹窗
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_left = new BaseDialog(mActivity);

                dialog_left.contentView(R.layout.dialog_left)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT))
                        .dimAmount(0.5f)
                        .gravity(Gravity.LEFT | Gravity.CENTER)
                        .animType(BaseDialog.LEFT)
                        .show();
            }
        });

        // 右边弹窗
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_right = new BaseDialog(mActivity);

                dialog_right.contentView(R.layout.dialog_left)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT))
                        .gravity(Gravity.RIGHT | Gravity.CENTER)
                        .animType(BaseDialog.RIGHT)
//                        .offset(DensityUtils.dp2px(mActivity, 20), 0)
                        .show();
            }
        });


//        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BaseDialog dialog_top = new BaseDialog(mActivity);
//
//                dialog_top.contentView(R.layout.alert_view)
//                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
//                        .dimAmount(0.5f)
//                        .gravity(Gravity.TOP)
//                        .offset(0, DensityUtils.dp2px(mActivity, 48))
//                        .animType(BaseDialog.TOP)
//                        .show();
//            }
//        });


        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_bottom = new BaseDialog(mActivity);
                dialog_bottom.contentView(R.layout.dialog_bottom)
                        // 重新设置宽高属性
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                        .gravity(Gravity.BOTTOM)
                        .animType(BaseDialog.BOTTOM)
//                        .offset(0, DensityUtils.dp2px(mActivity, 20))
//                        .canceledOnTouchOutside(false)
                        .show();


            }
        });

        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingView dialog_bottom = new LoadingView(mActivity);
                dialog_bottom.show();
            }
        });


    }
}
