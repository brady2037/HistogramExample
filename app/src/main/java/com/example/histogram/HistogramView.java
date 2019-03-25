package com.example.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.histogram.bean.BodyStatus;
import com.example.histogram.bean.RequestResult;
import com.example.histogram.bean.WeekSleepRangesBean;
import com.example.histogram.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class HistogramView extends View {


    private String resJsonStr = "{\n" +
            "  \"bodyStatusList\": [\n" +
            "    {\n" +
            "      \"a\": 0.29,\n" +
            "      \"ahi\": 3,\n" +
            "      \"d\": 6.43,\n" +
            "      \"date\": \"2019-03-16\",\n" +
            "      \"dayOfWeek\": \"03/16\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"12:54:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"12:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"12:56:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"12:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:04:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"12:58:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:06:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:06:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:12:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"13:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:24:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:26:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"13:26:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:48:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:50:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"13:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:52:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"13:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:08:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:10:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"14:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:12:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:14:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"14:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:16:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"14:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:20:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"14:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:22:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"14:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:34:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"14:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:40:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:42:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"14:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"15:50:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:44:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:00:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"15:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:06:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"16:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:10:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"16:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:14:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"16:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:18:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"16:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:26:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"16:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:28:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"16:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:34:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"16:30:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:36:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"16:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"16:44:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"16:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"17:12:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"16:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"17:14:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"17:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"17:16:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"17:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"17:26:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"17:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"17:48:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"17:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:20:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:24:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"23:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:20:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:26:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:22:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:30:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"00:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:10:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:12:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"01:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:20:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"01:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:44:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:52:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"01:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:00:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"01:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:02:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:04:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:34:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:06:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:36:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:38:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:40:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:44:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:46:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:24:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:26:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"03:26:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:30:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"03:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:34:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:36:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"03:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:40:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"03:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:44:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:46:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"03:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:50:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:02:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"03:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:12:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:18:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:22:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:38:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"04:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:00:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:18:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:22:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"05:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:50:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:02:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:16:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:26:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:28:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:30:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:30:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:32:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:34:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:34:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:38:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:44:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:46:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:48:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:52:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:54:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:56:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:00:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:58:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:10:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:12:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"07:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:20:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:26:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"07:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:42:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:58:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:44:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 69,\n" +
            "      \"stDev\": \"S084H052B020\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.29,\n" +
            "      \"ahi\": 2,\n" +
            "      \"d\": 5.57,\n" +
            "      \"date\": \"2019-03-17\",\n" +
            "      \"dayOfWeek\": \"03/17\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"12:41:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"12:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"12:45:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"12:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:43:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"12:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"13:51:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"13:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:13:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"13:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:15:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:19:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"14:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:21:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:23:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"14:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:31:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"14:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:35:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"14:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:37:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"14:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:43:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"14:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:45:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"14:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:47:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"14:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"14:51:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"14:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"15:19:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"14:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"15:39:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"15:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"18:45:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"18:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"18:51:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"18:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"18:53:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"18:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:05:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"18:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:09:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"19:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:15:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"19:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:19:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"19:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:25:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"19:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:27:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"19:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:37:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"19:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:39:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"19:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:47:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"19:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"19:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"19:57:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"19:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"20:13:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"20:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"20:35:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"20:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:21:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"20:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:39:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"21:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:41:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"21:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:09:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:11:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"22:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:31:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:43:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:45:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"22:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:47:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"22:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:59:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"22:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:01:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:07:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:27:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:09:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:29:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"23:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:33:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:35:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"23:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:09:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:11:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:21:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"00:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:23:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:25:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"00:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:47:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:53:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:57:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"00:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:05:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:13:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:21:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"01:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:29:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:45:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"01:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:21:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:25:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"02:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:27:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:47:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:49:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"02:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:51:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:41:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:43:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"03:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:49:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"03:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:33:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:35:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"04:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:37:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:41:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"04:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:57:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:05:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:15:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:17:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"05:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:19:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"05:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:23:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:29:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"05:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:33:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:39:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:41:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"05:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:45:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:49:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:57:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:59:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:01:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:03:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:13:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:15:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:35:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:39:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:47:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:57:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:05:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:31:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:51:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:33:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 63,\n" +
            "      \"stDev\": \"S109H084B019\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.43,\n" +
            "      \"ahi\": 2,\n" +
            "      \"d\": 5,\n" +
            "      \"date\": \"2019-03-18\",\n" +
            "      \"dayOfWeek\": \"03/18\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"21:51:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:41:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"21:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:43:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"22:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:57:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:17:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:19:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:23:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:25:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:27:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:29:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:31:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:33:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:37:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:41:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:43:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:53:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:55:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:57:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:57:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:59:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:03:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:23:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"00:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:29:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:41:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"00:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:15:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"00:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:33:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:35:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"01:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:51:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:03:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"01:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:13:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:21:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"02:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:23:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:51:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:57:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:59:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:11:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:13:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"03:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:43:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:51:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"03:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:31:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:37:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:59:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:09:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"05:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:11:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"05:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:27:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:29:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:37:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:41:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:09:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:17:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:19:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:29:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:33:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"06:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:01:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:07:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:09:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:09:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:31:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:11:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 71,\n" +
            "      \"stDev\": \"S125H081B026\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.29,\n" +
            "      \"ahi\": 3,\n" +
            "      \"d\": 5.29,\n" +
            "      \"date\": \"2019-03-19\",\n" +
            "      \"dayOfWeek\": \"03/19\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"23:39:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"22:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:51:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:23:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:53:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:25:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:27:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"00:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:31:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"00:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:43:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"00:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:53:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"00:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:01:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:03:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"01:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:19:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:21:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"01:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:23:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"01:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:29:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"01:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:37:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"01:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:39:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"01:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:19:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:23:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"02:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:35:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"02:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:39:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"02:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:45:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:49:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"03:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:57:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:59:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"03:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:09:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:11:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"04:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:15:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:17:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:19:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:25:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"04:21:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:41:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:59:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"04:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:07:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:13:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:09:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:15:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:35:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"05:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:37:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:41:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:43:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:47:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:27:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:49:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:29:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 75,\n" +
            "      \"stDev\": \"S094H068B020\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.14,\n" +
            "      \"ahi\": 2,\n" +
            "      \"d\": 5.14,\n" +
            "      \"date\": \"2019-03-20\",\n" +
            "      \"dayOfWeek\": \"03/20\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"20:10:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"20:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"20:24:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"20:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"20:26:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"20:26:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:06:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"20:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:18:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"21:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:32:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:34:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"21:34:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:18:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:40:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:44:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"22:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:10:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:54:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:58:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:34:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:36:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"00:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:46:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"00:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:02:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:08:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"01:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:14:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:28:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"01:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:30:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"01:30:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:14:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:16:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:44:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:48:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:56:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:02:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:58:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:06:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:14:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"03:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:38:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:40:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"03:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:42:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"03:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:02:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:44:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:04:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"04:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:06:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:06:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:10:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:12:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:16:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:20:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:50:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:52:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:54:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:04:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:10:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:06:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:12:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:36:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"05:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:38:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"05:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:48:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:50:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:52:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:52:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:54:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:00:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"05:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:02:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:08:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:10:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:12:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:30:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:32:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:36:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:34:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:38:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:44:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:46:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"06:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:52:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"06:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:58:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:16:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:18:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:24:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:44:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:26:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 75,\n" +
            "      \"stDev\": \"S084H055B020\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.14,\n" +
            "      \"ahi\": 2,\n" +
            "      \"d\": 5.29,\n" +
            "      \"date\": \"2019-03-21\",\n" +
            "      \"dayOfWeek\": \"03/21\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"22:35:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:37:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"22:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:43:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:45:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"22:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:47:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"22:47:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:53:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:59:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:25:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:01:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:27:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"23:27:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:35:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"23:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:39:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"23:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:43:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"23:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:47:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:03:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"23:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:35:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:39:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"00:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:03:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"00:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:05:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:11:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:13:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:23:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"02:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:27:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:25:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:35:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:41:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:53:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:55:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"02:55:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:01:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"02:57:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:03:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"03:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:05:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:09:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"03:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:49:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:11:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:57:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"03:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:11:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:13:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:13:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:37:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:49:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:57:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:51:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:05:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"04:59:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:31:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:35:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"05:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:37:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"05:37:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:01:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:03:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:03:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:37:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:05:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:41:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"06:39:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:13:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:43:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:15:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"07:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:17:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:33:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:53:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:35:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 74,\n" +
            "      \"stDev\": \"S080H057B016\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"a\": 0.14,\n" +
            "      \"ahi\": 1,\n" +
            "      \"d\": 4.71,\n" +
            "      \"date\": \"2019-03-22\",\n" +
            "      \"dayOfWeek\": \"03/22\",\n" +
            "      \"sleepRanges\": [\n" +
            "        {\n" +
            "          \"endTime\": \"21:20:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"21:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:30:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"21:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:40:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"21:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"21:44:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"21:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:32:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"21:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:34:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:34:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"22:36:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"22:36:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:06:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"22:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:08:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:12:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:16:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:18:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:20:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:22:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:30:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:36:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:38:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:44:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:40:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:48:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"23:46:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"23:52:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"23:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:54:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"23:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"00:56:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"00:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:08:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"00:58:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:10:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"01:10:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:14:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"01:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:36:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"01:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:40:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"01:38:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"01:48:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"01:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:18:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"01:50:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"02:20:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"02:20:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:20:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"02:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:26:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"03:22:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:30:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"03:28:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"03:32:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"03:32:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:10:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"03:34:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:12:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"04:12:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:14:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"04:14:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:28:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"04:16:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:40:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:30:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:52:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"04:42:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"04:54:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"04:54:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:02:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"04:56:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:06:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"05:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:16:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:08:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:22:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"05:18:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"05:46:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"05:24:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:00:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"05:48:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:02:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:02:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:06:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:04:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:15:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:15:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:21:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"06:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:27:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"06:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:29:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"06:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:31:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:31:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:33:00\",\n" +
            "          \"sleepStatus\": 1,\n" +
            "          \"startTime\": \"06:33:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:39:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:35:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:43:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:41:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"06:47:00\",\n" +
            "          \"sleepStatus\": 5,\n" +
            "          \"startTime\": \"06:45:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:05:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"06:49:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:07:00\",\n" +
            "          \"sleepStatus\": 2,\n" +
            "          \"startTime\": \"07:07:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:15:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:09:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:17:00\",\n" +
            "          \"sleepStatus\": 4,\n" +
            "          \"startTime\": \"07:17:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:21:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:19:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:27:00\",\n" +
            "          \"sleepStatus\": 3,\n" +
            "          \"startTime\": \"07:23:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:29:00\",\n" +
            "          \"sleepStatus\": 6,\n" +
            "          \"startTime\": \"07:29:00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"endTime\": \"07:49:00\",\n" +
            "          \"sleepStatus\": 7,\n" +
            "          \"startTime\": \"07:31:00\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"sleepScore\": 71,\n" +
            "      \"stDev\": \"S093H066B019\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"errorCode\": -996,\n" +
            "  \"weekSleepEvaluation\": \"\",\n" +
            "  \"weeklyDAinfoVo\": null\n" +
            "}";


    private Paint mBottomTextPaint;//底部文字
    private Paint mDateTimeTextPaint;//横纵轴文字 日期&时间
    private Rect mBottomTextBounds;

    private Paint mBottomRectPaint;//底部提示方块
    private float mBottomExplainMarginBottom = 18;//底部文字&方块 与最下方margin
    private float mBottomRectTextMargin = 18;//底部文字&方块 间隔margin
    private float mBottomRectWidth = 40;//底部方块
    private float mBottomRectHeight = 30;//底部方块

    private float dateTextMarginBottom = 22;//横向轴日期文字与提示文字上下间隔
    private float dateTextMarginTop = 10;//横向轴日期文字与上方横线间隔

    private float timeTextMarginLeft = 20;//左侧竖向时间轴 marginLeft
    private float timeTextMarginRight = 20;//左侧竖向时间轴 marginRight


    private Rect mTimeTextBounds;//纵向时间轴文字
    private Rect mDateTextBounds;//横向日期轴文字

    private float topReservedHeight = 60;//上方预留高度

    private float rightReservedWidth = 40;//右侧空白长度

    private float startX;//绘制坐标 左下角原点 X
    private float startY;//绘制坐标 左下角原点 Y

    private Paint testVerticalLinePaint;

    private Paint drawPaint;
    private List<String> timeTextList = new ArrayList<>();
    private List<String> dateTextList = new ArrayList<>();

    //------>测试 临时
    private List<String> explainTextList = new ArrayList<>();
    private List<Integer> explainColorList = new ArrayList<>();

    private RequestResult requestResult;
    private List<BodyStatus> bodyStatusList;
    //<-----

    public HistogramView(Context context) {
        this(context, null);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mBottomTextBounds = new Rect();
        mBottomTextPaint = new Paint();
        mBottomTextPaint.setColor(Color.WHITE);
        mBottomTextPaint.setTextSize(28);
        mBottomTextPaint.setAntiAlias(true);
        mBottomTextPaint.setDither(true);

        mBottomRectPaint = new Paint();

        mDateTimeTextPaint = new Paint();
        mDateTimeTextPaint.setColor(Color.WHITE);
        mDateTimeTextPaint.setTextSize(28);
        mDateTimeTextPaint.setAntiAlias(true);
        mDateTimeTextPaint.setDither(true);

        mTimeTextBounds = new Rect();
        mDateTextBounds = new Rect();

        drawPaint = new Paint();

        //测试 临时
        testVerticalLinePaint = new Paint();
        testVerticalLinePaint.setColor(Color.WHITE);
        testVerticalLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        testVerticalLinePaint.setStrokeWidth(20);

        requestResult = JsonUtil.toBean(resJsonStr, RequestResult.class);
        bodyStatusList = requestResult.getBodyStatusList();


        explainTextList.add("离床");
        explainTextList.add("清醒");
        explainTextList.add("REM");
        explainTextList.add("浅睡");
        explainTextList.add("深睡");

        timeTextList.add("12:00");
        timeTextList.add("08:00");
        timeTextList.add("04:00");
        timeTextList.add("00:00");
        timeTextList.add("20:00");
        timeTextList.add("16:00");
        timeTextList.add("12:00");

        dateTextList.add("03/16");
        dateTextList.add("03/17");
        dateTextList.add("03/18");
        dateTextList.add("03/19");
        dateTextList.add("03/20");
        dateTextList.add("03/21");
        dateTextList.add("03/22");

        explainColorList.add(Color.parseColor("#D3D3D3"));
        explainColorList.add(Color.parseColor("#61B0DD"));
        explainColorList.add(Color.parseColor("#F9FF04"));
        explainColorList.add(Color.parseColor("#EFC10C"));
        explainColorList.add(Color.parseColor("#9AE07D"));
        explainColorList.add(Color.CYAN);
        explainColorList.add(Color.GREEN);
        explainColorList.add(Color.YELLOW);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint testPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        testPaint.setColor(Color.parseColor("#2D3F56"));
        canvas.drawRect(0, 0, getWidth(), getHeight(), testPaint);


        //--->底部文字方块
        for (int i = 0; i < explainTextList.size(); i++) {
            //方块 left X坐标 --> 长度等分 - 总长度(方块+文字 )的一半
            float rectX = getWidth() / (explainTextList.size() + 1) * (i + 1) -
                    (mBottomRectWidth + mBottomRectTextMargin + mBottomTextBounds.width()) / 2;

            //底部文字
            mBottomTextPaint.getTextBounds(explainTextList.get(i), 0, explainTextList.get(i).length(), mBottomTextBounds);
            canvas.drawText(explainTextList.get(i), 0, explainTextList.get(i).length(), rectX + mBottomRectWidth + mBottomRectTextMargin, getHeight() - mBottomExplainMarginBottom, mBottomTextPaint);

            //底部方块
            mBottomRectPaint.setColor(explainColorList.get(i));
            canvas.drawRect(rectX,
                    getHeight() - mBottomRectHeight - mBottomExplainMarginBottom,
                    rectX + mBottomRectWidth,
                    getHeight() - mBottomExplainMarginBottom, mBottomRectPaint);
        }
        //<---

        //--->左侧竖向时间提示
        //绘制的坐标体系的左下角原点
        mDateTimeTextPaint.getTextBounds("12:00", 0, String.valueOf("12:00").length(), mTimeTextBounds);//获取绘制文字的宽高
        startX = timeTextMarginLeft + mTimeTextBounds.width() + timeTextMarginRight;//左侧时间+左右间隔

        mDateTimeTextPaint.getTextBounds("06/16", 0, String.valueOf("06/16").length(), mDateTextBounds);//获取绘制文字的宽高
        startY = getHeight() - (dateTextMarginBottom + dateTextMarginTop + mDateTextBounds.height() + getBottomExplainHeight());//总高度 - 最下方横线距离View最下端距离(下方提示文字高度+上下间隔+横向日期文字高度+上下间隔)

        drawPaint.setColor(Color.WHITE);
//        drawPaint.setColor(Color.parseColor("#19293B"));

        //坐标轴 横
        canvas.drawLine(startX, startY, getWidth() - rightReservedWidth, startY, drawPaint);
        //坐标轴 纵
        canvas.drawLine(startX, startY, startX, topReservedHeight, drawPaint);

        for (int i = 0; i < 7; i++) {
            //纵向时间
            canvas.drawText(timeTextList.get(i), 0, timeTextList.get(i).length(), timeTextMarginLeft,
                    topReservedHeight + ((startY - topReservedHeight) / 6 * i) + mTimeTextBounds.height() / 2,
                    mDateTimeTextPaint);
            //横向日期
            canvas.drawText(dateTextList.get(i), 0, dateTextList.get(i).length(),
                    (startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1)) - mDateTextBounds.width() / 2,
                    startY + dateTextMarginTop + mDateTextBounds.height(), mDateTimeTextPaint);


            //------> 横向竖线 彩带图
            //测试纯色
//            canvas.drawLine(startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1),
//                    startY, startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), topReservedHeight, testVerticalLinePaint);
//

            List<WeekSleepRangesBean> sleepRanges = bodyStatusList.get(i).getSleepRanges();


            //循环绘制彩带图
            for (int j = 0; j < sleepRanges.size(); j++) {

                WeekSleepRangesBean rangesBean = sleepRanges.get(j);
                String[] startTimeStrs = rangesBean.getStartTime().split(":");
                String[] endTimeStrs = rangesBean.getEndTime().split(":");
                int startHouse = Integer.parseInt(startTimeStrs[0]);
                int startMinute = Integer.parseInt(startTimeStrs[1]);
                int endHouse = Integer.parseInt(endTimeStrs[0]);
                int endMinute = Integer.parseInt(endTimeStrs[1]);

                float coordinateHeight = startY - topReservedHeight;//绘制坐标总高度
                float zeroOriginY = topReservedHeight + coordinateHeight / 2;//00点对应Y坐标

                float preHouseHeight = coordinateHeight / 24;//每小时高度
                float preMinuteHeight = preHouseHeight / 60;//每分钟高度

                float columnStartY = 0;
                float columnEndY = 0;
                if (startHouse >= 0 && startHouse <= 12) {
                    columnStartY = zeroOriginY - preHouseHeight * startHouse + preMinuteHeight * startMinute;
                    columnEndY = zeroOriginY - preHouseHeight * endHouse + preMinuteHeight * endMinute;
                } else {

                }
                testVerticalLinePaint.setColor(explainColorList.get(rangesBean.getSleepStatus()));
                canvas.drawLine(startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1),
                        columnStartY, startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), columnEndY, testVerticalLinePaint);

            }

