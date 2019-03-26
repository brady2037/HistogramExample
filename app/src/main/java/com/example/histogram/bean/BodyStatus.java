package com.example.histogram.bean;

import java.util.List;

public class BodyStatus {
    private String dayOfWeek;
    private String date;
    private List<WeekSleepRangesBean> sleepRanges;

    public List<WeekSleepRangesBean> getSleepRanges() {
        return sleepRanges;
    }

    public void setSleepRanges(List<WeekSleepRangesBean> sleepRanges) {
        this.sleepRanges = sleepRanges;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
