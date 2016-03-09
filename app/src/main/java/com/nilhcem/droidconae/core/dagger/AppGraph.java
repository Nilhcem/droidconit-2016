package com.nilhcem.droidconae.core.dagger;

import com.nilhcem.droidconae.receiver.BootReceiver;
import com.nilhcem.droidconae.ui.drawer.DrawerActivity;
import com.nilhcem.droidconae.ui.schedule.day.ScheduleDayFragment;
import com.nilhcem.droidconae.ui.schedule.pager.SchedulePagerFragment;
import com.nilhcem.droidconae.ui.sessions.details.SessionDetailsActivity;
import com.nilhcem.droidconae.ui.sessions.list.SessionsListActivity;
import com.nilhcem.droidconae.ui.settings.SettingsFragment;
import com.nilhcem.droidconae.ui.speakers.details.SpeakerDetailsDialogFragment;
import com.nilhcem.droidconae.ui.speakers.list.SpeakersListFragment;

/**
 * A common interface implemented by both the internal and production flavored components.
 */
public interface AppGraph {

    void inject(DrawerActivity activity);

    void inject(SchedulePagerFragment fragment);

    void inject(ScheduleDayFragment fragment);

    void inject(SessionsListActivity activity);

    void inject(SpeakersListFragment fragments);

    void inject(SessionDetailsActivity activity);

    void inject(SpeakerDetailsDialogFragment fragment);

    void inject(SettingsFragment fragment);

    void inject(BootReceiver receiver);
}
