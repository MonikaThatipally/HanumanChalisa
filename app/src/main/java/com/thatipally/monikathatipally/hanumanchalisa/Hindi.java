package com.thatipally.monikathatipally.hanumanchalisa;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class Hindi extends AppCompatActivity {

    Button hindi, henglish;
    String hcurrentLanguage;
    TextView hnews;
    Typeface hindiFont;
    Typeface hengFont;
    ToggleButton  hinplaybt;
    private MediaPlayer hinobj;
    Configuration hconfig;
    TextView htv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        hinplaybt = (ToggleButton) findViewById(R.id.tplay);
        htv=(TextView)findViewById(R.id.htvid);

        hinobj = MediaPlayer.create(Hindi.this,R.raw.hanumanhindi);


        hinplaybt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (hinplaybt.isChecked()) {
                    hinobj.start();
                    hinplaybt.setBackgroundResource(R.drawable.play);
                    htv.setText("play");
                } else {
                    hinobj.pause();
                    hinplaybt.setBackgroundResource(R.drawable.pause);
                    htv.setText("pause");
                }
            }
        });

        hcurrentLanguage = "";

        hengFont = Typeface.createFromAsset(getAssets(), "fonts/Gidugu.ttf");
        hindiFont = Typeface.createFromAsset(getAssets(), "fonts/anandmurti.ttf");

        hindi = (Button) findViewById(R.id.hinid);
        hindi.setTypeface(hindiFont);
        henglish = (Button) findViewById(R.id.hinengid);


        hnews = (TextView) findViewById(R.id.news);
        hnews.setText(R.string.hinnote);
        hnews.setTypeface(hindiFont);

        hindi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                hcurrentLanguage = "hi";
                Locale locale = new Locale(hcurrentLanguage);
                Locale.setDefault(locale);

                System.out.println("My current language: "
                        + Locale.getDefault());

                hconfig = new Configuration();
                hconfig.locale = locale;
                getBaseContext().getResources().updateConfiguration(hconfig,
                        getBaseContext().getResources().getDisplayMetrics());

                hnews.setText(R.string.hinnote);
                hnews.setTypeface(hindiFont);
            }
        });

        henglish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                hcurrentLanguage = "en";
                Locale locale = new Locale(hcurrentLanguage);
                Locale.setDefault(locale);


                System.out.println("My current language: "
                        + Locale.getDefault());

                hconfig = new Configuration();
                hconfig.locale = locale;
                getBaseContext().getResources().updateConfiguration(hconfig,
                        getBaseContext().getResources().getDisplayMetrics());

                hnews.setText(R.string.Engnote);
                hnews.setTypeface(hengFont);
            }
        });
    }
    public void onDestroy() {

        super.onDestroy();
        if(hinobj!=null) {
            hinobj.stop();
            hinobj.release();


        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


