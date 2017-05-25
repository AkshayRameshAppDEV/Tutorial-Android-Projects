package com.example.android.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeviceList extends Activity
{
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView tv;
    //???  private Paint pBlue;
//???  float x, y, z;
    private View mainView;
    private ArrayList<String> slist;
    private HashMap<String, Sensor> sensorMap;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        int iCount = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sensor);
        mainView = new View(this);
        tv = (TextView)findViewById(R.id.textView);
        listview = (ListView) findViewById(R.id.listView);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // List all of the available sensors.  This list will go away as soon as
        // we create the new view, so comment that out if you want to see the list.
        slist = new ArrayList<String>();
        sensorMap = new HashMap<String, Sensor>();
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        Iterator<Sensor> i = sensorList.iterator();
        while (i.hasNext()) {
            Sensor s = i.next();
            slist.add(s.getName());
            sensorMap.put(s.getName(), s);
            iCount++;
        }
        // Once we have the entire list, add it as the model for the
        // ListView.  Set up the click listener for the list.
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, slist);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new ItemClickListener());
        //Show the number of sensors in the title string.
        String strText = tv.getText().toString();
        strText += ": " + iCount;
        tv.setText(strText);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
//???    mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor, menu);
        return true;
    }

    public void onTextClick(View v)
    {
        if (v.getAlpha() != 0)
            v.setAlpha(0.0f);
        else
            v.setAlpha(1.0f);
    }


    private class StableArrayAdapter extends ArrayAdapter<String>
    {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects)
        {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }
    }


    private class ItemClickListener implements AdapterView.OnItemClickListener
    {
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id)
        {
            String device = (String) ((TextView) v).getText();
            Sensor s = sensorMap.get(device);
            int iType = s.getType();
            Intent iShow = new Intent(DeviceList.this, ShowDevice.class);
            DeviceNew dev = new DeviceNew(device, iType, 0.1);
            iShow.putExtra("data", dev);
            startActivity(iShow);
        }
    }
}