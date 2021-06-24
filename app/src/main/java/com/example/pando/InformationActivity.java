package com.example.pando;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


public class InformationActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseUser CurrentUser;
    Button DatePicker;
    TextView DateTextView;
    String uid;
    UserHealthInfo PeriodDate;
    String Date;
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
        userHealthInfoAdapter = new UserHealthInfoAdapter(this, UserHealthInfoList);
        recyclerView.setAdapter(userHealthInfoAdapter);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        DatePicker = findViewById(R.id.mDatePickerButton);
        DateTextView = findViewById(R.id.textViewdate);

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        long today = MaterialDatePicker.todayInUtcMilliseconds();
        calendar.setTimeInMillis(today);
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        long january = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH,Calendar.DECEMBER);
        long december = calendar.getTimeInMillis();


        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setStart(january);
        constraintBuilder.setEnd(december);


        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("SELECT A DATE");
        builder.setSelection(today);
        builder.setCalendarConstraints(constraintBuilder.build());
        final MaterialDatePicker materialDatePicker = builder.build();


        DatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                DatePicker.setText("Period Date Predictor :" + materialDatePicker.getHeaderText());
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserHealthInfo userHealthInfo = dataSnapshot.child(uid).getValue(UserHealthInfo.class);
                    UserHealthInfoList.add(userHealthInfo);
                }
                userHealthInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}