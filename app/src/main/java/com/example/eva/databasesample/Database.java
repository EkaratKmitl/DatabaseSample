package com.example.eva.databasesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "su";
    private static final int DB_VERSION = 1;

        public static final String TABLE_NAME = "sound";

        public static final String COL_Left_LV1 = "soundL_LV1";
        public static final String COL_Left_LV2 = "soundL_LV2";
        public static final String COL_Left_LV3 = "soundL_LV3";
        public static final String COL_Left_LV4 = "soundL_LV4";
        public static final String COL_Left_LV5 = "soundL_LV5";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_Left_LV1 + " INTEGER, " + COL_Left_LV2 + " INTEGER, "
                + COL_Left_LV3 + " INTEGER, " + COL_Left_LV4 + " INTEGER, "
                + COL_Left_LV5 + " INTEGER);");

        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_Left_LV1 + ", " + COL_Left_LV2 + ", " + COL_Left_LV3 + ", " + COL_Left_LV4 + ", " + COL_Left_LV5 +") VALUES (1, 2, 3,4,5);");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

public class Database { }