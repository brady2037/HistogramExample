package com.example.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.histogram.bean.WeekSleepRangesBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class MyViewBackup1 extends View {

    private Paint mLeavePaint;
    private Paint mSoberPaint;
    private Paint mREMPaint;
    private Paint mLightSleepPaint;
    private Paint mDeepSleepPaint;

    private int rectWidth = 30;
    int mStartX = 0;
    List<WeekSleepRangesBean> sleepRanges = new ArrayList<>();
    List<Integer> colorList = new ArrayList<>();


    public MyViewBackup1(Context context) {
        this(context, null);
    }

    public MyViewBackup1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyViewBackup1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLeavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSoberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mREMPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLightSleepPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDeepSleepPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mLeavePaint.setColor(Color.GRAY);
        mSoberPaint.setColor(Color.BLUE);
        mREMPaint.setColor(Color.YELLOW);
        mLightSleepPaint.setColor(Color.parseColor("#FF8000"));
        mDeepSleepPaint.setColor(Color.parseColor("#C0FF3E"));


        colorList.add(Color.GRAY);
        colorList.add(Color.BLUE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.parseColor("#FF8000"));
        colorList.add(Color.parseColor("#C0FF3E"));


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int getRemainingWidth() {
        return getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int mChartWidth = getRemainingWidth() / 8;

        //灰色背景
        Paint testPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        testPaint.setColor(Color.parseColor("#0A000000"));
        canvas.drawRect(0, 0, getWidth(), getHeight(), testPaint);
//        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mREMPaint);

        mStartX = getWidth() / 8;

//        canvas.drawLine(mStartX, getHeight() / 2, getWidth(), getHeight() / 2, mREMPaint);
//        canvas.drawLine(mStartX, getHeight() / 2 - 100, mStartX, getHeight() + 100, mREMPaint);
//        canvas.drawLine(mStartX*2, getHeight() / 2 - 100, mStartX*2, getHeight() + 100, mREMPaint);

//        canvas.drawRect(mStartX, 200, mStartX + rectWidth, getHeight(), mLeavePaint);
//        canvas.drawRect(mStartX * 2, 200, mStartX * 2 + rectWidth, getHeight(), mLeavePaint);


        for (int i = 0; i < 7; i++) {

            canvas.drawRect(mStartX * (i + 1), getHeight() - 400, mStartX * (i + 1) + rectWidth, getHeight(), mLeavePaint);

        }

    }
}
