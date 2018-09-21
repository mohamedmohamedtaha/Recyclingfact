package com.example.manasatpc.recyclingfact.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manasatpc.recyclingfact.R;

import java.util.ArrayList;

/**
 * Created by ManasatPC on 21/09/18.
 */

public class AdapterCommercy extends BaseAdapter {
    ArrayList<Commercy> commercies = new ArrayList<>();
    Context context ;
    public AdapterCommercy(ArrayList<Commercy> commercies,Context context){
        this.commercies = commercies;
        this.context = context;
    }
    @Override
    public int getCount() {
        return commercies.size();
    }

    @Override
    public Object getItem(int i) {
        return commercies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_commercy, viewGroup,false);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.image_view);
        TextView title_view = (TextView) rowView.findViewById(R.id.text_view_title);
        imageView.setImageResource(commercies.get(i).getImage_id());
        title_view.setText(commercies.get(i).getName());
        return rowView;
    }
}


























