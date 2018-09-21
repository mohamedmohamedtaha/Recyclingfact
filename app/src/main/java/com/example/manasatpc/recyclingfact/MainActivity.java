package com.example.manasatpc.recyclingfact;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String FACT_KEY = "fact_key";
    TextView factTextView;
    Button factButton,move_button,save_me_data;
    private String fact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for void rotate screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
getIntent().getStringExtra("");
        factTextView = (TextView)findViewById(R.id.facttextView);
        factButton = (Button)findViewById(R.id.factButton);
        move_button = (Button)findViewById(R.id.move_button);
        save_me_data= (Button)findViewById(R.id.save_me_data);
        final RecyclingFatsGenerator recyclingFatsGenerator = new RecyclingFatsGenerator(this);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fact = recyclingFatsGenerator.getFact();

                factTextView.setText(fact);

            }
        };
        View.OnClickListener onClickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SaveMyData.class);
                startActivity(intent);
            }
        };
        factButton.setOnClickListener(onClickListener);
        move_button.setOnClickListener(onClickListener1);
        save_me_data.setOnClickListener(onClickListener2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FACT_KEY,fact);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fact = savedInstanceState.getString(FACT_KEY);
        factTextView.setText(fact);

    }
}
