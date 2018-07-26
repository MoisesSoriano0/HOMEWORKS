package com.google.codelabs.migratingto.jobs;

import android.content.Context;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class JobsModule {
    @Provides
    @Singleton
    FirebaseJobDispatcher provideFirebaseJobDispathcer(Context context)
    {
        return new FirebaseJobDispatcher(new GooglePlayDriver(context));

    }

}
