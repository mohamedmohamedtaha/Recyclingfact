package com.example.manasatpc.recyclingfact;

import android.content.Context;

import java.util.Random;

/**
 * Created by ManasatPC on 14/09/18.
 */

public class RecyclingFatsGenerator {
    String facts[];
    public RecyclingFatsGenerator(Context context){
        facts = context.getResources().getStringArray(R.array.facts);
    }
    public String getFact(){
        Random andomGin = new Random();
        int numberRandom = andomGin.nextInt(facts.length);
        String fact = facts[numberRandom];
        return fact;
    }
        {
    }
}
