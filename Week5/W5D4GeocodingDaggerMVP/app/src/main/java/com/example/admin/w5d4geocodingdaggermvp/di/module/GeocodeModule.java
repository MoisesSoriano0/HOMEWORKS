package com.example.admin.w5d4geocodingdaggermvp.di.module;

import com.example.admin.w5d4geocodingdaggermvp.manager.LocationManager;
import com.example.admin.w5d4geocodingdaggermvp.model.datasource.Location;
import com.example.admin.w5d4geocodingdaggermvp.view.geocode.GeoCodePresenter;

import dagger.Module;
import dagger.Provides;

//Dagger2 Step 1: Create the module

@Module
public class GeocodeModule {

//    All the dependencies that you need to provide to the dependant
    @Provides
    GeoCodePresenter providesGeocodePresenter(LocationManager locationManager) {
        return new GeoCodePresenter(locationManager);
    }

    @Provides
    LocationManager providesLocationManager() {
        return new LocationManager();
    }
}
