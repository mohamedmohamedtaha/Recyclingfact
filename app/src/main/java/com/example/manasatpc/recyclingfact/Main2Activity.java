package com.example.manasatpc.recyclingfact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    Button eat,grow,shop,make, cook, list_view,recycler_view;
    EditText enter_name;
    String name_entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        eat = (Button)findViewById(R.id.eat);
        grow = (Button)findViewById(R.id.grow);
        shop = (Button)findViewById(R.id.shop);
        make = (Button)findViewById(R.id.make);
        cook = (Button)findViewById(R.id.cook);
        list_view = (Button)findViewById(R.id.list_view);
        recycler_view = (Button)findViewById(R.id.recycler_view);

        enter_name=(EditText)findViewById(R.id.enter_name);
        grow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(getString(R.string.grow));

            }
        });

        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(getString(R.string.cook));

            }
        });
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(getString(R.string.eat));

            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(getString(R.string.shop));

            }
        });
        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(getString(R.string.make));

            }
        });
        list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,ListActivity.class);
                startActivity(intent);
            }
        });
        recycler_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setIntent(String type){
        name_entered = enter_name.getText().toString();
        Intent intent =new Intent(Main2Activity.this,DetialsActivity.class);
        intent.putExtra(getString(R.string.enter_name),name_entered);
        intent.putExtra(getString(R.string.name_button),type);
        startActivity(intent);
    }

}




