package com.nilhcem.droidconae.ui.schedule.pager;

import com.nilhcem.droidconae.data.app.model.Schedule;

public interface SchedulePagerView {

    void displaySchedule(Schedule schedule);

    void displayLoadingError();
}
