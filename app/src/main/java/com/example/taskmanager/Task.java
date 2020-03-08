package com.example.taskmanager;

import java.util.Date;
import java.sql.Timestamp;
public class Task {
    private String namaMatkul;
    private Timestamp deadLine;
    private String deskripsiTugas;

    public Task(String namaMatkul, Timestamp deadLine, String deskripsiTugas) {
        this.namaMatkul = namaMatkul;
        this.deadLine = deadLine;
        this.deskripsiTugas = deskripsiTugas;
    }
    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public Timestamp getDeadLine(){ return deadLine; }

    public void setDeadLine(Timestamp deadLine) {this.deadLine = deadLine;}

    public String getDeskripsiTugas() {
        return deskripsiTugas;
    }

    public void setDeskripsiTugas(String deskripsiTugas) {
        this.deskripsiTugas = deskripsiTugas;
    }


}
