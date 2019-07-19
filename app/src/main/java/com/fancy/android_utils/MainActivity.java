package com.fancy.android_utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.fancy.androidutils.utils.DensityUtils;
import com.fancy.androidutils.widget.AlertView;
import com.fancy.androidutils.widget.BaseDialog;
import com.fancy.androidutils.widget.LoadingView;

public class MainActivity extends AppCompatActivity {
    private MainActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mActivity = this;

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, ListActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, GridActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertView(mActivity).setMsg("我被点出来了我被点出来了我被点出来了我被点出来了我被点出来了")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定",null)
                        .show();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_left = new BaseDialog(mActivity);

                dialog_left.contentView(R.layout.alert_view)
                        .dimAmount(0.5f)
                        .gravity(Gravity.LEFT | Gravity.CENTER)
                        .animType(BaseDialog.LEFT)
                        .show();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_top = new BaseDialog(mActivity);

                dialog_top.contentView(R.layout.alert_view)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                        .dimAmount(0.5f)
                        .gravity(Gravity.TOP)
                        .offset(0, DensityUtils.dp2px(mActivity, 48))
                        .animType(BaseDialog.TOP)
                        .show();
            }
        });

        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_right = new BaseDialog(mActivity);

                dialog_right.contentView(R.layout.alert_view)
                        .gravity(Gravity.RIGHT | Gravity.CENTER)
                        .animType(BaseDialog.RIGHT)
                        .offset(DensityUtils.dp2px(mActivity, 20), 0)
                        .show();
            }
        });

        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDialog dialog_bottom = new BaseDialog(mActivity);

                dialog_bottom.contentView(R.layout.alert_view)
                        .gravity(Gravity.BOTTOM)
                        .animType(BaseDialog.BOTTOM)
                        .offset(0, DensityUtils.dp2px(mActivity, 20))
                        .canceledOnTouchOutside(false)
                        .show();


            }
        });

  findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingView dialog_bottom = new LoadingView(mActivity);

                dialog_bottom.show();


            }
        });


    }
}
