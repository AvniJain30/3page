package com.example.a3page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class add extends AppCompatActivity {

    private EditText Class, subject, time, day, room;
    private Button btn_add;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        Class = findViewById(R.id.Class);
        subject = findViewById(R.id.subject);
        time = findViewById(R.id.time);
        day = findViewById(R.id.day);
        room = findViewById(R.id.room);
        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gClass = Class.getText().toString();
                String gSubject = subject.getText().toString();
                String gTime = time.getText().toString();
                String gDay = day.getText().toString();
                String gRoom = room.getText().toString();

                HashMap<String, Object> hashmap = new HashMap<>();
                hashmap.put("Class", gClass);
                hashmap.put("subject", gSubject);
                hashmap.put("time", gTime);
                hashmap.put("day", gDay);
                hashmap.put("room", gRoom);

                databaseReference.child("users")
                        .child(gClass)
                        .setValue(hashmap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(add.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(add.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}