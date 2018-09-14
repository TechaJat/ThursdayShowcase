package com.example.thursdayshowcase.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.thursdayshowcase.Question1Activity;
import com.example.thursdayshowcase.R;

public class QuotaFragment extends Fragment {


    public QuotaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quota, container, false);

        // ProgressBar pb = new ProgressBar(getActivity(), )

        Log.v("TEST", "Quotas");

        // Inflate the layout for this fragment
        return view;
    }

}
