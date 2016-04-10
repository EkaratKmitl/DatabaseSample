package com.example.eva.databasesample;
import java.util.ArrayList;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor mCursor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView)findViewById(R.id.listView1);
//*******************************************************************************************************************************
        mHelper = new MyDbHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT " + MyDbHelper.COL_Left_LV1 + ", "  + MyDbHelper.COL_Left_LV2
                + ", " + MyDbHelper.COL_Left_LV3 +", " + MyDbHelper.COL_Left_LV4 +", " + MyDbHelper.COL_Left_LV5 + " FROM " + MyDbHelper.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add("Sound LV1 :" + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_Left_LV1)) + "\t\t"
                    + "Sound LV2  : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_Left_LV2)) + "\n"
                    + "Sound LV3: " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_Left_LV3))+"\t\t"
                    + "Sound LV4 : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_Left_LV4)) + "\n"
                    + "Sound LV5: " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_Left_LV5))+"\t\t"
            );
            mCursor.moveToNext();
        }
//**********************************************************************************************************************************
        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);
    }   //OnCreate

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }       //onPause
 }           //main














