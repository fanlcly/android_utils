package com.fancy.androidutils.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fancy.androidutils.R;
import com.fancy.androidutils.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义底部导航栏
 *
 * @author fanlei
 * @version 1.0 2018\5\29 0029
 * @since JDK 1.7
 */
public class BottomNavigationBar extends LinearLayout {

    private Context context;
    private String[] titles; //要显示的标题
    private int[] imgs; //图标
    private int imgwidth;
    private int imgheight;
    private int txtsize; //标题大小
    private int txtColor; //标题未选中颜色
    private int txtSelectedColor; //选择颜色

    private List<TextView> textViews; //保存标题
    private List<ImageView> imageViews; //保存图片
    private List<View> dots;//保存圆点
    private List<TextView> tvMessageDots; // 消息数
    private int currentIndex = 0;

    private OnItemOnclickListener onItemOnclickListener;
    private int spacing;
    private boolean isShow = false;

    public BottomNavigationBar(Context context) {
        this(context, null);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setOnItemOnclickListener(OnItemOnclickListener onItemOnclickListener) {
        this.onItemOnclickListener = onItemOnclickListener;
    }

    /**
     * 设置标题、图片和当前选中的条目
     *
     * @param tabtxts
     * @param imgs
     * @param currentIndex
     */
    public void setDataSource(String[] tabtxts, int[] imgs, int currentIndex) {
        this.titles = tabtxts;
        this.imgs = imgs;
        this.currentIndex = currentIndex;
    }

    /**
     * 设置图标大小
     *
     * @param imgwidth
     * @param imgheight
     */
    public void setImageSize(int imgwidth, int imgheight) {
        this.imgwidth = DensityUtils.dp2px(context, imgwidth);
        this.imgheight = DensityUtils.dp2px(context, imgheight);
    }

    /**
     * 设置图片和文字之间的间隔
     *
     * @param spacing
     */
    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public void isShowAnim(boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 设置标题颜色
     *
     * @param txtsize
     * @param txtColor
     * @param txtSelectedColor
     */
    public void setTextStyle(int txtsize, int txtColor, int txtSelectedColor) {
        this.txtsize = txtsize;
        this.txtColor = txtColor;
        this.txtSelectedColor = txtSelectedColor;
    }

    /**
     * 动态布局
     * 1、外层为横向线性布局
     * 2、动态添加相对布局，平分父布局，使宽度一致，添加到横向布局中
     * 3、总线布局添加图标和标题，并添加到相对布局中
     * 4、添加圆点到相对布局中，并设置在3的右上角
     */
    public void initDatas() {
        textViews = new ArrayList<>();
        imageViews = new ArrayList<>();
        dots = new ArrayList<>();
        tvMessageDots = new ArrayList<>();
        setOrientation(HORIZONTAL);

        // 单个的item布局参数
        LayoutParams lp = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        lp.gravity = Gravity.CENTER;

        int size = titles.length;
        for (int i = 0; i < size; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_navigation_button, null, Boolean.FALSE);
            ImageView imageView = view.findViewById(R.id.iv_img);
            imageView.setImageResource(imgs[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TextView textView = view.findViewById(R.id.tv_info);
            View dot = view.findViewById(R.id.v_dot);
            TextView tvMessageDot = view.findViewById(R.id.tv_message_dot);
            textView.setText(titles[i]);
            textView.setTextSize(txtsize);

            final int index = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context, titles[index], Toast.LENGTH_SHORT).show();
                    setSelectStyle(index);
                    if (onItemOnclickListener != null) {
                        onItemOnclickListener.onItemClick(index);
                    }
                }
            });

            textViews.add(textView);
            imageViews.add(imageView);
            dots.add(dot);
            tvMessageDots.add(tvMessageDot);
            addView(view, lp);
        }
        setSelectStyle(currentIndex);
    }

    public void setSelectStyle(int index) {
        int size = titles.length;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                textViews.get(i).setTextColor(ContextCompat.getColor(context, txtSelectedColor));
                imageViews.get(i).setSelected(true);
                if (isShow) {
                    showAnimation(imageViews.get(i));
                }
//
            } else {
                textViews.get(i).setTextColor(ContextCompat.getColor(context, txtColor));
                imageViews.get(i).setSelected(false);
            }
        }
    }


    // 显示Tab动画
    private void showAnimation(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            Log.w("TAG", "sdk version below 16");
            return;
        }
//        SpringAnimUtil.showTabIconAnim(view);
    }

    /**
     * 设置圆点
     *
     * @param index 圆点索引
     */
    public void setIsShowDot(int index, boolean isShowDot) {
        if (dots == null || index > dots.size() - 1) return;
        if (isShowDot) {
            dots.get(index).setVisibility(VISIBLE);
        } else {
            dots.get(index).setVisibility(GONE);
        }
    }


    /**
     * 设置消息数
     *
     * @param index
     * @param count
     */
    public void setMessageCountForDot(int index, int count) {
        if (tvMessageDots == null || index > tvMessageDots.size() - 1) return;
        if (count > 0) {
            tvMessageDots.get(index).setVisibility(VISIBLE);
            tvMessageDots.get(index).setText(String.valueOf(count));
        } else {
            tvMessageDots.get(index).setVisibility(GONE);
        }
    }


    public interface OnItemOnclickListener {
        void onItemClick(int index);
    }

}
