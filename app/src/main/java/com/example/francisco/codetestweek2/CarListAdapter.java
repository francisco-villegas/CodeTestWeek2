package com.example.francisco.codetestweek2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by FRANCISCO on 11/08/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder>{
    private static final String TAG = "CarListAdapter";
    ArrayList<Car> carList = new ArrayList<>();
    Context context;

    public CarListAdapter(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvModel, tvType, tvYear;

        public ViewHolder(View itemView) {
            super(itemView);

            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
            tvYear = (TextView) itemView.findViewById(R.id.tvYear);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        final Car car = carList.get(position);
        holder.tvModel.setText(car.getModel());
        holder.tvType.setText(car.getType());
        holder.tvYear.setText(String.valueOf(car.getYear()));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ carList.size());
        return carList.size();
    }

}
