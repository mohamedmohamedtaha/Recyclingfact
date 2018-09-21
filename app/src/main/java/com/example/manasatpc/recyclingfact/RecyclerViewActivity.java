package com.example.manasatpc.recyclingfact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.manasatpc.recyclingfact.model.AdapterCommercy;
import com.example.manasatpc.recyclingfact.model.Commercy;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    AdapterRecyclerView adapterRecyclerView ;
    ArrayList<Commercy>commercyArrayList =new ArrayList<>();
    RecyclerView listView ;
    EditText enter_name;
    String name_entered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        listView = (RecyclerView) findViewById(R.id.recycler_view);
        enter_name= (EditText)findViewById(R.id.edit_text) ;
        final Commercy commercy = new Commercy(getString(R.string.grow),getString(R.string.grow_description),R.drawable.grow);
        Commercy commercy1 = new Commercy(getString(R.string.eat),getString(R.string.eat_description),R.drawable.eat);
        Commercy commercy2 = new Commercy(getString(R.string.shop),getString(R.string.shop_description),R.drawable.shop);
        Commercy commercy3 = new Commercy(getString(R.string.make),getString(R.string.make_description),R.drawable.make);
        Commercy commercy4 = new Commercy(getString(R.string.cook),getString(R.string.cook_description),R.drawable.cook);
        commercyArrayList.add(commercy);
        commercyArrayList.add(commercy1);
        commercyArrayList.add(commercy2);
        commercyArrayList.add(commercy3);
        commercyArrayList.add(commercy4);


        adapterRecyclerView = new AdapterRecyclerView(commercyArrayList,this);
        listView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(linearLayoutManager);


        listView.setAdapter(adapterRecyclerView);

        }
    public void setIntent(Commercy commercy){
        name_entered = enter_name.getText().toString();
        Intent intent =new Intent(RecyclerViewActivity.this,DetialsActivity.class);
        intent.putExtra(getString(R.string.enter_name),name_entered);
        intent.putExtra(getString(R.string.name_button),commercy);
        startActivity(intent);
    }
}
