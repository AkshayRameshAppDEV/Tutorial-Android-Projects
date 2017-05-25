package com.example.android.contacts2;


import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Created by jxc064000 on 5/18/2017.
 */

public class FileIO
{





    /********************************************************************
     * Function to return all lines read from a file in an ArrayList.
     * @param strFilename
     * @return ArrayList of all lines from the fi
     ********************************************************************/
    public HashMap<Integer, String> readContacts(String strFilename)
    {
        File inputFile;
        Scanner input = null;
        HashMap<Integer, String> contactList = new HashMap<Integer, String>();
        try
        {

            inputFile = new File(strFilename);
            input = new Scanner(inputFile);
        }
        catch(Exception ex)
        {
            return contactList;
        }
        while (input.hasNext())
        {
            String strLine = input.nextLine();
            String[] strTemp = strLine.split("\t");
            contactList.put(Integer.parseInt(strTemp[0]), strLine);
        }
        input.close();
        return contactList;
    }

    public void writeContacts(HashMap<Integer, String> strList, String strFilename)
    {
        File outfile;
        PrintWriter writer = null;

        try
        {
            outfile = new File(strFilename);
            writer = new PrintWriter(outfile);
        }
        catch(Exception ex)
        {
        }
        for(Map.Entry<Integer, String> entry : strList.entrySet())
        {
            Integer key = entry.getKey();
            String value = entry.getValue();
            writer.println(value);
        }
        writer.close();
    }

}
