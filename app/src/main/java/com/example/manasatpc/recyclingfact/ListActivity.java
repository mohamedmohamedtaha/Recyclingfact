package com.example.manasatpc.recyclingfact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.manasatpc.recyclingfact.model.AdapterCommercy;
import com.example.manasatpc.recyclingfact.model.Commercy;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    AdapterCommercy adapterCommercy ;
    ArrayList<Commercy>commercyArrayList =new ArrayList<>();
    ListView listView ;
    EditText enter_name;
    String name_entered;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView)findViewById(R.id.list_view);
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

        adapterCommercy = new AdapterCommercy(commercyArrayList,this);

        listView.setAdapter(adapterCommercy);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setIntent(commercyArrayList.get(i));

            }
        });


    }
    private void setIntent(Commercy commercy){
        name_entered = enter_name.getText().toString();
        Intent intent =new Intent(ListActivity.this,DetialsActivity.class);
        intent.putExtra(getString(R.string.enter_name),name_entered);
        intent.putExtra(getString(R.string.name_button),commercy);
        startActivity(intent);
    }
}
