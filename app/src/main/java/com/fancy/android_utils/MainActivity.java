package com.fancy.android_utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.fancy.androidutils.encrypt.SharedWrapper;
import com.fancy.androidutils.utils.DensityUtils;
import com.fancy.androidutils.widget.AlertView;
import com.fancy.androidutils.widget.BaseDialog;
import com.fancy.androidutils.widget.BottomNavigationBar;
import com.fancy.androidutils.widget.LoadingView;

public class MainActivity extends AppCompatActivity {
    private final String[] titlesByShop = {"首页", "分类", "店铺", "购物车", "个人中心"};
    private final int[] imgsByShop = {R.drawable.home_one_selector, R.drawable.home_two_selector, R.drawable.home_shop_selector, R.drawable.home_four_selector, R.drawable.home_five_selector};

    private MainActivity mActivity;
    private BottomNavigationBar bottom_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mActivity = this;

        bottom_view = findViewById(R.id.bottom_navigation_bar);

        bottom_view.setDataSource(titlesByShop, imgsByShop, 0);
        bottom_view.setImageSize(20, 20);
        bottom_view.setTextStyle(10, R.color.text_333333, R.color.text_037BFF);
        bottom_view.initDatas();
        bottom_view.setOnItemOnclickListener(new BottomNavigationBar.OnItemOnclickListener() {
            @Override
            public void onItemClick(int index) {
                bottom_view.setSelectStyle(index);
            }
        });


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
                Intent intent = new Intent(mActivity, DialogActivity.class);
                startActivity(intent);
            }
        });



        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, PrizeActivity.class);
                startActivity(intent);
            }
        });

    }
}
