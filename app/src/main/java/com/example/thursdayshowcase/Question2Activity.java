package com.example.thursdayshowcase;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.thursdayshowcase.models.ScreeningContract;
import com.example.thursdayshowcase.models.ScreeningDbHelper;

public class Question2Activity extends AppCompatActivity {

    private int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        RadioGroup radioGroup = findViewById(R.id.radioGroup_q_2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = radioGroup.findViewById(i);

                boolean isChecked = checkedRadioButton.isChecked();

                if(isChecked) {
                    String entry[] = getResources().getResourceEntryName(i).split("-");
                    answer = Integer.parseInt(entry[1]);
                }
            }
        });

        Button nextBtn = findViewById(R.id.button_next);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(answer == 0) {
                    Toast.makeText(Question2Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else if (answer == 1) {
                    nextQuestion();
                }
                else if (answer == 2) {
                    screenOut();
                }*/
                //finish();
                if(answer != 0) {
                    recordAnswer();

                    if(answer == 1) {
                        nextQuestion();
                    } else if (answer == 2) {
                        screenOut();
                    }
                } else {
                    Toast.makeText(Question2Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void recordAnswer() {
        ScreeningDbHelper mDbHelper = new ScreeningDbHelper(this);
        SQLiteDatabase dbWritable = mDbHelper.getWritableDatabase();
        SQLiteDatabase dbReadable = mDbHelper.getReadableDatabase(); // could return the same object as above...

        ContentValues values = new ContentValues();
        values.put(ScreeningContract.ScreeningEntry.COLUMN_NAME_Q2, answer);

        int lastRowId = -1;

        String query = "SELECT * FROM " + ScreeningContract.ScreeningEntry.TABLE_NAME +
                " ORDER BY " + ScreeningContract.ScreeningEntry._ID + " DESC LIMIT 1";
        Cursor cursor = null;
        try {
            cursor = dbReadable.rawQuery(query, null);
            cursor.moveToFirst();
            lastRowId = cursor.getInt(cursor.getColumnIndex(ScreeningContract.ScreeningEntry._ID));
        } finally {
            cursor.close();
        }

        dbWritable.update(ScreeningContract.ScreeningEntry.TABLE_NAME, values,
                ScreeningContract.ScreeningEntry._ID + "=" + lastRowId, null);

        mDbHelper.close();
    }

    private void nextQuestion() {
        Intent intent = new Intent(Question2Activity.this, FinishScreeningActivity.class);
        startActivity(intent);
        finish();
    }

    private void screenOut() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Question2Activity.this);

        alertDialog.setTitle("Screened out");
        alertDialog.setMessage("The person you want to interview has been screened out.");
        //alertDialog.setIcon(R.drawable.)

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); //
            }
        });

        alertDialog.show();
    }
}
