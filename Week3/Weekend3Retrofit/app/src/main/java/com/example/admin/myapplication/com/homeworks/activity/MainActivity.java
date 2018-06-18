package com.example.admin.myapplication.com.homeworks.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.com.homeworks.adapter.EmployeeAdapter;
import com.example.admin.myapplication.com.homeworks.model.Employee;
import com.example.admin.myapplication.com.homeworks.model.EmployeeList;
import com.example.admin.myapplication.com.homeworks.network.GetEmployeeDataService;
import com.example.admin.myapplication.com.homeworks.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EmployeeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create handler for the RetrofitInstance interface
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

//        Call the method with parameter in the interface to get the employee data
        Call<EmployeeList> call = service.getEmployeeData(100);

        /*Log the url called*/
        Log.wtf("Url Called", call.request().url() + "");

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                generateEmployeeList(response.body().getEmployeeArrayList());
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong... Please try later!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generateEmployeeList(ArrayList<Employee> employeeArrayList) {
        recyclerView = findViewById(R.id.recycler_view_employee_list);
        adapter = new EmployeeAdapter((employeeArrayList));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
