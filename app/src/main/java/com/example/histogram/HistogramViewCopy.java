package com.example.histogram;

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

public class HistogramViewCopy extends View {

    private Paint mBottomTextPaint;//底部文字
    private Rect mBottomTextBounds;

    private Paint mRectPaint;

    private int mBottomExplainMarginBottom = 18;//底部文字&方块 与最下方margin
    private int mBottomRectTextMargin = 18;//底部文字&方块 与最下方margin
    private int mBottomRectWidth = 40;//底部方块
    private int mBottomRectHeight = 30;//底部方块


    //测试 临时
    private List<String> explainTextList = new ArrayList<>();

    public HistogramViewCopy(Context context) {
        this(context, null);
    }

    public HistogramViewCopy(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HistogramViewCopy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mBottomTextBounds = new Rect();
        mBottomTextPaint = new Paint();
        mBottomTextPaint.setColor(Color.WHITE);
        mBottomTextPaint.setTextSize(28);

        mRectPaint = new Paint();

        //测试 临时
        explainTextList.add("离床");
        explainTextList.add("清醒");
        explainTextList.add("REM");
        explainTextList.add("浅睡");
        explainTextList.add("深睡");

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint testPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        testPaint.setColor(Color.parseColor("#25374B"));
        canvas.drawRect(0, 0, getWidth(), getHeight(), testPaint);


        //底部文字方块
        for (int i = 0; i < explainTextList.size(); i++) {
            //方块 left X坐标 --> 长度等分 - (方块+文字 总长度) / 2
            int rectX = getWidth() / (explainTextList.size() + 1) -
                    (mBottomRectWidth + mBottomRectTextMargin + mBottomTextBounds.width()) / 2;

            //底部文字
            mBottomTextPaint.getTextBounds(explainTextList.get(i), 0, explainTextList.get(i).length(), mBottomTextBounds);
            canvas.drawText(explainTextList.get(i), rectX + mBottomRectWidth + mBottomRectTextMargin, getHeight() - mBottomExplainMarginBottom, mBottomTextPaint);

            //底部方块
            mRectPaint.setColor(Color.parseColor("#FF8000"));


            canvas.drawRect(rectX * (i + 1),
                    getHeight() - mBottomRectHeight - mBottomExplainMarginBottom,
                    (rectX + mBottomRectWidth) * (i + 1),
                    getHeight() - mBottomExplainMarginBottom, mRectPaint);
        }
    }

    /**
     *
     *

     //底部文字方块
     for (int i = 0; i < explainTextList.size(); i++) {
     //方块 left X坐标 --> 长度等分 - (方块+文字 总长度) / 2
     int rectX = getWidth() / (explainTextList.size() + 1) -
     (mBottomRectWidth + mBottomRectTextMargin + mBottomTextBounds.width()) / 2;

     //底部文字
     mBottomTextPaint.getTextBounds(explainTextList.get(i), 0, explainTextList.get(i).length(), mBottomTextBounds);
     canvas.drawText(explainTextList.get(i), rectX + mBottomRectWidth + mBottomRectTextMargin, getHeight() - mBottomExplainMarginBottom, mBottomTextPaint);

     //底部方块
     mRectPaint.setColor(Color.parseColor("#FF8000"));


     canvas.drawRect(rectX * (i + 1),
     getHeight() - mBottomRectHeight - mBottomExplainMarginBottom,
     (rectX + mBottomRectWidth) * (i + 1),
     getHeight() - mBottomExplainMarginBottom, mRectPaint);
     }

     */


    //计算底部说明X坐标
    public int getExplainX(int i) {
        return getWidth() / (explainTextList.size() + 1) * (i + 1);
    }
}
