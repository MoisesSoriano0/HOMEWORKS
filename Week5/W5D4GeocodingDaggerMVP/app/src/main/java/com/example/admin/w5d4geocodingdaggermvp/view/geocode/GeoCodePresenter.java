package com.example.admin.w5d4geocodingdaggermvp.view.geocode;

import android.location.Location;

import com.example.admin.w5d4geocodingdaggermvp.manager.LocationManager;
import com.example.admin.w5d4geocodingdaggermvp.model.datasource.GeoCodeResponse;
import com.example.admin.w5d4geocodingdaggermvp.model.datasource.RemoteDataSource;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeoCodePresenter implements GeoCodeContract.Presenter, LocationManager.LocationListener {

//    1.first
    GeoCodeContract.View view;

    LocationManager locationManager;
    Location location;

    @Override
    public void getCurrentLocation() {
        //get current location
        locationManager.getLocation();
    }

    @Override
    public void getAddress() {
        RemoteDataSource.getResponse(getFormmatedLocation())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GeoCodeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GeoCodeResponse geoCodeResponse) {

                        view.onAddressRecieved(geoCodeResponse.getResults().get(0).getFormattedAddress());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private String getFormmatedLocation() {
        String lat = String.valueOf(location.getLatitude());
        String lng = String.valueOf(location.getLongitude());
        String latlng = lat + "," + lng;
        return latlng;
    }

    @Override
    public void attachView(GeoCodeContract.View view) {
        this.view = view;
        locationManager = new LocationManager(view, this);
    }

    @Override
    public void detachView() {

    }


    @Override
    public void onLocationResults(Location location) {
        this.location = location;
        view.onLocationRecieved(location);
    }
}
