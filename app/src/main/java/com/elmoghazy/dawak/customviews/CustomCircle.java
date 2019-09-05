package com.elmoghazy.dawak.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

    public class CustomCircle extends View {
    private float borderWidth = 4.0f;
    // View size in pixels
    private int size = 600;

    private Paint paint;
    public CustomCircle(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        paint = new Paint();

    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius= 270;
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.WHITE);
//        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
//        paint.setColor(Color.parseColor("#CD5C5C"))

        paint.setColor(Color.WHITE);
//        canvas.translate(getWidth()/2f,getHeight()/2f);
//        canvas.drawCircle(0,0, radius, paint);
        canvas.drawCircle(x / 2, y / 2  , radius, paint);
//        canvas.drawColor(Color.BLUE);
//        canvas.drawCircle(100,100,200,paint);
        // 1
//        paint.setColor(Color.WHITE);
//        paint.setStyle(Paint.Style.FILL);
//
//        // 2
//        float radius = size / 2f;
//
//        // 3
//        canvas.drawCircle(size / 2f, size / 2f, radius, paint);
//
//        // 4
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(borderWidth);
//
//        // 5
//        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint);
    }
//        @Override
//         protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//            // 1
//            size = Math.min(getWidth(),getHeight());
//// 2
//            setMeasuredDimension(size, size);
//
//        }
}
