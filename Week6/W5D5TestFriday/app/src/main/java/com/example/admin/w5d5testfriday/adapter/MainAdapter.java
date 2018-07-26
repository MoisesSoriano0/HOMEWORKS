package com.example.admin.w5d5testfriday.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.w5d5testfriday.R;
import com.example.admin.w5d5testfriday.model.data.Schools;
import com.example.admin.w5d5testfriday.model.data.model.SchoolSingleton;
import com.example.admin.w5d5testfriday.view.DetailActivity;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    ArrayList<Schools> schools;
    SchoolSingleton schoolModel;
    private Context context;



    public MainAdapter(ArrayList<Schools> schools) {
        this.schools = schools;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_recycler, parent, false);


        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.position.setText("" + (position+1));
        holder.schoolName.setText(schools.get(position).getSchoolName());

        final int pos = position;
        holder.viewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                schoolModel = SchoolSingleton.getInstance();
                schoolModel.setFaxNumber(schools.get(pos).getFaxNumber());
                schoolModel.setPhoneNumber(schools.get(pos).getPhoneNumber());
                schoolModel.setSchoolCity(schools.get(pos).getCity());
                schoolModel.setSchoolName(schools.get(pos).getDbn());

                Intent schoolDetails = new Intent(context, DetailActivity.class);
                context.startActivity(schoolDetails);

            }
        });
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout viewClick;
        TextView position;
        TextView schoolName;
        Animation scaleAnim;

        public ViewHolder(View itemView)
        {
            super(itemView);
//            viewClick = itemView.findViewById(R.id.viewClick);
//            position = itemView.findViewById(R.id.positionTxt);
//            schoolName = itemView.findViewById(R.id.schoolName);

        }
    }
}
