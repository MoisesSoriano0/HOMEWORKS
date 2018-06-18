package com.example.admin.myapplication.com.homeworks.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.com.homeworks.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>{

    private ArrayList<Employee> dataList;

    public EmployeeAdapter(ArrayList<Employee> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.tvEmployeeName.setText(dataList.get(position).getName());
        holder.tvEmployeeEmail.setText(dataList.get(position).getEmail());
        holder.tvEmployeePhone.setText(dataList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView tvEmployeeName, tvEmployeeEmail, tvEmployeePhone;

        public EmployeeViewHolder(View itemView) {
            super(itemView);

            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeEmail = itemView.findViewById(R.id.tvEmployeeEmail);
            tvEmployeePhone = itemView.findViewById(R.id.tvEmployeePhone);
        }
    }
}
