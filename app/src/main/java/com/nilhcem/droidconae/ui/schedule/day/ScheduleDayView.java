package com.nilhcem.droidconae.ui.schedule.day;

import com.nilhcem.droidconae.data.app.model.ScheduleSlot;

import java.util.List;

public interface ScheduleDayView {

    void initSlotsList(List<ScheduleSlot> slots);

    void refreshSlotsList();
}
