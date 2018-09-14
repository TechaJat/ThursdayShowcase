package com.example.thursdayshowcase.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScreeningDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "thursday_showcase.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ScreeningContract.ScreeningEntry.TABLE_NAME + " (" +
                    ScreeningContract.ScreeningEntry._ID + " INTEGER PRIMARY KEY," +
                    ScreeningContract.ScreeningEntry.COLUMN_NAME_Q1 + " INTEGER," +
                    ScreeningContract.ScreeningEntry.COLUMN_NAME_Q2 + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ScreeningContract.ScreeningEntry.TABLE_NAME;

    public ScreeningDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
