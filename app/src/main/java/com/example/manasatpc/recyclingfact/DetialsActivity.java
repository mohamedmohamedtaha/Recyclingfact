package com.example.manasatpc.recyclingfact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manasatpc.recyclingfact.model.Commercy;

public class DetialsActivity extends AppCompatActivity {
TextView show_title,show_description;
String show_name /*,type*/ ;
ImageView show_image;
Button share_friend ;
private Commercy commercy ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detials);
        show_title = (TextView)findViewById(R.id.show_title);
        show_description = (TextView)findViewById(R.id.show_description);
        share_friend = (Button)findViewById(R.id.share_friend);
        show_image = (ImageView)findViewById(R.id.show_image);
        show_name = getIntent().getStringExtra(getString(R.string.enter_name));
        show_title.setText(show_name);
        commercy =   (Commercy) getIntent().getSerializableExtra(getString(R.string.name_button));
        // type = getIntent().getStringExtra(getString(R.string.name_button));

      //  show_image.setImageResource(getTypeDrawable(type));
        show_image.setImageResource(commercy.getImage_id());

     //   show_title.setText(type);
        show_title.setText(commercy.getName());

      //  show_description.setText(getDescription(type));
        show_description.setText(commercy.getDescription());

        share_friend.setText(String.format("%s %s ",getString(R.string.share_friend),show_name));
        share_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
               // String messgae = String.format("%s: %s",show_name,getDescription(type));
                String messgae = String.format("%s: %s",show_name,commercy.getDescription());

                shareIntent.putExtra(Intent.EXTRA_TEXT,messgae);
                startActivity(Intent.createChooser(shareIntent,getString(R.string.app_name2)));
            }
        });
    }
    private int getTypeDrawable(String type){
        if (type.equals(getString(R.string.make))){
            return R.drawable.make;
        }else if (type.equals(getString(R.string.cook))){
            return R.drawable.cook;
        }
        else if (type.equals(getString(R.string.shop))){
            return R.drawable.shop;

        }else if (type.equals(getString(R.string.grow))){
            return R.drawable.grow;

        }else
            return R.drawable.eat;
    }
    private String getDescription(String type){
        if (type.equals(getString(R.string.make))){
            return getString(R.string.make_description);
        }else if (type.equals(getString(R.string.cook))){
            return getString(R.string.cook_description);
        }
        else if (type.equals(getString(R.string.shop))){
            return getString(R.string.shop_description);

        }else if (type.equals(getString(R.string.grow))){
            return getString(R.string.grow_description);

        }else
            return getString(R.string.eat_description);
    }
}
