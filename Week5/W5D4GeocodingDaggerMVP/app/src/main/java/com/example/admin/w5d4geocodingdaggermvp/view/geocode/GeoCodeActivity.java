package com.example.admin.w5d4geocodingdaggermvp.view.geocode;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w5d4geocodingdaggermvp.R;

import org.w3c.dom.Text;

public class GeoCodeActivity extends AppCompatActivity implements GeoCodeContract.View {

    public static final int MY_PERMISSIONS_REQUEST_READ_LOCATION = 5;
    public static final String TAG = GeoCodeActivity.class.getSimpleName() + "_TAG";
    private GeoCodePresenter presenter;
    private TextView tvLocation;
    private TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvLocation = findViewById(R.id.tvLocation);
        tvAddress = findViewById(R.id.tvAddress);

        presenter = new GeoCodePresenter();
        presenter.attachView(this);

//        Asks the user for location

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "onCreate: permission not granted");

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user asynchronously -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
//                Log.d(TAG, "onCreate: Show explanation");
                showExplanation();
            } else {
                // No explanation needed; request the permission
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_READ_LOCATION);

//                We created the permission in a separate method instead
                requestPermission();
                Log.d(TAG, "onCreate: Request Permission");
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Log.d(TAG, "onCreate: Permission already granted");
            presenter.getCurrentLocation();
        }

    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_READ_LOCATION);
    }
    public void showExplanation() {
        Log.d(TAG, "showExplanation: ");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage("I NEED THIS PERMISSION!!")
                .setNegativeButton("Nooo!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Bummer!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Alright", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermission();
                    }
                });

        builder.create().show();
    }

    //this is the callback
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Log.d(TAG, "onRequestPermissionsResult: Permission granted");
                    presenter.getCurrentLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Log.d(TAG, "onRequestPermissionsResult: Permission denied");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    public void onLocationRecieved(Location location) {
        Log.d(TAG, "onLocationRecieved: " +location.toString());
        Toast.makeText(getApplicationContext(), location.toString(), Toast.LENGTH_SHORT).show();

        tvLocation.setText(location.toString());
    }

    @Override
    public void onAddressRecieved(String address) {
        tvAddress.setText(address);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void onButtonClicked(View view) {
        presenter.getAddress();
    }
}
