package com.example.histogram.bean;

import java.util.List;

public class BodyStatus {
    private List<WeekSleepRangesBean> sleepRanges;

    public List<WeekSleepRangesBean> getSleepRanges() {
        return sleepRanges;
    }

    public void setSleepRanges(List<WeekSleepRangesBean> sleepRanges) {
        this.sleepRanges = sleepRanges;
    }
}
