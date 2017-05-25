package com.example.android.sensors;



        import java.io.Serializable;

/**
 * Created by jxc064000 on 2/7/2016.
 */
public class DeviceNew implements Serializable
{
    private String strName;
    int iType;
    private double dResolution;
    DeviceNew()
    {
        iType = 0;
        dResolution = 0.0;
        strName = "";
    }
    DeviceNew(String name, int iType, double resolution)
    {
        strName = name;
        this.iType = iType;
        dResolution = resolution;
    }
    public String getName() {return strName;}
    public int getType() {return iType;}
    public double getResolution() {return dResolution;}
}