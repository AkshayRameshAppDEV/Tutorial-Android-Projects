package com.example.android.followme1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by AKSHAY on 5/19/2017.
 */

public class MyDraw extends View
{
    Paint pBlue;
    Paint pCircle;
    float xPos=100, yPos=100;
    SensorManager mSensorManager;
    Sensor mAccelerometer;

    public MyDraw(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        pBlue = new Paint();
        pBlue.setColor(Color.BLUE);
        pBlue.setStrokeWidth(4);

        pCircle = new Paint();
        pCircle.setColor(Color.RED);
        pCircle.setStrokeWidth(3);
        pCircle.setStyle(Paint.Style.FILL);

    }

    @Override
    public void  onDraw(Canvas canvas)
    {
        canvas.drawCircle(xPos,yPos,50,pCircle);

    }
    public void setX(float x)
    {
        xPos = x;


    }
    public void setY(float y)
    {
        yPos =y;

    }

}




