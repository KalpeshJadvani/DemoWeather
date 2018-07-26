package com.jams.itsolution.demoweather.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jams.itsolution.demoweather.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.ForcastHolder> {
    public ArrayList<weatherData> weatherData;
    public Context mContext;

    @NonNull
    @Override
    public ForcastHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forcast_list_row,parent,false);
        return new ForcastHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForcastHolder holder, int position) {

        holder.weatherDay.setText(weatherData.get(position).getDate());
        holder.weatherText.setText(weatherData.get(position).getText());
        holder.weatherTemp.setText(weatherData.get(position).getTemperature());

        Picasso.with(mContext).load(R.drawable.clouds).into(holder.weatherIcon);

    }

    @Override
    public int getItemCount() {
        return weatherData.size();
    }


    public static class ForcastHolder extends RecyclerView.ViewHolder{
        TextView weatherDay,weatherText,weatherTemp;
        ImageView weatherIcon;
        public ForcastHolder(View view){
            super(view);

            weatherDay = view.findViewById(R.id.weatherDay);
            weatherText = view.findViewById(R.id.weatherText);
            weatherTemp = view.findViewById(R.id.weatherTemp);
            weatherIcon = view.findViewById(R.id.weatherIcon);

        }


    }

    public ForcastAdapter(ArrayList<weatherData> weatherData, Context context){

         this.weatherData = weatherData;
         this.mContext = context;


    }

}
