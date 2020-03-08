package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.sql.Timestamp;
public class MainActivity extends AppCompatActivity {

    private RecyclerView tasks;
    private RecyclerView.Adapter adapter;
    int request_Code = 1;
    String nama = "";
    Timestamp tanggal;
    String desc="";
    ArrayList<Task> list = new ArrayList<>();

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
                list.add(new Task(data.getStringExtra("satu"), Timestamp.valueOf(data.getStringExtra("dua")) ,data.getStringExtra("tiga")));
                adapter = new TaskAdapter(list,this);
                this.tasks.setAdapter(adapter);
            }
        }
    }
    private ArrayList<Task> assignTask() {


        list.add(new Task("agama", Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat kaligrafi"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));
        list.add(new Task("pkn",Timestamp.valueOf("2020-4-10 02:30:30") ,"membuat presentasi mengenai pemilihan menteri"));


        return list;
    }
}

