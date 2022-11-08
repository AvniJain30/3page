package com.example.a3page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class mondayItemAdapter extends RecyclerView.Adapter<mondayItemAdapter.ViewHolder> {

    Context context;
    ArrayList<monday_item> list;

    public mondayItemAdapter(Context context, ArrayList<monday_item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.monday_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        monday_item monday_item = list.get(position);
        holder.txtClass.setText(monday_item.getTxtClass());
        holder.Subject.setText(monday_item.getSubject());
        holder.Time.setText(monday_item.getTime());
        holder.Room.setText(monday_item.getRoom());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtClass, Subject, Time, Room;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtClass = itemView.findViewById(R.id.txtClass);
            Subject = itemView.findViewById(R.id.txtsubject);
            Time = itemView.findViewById(R.id.txtTime);
            Room = itemView.findViewById(R.id.txtRoom);
        }
    }
}
