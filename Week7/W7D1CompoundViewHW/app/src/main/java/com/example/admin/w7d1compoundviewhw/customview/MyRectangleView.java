package com.example.admin.w7d1compoundviewhw.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.w7d1compoundviewhw.R;

public class MyRectangleView extends View {

    int fillColor;
    private Paint paint;
    int width;
    int height;

    public MyRectangleView(Context context) {
        super(context);
    }

    public MyRectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs,0,0);
    }

    public MyRectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs,defStyleAttr,0);
    }

    public MyRectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs,defStyleAttr,defStyleRes);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRectangleView, defStyleAttr, defStyleRes);

//        fillColor = typedArray.getColor(R.styleable.MyRectangleView_fillColor, getResources().getColor(android.R.color.black)); //getColor returns an integer value of a color, Color.BLACK also would work
        fillColor = typedArray.getColor(R.styleable.MyRectangleView_fillColor, Color.BLACK); //getColor returns an integer value of a color, Color.BLACK also would work

        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(fillColor);
        Rect rect=new Rect();
        rect.set(100,150,500,400);

        canvas.drawRect(rect, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int desiredHeight = 200;
        int desiredWidth = 200;

        //we get the value of the specification, wrap-content, match-parent...
        int widthMode = MeasureSpec.getMode(widthMeasureSpec); //check the mode of the width
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec); //check the mode of the height
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //Measure width
        if (widthMode == MeasureSpec.EXACTLY) {
            //must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than that
            width = Math.min(desiredHeight, widthSize);
        }else{
            //whatever we want
            width = desiredWidth;
        }

        //Measure height
        if (heightMode == MeasureSpec.EXACTLY) {
            //must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than that
            height = Math.min(desiredHeight, heightSize);
        }else{
            //whatever we want
            height = desiredWidth;
        }

        setMeasuredDimension(width, height);
    }
}
