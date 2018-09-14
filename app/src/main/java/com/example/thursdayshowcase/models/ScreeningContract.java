package com.example.thursdayshowcase.models;

import android.provider.BaseColumns;

public class ScreeningContract {

    private ScreeningContract() {}

    public static class ScreeningEntry implements BaseColumns {
        public static final String TABLE_NAME = "screening_results";
        public static final String _ID = "_id";
        public static final String COLUMN_NAME_Q1 = "q1";
        public static final String COLUMN_NAME_Q2 = "q2";
    }
}
