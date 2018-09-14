package com.example.thursdayshowcase.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thursdayshowcase.Question1Activity;
import com.example.thursdayshowcase.R;
import com.example.thursdayshowcase.ScreeningResultsActivity;

public class ScreeningFragment extends Fragment {


    public ScreeningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screening, container, false);

        Button btnStartScreening = view.findViewById(R.id.button_start_screening);

        btnStartScreening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScreening();
            }
        });

        Button btnSceeningResults = view.findViewById(R.id.button_show_results);

        btnSceeningResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScreeningResults();
            }
        });

        Log.v("TEST", "Screening");

        // Inflate the layout for this fragment
        return view;
    }

    private void startScreening() {
        Intent intent = new Intent(getActivity(), Question1Activity.class);
        startActivity(intent);
    }

    private void startScreeningResults() {
        Intent intent = new Intent(getActivity(), ScreeningResultsActivity.class);
        startActivity(intent);
    }
}
