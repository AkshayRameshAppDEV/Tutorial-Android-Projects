package com.example.android.sensordemo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by AKSHAY on 5/19/2017.
 */




public class LineView extends View implements SensorEventListener
{
    Paint pBlue;
    Paint pCircle;
   float xPos,yPos;
    SensorManager mSensorManager;
    Sensor mAccelerometer;

    public LineView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        pBlue = new Paint();
        pBlue.setColor(Color.BLUE);
        pBlue.setStrokeWidth(4);

        pCircle = new Paint();
        pCircle.setColor(Color.RED);
        pCircle.setStrokeWidth(3);
        pCircle.setStyle(Paint.Style.STROKE);

    }



    @Override
    public void onDraw(Canvas canvas)
    {
        int width = this.getWidth();
        int height = this.getHeight();
        canvas.drawLine(width/2,0,width/2,height,pBlue);
        canvas.drawLine(0,height/2,width,height/2,pBlue);
        canvas.drawCircle(xPos*10+width/2,yPos*10+height/2,width/10.0f,pCircle);


    }

    public void setSensor(SensorManager sm)
    {
        mSensorManager = sm;
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }
    public void  registerListener()
    {
        mSensorManager.registerListener(this,mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void unRegisterListener()
    {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        xPos = event.values[0];
        yPos = event.values[1];
        invalidate();
    }

    @Override
    public  void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}
