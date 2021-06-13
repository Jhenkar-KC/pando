package com.example.pando;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private UserHealthInfoAdapter userHealthInfoAdapter;
    private ArrayList<UserHealthInfo> UserHealthInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_information);


        recyclerView = (RecyclerView) findViewById(R.id.recycledview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserHealthInfoList = new ArrayList<>();
        userHealthInfoAdapter = new UserHealthInfoAdapter(this ,UserHealthInfoList );
        recyclerView.setAdapter(userHealthInfoAdapter);



        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("UserHealthInfo");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    UserHealthInfo userHealthInfo = dataSnapshot.getValue(UserHealthInfo.class);
                    UserHealthInfoList.add(userHealthInfo);
                }
                userHealthInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NotNull DatabaseError error) {

            }
        });
    }
}