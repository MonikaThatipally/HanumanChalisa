package com.thatipally.monikathatipally.hanumanchalisa;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class Telugu extends AppCompatActivity {

    Button telugu, english;
    String currentLanguage;
    TextView news;
    Typeface teluguFont;
    Typeface engFont;
    ToggleButton  playbt;
    TextView tv;

    private MediaPlayer mpobj;
    Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telugu);
        playbt = (ToggleButton) findViewById(R.id.play);
         tv=(TextView)findViewById(R.id.tvid);

        mpobj = MediaPlayer.create(Telugu.this,R.raw.hanumanaudio);

        playbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (playbt.isChecked()) {
                   mpobj.start();
                    playbt.setBackgroundResource(R.drawable.play);
                    tv.setText("play");
                } else {
                    mpobj.pause();
                    playbt.setBackgroundResource(R.drawable.pause);
                   tv.setText("pause");

                }
            }
        });


        currentLanguage = "";

        telugu = (Button) findViewById(R.id.ttelugu);
        english = (Button) findViewById(R.id.tenglish);

        engFont = Typeface.createFromAsset(getAssets(), "fonts/Gidugu.ttf");

        news = (TextView) findViewById(R.id.tnews);
        news.setText(R.string.note);
        news.setTypeface(engFont);

        teluguFont = Typeface.createFromAsset(getAssets(), "fonts/Gidugu.ttf");

        telugu.setTypeface(teluguFont);

        telugu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                currentLanguage = "te";
                Locale locale = new Locale(currentLanguage);
                Locale.setDefault(locale);

                System.out.println("My current language: "
                        + Locale.getDefault());

                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                news.setText(R.string.telnote);
                news.setTypeface(teluguFont);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                currentLanguage = "en";
                Locale locale = new Locale(currentLanguage);
                Locale.setDefault(locale);


                System.out.println("My current language: "
                        + Locale.getDefault());

                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                news.setText(R.string.note);
                news.setTypeface(engFont);
            }
        });
    }
    public void onDestroy() {

        super.onDestroy();
        if(mpobj!=null) {
            mpobj.stop();
            mpobj.release();

        }
    }

}


