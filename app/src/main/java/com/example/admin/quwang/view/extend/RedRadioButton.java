package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.example.admin.quwang.R;

/**
 * Created by admin on 2017/3/28.
 */

public class RedRadioButton extends RadioButton {

    private Paint colorpaint;
    private TextPaint textPaint;
    int count;
    int radius;
    private Paint circlePaint;
    private int cx;
    private int cy;

    public RedRadioButton(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet set) {
        colorpaint = new Paint();
        colorpaint.setColor(getResources().getColor(R.color.colorAccent));
        colorpaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(10);
        textPaint.setStrokeWidth(2);
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        circlePaint = new Paint();
        circlePaint.setColor(Color.WHITE);
        circlePaint.setAntiAlias(true);
        circlePaint.setDither(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(1);
        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.RedRadioButton);
        count = typedArray.getInt(R.styleable.RedRadioButton_count, 0);
        typedArray.recycle();
    }

    public RedRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RedRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(getWidth(), getHeight()) / 5;
        cx = (int) (getWidth() / 2 + 1.5f * radius);
        cy = (int) (getHeight() / 2 - 1.5f * radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (count == 0) return;
        drawCirlce(canvas);
        drawCount(canvas);
        drawOvel(canvas);
    }

    private void drawOvel(Canvas canvas) {
        canvas.drawCircle(cx,cy,radius,circlePaint);
    }

    private void drawCount(Canvas canvas) {
        String countStr = count + "";
        if (count >= 100) {
            countStr = "99+";
        }

        float lenght = textPaint.measureText(countStr);
        Rect rect = new Rect();
        textPaint.getTextBounds(countStr, 0, countStr.length(), rect);

        int startX = (int) (cx - lenght / 2);
        int startY = (int) (cy + rect.height() / 2);
        canvas.drawText(countStr, 0, countStr.length(), startX, startY, textPaint);
    }

    public void setCount(int count) {
        this.count = count;
        postInvalidate();
    }

    private void drawCirlce(Canvas canvas) {
        canvas.drawCircle(cx, cy, radius, colorpaint);
    }
}
