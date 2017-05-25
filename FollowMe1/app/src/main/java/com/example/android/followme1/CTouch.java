package com.example.android.followme1;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by AKSHAY on 5/19/2017.
 */

public class CTouch implements View.OnTouchListener
{
    MyDraw draw;

    public CTouch(MyDraw view)
    {
        draw = view;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {

            draw.setX(event.getX());
            draw.setY(event.getY());
            draw.invalidate();

        return true;
    }
}
