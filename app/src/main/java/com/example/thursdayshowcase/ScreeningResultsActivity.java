package com.example.thursdayshowcase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thursdayshowcase.fragments.ScreeningResultRow;
import com.example.thursdayshowcase.models.ScreeningContract;
import com.example.thursdayshowcase.models.ScreeningDbHelper;

import java.util.ArrayList;
import java.util.List;

public class ScreeningResultsActivity extends AppCompatActivity {

    private List<ScreeningResultRow> screeningRows = new ArrayList<ScreeningResultRow>();
    private RecyclerView recyclerView;
    private ScreeningResultsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening_results);

        recyclerView = findViewById(R.id.recyclerView);

        mAdapter = new ScreeningResultsAdapter(screeningRows);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        getScreeningResultRows();
    }

    private void getScreeningResultRows(){
        ScreeningDbHelper mDbhelper = new ScreeningDbHelper(this);
        SQLiteDatabase db = mDbhelper.getReadableDatabase();

        ScreeningResultRow row;

        String query = "SELECT * FROM " + ScreeningContract.ScreeningEntry.TABLE_NAME;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, null);

            while(cursor.moveToNext()) {
                row = new ScreeningResultRow();
                row.setId(cursor.getInt(cursor.getColumnIndex(ScreeningContract.ScreeningEntry._ID)));
                row.addResult(cursor.getInt(cursor.getColumnIndex(ScreeningContract.ScreeningEntry.COLUMN_NAME_Q1)));
                row.addResult(cursor.getInt(cursor.getColumnIndex(ScreeningContract.ScreeningEntry.COLUMN_NAME_Q2)));
                screeningRows.add(row);
            }
            cursor.close();
        } finally {
            // cursor.close();
        }

        mAdapter.notifyDataSetChanged();
    }
}
