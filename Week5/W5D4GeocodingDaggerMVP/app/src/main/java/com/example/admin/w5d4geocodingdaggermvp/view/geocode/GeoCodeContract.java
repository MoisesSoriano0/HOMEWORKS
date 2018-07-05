package com.example.admin.w5d4geocodingdaggermvp.view.geocode;

import android.location.Location;

import com.example.admin.w5d4geocodingdaggermvp.view.base.BasePresenter;
import com.example.admin.w5d4geocodingdaggermvp.view.base.BaseView;

public interface GeoCodeContract {

    interface View extends BaseView{
        void onLocationRecieved(Location location);

        void onAddressRecieved(String address);
    }

    interface Presenter extends BasePresenter<View> {
        void getCurrentLocation();

        void getAddress();

    }

}
