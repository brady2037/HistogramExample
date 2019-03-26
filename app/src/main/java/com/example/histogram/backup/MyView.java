package com.example.histogram.backup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.histogram.bean.WeekSleepRangesBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class MyView extends View {

    private Paint mRemainingPaint;//矩形柱

    private Paint mDateTextPaint;//日期
    private Rect mDateTextBound;

    private int rectWidth = 30;//灰色方块宽度
    private int mStartX = 0;//矩形柱左侧X坐标
    private List<WeekSleepRangesBean> sleepRanges = new ArrayList<>();
    private List<Integer> colorList = new ArrayList<>();//颜色

    private int timeLeftMargin = 10;//最左侧竖排时间 左侧间距大小

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRemainingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //日期text
        mDateTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDateTextPaint.setTextSize(35);
        mDateTextPaint.setTextAlign(Paint.Align.CENTER);
        mDateTextPaint.getTextBounds(String.valueOf("03/16"), 0, String.valueOf("03/16").length(), mDateTextBound);

        mRemainingPaint.setColor(Color.GRAY);

        colorList.add(Color.GRAY);
        colorList.add(Color.BLUE);
        colorList.add(Color.CYAN);
        colorList.add(Color.parseColor("#FF8000"));
        colorList.add(Color.parseColor("#C0FF3E"));
        colorList.add(Color.YELLOW);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        //灰色背景
        Paint testPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        testPaint.setColor(Color.parseColor("#0A000000"));
        canvas.drawRect(0, 0, getWidth(), getHeight(), testPaint);

        mStartX = getWidth() / 8;

//        canvas.drawText("03/16",mStartX,getHeight(),);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                mRemainingPaint.setColor(colorList.get(j));
                canvas.drawRect(mStartX * (i + 1), getHeight() - getHeight() / 7 * (j + 1),
                        mStartX * (i + 1) + rectWidth, getHeight() - getHeight() / 7 * j, mRemainingPaint);
            }
        }

    }

}
