package com.iyuba.myapplication.view;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
/**
 * Author：Howard on 2016/4/26 17:20
 * Email：Howard9891@163.com
 */

public class PopView extends RelativeLayout {

    public PopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }



}
