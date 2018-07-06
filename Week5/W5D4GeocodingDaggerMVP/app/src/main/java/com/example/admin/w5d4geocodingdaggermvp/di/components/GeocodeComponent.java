package com.example.admin.w5d4geocodingdaggermvp.di.components;

import com.example.admin.w5d4geocodingdaggermvp.di.module.GeocodeModule;
import com.example.admin.w5d4geocodingdaggermvp.view.geocode.GeoCodeActivity;

import dagger.Component;


//Step 2: create a contract for dependencies and dependent

//Component knows the source of dependent from the module class
@Component(modules = GeocodeModule.class)
public interface GeocodeComponent {
    //    it acts as a bridge between the dependent and the dependencies

    //target for dependencies
    void inject(GeoCodeActivity geoCodeActivity);
}
