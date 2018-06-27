package com.example.admin.w5d2fragmentsrecyclerview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.w5d2fragmentsrecyclerview.fragments.FragmentOne;
import com.example.admin.w5d2fragmentsrecyclerview.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener, FragmentTwo.OnFragmentInteractionListener {

    private TextView tvNewCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNewCar = findViewById(R.id.tvNewCar);
        addFragment();

    }


    private void addFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flFragOne, FragmentOne.newInstance("", ""))
                .add(R.id.flFragTwo, FragmentTwo.newInstance("", ""))
                .commit();
    }

    @Override
    public void onFragmentInteraction(Car car) {

        System.out.println("onFragmentInteraction: "+ car.getModel().toString());
        System.out.println("onFragmentInteraction: "+ car.getType().toString());
        System.out.println("onFragmentInteraction: "+ car.getYear().toString());

        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager()
                .findFragmentById(R.id.flFragTwo);


        if (fragmentTwo != null) {
            fragmentTwo.updateFragmentTwo(car);
        }


//        tvNewCar.setText(car.getModel().toString());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