//
//            WeekSleepRangesBean rangesBean = new WeekSleepRangesBean();
//            rangesBean.setStartTime("07:14:00");
//            rangesBean.setEndTime("07:20:00");
//            rangesBean.setSleepStatus(1);
//            String[] startTimeStrs = rangesBean.getStartTime().split(":");
//            String[] endTimeStrs = rangesBean.getEndTime().split(":");
//            int startHouse = Integer.parseInt(startTimeStrs[0]);
//            int startMinute = Integer.parseInt(startTimeStrs[1]);
//            int endHouse = Integer.parseInt(endTimeStrs[0]);
//            int endMinute = Integer.parseInt(endTimeStrs[1]);
//
//            float coordinateHeight = startY - topReservedHeight;//绘制坐标总高度
//            float zeroOriginY = topReservedHeight + coordinateHeight / 2;//00点对应Y坐标
//
//            float preHouseHeight = coordinateHeight / 24;//每小时高度
//            float preMinuteHeight = preHouseHeight / 60;//每分钟高度
//
//            float columnStartY = 0;
//            float columnEndY = 0;
//            if (startHouse >= 0 && startHouse <= 12) {
//                columnStartY = zeroOriginY - preHouseHeight * startHouse + preMinuteHeight * startMinute;
//                columnEndY = zeroOriginY - preHouseHeight * endHouse + preMinuteHeight * endMinute;
//            } else {
//
//            }
//            testVerticalLinePaint.setColor(explainColorList.get(rangesBean.getSleepStatus()));
//            canvas.drawLine(startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1),
//                    columnStartY, startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), columnEndY, testVerticalLinePaint);


            //<------
            //纵向横线
