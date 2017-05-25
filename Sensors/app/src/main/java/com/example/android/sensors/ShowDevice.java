package com.example.android.sensors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDevice extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_device);
        TextView v = (TextView)findViewById(R.id.deviceView);
        try {
            Intent intent = getIntent();
            DeviceNew sData = (DeviceNew) intent.getSerializableExtra("data");
            v.setText(sData.getName()+ "\n" +
                    "Resolution: " + sData.getResolution() + "\n" +
                    "Type: " + sData.getType());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }

}

