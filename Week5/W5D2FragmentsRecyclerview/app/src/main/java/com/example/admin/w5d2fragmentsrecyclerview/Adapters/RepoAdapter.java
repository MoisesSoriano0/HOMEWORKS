package com.example.admin.w5d2fragmentsrecyclerview.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.w5d2fragmentsrecyclerview.R;
import com.example.admin.w5d2fragmentsrecyclerview.model.Repository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.MyViewHolder>{
    ArrayList<Repository> repositories;

    public RepoAdapter(ArrayList<Repository> repositories) {
        this.repositories = repositories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.repo_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvRepoName.setText(repositories.get(position).getName());
        Picasso.get().load(repositories.get(position).getOwner().getAvatarURL())
                .into(holder.ivRepoImage);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRepoImage;
        TextView tvRepoName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivRepoImage = itemView.findViewById(R.id.ivUserImage);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
        }
    }
}
