package com.example.manasatpc.recyclingfact;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SaveMyData extends AppCompatActivity {
    private static final String PREF_FILE = "com.example.manasatpc.recyclingfact.saveMyData";
    private static final String TEXT_KEY ="text_key" ;
    EditText editText;
    TextView textView;
    CheckBox checkBox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_my_data);

        editText = (EditText)findViewById(R.id.editText_save_my_data);
        textView = (TextView)findViewById(R.id.text_view_save_me_data);
        sharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

        checkBox = (CheckBox)findViewById(R.id.checkBox);

        Boolean b = sharedPreferences.getBoolean(TEXT_KEY, false);
        checkBox.setChecked(b);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putString(TEXT_KEY,editText.getText().toString()).apply();
        sharedPreferences.edit().putBoolean(TEXT_KEY,checkBox.isChecked()).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences.edit().remove(TEXT_KEY).apply();
        String name = sharedPreferences.getString(TEXT_KEY,"لا توجد قيمةمخزنة");
        textView.setText(name);
    }
}
