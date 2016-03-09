package com.nilhcem.droidconae.ui.settings;

import android.content.Context;

import com.nilhcem.droidconae.receiver.BootReceiver;
import com.nilhcem.droidconae.receiver.reminder.SessionsReminder;
import com.nilhcem.droidconae.ui.BasePresenter;
import com.nilhcem.droidconae.utils.App;

public class SettingsPresenter extends BasePresenter<SettingsView> {

    private final Context context;
    private final SessionsReminder sessionsReminder;

    public SettingsPresenter(Context context, SettingsView view, SessionsReminder sessionsReminder) {
        super(view);
        this.context = context;
        this.sessionsReminder = sessionsReminder;
    }

    public void onCreate() {
        view.setAppVersion(App.getVersion());
    }

    public boolean onNotifySessionsChange(boolean checked) {
        view.setNotifySessionsCheckbox(checked);

        if (checked) {
            sessionsReminder.enableSessionReminder();
            BootReceiver.enable(context);
        } else {
            sessionsReminder.disableSessionReminder();
            BootReceiver.disable(context);
        }
        return true;
    }
}