//            canvas.drawLine(startX, topReservedHeight + (startY - topReservedHeight) / 6 * i, getWidth() - rightReservedWidth, topReservedHeight + (startY - topReservedHeight) / 6 * i, drawPaint);
            canvas.drawLine(startX, topReservedHeight + (startY - topReservedHeight) / 6 * i, getWidth() - rightReservedWidth, topReservedHeight + (startY - topReservedHeight) / 6 * i, drawPaint);
        }

        //<---

        //测试
//        canvas.drawLine(timeTextMarginLeft, getHeight() - getBottomExplainHeight(), getWidth(), getHeight() - getBottomExplainHeight(), drawPaint);
    }

    public void getTimeCorrespondStartY(WeekSleepRangesBean rangesBean, Canvas canvas, int i) {


        String[] startTimeStrs = rangesBean.getStartTime().split(":");
        String[] endTimeStrs = rangesBean.getEndTime().split(":");
        int startHouse = Integer.parseInt(startTimeStrs[0]);
        int startMinute = Integer.parseInt(startTimeStrs[1]);
        int endHouse = Integer.parseInt(endTimeStrs[0]);
        int endMinute = Integer.parseInt(endTimeStrs[1]);

        if (startHouse >= 0 && startHouse <= 12) {

        } else {

        }

    }

    public void getTimeCorrespondEndY() {

    }

    //注意mBottomTextBounds 需要在绘制后才能获取
    public float getBottomExplainHeight() {
        if (mBottomTextBounds.height() <= 0) {
            return mBottomRectHeight + mBottomExplainMarginBottom;
        }
        return mBottomRectHeight > mBottomTextBounds.height() ? mBottomRectHeight + mBottomExplainMarginBottom : mBottomTextBounds.height() + mBottomExplainMarginBottom;
    }

    //计算底部说明X坐标
    public int getExplainX(int i) {
        return getWidth() / (explainTextList.size() + 1) * (i + 1);
    }

}
