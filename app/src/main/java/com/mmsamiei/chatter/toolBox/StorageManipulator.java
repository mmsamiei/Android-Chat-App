package com.mmsamiei.chatter.toolBox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.RowId;

/**
 * Created by Win2 on 3/17/2016.
 */
public class StorageManipulator extends SQLiteOpenHelper{
    public static final String Database_name="Chatter.db";
    public static final int Database_version=1;

    public static final String _ID = "_id";
    public static final String Table_name_message = "table_message";
    public static final String Message_Reciver="reciver";
    public static final String Message_Sender = "Sender";
    public static final String Message_Message = "message";
    public static final String TABLE_MESSAGE_DROP
            ="DROP TABLE IF EXIST"+Table_name_message;
    private static final String TABLE_MESSAGE_CREATE
            ="CREATE TABLE "+Table_name_message
            +"("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +Message_Reciver+" VARCHAR(25),"
            +Message_Sender+" VARCHAR(25))";

    public StorageManipulator(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_MESSAGE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_MESSAGE_DROP);

    }
    public void insert(String Sender,String Reciver,String Message){
        long rowId;
        try {
            SQLiteDatabase db= getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Message_Reciver,Reciver);
            contentValues.put(Message_Sender,Sender);
            contentValues.put(Message_Message,Message);
            rowId=db.insert(Table_name_message,null,contentValues);

        }
        catch (Exception e){

        }
    }
    public Cursor get(String sender,String Reciver){
        SQLiteDatabase db = getWritableDatabase();
        String selectQuery="SELECT * FROM"+Table_name_message+"WHERE"+Message_Sender+"LIKE"+sender+"AND"+Message_Reciver+"LIKE"+Reciver+"ORDER BY "+_ID+"ASC";
        return null;
    }
}
