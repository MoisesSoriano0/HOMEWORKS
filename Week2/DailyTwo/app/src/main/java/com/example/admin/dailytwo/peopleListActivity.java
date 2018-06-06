package com.example.admin.dailytwo;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class peopleListActivity extends AppCompatActivity {

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        tvMain = findViewById(R.id.tvMain);


        ArrayList<Parcelable> person = getIntent().getParcelableArrayListExtra(Constants.KEY.PERSON);

        tvMain.setText(person.toString());
    }
}
