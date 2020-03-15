package com.example.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "taskName";
    static final String KEY_DATE = "date";
    static final String KEY_EMAIL = "description";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 2;
    static final String DATABASE_CREATE =
            "create table contacts (_id integer primary key autoincrement, "+"taskName text not null,date text not null ,description text not null);";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private  static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            try{
                db.execSQL(DATABASE_CREATE);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion +
                    ",which will destroy all old data");
            onCreate(db);
        }
    }
    public  DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        DBHelper.close();
    }
    public long insertContact(String taskName,String date ,String description){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME,taskName);
        initialValues.put(KEY_DATE,date);
        initialValues.put(KEY_EMAIL,description);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public boolean deleteContact(long rowId){
        return db.delete(DATABASE_TABLE,KEY_ROWID+"="+rowId,null)>0;
    }
    public Cursor getAllContacts(){
        return db.query(DATABASE_TABLE,new String[]{KEY_ROWID,KEY_NAME,KEY_DATE,KEY_EMAIL},null,null,null,null,null);
    }
    public Cursor getContact(long rowId) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID,KEY_NAME,KEY_DATE,KEY_EMAIL},KEY_ROWID+"="+
                        rowId,null,null,null,null,null);
        if (mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateContact(long rowId, String taskName,String date ,String description)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME,taskName);
        args.put(KEY_DATE,date);
        args.put(KEY_EMAIL,description);
        return db.update(DATABASE_TABLE,args,KEY_ROWID+"="+rowId,null)>0;
    }
}
