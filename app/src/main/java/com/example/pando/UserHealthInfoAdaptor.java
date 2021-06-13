package com.example.pando;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class UserHealthInfoAdapter  extends RecyclerView.Adapter<UserHealthInfoAdapter .UserHealthInfoViewHolder> {

    ArrayList<UserHealthInfo> UserHealthInfoList;
    Context context;

    public UserHealthInfoAdapter (Context context , ArrayList<UserHealthInfo> UserHealthInfoList){

        this.UserHealthInfoList = UserHealthInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserHealthInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new UserHealthInfoViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull UserHealthInfoViewHolder holder, int position) {
        UserHealthInfo userHealthInfo = UserHealthInfoList.get(position);
        holder.Name.setText(userHealthInfo.getUsername());
        holder.Age.setText(userHealthInfo.getDate_of_birth());
        holder.LastPeriodDate.setText(userHealthInfo.getLast_period_date());
        holder.Weight.setText(userHealthInfo.getWeight());
        holder.Height.setText(userHealthInfo.getUsername());
        holder.BloodPressure.setText(userHealthInfo.getBlood_pressure());
        holder.HeartRate.setText(userHealthInfo.getHeart_rate());
        holder.WarningPeriodDate.setText(userHealthInfo.getLast_period_date());
        holder.UpcomingPeriodDate.setText(userHealthInfo.getLast_period_date());
    }

    @Override
    public int getItemCount() {
        return UserHealthInfoList.size();
    }

    public static  class UserHealthInfoViewHolder extends RecyclerView.ViewHolder{

        TextView Name,LastPeriodDate,UpcomingPeriodDate,WarningPeriodDate,Height,Weight,BloodPressure,HeartRate,Age;

        public UserHealthInfoViewHolder(@NonNull View textview) {
            super(textview);

            Name = textview.findViewById(R.id.usernameCardView);
            LastPeriodDate = textview.findViewById(R.id.last_period_dateCardView);
            UpcomingPeriodDate = textview.findViewById(R.id.upcomingPeriodDateCardView);
            WarningPeriodDate = textview.findViewById(R.id.warningPeriodDateCardView);
            Height = textview.findViewById(R.id.heightCardView);
            Weight = textview.findViewById(R.id.weightCardView);
            BloodPressure = textview.findViewById(R.id.blood_pressureCardView);
            HeartRate = textview.findViewById(R.id.heart_rateCardView);
            Age = textview.findViewById(R.id.ageCardView);
        }
    }
}