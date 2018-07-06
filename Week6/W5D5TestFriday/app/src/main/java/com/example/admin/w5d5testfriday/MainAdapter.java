package com.example.admin.w5d5testfriday;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.w5d5testfriday.model.datasource.Schools;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private ArrayList<Schools> schoolsItem;
    Context ctext;

    public MainAdapter(ArrayList<Schools> schoolsItem) {
        this.schoolsItem = schoolsItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);

        ctext = parent.getContext();

        return new ViewHolder((viewItem));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemValue.setText(schoolsItem.get(position).getDbn());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctext, DetailActivity.class);
                intent.putExtra("dbn", schoolsItem.get(position).getDbn());
                ctext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolsItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemValue;
        LinearLayout layoutItem;

        public ViewHolder(View itemView) {
            super(itemView);
            itemValue = itemView.findViewById(R.id.itemValue);
            layoutItem = itemView.findViewById(R.id.reclyclerItem);
        }
    }
}
