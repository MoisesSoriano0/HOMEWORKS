package com.example.admin.weekend3booksapiretrofitpicasso.activity.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.weekend3booksapiretrofitpicasso.R;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<Book> dataList;

    public BookAdapter(ArrayList<Book> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.books_layout, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        if(dataList.get(position).getVolumeInfo().getImageLinks().getSmallThumbnail()!=null){
            Picasso.get().load(dataList.get(position).getVolumeInfo().getImageLinks().getSmallThumbnail()).into(holder.thumbnail);
//            Picasso.get().load("https://openclipart.org/download/211479/Simple-Image-Not-Found-Icon.svg").into(holder.thumbnail);
        }
        if(dataList.get(position).getVolumeInfo().getTitle()!= null){
            holder.title.setText(dataList.get(position).getVolumeInfo().getTitle());

        }else{
            holder.title.setText("Title not found");
        }

        if(dataList.get(position).getVolumeInfo().getAuthors() != null){
            holder.author.setText(dataList.get(position).getVolumeInfo().getAuthors().toString());
        }else {
            holder.author.setText("No Author");
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView title, author;

        public BookViewHolder(View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.ivThumbnail);
            title = itemView.findViewById(R.id.tvTitle);
            author = itemView.findViewById(R.id.tvAuthor);
        }
    }
}
