package com.nilhcem.droidconit.core.dagger.module;

import android.app.Application;

import com.nilhcem.droidconit.DroidconApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {

    private final DroidconApp app;

    public AppModule(DroidconApp app) {
        this.app = app;
    }

    @Provides @Singleton Application provideApplication() {
        return app;
    }
}
