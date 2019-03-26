package com.example.histogram.backup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class HistogramViewCV2_0 extends View {

    private Paint mBottomTextPaint;//底部文字
    private Paint mDateTimeTextPaint;//横纵轴文字 日期&时间
    private Rect mBottomTextBounds;

    private Paint mBottomRectPaint;//底部提示方块
    private float mBottomExplainMarginBottom = 18;//底部文字&方块 与最下方margin
    private float mBottomRectTextMargin = 18;//底部文字&方块 间隔margin
    private float mBottomRectWidth = 40;//底部方块
    private float mBottomRectHeight = 30;//底部方块

    private float dateTextMarginBottom = 22;//横向轴日期文字与提示文字上下间隔
    private float dateTextMarginTop = 10;//横向轴日期文字与上方横线间隔

    private float timeTextMarginLeft = 20;//左侧竖向时间轴 marginLeft
    private float timeTextMarginRight = 20;//左侧竖向时间轴 marginRight


    private Rect mTimeTextBounds;//纵向时间轴文字
    private Rect mDateTextBounds;//横向日期轴文字

    private float topReservedHeight = 60;//上方预留高度

    private float rightReservedWidth = 40;//右侧空白长度

    private float startX;//绘制坐标 左下角原点 X
    private float startY;//绘制坐标 左下角原点 Y

    private Paint testVerticalLinePaint;

    private Paint drawPaint;
    private List<String> timeTextList = new ArrayList<>();
    private List<String> dateTextList = new ArrayList<>();

    //测试 临时
    private List<String> explainTextList = new ArrayList<>();
    private List<Integer> explainColorList = new ArrayList<>();

    public HistogramViewCV2_0(Context context) {
        this(context, null);
    }

    public HistogramViewCV2_0(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HistogramViewCV2_0(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mBottomTextBounds = new Rect();
        mBottomTextPaint = new Paint();
        mBottomTextPaint.setColor(Color.WHITE);
        mBottomTextPaint.setTextSize(28);
        mBottomTextPaint.setAntiAlias(true);
        mBottomTextPaint.setDither(true);

        mBottomRectPaint = new Paint();

        mDateTimeTextPaint = new Paint();
        mDateTimeTextPaint.setColor(Color.WHITE);
        mDateTimeTextPaint.setTextSize(28);
        mDateTimeTextPaint.setAntiAlias(true);
        mDateTimeTextPaint.setDither(true);

        mTimeTextBounds = new Rect();
        mDateTextBounds = new Rect();

        drawPaint = new Paint();

        //测试 临时
        testVerticalLinePaint = new Paint();
        testVerticalLinePaint.setColor(Color.WHITE);
        testVerticalLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        testVerticalLinePaint.setStrokeWidth(20);

        explainTextList.add("离床");
        explainTextList.add("清醒");
        explainTextList.add("REM");
        explainTextList.add("浅睡");
        explainTextList.add("深睡");

        timeTextList.add("12:00");
        timeTextList.add("08:00");
        timeTextList.add("04:00");
        timeTextList.add("00:00");
        timeTextList.add("20:00");
        timeTextList.add("16:00");
        timeTextList.add("12:00");

        dateTextList.add("03/16");
        dateTextList.add("03/17");
        dateTextList.add("03/18");
        dateTextList.add("03/19");
        dateTextList.add("03/20");
        dateTextList.add("03/21");
        dateTextList.add("03/22");

        explainColorList.add(Color.parseColor("#D3D3D3"));
        explainColorList.add(Color.parseColor("#61B0DD"));
        explainColorList.add(Color.parseColor("#F9FF04"));
        explainColorList.add(Color.parseColor("#EFC10C"));
        explainColorList.add(Color.parseColor("#9AE07D"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint testPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        testPaint.setColor(Color.parseColor("#2D3F56"));
        canvas.drawRect(0, 0, getWidth(), getHeight(), testPaint);


        //--->底部文字方块
        for (int i = 0; i < explainTextList.size(); i++) {
            //方块 left X坐标 --> 长度等分 - 总长度(方块+文字 )的一半
            float rectX = getWidth() / (explainTextList.size() + 1) * (i + 1) -
                    (mBottomRectWidth + mBottomRectTextMargin + mBottomTextBounds.width()) / 2;

            //底部文字
            mBottomTextPaint.getTextBounds(explainTextList.get(i), 0, explainTextList.get(i).length(), mBottomTextBounds);
            canvas.drawText(explainTextList.get(i), 0, explainTextList.get(i).length(), rectX + mBottomRectWidth + mBottomRectTextMargin, getHeight() - mBottomExplainMarginBottom, mBottomTextPaint);

            //底部方块
            mBottomRectPaint.setColor(explainColorList.get(i));
            canvas.drawRect(rectX,
                    getHeight() - mBottomRectHeight - mBottomExplainMarginBottom,
                    rectX + mBottomRectWidth,
                    getHeight() - mBottomExplainMarginBottom, mBottomRectPaint);
        }
        //<---

        //--->左侧竖向时间提示
        //绘制的坐标体系的左下角原点
        mDateTimeTextPaint.getTextBounds("12:00", 0, String.valueOf("12:00").length(), mTimeTextBounds);//获取绘制文字的宽高
        startX = timeTextMarginLeft + mTimeTextBounds.width() + timeTextMarginRight;//左侧时间+左右间隔

        mDateTimeTextPaint.getTextBounds("06/16", 0, String.valueOf("06/16").length(), mDateTextBounds);//获取绘制文字的宽高
        startY = getHeight() - (dateTextMarginBottom + dateTextMarginTop + mDateTextBounds.height() + getBottomExplainHeight());//总高度 - 最下方横线距离View最下端距离(下方提示文字高度+上下间隔+横向日期文字高度+上下间隔)

        drawPaint.setColor(Color.WHITE);
//        drawPaint.setColor(Color.parseColor("#19293B"));

        //坐标轴 横
        canvas.drawLine(startX, startY, getWidth() - rightReservedWidth, startY, drawPaint);
        //坐标轴 纵
        canvas.drawLine(startX, startY, startX, topReservedHeight, drawPaint);

        for (int i = 0; i < 7; i++) {
            //纵向时间
            canvas.drawText(timeTextList.get(i), 0, timeTextList.get(i).length(), timeTextMarginLeft,
                    topReservedHeight + ((startY - topReservedHeight) / 6 * i) + mTimeTextBounds.height() / 2,
                    mDateTimeTextPaint);
            //横向日期
            canvas.drawText(dateTextList.get(i), 0, dateTextList.get(i).length(),
                    (startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1)) - mDateTextBounds.width() / 2,
                    startY + dateTextMarginTop + mDateTextBounds.height(), mDateTimeTextPaint);

            //测试 横向竖线
            canvas.drawLine(startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), startY, startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), topReservedHeight, testVerticalLinePaint);

            //纵向横线
            canvas.drawLine(startX, topReservedHeight + (startY - topReservedHeight) / 6 * i, getWidth() - rightReservedWidth, topReservedHeight + (startY - topReservedHeight) / 6 * i, drawPaint);
        }

        for (int i = 1; i <= 6; i++) {

        }
        //<---

        //测试
//        canvas.drawLine(timeTextMarginLeft, getHeight() - getBottomExplainHeight(), getWidth(), getHeight() - getBottomExplainHeight(), drawPaint);
    }

    //注意mBottomTextBounds 需要在绘制后才能获取
    public float getBottomExplainHeight() {
        if (mBottomTextBounds.height() <= 0) {
            return mBottomRectHeight + mBottomExplainMarginBottom;
        }
        return mBottomRectHeight > mBottomTextBounds.height() ? mBottomRectHeight + mBottomExplainMarginBottom : mBottomTextBounds.height() + mBottomExplainMarginBottom;
    }


    //计算底部说明X坐标
    public int getExplainX(int i) {
        return getWidth() / (explainTextList.size() + 1) * (i + 1);
    }
}
