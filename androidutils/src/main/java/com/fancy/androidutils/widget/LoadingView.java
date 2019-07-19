package com.fancy.androidutils.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fancy.androidutils.R;

/**
 * @Description: 加载框
 * @Author: fanlei
 * @CreateDate: 2019/7/17 17:28
 * @Version: 1.0
 */
public class LoadingView extends BaseDialog {
    private final DisplayMetrics dm;
    private String message;
    private boolean isShowMessage = true;
    private TextView msgText;

    public LoadingView(Context context) {
        super(context);
        dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        setContentView();
    }

    private void setContentView() {
        // 获取Dialog布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading, null);
        msgText = view.findViewById(R.id.tipTextView);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        contentView(view, params);
        animType(BaseDialog.CENTER);
    }


    /**
     * 设置提示信息
     *
     * @param message
     * @return
     */

    public LoadingView setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 设置是否显示提示信息
     *
     * @param isShowMessage
     * @return
     */
    public LoadingView setShowMessage(boolean isShowMessage) {
        this.isShowMessage = isShowMessage;
        return this;
    }


    public void show() {
        setLayout();
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setLayout() {
        if (isShowMessage) {
            msgText.setText(message);
        } else {
            msgText.setVisibility(View.GONE);
        }

    }

}
