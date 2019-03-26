package com.example.histogram.bean;

import java.util.List;

/**
 * 模拟数据类
 */
public class RequestResult {
    private List<BodyStatus> bodyStatusList;

    public List<BodyStatus> getBodyStatusList() {
        return bodyStatusList;
    }

    public void setBodyStatusList(List<BodyStatus> bodyStatusList) {
        this.bodyStatusList = bodyStatusList;
    }
}
