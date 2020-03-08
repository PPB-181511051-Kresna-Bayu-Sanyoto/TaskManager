package com.example.taskmanager;

import android.app.Activity;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void onClick(View view){
        Intent i = new Intent();
        //get the EditText view
        String[] task = new String[3];
        EditText editText = (EditText)findViewById(R.id.editText);
        task[0] = editText.getText().toString();
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        task[1] = editText2.getText().toString()+" 00:00:00";
        EditText editText3 = (EditText)findViewById(R.id.editText3);
        task[2] = editText3.getText().toString();
        //set data to pass back
        i.putExtra("satu",task[0]);
        i.putExtra("dua",task[1]);
        i.putExtra("tiga",task[2]);
        setResult(RESULT_OK,i);
        //closes the activity
        finish();
    }
}
