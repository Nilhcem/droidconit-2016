package com.nilhcem.droidcontn.core.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.nilhcem.droidcontn.core.dagger.OkHttpModule;
import com.nilhcem.droidcontn.core.moshi.LocalDateTimeAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import timber.log.Timber;

@Module(includes = OkHttpModule.class)
public final class DataModule {

    private static final String PREFS_NAME = "preferences";
    private static final long DISK_CACHE_SIZE = 31_457_280; // 30MB

    @Provides @Singleton SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Provides @Singleton Moshi provideMoshi(LocalDateTimeAdapter localDateTimeAdapter) {
        return new Moshi.Builder()
                .add(localDateTimeAdapter)
                .build();
    }

    @Provides @Singleton OkHttpClient.Builder provideOkHttpClientBuilder(Application app) {
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        return new OkHttpClient.Builder().cache(cache);
    }

    @Provides @Singleton Picasso providePicasso(Application app, OkHttpClient client) {
        return new Picasso.Builder(app)
                .downloader(new OkHttp3Downloader(client))
                .listener((picasso, uri, e) -> Timber.e(e, "Failed to load image: %s", uri))
                .build();
    }
}
