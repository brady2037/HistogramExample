package com.example.histogram.bean;

public class WeekSleepRangesBean {

    private String endTime;
    private String startTime;
    private Integer sleepStatus;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getSleepStatus() {
        return sleepStatus;
    }

    public void setSleepStatus(Integer sleepStatus) {
        this.sleepStatus = sleepStatus;
    }
}
