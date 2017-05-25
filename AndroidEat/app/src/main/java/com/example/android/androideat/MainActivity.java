package com.example.android.androideat;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view)
    {

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(50);

        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
        tg.startTone(ToneGenerator.TONE_CDMA_REORDER);

        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);

                // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        textView.setText("I'm so full!!!");

    }
    public void undo(View view)
    {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.before_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        textView.setText("I'm so hungry!!!");

    }
}