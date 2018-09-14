package com.example.thursdayshowcase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thursdayshowcase.fragments.ScreeningResultRow;

import java.util.List;

public class ScreeningResultsAdapter extends RecyclerView.Adapter<ScreeningResultsAdapter.MyViewHolder> {

    private List<ScreeningResultRow> resultsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView resultId, result1, result2;

        public MyViewHolder(View view) {
            super(view);

            resultId = view.findViewById(R.id.textView_id);
            result1 = view.findViewById(R.id.textView_result_1);
            result2 = view.findViewById(R.id.textView_result_2);
        }
    }

    public ScreeningResultsAdapter(List<ScreeningResultRow> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.screening_results_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ScreeningResultRow row = resultsList.get(position);
        holder.resultId.setText(Integer.toString(row.getId()));
        holder.result1.setText(Integer.toString(row.getResult(0)));
        holder.result2.setText(Integer.toString(row.getResult(1)));
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
