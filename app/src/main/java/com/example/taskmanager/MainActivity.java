package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;
import java.sql.Timestamp;
public class MainActivity extends AppCompatActivity {

    private RecyclerView tasks;
    private RecyclerView.Adapter adapter;
    int request_Code = 1;

    ArrayList<Task> list = new ArrayList<>();
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> tasks= assignTask();



        this.tasks = (RecyclerView) findViewById(R.id.tasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.tasks.setLayoutManager(mLayoutManager);

        adapter = new TaskAdapter(tasks,this);
        this.tasks.setAdapter(adapter);

    }
    public void onClick(View view){
        startActivityForResult(new Intent("com.example.taskmanager.SecondActivity"),request_Code);
    }
    public  void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==request_Code){
            if (resultCode == RESULT_OK){
                db.open();
                long id = db.insertContact(data.getStringExtra("satu"),data.getStringExtra("dua"),data.getStringExtra("tiga"));
                db.close();
                list.add(new Task(data.getStringExtra("satu"), Timestamp.valueOf(data.getStringExtra("dua")) ,data.getStringExtra("tiga")));
                adapter = new TaskAdapter(list,this);
                this.tasks.setAdapter(adapter);
            }
        }
    }
    private ArrayList<Task> assignTask() {

        db.open();
            Cursor c = db.getAllContacts();
            if (c.moveToFirst()){
                do{
                    list.add(new Task(c.getString(1), Timestamp.valueOf(c.getString(2)) ,c.getString(3)));
                }while (c.moveToNext());
            }
        db.close();

        return list;
    }
}

