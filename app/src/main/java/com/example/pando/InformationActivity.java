package com.example.pando;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseUser CurrentUser;
    String uid;
    private UserHealthInfoAdapter userHealthInfoAdapter;
    private ArrayList<UserHealthInfo> UserHealthInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_information);


        RecyclerView recyclerView = findViewById(R.id.recycledview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserHealthInfoList = new ArrayList<>();
        CurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        uid = CurrentUser.getUid();
        userHealthInfoAdapter = new UserHealthInfoAdapter(this ,UserHealthInfoList );
        recyclerView.setAdapter(userHealthInfoAdapter);



        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    UserHealthInfo userHealthInfo = dataSnapshot.child(uid).getValue(UserHealthInfo.class);
                    UserHealthInfoList.add(userHealthInfo);
                }
                userHealthInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}