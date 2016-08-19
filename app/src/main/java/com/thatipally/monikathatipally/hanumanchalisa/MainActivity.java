package com.thatipally.monikathatipally.hanumanchalisa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;
    TextView tv;
    Typeface st;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st = Typeface.createFromAsset(getAssets(), "fonts/Zenzai.ttf");

        tv=(TextView)findViewById(R.id.title);
        tv.setTypeface(st);

        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Telugu.class);
                startActivity(i);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(MainActivity.this,Hindi.class);
                startActivity(i1);

            }
        });
    }
}
