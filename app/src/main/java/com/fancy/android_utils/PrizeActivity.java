package com.fancy.android_utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.fancy.android_utils.widget.PrizeView;

/**
 * @Description: java类作用描述
 * @Author: fanlei
 * @CreateDate: 2020/8/21 10:29
 * @Version: 1.0
 */
public class PrizeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_prize);
       PrizeView luckpan =  findViewById(R.id.luckpan);
        luckpan.setOnLuckPanAnimEndListener(new PrizeView.OnLuckPanAnimEndListener() {
            @Override
            public void onAnimEnd(int position, String msg) {
                Toast.makeText(PrizeActivity.this, "位置："+position+"提示信息："+msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
