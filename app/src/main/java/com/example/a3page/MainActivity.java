package com.example.a3page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button homeImg, CalendarImg, add;
    TextView timeTable;

    ArrayList<DayModel> arrDay = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeImg = findViewById(R.id.imgHome);
        CalendarImg = findViewById(R.id.imgCalendar);
        add = findViewById(R.id.add);
        timeTable = findViewById(R.id.txtTT);

        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, homePage.class);
                startActivity(intent);
            }
        });

        CalendarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calendar.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, add.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerDay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrDay.add( new DayModel("Monday"));
        arrDay.add( new DayModel("Tuesday"));
        arrDay.add( new DayModel("Wednesday"));
        arrDay.add( new DayModel("Thursday"));
        arrDay.add( new DayModel("Friday"));
        arrDay.add( new DayModel("Saturday"));
        arrDay.add( new DayModel("Sunday"));

        RecyclerDayAdapter adapter = new RecyclerDayAdapter(this, arrDay);
        recyclerView.setAdapter(adapter);
    }
}