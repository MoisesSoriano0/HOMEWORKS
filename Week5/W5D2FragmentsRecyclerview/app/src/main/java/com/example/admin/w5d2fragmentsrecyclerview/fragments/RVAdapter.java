package com.example.admin.w5d2fragmentsrecyclerview.fragments;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.w5d2fragmentsrecyclerview.Car;
import com.example.admin.w5d2fragmentsrecyclerview.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private ArrayList<Car> cars = new ArrayList<>();
//    private Car cars2;

//    public RVAdapter(Car cars2) {
//        this.cars2 = cars2;
//    }

//    public RVAdapter(ArrayList<Car> cars) {
//        this.cars = cars;
//    }


    public RVAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_recycler_one, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String model = cars.get(position).getModel();
        if (model.equalsIgnoreCase("Nissan")) {
            holder.tvModel.setBackgroundColor(Color.RED);
        }


        holder.tvModel.setText(cars.get(position).getModel());
        holder.tvType.setText(cars.get(position).getType());
        holder.tvYear.setText(cars.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void addItem(Car car, int pos) {
        cars.add(car);
        notifyDataSetChanged();
        notifyItemInserted(getItemCount()-1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvModel, tvType, tvYear;

        public ViewHolder(View itemView) {
            super(itemView);

            tvModel = itemView.findViewById(R.id.tvModel);
            tvType = itemView.findViewById(R.id.tvType);
            tvYear = itemView.findViewById(R.id.tvYear);
        }
    }
}
