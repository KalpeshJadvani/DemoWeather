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
import com.jams.itsolution.demoweather.service.Const;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.ForcastHolder> {
    public ArrayList<Forecast.ForecastDay>  forecastDay;
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

        holder.weatherDay.setText(Const.ConvertDateToFormat(forecastDay.get(position).getDate()));

        holder.weatherText.setText(forecastDay.get(position).getDay().getCondition().getText());

        String uriLink = "http:"+forecastDay.get(position).getDay().getCondition().getIcon();


        Picasso.with(mContext).load(uriLink).fit().centerCrop().into(holder.weatherIcon);

        String maxTemp = String.format("%s°", (int)forecastDay.get(position).getDay().getMaxtempC());
        String minTemp = String.format("%s°", (int)forecastDay.get(position).getDay().getMintempC());

        String tempratue = minTemp+"/"+maxTemp;


        holder.weatherTemp.setText(tempratue);
    }

    @Override
    public int getItemCount() {
        return forecastDay.size();
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

    public ForcastAdapter(ArrayList<Forecast.ForecastDay> adapter, Context context){

         this.forecastDay = adapter;
         this.mContext = context;


    }

}
