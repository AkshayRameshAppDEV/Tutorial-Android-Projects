package com.example.android.hellotablet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{


    private TextView helloText,BGcol;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        // NOTE: setContentView is below, not here



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

    public void changeBGColor(View view)
    {
      /* helloText = (TextView) findViewById(R.id.helloText);
        linearLayout = (LinearLayout) findViewById(R.id.linearOrg);
        BGcol = (TextView) findViewById(R.id.BGtext);
        helloText.setTextColor(Color.RED);
        linearLayout.setBackgroundColor(Color.parseColor("#000000"));
            BGcol.setText(" How are   you??\n");
            BGcol.setTextColor(Color.YELLOW);
            BGcol.setTextSize(100);
        Toast.makeText(this,"!!!!!",Toast.LENGTH_LONG).show();
        */



      // Create new LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(0xff99ccff);

        // Add textviews
        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView1.setText("programmatically created TextView1");
        textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
        textView1.setPadding(20, 20, 20, 20); // in pixels (left, top, right, bottom)
        linearLayout.addView(textView1);

        TextView textView2 = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.RIGHT;
        layoutParams.setMargins(10, 10, 10, 10); // (left, top, right, bottom)
        textView2.setLayoutParams(layoutParams);
        textView2.setText("programmatically created TextView2");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView2.setBackgroundColor(0xffffdbdb); // hex color 0xAARRGGBB
        linearLayout.addView(textView2);



        TextView textView3 = new TextView(this);
        LinearLayout.LayoutParams layoutParamss = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.RIGHT;
        layoutParams.setMargins(10, 10, 10, 10); // (left, top, right, bottom)
        textView2.setLayoutParams(layoutParamss);
        textView2.setText("programmatically created TextView2");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView2.setBackgroundColor(0xffffdbdb); // hex color 0xAARRGGBB
        linearLayout.addView(textView3);

        // Set context view
        setContentView(linearLayout);



    }
}
