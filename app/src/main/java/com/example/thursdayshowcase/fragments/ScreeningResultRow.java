package com.example.thursdayshowcase.fragments;

import java.util.ArrayList;

public class ScreeningResultRow {

    private int id;
    private ArrayList<Integer> results;

    public ScreeningResultRow() {
        this.results = new ArrayList<Integer>();
    }

    public ScreeningResultRow(int id, ArrayList<Integer> results) {
        this.id = id;
        this.results = results;
    }

    public int getId() {
        return this.id;
    }

    public int getResult(int position) {
        return this.results.get(position);
    }

    public ArrayList<Integer> getResults() {
        return this.results;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addResult(int result) {
        this.results.add(result);
    }
}
