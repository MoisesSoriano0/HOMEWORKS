package com.example.admin.w5d5testfridayreddit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.w5d5testfridayreddit.DetailActivity;
import com.example.admin.w5d5testfridayreddit.R;
import com.example.admin.w5d5testfridayreddit.model.Child;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<Child> results;
    private static Context context;
    private static final String DEFAULT_URL = "https://www.eyerys.com/sites/default/files/reddit-logo-many.png";



    public MainAdapter(ArrayList<Child> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_itempost, parent, false);
        context = parent.getContext();
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.tvTitle.setText(results.get(position).getData().getTitle());
        holder.tvUserName.setText(results.get(position).getData().getAuthor());
        holder.tvNumUps.setText(results.get(position).getData().getUps());
        holder.tvNumDowns.setText(results.get(position).getData().getDowns());
        holder.tvNumComments.setText(results.get(position).getData().getNumComments());

        if(results.get(position).getData().getThumbnail() != null && results.get(position).getData().getThumbnail().length() > 0) {
            Picasso.get().load(results.get(position).getData().getThumbnail()).into(holder.ivPicture);
        }else{
            Picasso.get().load(DEFAULT_URL).into(holder.ivPicture);
        }

        final int  pos = position;

        holder.vwLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("tvTitle", results.get(pos).getData().getTitle());
                intent.putExtra("tvUserName", results.get(pos).getData().getAuthor());
                intent.putExtra("tvNumComments", results.get(pos).getData().getNumComments());
                intent.putExtra("tvNumUps", results.get(pos).getData().getUps());
                intent.putExtra("tvNumDowns", results.get(pos).getData().getDowns());
                intent.putExtra("ivPicture", results.get(pos).getData().getThumbnail());

                if(results.get(pos).getData().getThumbnail() != null && results.get(pos).getData().getThumbnail().length() > 0) {
                    intent.putExtra("ivPicture", results.get(pos).getData().getThumbnail());
                }else{
                    intent.putExtra("ivPicture", DEFAULT_URL);
                }

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvUserName, tvTitle, tvNumComments, tvNumUps, tvNumDowns;
        LinearLayout vwLayout;

        public MainViewHolder(View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.ivPicture);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvNumComments = itemView.findViewById(R.id.tvNumComments);
            tvNumUps = itemView.findViewById(R.id.tvNumUps);
            tvNumDowns = itemView.findViewById(R.id.tvNumDowns);
            vwLayout = itemView.findViewById(R.id.vwLayout);

        }
    }
}
