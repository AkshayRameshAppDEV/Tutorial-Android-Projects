package com.example.android.helloworld4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HelloWorld4 extends AppCompatActivity
{
    private  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a function!!!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void btnClick(View v)
    {

        int btnColor = ((Button)v).getCurrentTextColor();
        btnColor += 1000;
        ((Button)v).setTextColor(btnColor);
    }
    public void helloClick(View v)
    {
        String strText = ((TextView)v).getText().toString();

        String strNum;
        if (Character.isDigit(strText.charAt(strText.length()-1)))
        {
            strText += "1";
        }

        else
        {
            strText += "9";
        }
        ((TextView)v).setText(strText);
    }

    public void magic_button(View view)
    {
        textView = (TextView) findViewById(R.id.original);
        textView.setBackgroundColor(255);
         //TextView textView = (TextView) findViewById(R.id.original);

        //Toast.makeText(this,"Hello Magic Button", Toast.LENGTH_SHORT).show();
    }
}
