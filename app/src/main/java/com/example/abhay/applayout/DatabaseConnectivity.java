package com.example.abhay.applayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnectivity extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "NEW_DB";
    // Contacts table name
    private static final String TABLE_NAME_1 = "DEST_DATA";
    private static final String TABLE_NAME_2 = "CUSTOM_MSG";
    // Shops Table Columns names
    private static final String DEST = "destination";
    private static final String CONTACT = "contact";
    private static final String CUS_MSG = "custom_msg";
    private static final String LAT="lattitude";
    private static final String LONG="longitude";


    public DatabaseConnectivity(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SAVED_DATA = "CREATE TABLE " + TABLE_NAME_1 + "("
        + DEST + " VARCHAR(20),"+LAT +" VARCHAR(20) ,"+LONG+" VARCHAR(20) )";

        String CUSTOM_MSG = "CREATE TABLE " + TABLE_NAME_2 + "("
                + CUS_MSG + " VARCHAR(20)"+")";

        db.execSQL(SAVED_DATA);
        db.execSQL(CUSTOM_MSG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    SQLiteDatabase db;
    //db functions for Table_2

    public void addMsg(cus_msg_elements ele) {

        db = this.getWritableDatabase();
        db.delete(TABLE_NAME_2,null,null);
        ContentValues values = new ContentValues();
        values.put(CUS_MSG, ele.getMsg());

        db.insert(TABLE_NAME_2, null, values);
        db.close(); // Closing database connection
    }

    public cus_msg_elements showMsg()
    {
        cus_msg_elements ele = new cus_msg_elements();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME_2,null);
        if (cursor.moveToFirst()) {
            ele = new cus_msg_elements(cursor.getString(0));
        }
        return ele;
    }


    //db functions for Table_1

    public void addDetails(saved_data_elements ele) {
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME_1,null,null);
        ContentValues values = new ContentValues();
        values.put(DEST,ele.getDest());
        values.put(LAT,ele.getLattitude());
        values.put(LONG,ele.getLongitude());

        db.insert(TABLE_NAME_1,null,values);
        db.close();
    }

    public saved_data_elements showDetails()
    {
        saved_data_elements ele = new saved_data_elements();
        db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABLE_NAME_1,null);
        if(cursor.moveToFirst()) {
            ele.setDest(cursor.getString(0));
            ele.setLattitude(cursor.getString(1));
            ele.setLongitude(cursor.getString(2));
        }
        return ele;

    }
}
