package com.nilhcem.droidconae.core.dagger;

import com.nilhcem.droidconae.InternalDroidconApp;

public interface InternalAppGraph extends AppGraph {

    void inject(InternalDroidconApp app);
}
