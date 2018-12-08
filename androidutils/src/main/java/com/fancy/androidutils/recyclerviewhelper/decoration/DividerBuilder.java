package com.fancy.androidutils.recyclerviewhelper.decoration;

import android.support.annotation.ColorInt;

/**
 * file explain
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class DividerBuilder {
    private SideLine leftSideLine;
    private SideLine topSideLine;
    private SideLine rightSideLine;
    private SideLine bottomSideLine;


    public DividerBuilder setLeftSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.leftSideLine = new SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public DividerBuilder setTopSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.topSideLine = new SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public DividerBuilder setRightSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.rightSideLine = new SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public DividerBuilder setBottomSideLine(boolean isHave, @ColorInt int color, float widthDp, float startPaddingDp, float endPaddingDp) {
        this.bottomSideLine = new SideLine(isHave, color, widthDp, startPaddingDp, endPaddingDp);
        return this;
    }

    public Divider create() {
        //提供一个默认不显示的sideline，防止空指针
        SideLine defaultSideLine = new SideLine(false, 0xff666666, 0, 0, 0);

        leftSideLine = (leftSideLine != null ? leftSideLine : defaultSideLine);
        topSideLine = (topSideLine != null ? topSideLine : defaultSideLine);
        rightSideLine = (rightSideLine != null ? rightSideLine : defaultSideLine);
        bottomSideLine = (bottomSideLine != null ? bottomSideLine : defaultSideLine);

        return new Divider(leftSideLine, topSideLine, rightSideLine, bottomSideLine);
    }

}
