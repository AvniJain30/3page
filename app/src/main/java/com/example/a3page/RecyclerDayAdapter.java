package com.example.a3page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDayAdapter extends RecyclerView.Adapter<RecyclerDayAdapter.ViewHolder> {

    Context context;
    ArrayList<DayModel> arrDay;
    RecyclerDayAdapter(Context context, ArrayList<DayModel> arrDay){
        this.context = context;
        this.arrDay = arrDay;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dayTxt.setText(arrDay.get(position).day);
    }

    @Override
    public int getItemCount() {
        return arrDay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dayTxt;
        public ViewHolder(View itemView){
            super(itemView);

            dayTxt = itemView.findViewById(R.id.txt);
        }
    }
}
