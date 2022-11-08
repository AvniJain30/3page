package com.example.a3page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class monday extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    mondayItemAdapter mondayItemAdapter;
    ArrayList<monday_item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        recyclerView = findViewById(R.id.monday);
        databaseReference = FirebaseDatabase.getInstance().getReference("monday_item");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        mondayItemAdapter = new mondayItemAdapter(this, list);
        recyclerView.setAdapter(mondayItemAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    monday_item monday_item = dataSnapshot.getValue(monday_item.class);
                    list.add(monday_item);
                }
                mondayItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}