package com.example.histogram.backup;

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

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class HistogramViewCV5test extends View {


    private String resJsonStr = "{\"bodyStatusList\":[{\"a\":0.29,\"ahi\":3,\"d\":5.29,\"date\":\"2019-03-19\",\"dayOfWeek\":\"03\\/19\",\"sleepRanges\":[{\"endTime\":\"23:39:00\",\"sleepStatus\":6,\"startTime\":\"22:55:00\"},{\"endTime\":\"23:51:00\",\"sleepStatus\":3,\"startTime\":\"23:41:00\"},{\"endTime\":\"00:23:00\",\"sleepStatus\":5,\"startTime\":\"23:53:00\"},{\"endTime\":\"00:25:00\",\"sleepStatus\":3,\"startTime\":\"00:25:00\"},{\"endTime\":\"00:27:00\",\"sleepStatus\":7,\"startTime\":\"00:27:00\"},{\"endTime\":\"00:31:00\",\"sleepStatus\":6,\"startTime\":\"00:29:00\"},{\"endTime\":\"00:43:00\",\"sleepStatus\":7,\"startTime\":\"00:33:00\"},{\"endTime\":\"00:53:00\",\"sleepStatus\":6,\"startTime\":\"00:45:00\"},{\"endTime\":\"01:01:00\",\"sleepStatus\":3,\"startTime\":\"00:55:00\"},{\"endTime\":\"01:03:00\",\"sleepStatus\":5,\"startTime\":\"01:03:00\"},{\"endTime\":\"01:19:00\",\"sleepStatus\":3,\"startTime\":\"01:05:00\"},{\"endTime\":\"01:21:00\",\"sleepStatus\":6,\"startTime\":\"01:21:00\"},{\"endTime\":\"01:23:00\",\"sleepStatus\":4,\"startTime\":\"01:23:00\"},{\"endTime\":\"01:29:00\",\"sleepStatus\":5,\"startTime\":\"01:25:00\"},{\"endTime\":\"01:37:00\",\"sleepStatus\":7,\"startTime\":\"01:31:00\"},{\"endTime\":\"01:39:00\",\"sleepStatus\":4,\"startTime\":\"01:39:00\"},{\"endTime\":\"02:19:00\",\"sleepStatus\":3,\"startTime\":\"01:41:00\"},{\"endTime\":\"02:23:00\",\"sleepStatus\":2,\"startTime\":\"02:21:00\"},{\"endTime\":\"02:35:00\",\"sleepStatus\":1,\"startTime\":\"02:25:00\"},{\"endTime\":\"02:39:00\",\"sleepStatus\":2,\"startTime\":\"02:37:00\"},{\"endTime\":\"03:45:00\",\"sleepStatus\":3,\"startTime\":\"02:41:00\"},{\"endTime\":\"03:49:00\",\"sleepStatus\":4,\"startTime\":\"03:47:00\"},{\"endTime\":\"03:57:00\",\"sleepStatus\":3,\"startTime\":\"03:51:00\"},{\"endTime\":\"03:59:00\",\"sleepStatus\":5,\"startTime\":\"03:59:00\"},{\"endTime\":\"04:09:00\",\"sleepStatus\":6,\"startTime\":\"04:01:00\"},{\"endTime\":\"04:11:00\",\"sleepStatus\":4,\"startTime\":\"04:11:00\"},{\"endTime\":\"04:15:00\",\"sleepStatus\":5,\"startTime\":\"04:13:00\"},{\"endTime\":\"04:17:00\",\"sleepStatus\":3,\"startTime\":\"04:17:00\"},{\"endTime\":\"04:19:00\",\"sleepStatus\":5,\"startTime\":\"04:19:00\"},{\"endTime\":\"04:25:00\",\"sleepStatus\":7,\"startTime\":\"04:21:00\"},{\"endTime\":\"04:41:00\",\"sleepStatus\":6,\"startTime\":\"04:27:00\"},{\"endTime\":\"04:49:00\",\"sleepStatus\":3,\"startTime\":\"04:43:00\"},{\"endTime\":\"04:59:00\",\"sleepStatus\":4,\"startTime\":\"04:51:00\"},{\"endTime\":\"05:07:00\",\"sleepStatus\":3,\"startTime\":\"05:01:00\"},{\"endTime\":\"05:13:00\",\"sleepStatus\":5,\"startTime\":\"05:09:00\"},{\"endTime\":\"05:15:00\",\"sleepStatus\":7,\"startTime\":\"05:15:00\"},{\"endTime\":\"06:35:00\",\"sleepStatus\":6,\"startTime\":\"05:17:00\"},{\"endTime\":\"06:37:00\",\"sleepStatus\":4,\"startTime\":\"06:37:00\"},{\"endTime\":\"06:41:00\",\"sleepStatus\":5,\"startTime\":\"06:39:00\"},{\"endTime\":\"06:43:00\",\"sleepStatus\":4,\"startTime\":\"06:43:00\"},{\"endTime\":\"06:47:00\",\"sleepStatus\":5,\"startTime\":\"06:45:00\"},{\"endTime\":\"07:27:00\",\"sleepStatus\":6,\"startTime\":\"06:49:00\"},{\"endTime\":\"07:49:00\",\"sleepStatus\":7,\"startTime\":\"07:29:00\"}],\"sleepScore\":75,\"stDev\":\"S094H068B020\"},{\"a\":0.14,\"ahi\":2,\"d\":5.14,\"date\":\"2019-03-20\",\"dayOfWeek\":\"03\\/20\",\"sleepRanges\":[{\"endTime\":\"20:10:00\",\"sleepStatus\":7,\"startTime\":\"20:10:00\"},{\"endTime\":\"20:24:00\",\"sleepStatus\":6,\"startTime\":\"20:12:00\"},{\"endTime\":\"20:26:00\",\"sleepStatus\":7,\"startTime\":\"20:26:00\"},{\"endTime\":\"21:06:00\",\"sleepStatus\":6,\"startTime\":\"20:28:00\"},{\"endTime\":\"21:18:00\",\"sleepStatus\":7,\"startTime\":\"21:08:00\"},{\"endTime\":\"21:32:00\",\"sleepStatus\":6,\"startTime\":\"21:20:00\"},{\"endTime\":\"21:34:00\",\"sleepStatus\":7,\"startTime\":\"21:34:00\"},{\"endTime\":\"22:18:00\",\"sleepStatus\":6,\"startTime\":\"21:36:00\"},{\"endTime\":\"22:40:00\",\"sleepStatus\":3,\"startTime\":\"22:20:00\"},{\"endTime\":\"22:44:00\",\"sleepStatus\":4,\"startTime\":\"22:42:00\"},{\"endTime\":\"23:10:00\",\"sleepStatus\":5,\"startTime\":\"22:46:00\"},{\"endTime\":\"23:54:00\",\"sleepStatus\":3,\"startTime\":\"23:12:00\"},{\"endTime\":\"23:58:00\",\"sleepStatus\":4,\"startTime\":\"23:56:00\"},{\"endTime\":\"00:34:00\",\"sleepStatus\":3,\"startTime\":\"00:00:00\"},{\"endTime\":\"00:36:00\",\"sleepStatus\":2,\"startTime\":\"00:36:00\"},{\"endTime\":\"00:46:00\",\"sleepStatus\":1,\"startTime\":\"00:38:00\"},{\"endTime\":\"01:02:00\",\"sleepStatus\":3,\"startTime\":\"00:48:00\"},{\"endTime\":\"01:08:00\",\"sleepStatus\":6,\"startTime\":\"01:04:00\"},{\"endTime\":\"01:14:00\",\"sleepStatus\":3,\"startTime\":\"01:10:00\"},{\"endTime\":\"01:28:00\",\"sleepStatus\":7,\"startTime\":\"01:16:00\"},{\"endTime\":\"01:30:00\",\"sleepStatus\":6,\"startTime\":\"01:30:00\"},{\"endTime\":\"02:14:00\",\"sleepStatus\":3,\"startTime\":\"01:32:00\"},{\"endTime\":\"02:16:00\",\"sleepStatus\":5,\"startTime\":\"02:16:00\"},{\"endTime\":\"02:44:00\",\"sleepStatus\":3,\"startTime\":\"02:18:00\"},{\"endTime\":\"02:48:00\",\"sleepStatus\":4,\"startTime\":\"02:46:00\"},{\"endTime\":\"02:56:00\",\"sleepStatus\":3,\"startTime\":\"02:50:00\"},{\"endTime\":\"03:02:00\",\"sleepStatus\":6,\"startTime\":\"02:58:00\"},{\"endTime\":\"03:06:00\",\"sleepStatus\":3,\"startTime\":\"03:04:00\"},{\"endTime\":\"03:14:00\",\"sleepStatus\":7,\"startTime\":\"03:08:00\"},{\"endTime\":\"03:38:00\",\"sleepStatus\":3,\"startTime\":\"03:16:00\"},{\"endTime\":\"03:40:00\",\"sleepStatus\":7,\"startTime\":\"03:40:00\"},{\"endTime\":\"03:42:00\",\"sleepStatus\":6,\"startTime\":\"03:42:00\"},{\"endTime\":\"04:02:00\",\"sleepStatus\":3,\"startTime\":\"03:44:00\"},{\"endTime\":\"04:04:00\",\"sleepStatus\":7,\"startTime\":\"04:04:00\"},{\"endTime\":\"04:06:00\",\"sleepStatus\":6,\"startTime\":\"04:06:00\"},{\"endTime\":\"04:10:00\",\"sleepStatus\":3,\"startTime\":\"04:08:00\"},{\"endTime\":\"04:12:00\",\"sleepStatus\":5,\"startTime\":\"04:12:00\"},{\"endTime\":\"04:16:00\",\"sleepStatus\":3,\"startTime\":\"04:14:00\"},{\"endTime\":\"04:20:00\",\"sleepStatus\":2,\"startTime\":\"04:18:00\"},{\"endTime\":\"04:50:00\",\"sleepStatus\":5,\"startTime\":\"04:22:00\"},{\"endTime\":\"04:52:00\",\"sleepStatus\":3,\"startTime\":\"04:52:00\"},{\"endTime\":\"04:54:00\",\"sleepStatus\":5,\"startTime\":\"04:54:00\"},{\"endTime\":\"05:04:00\",\"sleepStatus\":3,\"startTime\":\"04:56:00\"},{\"endTime\":\"05:10:00\",\"sleepStatus\":5,\"startTime\":\"05:06:00\"},{\"endTime\":\"05:12:00\",\"sleepStatus\":7,\"startTime\":\"05:12:00\"},{\"endTime\":\"05:36:00\",\"sleepStatus\":6,\"startTime\":\"05:14:00\"},{\"endTime\":\"05:38:00\",\"sleepStatus\":4,\"startTime\":\"05:38:00\"},{\"endTime\":\"05:48:00\",\"sleepStatus\":5,\"startTime\":\"05:40:00\"},{\"endTime\":\"05:50:00\",\"sleepStatus\":3,\"startTime\":\"05:50:00\"},{\"endTime\":\"05:52:00\",\"sleepStatus\":5,\"startTime\":\"05:52:00\"},{\"endTime\":\"05:54:00\",\"sleepStatus\":3,\"startTime\":\"05:54:00\"},{\"endTime\":\"06:00:00\",\"sleepStatus\":6,\"startTime\":\"05:56:00\"},{\"endTime\":\"06:02:00\",\"sleepStatus\":4,\"startTime\":\"06:02:00\"},{\"endTime\":\"06:08:00\",\"sleepStatus\":5,\"startTime\":\"06:04:00\"},{\"endTime\":\"06:10:00\",\"sleepStatus\":7,\"startTime\":\"06:10:00\"},{\"endTime\":\"06:12:00\",\"sleepStatus\":4,\"startTime\":\"06:12:00\"},{\"endTime\":\"06:30:00\",\"sleepStatus\":5,\"startTime\":\"06:14:00\"},{\"endTime\":\"06:32:00\",\"sleepStatus\":3,\"startTime\":\"06:32:00\"},{\"endTime\":\"06:36:00\",\"sleepStatus\":7,\"startTime\":\"06:34:00\"},{\"endTime\":\"06:38:00\",\"sleepStatus\":4,\"startTime\":\"06:38:00\"},{\"endTime\":\"06:44:00\",\"sleepStatus\":3,\"startTime\":\"06:40:00\"},{\"endTime\":\"06:46:00\",\"sleepStatus\":2,\"startTime\":\"06:46:00\"},{\"endTime\":\"06:52:00\",\"sleepStatus\":1,\"startTime\":\"06:48:00\"},{\"endTime\":\"06:58:00\",\"sleepStatus\":3,\"startTime\":\"06:54:00\"},{\"endTime\":\"07:16:00\",\"sleepStatus\":6,\"startTime\":\"07:00:00\"},{\"endTime\":\"07:18:00\",\"sleepStatus\":7,\"startTime\":\"07:18:00\"},{\"endTime\":\"07:24:00\",\"sleepStatus\":6,\"startTime\":\"07:20:00\"},{\"endTime\":\"07:44:00\",\"sleepStatus\":7,\"startTime\":\"07:26:00\"}],\"sleepScore\":75,\"stDev\":\"S084H055B020\"},{\"a\":0.14,\"ahi\":2,\"d\":5.29,\"date\":\"2019-03-21\",\"dayOfWeek\":\"03\\/21\",\"sleepRanges\":[{\"endTime\":\"22:35:00\",\"sleepStatus\":6,\"startTime\":\"21:31:00\"},{\"endTime\":\"22:37:00\",\"sleepStatus\":4,\"startTime\":\"22:37:00\"},{\"endTime\":\"22:43:00\",\"sleepStatus\":5,\"startTime\":\"22:39:00\"},{\"endTime\":\"22:45:00\",\"sleepStatus\":6,\"startTime\":\"22:45:00\"},{\"endTime\":\"22:47:00\",\"sleepStatus\":4,\"startTime\":\"22:47:00\"},{\"endTime\":\"22:53:00\",\"sleepStatus\":5,\"startTime\":\"22:49:00\"},{\"endTime\":\"22:59:00\",\"sleepStatus\":3,\"startTime\":\"22:55:00\"},{\"endTime\":\"23:25:00\",\"sleepStatus\":5,\"startTime\":\"23:01:00\"},{\"endTime\":\"23:27:00\",\"sleepStatus\":1,\"startTime\":\"23:27:00\"},{\"endTime\":\"23:35:00\",\"sleepStatus\":7,\"startTime\":\"23:29:00\"},{\"endTime\":\"23:39:00\",\"sleepStatus\":6,\"startTime\":\"23:37:00\"},{\"endTime\":\"23:43:00\",\"sleepStatus\":2,\"startTime\":\"23:41:00\"},{\"endTime\":\"23:47:00\",\"sleepStatus\":3,\"startTime\":\"23:45:00\"},{\"endTime\":\"00:03:00\",\"sleepStatus\":2,\"startTime\":\"23:49:00\"},{\"endTime\":\"00:35:00\",\"sleepStatus\":3,\"startTime\":\"00:05:00\"},{\"endTime\":\"00:39:00\",\"sleepStatus\":2,\"startTime\":\"00:37:00\"},{\"endTime\":\"02:03:00\",\"sleepStatus\":3,\"startTime\":\"00:41:00\"},{\"endTime\":\"02:05:00\",\"sleepStatus\":4,\"startTime\":\"02:05:00\"},{\"endTime\":\"02:11:00\",\"sleepStatus\":6,\"startTime\":\"02:07:00\"},{\"endTime\":\"02:13:00\",\"sleepStatus\":4,\"startTime\":\"02:13:00\"},{\"endTime\":\"02:23:00\",\"sleepStatus\":5,\"startTime\":\"02:15:00\"},{\"endTime\":\"02:27:00\",\"sleepStatus\":4,\"startTime\":\"02:25:00\"},{\"endTime\":\"02:35:00\",\"sleepStatus\":6,\"startTime\":\"02:29:00\"},{\"endTime\":\"02:41:00\",\"sleepStatus\":4,\"startTime\":\"02:37:00\"},{\"endTime\":\"02:53:00\",\"sleepStatus\":3,\"startTime\":\"02:43:00\"},{\"endTime\":\"02:55:00\",\"sleepStatus\":7,\"startTime\":\"02:55:00\"},{\"endTime\":\"03:01:00\",\"sleepStatus\":6,\"startTime\":\"02:57:00\"},{\"endTime\":\"03:03:00\",\"sleepStatus\":2,\"startTime\":\"03:03:00\"},{\"endTime\":\"03:05:00\",\"sleepStatus\":3,\"startTime\":\"03:05:00\"},{\"endTime\":\"03:09:00\",\"sleepStatus\":5,\"startTime\":\"03:07:00\"},{\"endTime\":\"03:49:00\",\"sleepStatus\":3,\"startTime\":\"03:11:00\"},{\"endTime\":\"03:57:00\",\"sleepStatus\":4,\"startTime\":\"03:51:00\"},{\"endTime\":\"04:11:00\",\"sleepStatus\":3,\"startTime\":\"03:59:00\"},{\"endTime\":\"04:13:00\",\"sleepStatus\":2,\"startTime\":\"04:13:00\"},{\"endTime\":\"04:37:00\",\"sleepStatus\":3,\"startTime\":\"04:15:00\"},{\"endTime\":\"04:49:00\",\"sleepStatus\":5,\"startTime\":\"04:39:00\"},{\"endTime\":\"04:57:00\",\"sleepStatus\":3,\"startTime\":\"04:51:00\"},{\"endTime\":\"05:05:00\",\"sleepStatus\":4,\"startTime\":\"04:59:00\"},{\"endTime\":\"05:31:00\",\"sleepStatus\":5,\"startTime\":\"05:07:00\"},{\"endTime\":\"05:35:00\",\"sleepStatus\":6,\"startTime\":\"05:33:00\"},{\"endTime\":\"05:37:00\",\"sleepStatus\":4,\"startTime\":\"05:37:00\"},{\"endTime\":\"06:01:00\",\"sleepStatus\":5,\"startTime\":\"05:39:00\"},{\"endTime\":\"06:03:00\",\"sleepStatus\":4,\"startTime\":\"06:03:00\"},{\"endTime\":\"06:37:00\",\"sleepStatus\":3,\"startTime\":\"06:05:00\"},{\"endTime\":\"06:41:00\",\"sleepStatus\":2,\"startTime\":\"06:39:00\"},{\"endTime\":\"07:13:00\",\"sleepStatus\":3,\"startTime\":\"06:43:00\"},{\"endTime\":\"07:15:00\",\"sleepStatus\":5,\"startTime\":\"07:15:00\"},{\"endTime\":\"07:17:00\",\"sleepStatus\":3,\"startTime\":\"07:17:00\"},{\"endTime\":\"07:33:00\",\"sleepStatus\":6,\"startTime\":\"07:19:00\"},{\"endTime\":\"07:53:00\",\"sleepStatus\":7,\"startTime\":\"07:35:00\"}],\"sleepScore\":74,\"stDev\":\"S080H057B016\"},{\"a\":0.14,\"ahi\":1,\"d\":4.71,\"date\":\"2019-03-22\",\"dayOfWeek\":\"03\\/22\",\"sleepRanges\":[{\"endTime\":\"21:20:00\",\"sleepStatus\":7,\"startTime\":\"21:20:00\"},{\"endTime\":\"21:30:00\",\"sleepStatus\":6,\"startTime\":\"21:22:00\"},{\"endTime\":\"21:40:00\",\"sleepStatus\":3,\"startTime\":\"21:32:00\"},{\"endTime\":\"21:44:00\",\"sleepStatus\":4,\"startTime\":\"21:42:00\"},{\"endTime\":\"22:32:00\",\"sleepStatus\":5,\"startTime\":\"21:46:00\"},{\"endTime\":\"22:34:00\",\"sleepStatus\":3,\"startTime\":\"22:34:00\"},{\"endTime\":\"22:36:00\",\"sleepStatus\":5,\"startTime\":\"22:36:00\"},{\"endTime\":\"23:06:00\",\"sleepStatus\":3,\"startTime\":\"22:38:00\"},{\"endTime\":\"23:08:00\",\"sleepStatus\":5,\"startTime\":\"23:08:00\"},{\"endTime\":\"23:12:00\",\"sleepStatus\":3,\"startTime\":\"23:10:00\"},{\"endTime\":\"23:16:00\",\"sleepStatus\":5,\"startTime\":\"23:14:00\"},{\"endTime\":\"23:18:00\",\"sleepStatus\":4,\"startTime\":\"23:18:00\"},{\"endTime\":\"23:20:00\",\"sleepStatus\":3,\"startTime\":\"23:20:00\"},{\"endTime\":\"23:22:00\",\"sleepStatus\":4,\"startTime\":\"23:22:00\"},{\"endTime\":\"23:30:00\",\"sleepStatus\":3,\"startTime\":\"23:24:00\"},{\"endTime\":\"23:36:00\",\"sleepStatus\":4,\"startTime\":\"23:32:00\"},{\"endTime\":\"23:38:00\",\"sleepStatus\":3,\"startTime\":\"23:38:00\"},{\"endTime\":\"23:44:00\",\"sleepStatus\":5,\"startTime\":\"23:40:00\"},{\"endTime\":\"23:48:00\",\"sleepStatus\":4,\"startTime\":\"23:46:00\"},{\"endTime\":\"23:52:00\",\"sleepStatus\":5,\"startTime\":\"23:50:00\"},{\"endTime\":\"00:54:00\",\"sleepStatus\":3,\"startTime\":\"23:54:00\"},{\"endTime\":\"00:56:00\",\"sleepStatus\":4,\"startTime\":\"00:56:00\"},{\"endTime\":\"01:08:00\",\"sleepStatus\":6,\"startTime\":\"00:58:00\"},{\"endTime\":\"01:10:00\",\"sleepStatus\":4,\"startTime\":\"01:10:00\"},{\"endTime\":\"01:14:00\",\"sleepStatus\":6,\"startTime\":\"01:12:00\"},{\"endTime\":\"01:36:00\",\"sleepStatus\":3,\"startTime\":\"01:16:00\"},{\"endTime\":\"01:40:00\",\"sleepStatus\":4,\"startTime\":\"01:38:00\"},{\"endTime\":\"01:48:00\",\"sleepStatus\":7,\"startTime\":\"01:42:00\"},{\"endTime\":\"02:18:00\",\"sleepStatus\":6,\"startTime\":\"01:50:00\"},{\"endTime\":\"02:20:00\",\"sleepStatus\":4,\"startTime\":\"02:20:00\"},{\"endTime\":\"03:20:00\",\"sleepStatus\":3,\"startTime\":\"02:22:00\"},{\"endTime\":\"03:26:00\",\"sleepStatus\":5,\"startTime\":\"03:22:00\"},{\"endTime\":\"03:30:00\",\"sleepStatus\":6,\"startTime\":\"03:28:00\"},{\"endTime\":\"03:32:00\",\"sleepStatus\":4,\"startTime\":\"03:32:00\"},{\"endTime\":\"04:10:00\",\"sleepStatus\":3,\"startTime\":\"03:34:00\"},{\"endTime\":\"04:12:00\",\"sleepStatus\":5,\"startTime\":\"04:12:00\"},{\"endTime\":\"04:14:00\",\"sleepStatus\":7,\"startTime\":\"04:14:00\"},{\"endTime\":\"04:28:00\",\"sleepStatus\":6,\"startTime\":\"04:16:00\"},{\"endTime\":\"04:40:00\",\"sleepStatus\":2,\"startTime\":\"04:30:00\"},{\"endTime\":\"04:52:00\",\"sleepStatus\":1,\"startTime\":\"04:42:00\"},{\"endTime\":\"04:54:00\",\"sleepStatus\":2,\"startTime\":\"04:54:00\"},{\"endTime\":\"05:02:00\",\"sleepStatus\":3,\"startTime\":\"04:56:00\"},{\"endTime\":\"05:06:00\",\"sleepStatus\":2,\"startTime\":\"05:04:00\"},{\"endTime\":\"05:16:00\",\"sleepStatus\":7,\"startTime\":\"05:08:00\"},{\"endTime\":\"05:22:00\",\"sleepStatus\":3,\"startTime\":\"05:18:00\"},{\"endTime\":\"05:46:00\",\"sleepStatus\":5,\"startTime\":\"05:24:00\"},{\"endTime\":\"06:00:00\",\"sleepStatus\":7,\"startTime\":\"05:48:00\"},{\"endTime\":\"06:02:00\",\"sleepStatus\":4,\"startTime\":\"06:02:00\"},{\"endTime\":\"06:06:00\",\"sleepStatus\":5,\"startTime\":\"06:04:00\"},{\"endTime\":\"06:15:00\",\"sleepStatus\":6,\"startTime\":\"06:15:00\"},{\"endTime\":\"06:21:00\",\"sleepStatus\":7,\"startTime\":\"06:17:00\"},{\"endTime\":\"06:27:00\",\"sleepStatus\":6,\"startTime\":\"06:23:00\"},{\"endTime\":\"06:29:00\",\"sleepStatus\":4,\"startTime\":\"06:29:00\"},{\"endTime\":\"06:31:00\",\"sleepStatus\":5,\"startTime\":\"06:31:00\"},{\"endTime\":\"06:33:00\",\"sleepStatus\":1,\"startTime\":\"06:33:00\"},{\"endTime\":\"06:39:00\",\"sleepStatus\":5,\"startTime\":\"06:35:00\"},{\"endTime\":\"06:43:00\",\"sleepStatus\":3,\"startTime\":\"06:41:00\"},{\"endTime\":\"06:47:00\",\"sleepStatus\":5,\"startTime\":\"06:45:00\"},{\"endTime\":\"07:05:00\",\"sleepStatus\":3,\"startTime\":\"06:49:00\"},{\"endTime\":\"07:07:00\",\"sleepStatus\":2,\"startTime\":\"07:07:00\"},{\"endTime\":\"07:15:00\",\"sleepStatus\":3,\"startTime\":\"07:09:00\"},{\"endTime\":\"07:17:00\",\"sleepStatus\":4,\"startTime\":\"07:17:00\"},{\"endTime\":\"07:21:00\",\"sleepStatus\":6,\"startTime\":\"07:19:00\"},{\"endTime\":\"07:27:00\",\"sleepStatus\":3,\"startTime\":\"07:23:00\"},{\"endTime\":\"07:29:00\",\"sleepStatus\":6,\"startTime\":\"07:29:00\"},{\"endTime\":\"07:49:00\",\"sleepStatus\":7,\"startTime\":\"07:31:00\"}],\"sleepScore\":71,\"stDev\":\"S093H066B019\"},{\"a\":0.29,\"ahi\":3,\"d\":5.71,\"date\":\"2019-03-23\",\"dayOfWeek\":\"03\\/23\",\"sleepRanges\":[{\"endTime\":\"21:02:00\",\"sleepStatus\":7,\"startTime\":\"21:02:00\"},{\"endTime\":\"21:10:00\",\"sleepStatus\":6,\"startTime\":\"21:04:00\"},{\"endTime\":\"21:12:00\",\"sleepStatus\":7,\"startTime\":\"21:12:00\"},{\"endTime\":\"21:20:00\",\"sleepStatus\":3,\"startTime\":\"21:14:00\"},{\"endTime\":\"21:22:00\",\"sleepStatus\":7,\"startTime\":\"21:22:00\"},{\"endTime\":\"21:32:00\",\"sleepStatus\":6,\"startTime\":\"21:24:00\"},{\"endTime\":\"21:38:00\",\"sleepStatus\":3,\"startTime\":\"21:34:00\"},{\"endTime\":\"21:42:00\",\"sleepStatus\":4,\"startTime\":\"21:40:00\"},{\"endTime\":\"21:48:00\",\"sleepStatus\":3,\"startTime\":\"21:44:00\"},{\"endTime\":\"22:10:00\",\"sleepStatus\":5,\"startTime\":\"21:50:00\"},{\"endTime\":\"22:24:00\",\"sleepStatus\":3,\"startTime\":\"22:12:00\"},{\"endTime\":\"22:40:00\",\"sleepStatus\":5,\"startTime\":\"22:26:00\"},{\"endTime\":\"22:42:00\",\"sleepStatus\":1,\"startTime\":\"22:42:00\"},{\"endTime\":\"22:44:00\",\"sleepStatus\":2,\"startTime\":\"22:44:00\"},{\"endTime\":\"23:06:00\",\"sleepStatus\":3,\"startTime\":\"22:46:00\"},{\"endTime\":\"23:08:00\",\"sleepStatus\":4,\"startTime\":\"23:08:00\"},{\"endTime\":\"23:10:00\",\"sleepStatus\":6,\"startTime\":\"23:10:00\"},{\"endTime\":\"23:12:00\",\"sleepStatus\":4,\"startTime\":\"23:12:00\"},{\"endTime\":\"23:18:00\",\"sleepStatus\":6,\"startTime\":\"23:14:00\"},{\"endTime\":\"23:22:00\",\"sleepStatus\":3,\"startTime\":\"23:20:00\"},{\"endTime\":\"23:26:00\",\"sleepStatus\":7,\"startTime\":\"23:24:00\"},{\"endTime\":\"23:28:00\",\"sleepStatus\":4,\"startTime\":\"23:28:00\"},{\"endTime\":\"23:32:00\",\"sleepStatus\":3,\"startTime\":\"23:30:00\"},{\"endTime\":\"23:34:00\",\"sleepStatus\":5,\"startTime\":\"23:34:00\"},{\"endTime\":\"00:50:00\",\"sleepStatus\":3,\"startTime\":\"23:36:00\"},{\"endTime\":\"00:52:00\",\"sleepStatus\":4,\"startTime\":\"00:52:00\"},{\"endTime\":\"01:00:00\",\"sleepStatus\":6,\"startTime\":\"00:54:00\"},{\"endTime\":\"01:04:00\",\"sleepStatus\":4,\"startTime\":\"01:02:00\"},{\"endTime\":\"01:10:00\",\"sleepStatus\":5,\"startTime\":\"01:06:00\"},{\"endTime\":\"01:28:00\",\"sleepStatus\":3,\"startTime\":\"01:12:00\"},{\"endTime\":\"01:36:00\",\"sleepStatus\":5,\"startTime\":\"01:30:00\"},{\"endTime\":\"01:40:00\",\"sleepStatus\":4,\"startTime\":\"01:38:00\"},{\"endTime\":\"02:26:00\",\"sleepStatus\":3,\"startTime\":\"01:42:00\"},{\"endTime\":\"02:58:00\",\"sleepStatus\":5,\"startTime\":\"02:28:00\"},{\"endTime\":\"03:00:00\",\"sleepStatus\":3,\"startTime\":\"03:00:00\"},{\"endTime\":\"03:02:00\",\"sleepStatus\":4,\"startTime\":\"03:02:00\"},{\"endTime\":\"03:10:00\",\"sleepStatus\":3,\"startTime\":\"03:04:00\"},{\"endTime\":\"03:12:00\",\"sleepStatus\":7,\"startTime\":\"03:12:00\"},{\"endTime\":\"03:22:00\",\"sleepStatus\":6,\"startTime\":\"03:14:00\"},{\"endTime\":\"04:08:00\",\"sleepStatus\":3,\"startTime\":\"03:24:00\"},{\"endTime\":\"04:10:00\",\"sleepStatus\":5,\"startTime\":\"04:10:00\"},{\"endTime\":\"04:38:00\",\"sleepStatus\":3,\"startTime\":\"04:12:00\"},{\"endTime\":\"04:40:00\",\"sleepStatus\":4,\"startTime\":\"04:40:00\"},{\"endTime\":\"04:42:00\",\"sleepStatus\":3,\"startTime\":\"04:42:00\"},{\"endTime\":\"04:46:00\",\"sleepStatus\":4,\"startTime\":\"04:44:00\"},{\"endTime\":\"04:50:00\",\"sleepStatus\":6,\"startTime\":\"04:48:00\"},{\"endTime\":\"04:52:00\",\"sleepStatus\":4,\"startTime\":\"04:52:00\"},{\"endTime\":\"05:08:00\",\"sleepStatus\":5,\"startTime\":\"04:54:00\"},{\"endTime\":\"05:16:00\",\"sleepStatus\":3,\"startTime\":\"05:10:00\"},{\"endTime\":\"05:18:00\",\"sleepStatus\":7,\"startTime\":\"05:18:00\"},{\"endTime\":\"05:22:00\",\"sleepStatus\":6,\"startTime\":\"05:20:00\"},{\"endTime\":\"05:28:00\",\"sleepStatus\":3,\"startTime\":\"05:24:00\"},{\"endTime\":\"05:30:00\",\"sleepStatus\":2,\"startTime\":\"05:30:00\"},{\"endTime\":\"05:36:00\",\"sleepStatus\":1,\"startTime\":\"05:32:00\"},{\"endTime\":\"05:38:00\",\"sleepStatus\":2,\"startTime\":\"05:38:00\"},{\"endTime\":\"05:48:00\",\"sleepStatus\":3,\"startTime\":\"05:40:00\"},{\"endTime\":\"05:58:00\",\"sleepStatus\":5,\"startTime\":\"05:50:00\"},{\"endTime\":\"06:04:00\",\"sleepStatus\":3,\"startTime\":\"06:00:00\"},{\"endTime\":\"06:08:00\",\"sleepStatus\":7,\"startTime\":\"06:06:00\"},{\"endTime\":\"06:10:00\",\"sleepStatus\":6,\"startTime\":\"06:10:00\"},{\"endTime\":\"06:12:00\",\"sleepStatus\":4,\"startTime\":\"06:12:00\"},{\"endTime\":\"06:14:00\",\"sleepStatus\":5,\"startTime\":\"06:14:00\"},{\"endTime\":\"06:16:00\",\"sleepStatus\":3,\"startTime\":\"06:16:00\"},{\"endTime\":\"06:18:00\",\"sleepStatus\":5,\"startTime\":\"06:18:00\"},{\"endTime\":\"06:22:00\",\"sleepStatus\":2,\"startTime\":\"06:20:00\"},{\"endTime\":\"06:24:00\",\"sleepStatus\":1,\"startTime\":\"06:24:00\"},{\"endTime\":\"06:26:00\",\"sleepStatus\":3,\"startTime\":\"06:26:00\"},{\"endTime\":\"06:28:00\",\"sleepStatus\":2,\"startTime\":\"06:28:00\"},{\"endTime\":\"07:28:00\",\"sleepStatus\":6,\"startTime\":\"06:30:00\"},{\"endTime\":\"07:48:00\",\"sleepStatus\":7,\"startTime\":\"07:30:00\"},{\"endTime\":\"11:35:00\",\"sleepStatus\":6,\"startTime\":\"11:35:00\"},{\"endTime\":\"11:37:00\",\"sleepStatus\":4,\"startTime\":\"11:37:00\"}],\"sleepScore\":74,\"stDev\":\"S091H068B020\"},{\"a\":0.43,\"ahi\":1,\"d\":5.57,\"date\":\"2019-03-24\",\"dayOfWeek\":\"03\\/24\",\"sleepRanges\":[{\"endTime\":\"12:04:00\",\"sleepStatus\":5,\"startTime\":\"12:02:00\"},{\"endTime\":\"12:16:00\",\"sleepStatus\":3,\"startTime\":\"12:06:00\"},{\"endTime\":\"12:28:00\",\"sleepStatus\":5,\"startTime\":\"12:18:00\"},{\"endTime\":\"13:00:00\",\"sleepStatus\":3,\"startTime\":\"12:30:00\"},{\"endTime\":\"13:08:00\",\"sleepStatus\":2,\"startTime\":\"13:02:00\"},{\"endTime\":\"13:32:00\",\"sleepStatus\":3,\"startTime\":\"13:10:00\"},{\"endTime\":\"13:34:00\",\"sleepStatus\":4,\"startTime\":\"13:34:00\"},{\"endTime\":\"13:40:00\",\"sleepStatus\":6,\"startTime\":\"13:36:00\"},{\"endTime\":\"13:42:00\",\"sleepStatus\":4,\"startTime\":\"13:42:00\"},{\"endTime\":\"13:58:00\",\"sleepStatus\":5,\"startTime\":\"13:44:00\"},{\"endTime\":\"14:00:00\",\"sleepStatus\":3,\"startTime\":\"14:00:00\"},{\"endTime\":\"14:04:00\",\"sleepStatus\":5,\"startTime\":\"14:02:00\"},{\"endTime\":\"14:08:00\",\"sleepStatus\":6,\"startTime\":\"14:06:00\"},{\"endTime\":\"14:24:00\",\"sleepStatus\":3,\"startTime\":\"14:10:00\"},{\"endTime\":\"14:26:00\",\"sleepStatus\":4,\"startTime\":\"14:26:00\"},{\"endTime\":\"14:46:00\",\"sleepStatus\":3,\"startTime\":\"14:28:00\"},{\"endTime\":\"14:48:00\",\"sleepStatus\":2,\"startTime\":\"14:48:00\"},{\"endTime\":\"14:50:00\",\"sleepStatus\":1,\"startTime\":\"14:50:00\"},{\"endTime\":\"14:54:00\",\"sleepStatus\":6,\"startTime\":\"14:52:00\"},{\"endTime\":\"15:16:00\",\"sleepStatus\":7,\"startTime\":\"14:56:00\"},{\"endTime\":\"21:11:00\",\"sleepStatus\":6,\"startTime\":\"21:01:00\"},{\"endTime\":\"21:13:00\",\"sleepStatus\":7,\"startTime\":\"21:13:00\"},{\"endTime\":\"21:27:00\",\"sleepStatus\":6,\"startTime\":\"21:15:00\"},{\"endTime\":\"21:37:00\",\"sleepStatus\":7,\"startTime\":\"21:29:00\"},{\"endTime\":\"21:49:00\",\"sleepStatus\":6,\"startTime\":\"21:39:00\"},{\"endTime\":\"22:19:00\",\"sleepStatus\":3,\"startTime\":\"21:51:00\"},{\"endTime\":\"22:21:00\",\"sleepStatus\":4,\"startTime\":\"22:21:00\"},{\"endTime\":\"22:29:00\",\"sleepStatus\":6,\"startTime\":\"22:23:00\"},{\"endTime\":\"22:31:00\",\"sleepStatus\":4,\"startTime\":\"22:31:00\"},{\"endTime\":\"22:59:00\",\"sleepStatus\":5,\"startTime\":\"22:33:00\"},{\"endTime\":\"23:01:00\",\"sleepStatus\":6,\"startTime\":\"23:01:00\"},{\"endTime\":\"23:03:00\",\"sleepStatus\":3,\"startTime\":\"23:03:00\"},{\"endTime\":\"23:05:00\",\"sleepStatus\":6,\"startTime\":\"23:05:00\"},{\"endTime\":\"23:07:00\",\"sleepStatus\":4,\"startTime\":\"23:07:00\"},{\"endTime\":\"23:09:00\",\"sleepStatus\":6,\"startTime\":\"23:09:00\"},{\"endTime\":\"23:11:00\",\"sleepStatus\":4,\"startTime\":\"23:11:00\"},{\"endTime\":\"00:13:00\",\"sleepStatus\":3,\"startTime\":\"23:13:00\"},{\"endTime\":\"00:21:00\",\"sleepStatus\":4,\"startTime\":\"00:15:00\"},{\"endTime\":\"00:33:00\",\"sleepStatus\":3,\"startTime\":\"00:23:00\"},{\"endTime\":\"00:35:00\",\"sleepStatus\":4,\"startTime\":\"00:35:00\"},{\"endTime\":\"00:39:00\",\"sleepStatus\":6,\"startTime\":\"00:37:00\"},{\"endTime\":\"01:33:00\",\"sleepStatus\":3,\"startTime\":\"00:41:00\"},{\"endTime\":\"01:39:00\",\"sleepStatus\":7,\"startTime\":\"01:35:00\"},{\"endTime\":\"01:41:00\",\"sleepStatus\":6,\"startTime\":\"01:41:00\"},{\"endTime\":\"01:43:00\",\"sleepStatus\":4,\"startTime\":\"01:43:00\"},{\"endTime\":\"01:59:00\",\"sleepStatus\":5,\"startTime\":\"01:45:00\"},{\"endTime\":\"02:01:00\",\"sleepStatus\":4,\"startTime\":\"02:01:00\"},{\"endTime\":\"03:41:00\",\"sleepStatus\":3,\"startTime\":\"02:03:00\"},{\"endTime\":\"03:43:00\",\"sleepStatus\":4,\"startTime\":\"03:43:00\"},{\"endTime\":\"03:45:00\",\"sleepStatus\":6,\"startTime\":\"03:45:00\"},{\"endTime\":\"03:47:00\",\"sleepStatus\":4,\"startTime\":\"03:47:00\"},{\"endTime\":\"04:01:00\",\"sleepStatus\":5,\"startTime\":\"03:49:00\"},{\"endTime\":\"04:05:00\",\"sleepStatus\":7,\"startTime\":\"04:03:00\"},{\"endTime\":\"04:27:00\",\"sleepStatus\":6,\"startTime\":\"04:07:00\"},{\"endTime\":\"04:43:00\",\"sleepStatus\":1,\"startTime\":\"04:29:00\"},{\"endTime\":\"04:47:00\",\"sleepStatus\":3,\"startTime\":\"04:45:00\"},{\"endTime\":\"05:01:00\",\"sleepStatus\":5,\"startTime\":\"04:49:00\"},{\"endTime\":\"05:07:00\",\"sleepStatus\":3,\"startTime\":\"05:03:00\"},{\"endTime\":\"05:27:00\",\"sleepStatus\":5,\"startTime\":\"05:09:00\"},{\"endTime\":\"05:39:00\",\"sleepStatus\":3,\"startTime\":\"05:29:00\"},{\"endTime\":\"05:43:00\",\"sleepStatus\":2,\"startTime\":\"05:41:00\"},{\"endTime\":\"05:45:00\",\"sleepStatus\":3,\"startTime\":\"05:45:00\"},{\"endTime\":\"05:49:00\",\"sleepStatus\":2,\"startTime\":\"05:47:00\"},{\"endTime\":\"06:19:00\",\"sleepStatus\":3,\"startTime\":\"05:51:00\"},{\"endTime\":\"06:39:00\",\"sleepStatus\":5,\"startTime\":\"06:21:00\"},{\"endTime\":\"06:45:00\",\"sleepStatus\":4,\"startTime\":\"06:41:00\"},{\"endTime\":\"06:55:00\",\"sleepStatus\":5,\"startTime\":\"06:47:00\"},{\"endTime\":\"07:01:00\",\"sleepStatus\":3,\"startTime\":\"06:57:00\"},{\"endTime\":\"07:25:00\",\"sleepStatus\":6,\"startTime\":\"07:03:00\"},{\"endTime\":\"07:47:00\",\"sleepStatus\":7,\"startTime\":\"07:27:00\"}],\"sleepScore\":73,\"stDev\":\"S080H057B024\"},{\"a\":0.29,\"ahi\":1,\"d\":5.71,\"date\":\"2019-03-25\",\"dayOfWeek\":\"03\\/25\",\"sleepRanges\":[{\"endTime\":\"12:24:00\",\"sleepStatus\":3,\"startTime\":\"12:02:00\"},{\"endTime\":\"12:28:00\",\"sleepStatus\":6,\"startTime\":\"12:26:00\"},{\"endTime\":\"12:32:00\",\"sleepStatus\":4,\"startTime\":\"12:30:00\"},{\"endTime\":\"12:36:00\",\"sleepStatus\":3,\"startTime\":\"12:34:00\"},{\"endTime\":\"12:52:00\",\"sleepStatus\":5,\"startTime\":\"12:38:00\"},{\"endTime\":\"13:00:00\",\"sleepStatus\":3,\"startTime\":\"12:54:00\"},{\"endTime\":\"13:02:00\",\"sleepStatus\":2,\"startTime\":\"13:02:00\"},{\"endTime\":\"13:04:00\",\"sleepStatus\":1,\"startTime\":\"13:04:00\"},{\"endTime\":\"13:06:00\",\"sleepStatus\":6,\"startTime\":\"13:06:00\"},{\"endTime\":\"13:26:00\",\"sleepStatus\":7,\"startTime\":\"13:08:00\"},{\"endTime\":\"22:35:00\",\"sleepStatus\":6,\"startTime\":\"21:51:00\"},{\"endTime\":\"22:45:00\",\"sleepStatus\":1,\"startTime\":\"22:37:00\"},{\"endTime\":\"22:55:00\",\"sleepStatus\":3,\"startTime\":\"22:47:00\"},{\"endTime\":\"22:57:00\",\"sleepStatus\":4,\"startTime\":\"22:57:00\"},{\"endTime\":\"22:59:00\",\"sleepStatus\":5,\"startTime\":\"22:59:00\"},{\"endTime\":\"23:07:00\",\"sleepStatus\":6,\"startTime\":\"23:01:00\"},{\"endTime\":\"23:09:00\",\"sleepStatus\":4,\"startTime\":\"23:09:00\"},{\"endTime\":\"23:23:00\",\"sleepStatus\":5,\"startTime\":\"23:11:00\"},{\"endTime\":\"23:25:00\",\"sleepStatus\":3,\"startTime\":\"23:25:00\"},{\"endTime\":\"23:27:00\",\"sleepStatus\":1,\"startTime\":\"23:27:00\"},{\"endTime\":\"23:35:00\",\"sleepStatus\":7,\"startTime\":\"23:29:00\"},{\"endTime\":\"23:51:00\",\"sleepStatus\":6,\"startTime\":\"23:37:00\"},{\"endTime\":\"23:53:00\",\"sleepStatus\":4,\"startTime\":\"23:53:00\"},{\"endTime\":\"00:35:00\",\"sleepStatus\":3,\"startTime\":\"23:55:00\"},{\"endTime\":\"00:57:00\",\"sleepStatus\":5,\"startTime\":\"00:37:00\"},{\"endTime\":\"01:25:00\",\"sleepStatus\":3,\"startTime\":\"00:59:00\"},{\"endTime\":\"01:29:00\",\"sleepStatus\":6,\"startTime\":\"01:27:00\"},{\"endTime\":\"01:31:00\",\"sleepStatus\":4,\"startTime\":\"01:31:00\"},{\"endTime\":\"01:37:00\",\"sleepStatus\":5,\"startTime\":\"01:33:00\"},{\"endTime\":\"01:39:00\",\"sleepStatus\":4,\"startTime\":\"01:39:00\"},{\"endTime\":\"02:37:00\",\"sleepStatus\":3,\"startTime\":\"01:41:00\"},{\"endTime\":\"02:39:00\",\"sleepStatus\":7,\"startTime\":\"02:39:00\"},{\"endTime\":\"02:49:00\",\"sleepStatus\":6,\"startTime\":\"02:41:00\"},{\"endTime\":\"02:51:00\",\"sleepStatus\":4,\"startTime\":\"02:51:00\"},{\"endTime\":\"02:59:00\",\"sleepStatus\":5,\"startTime\":\"02:53:00\"},{\"endTime\":\"03:01:00\",\"sleepStatus\":4,\"startTime\":\"03:01:00\"},{\"endTime\":\"03:03:00\",\"sleepStatus\":6,\"startTime\":\"03:03:00\"},{\"endTime\":\"03:05:00\",\"sleepStatus\":4,\"startTime\":\"03:05:00\"},{\"endTime\":\"03:07:00\",\"sleepStatus\":6,\"startTime\":\"03:07:00\"},{\"endTime\":\"03:09:00\",\"sleepStatus\":4,\"startTime\":\"03:09:00\"},{\"endTime\":\"03:11:00\",\"sleepStatus\":3,\"startTime\":\"03:11:00\"},{\"endTime\":\"03:25:00\",\"sleepStatus\":5,\"startTime\":\"03:13:00\"},{\"endTime\":\"04:13:00\",\"sleepStatus\":3,\"startTime\":\"03:27:00\"},{\"endTime\":\"04:21:00\",\"sleepStatus\":2,\"startTime\":\"04:15:00\"},{\"endTime\":\"04:35:00\",\"sleepStatus\":3,\"startTime\":\"04:23:00\"},{\"endTime\":\"04:37:00\",\"sleepStatus\":6,\"startTime\":\"04:37:00\"},{\"endTime\":\"04:39:00\",\"sleepStatus\":4,\"startTime\":\"04:39:00\"},{\"endTime\":\"04:45:00\",\"sleepStatus\":5,\"startTime\":\"04:41:00\"},{\"endTime\":\"04:51:00\",\"sleepStatus\":3,\"startTime\":\"04:47:00\"},{\"endTime\":\"04:59:00\",\"sleepStatus\":5,\"startTime\":\"04:53:00\"},{\"endTime\":\"05:01:00\",\"sleepStatus\":7,\"startTime\":\"05:01:00\"},{\"endTime\":\"05:03:00\",\"sleepStatus\":6,\"startTime\":\"05:03:00\"},{\"endTime\":\"05:05:00\",\"sleepStatus\":4,\"startTime\":\"05:05:00\"},{\"endTime\":\"05:11:00\",\"sleepStatus\":5,\"startTime\":\"05:07:00\"},{\"endTime\":\"05:27:00\",\"sleepStatus\":3,\"startTime\":\"05:13:00\"},{\"endTime\":\"05:35:00\",\"sleepStatus\":5,\"startTime\":\"05:29:00\"},{\"endTime\":\"05:39:00\",\"sleepStatus\":3,\"startTime\":\"05:37:00\"},{\"endTime\":\"05:41:00\",\"sleepStatus\":5,\"startTime\":\"05:41:00\"},{\"endTime\":\"06:37:00\",\"sleepStatus\":3,\"startTime\":\"05:43:00\"},{\"endTime\":\"06:39:00\",\"sleepStatus\":2,\"startTime\":\"06:39:00\"},{\"endTime\":\"06:41:00\",\"sleepStatus\":3,\"startTime\":\"06:41:00\"},{\"endTime\":\"06:43:00\",\"sleepStatus\":5,\"startTime\":\"06:43:00\"},{\"endTime\":\"06:55:00\",\"sleepStatus\":3,\"startTime\":\"06:45:00\"},{\"endTime\":\"07:31:00\",\"sleepStatus\":6,\"startTime\":\"06:57:00\"},{\"endTime\":\"07:51:00\",\"sleepStatus\":7,\"startTime\":\"07:33:00\"}],\"sleepScore\":70,\"stDev\":\"S090H067B022\"}],\"errorCode\":-996,\"weekSleepEvaluation\":\"\",\"weeklyDAinfoVo\":null}";

    private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");
    private DateTime zeroOriginDT12;
    private DateTime zeroOriginDT00;

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
    private int VerticalLineWidth = 40;//柱状图宽度

    private Paint drawPaint;
    private List<String> timeTextList = new ArrayList<>();
    private List<String> dateTextList = new ArrayList<>();

    //------>测试 临时
    private List<String> explainTextList = new ArrayList<>();
    private List<Integer> explainColorList = new ArrayList<>();

    private RequestResult requestResult;
    private List<BodyStatus> bodyStatusList;
    //<-----

    public HistogramViewCV5test(Context context) {
        this(context, null);
    }

    public HistogramViewCV5test(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HistogramViewCV5test(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        testVerticalLinePaint.setColor(Color.parseColor("#55B0DD"));
        testVerticalLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        testVerticalLinePaint.setStrokeWidth(VerticalLineWidth);

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


        explainColorList.add(Color.parseColor("#9ae07e"));
        explainColorList.add(Color.parseColor("#61B0DD"));
        explainColorList.add(Color.parseColor("#F9FF04"));
        explainColorList.add(Color.parseColor("#EFC10C"));
        explainColorList.add(Color.parseColor("#9AE07D"));

        try {
            zeroOriginDT12 = new DateTime(dateTimeFormatter.parse("12:00:00"));
            zeroOriginDT00 = new DateTime(dateTimeFormatter.parse("00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
            canvas.drawText(requestResult.getBodyStatusList().get(i).getDayOfWeek(), 0, dateTextList.get(i).length(),
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
                float zeroOrigin12Y = startY;//12点对应Y坐标
                float zeroOrigin00Y = startY - (startY - topReservedHeight) / 2;//00点对应Y坐标

                float preHouseHeight = coordinateHeight / 24;//每小时高度
                float preMinuteHeight = preHouseHeight / 60;//每分钟高度

                float columnStartY = 0;
                float columnEndY = 0;
                float zeroOriginHouse = 24;
                float zeroOrigin12House = 12;

//                DateTime startDateTime = null;
//                DateTime endDateTime = null;
//                try {
//                    startDateTime = new DateTime(dateTimeFormatter.parse(rangesBean.getStartTime()));
//                    endDateTime = new DateTime(dateTimeFormatter.parse(rangesBean.getEndTime()));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    continue;
//                }
//
//                if (startDateTime.isEqual(zeroOriginDT12)) {
//                    if (endDateTime.isEqual(zeroOriginDT12)) {
//                        continue;
//                    }
//                    if (endDateTime.isAfter(zeroOriginDT12)) {
//                        columnStartY = zeroOrigin12Y;
//                    } else {
//                        continue;
//                    }
//                } else if (startDateTime.isAfter(zeroOriginDT12)) {//12点到24点
//                    columnStartY = zeroOrigin12Y - (preHouseHeight * (startHouse - zeroOrigin12House)) - (preMinuteHeight * startMinute);
//                } else if (startDateTime.isBefore(zeroOriginDT12)) {//00点到12点
//                    columnStartY = zeroOrigin00Y - preHouseHeight * startHouse - (preMinuteHeight * startMinute);
//                } else {
//                    throw new NullPointerException("错误 startDateTime异常");
//                }
//
//                if (endDateTime.isEqual(zeroOriginDT12)) {
//                    if (startDateTime.isEqual(zeroOriginDT12)) {
//                        continue;
//                    }
//                    if (startDateTime.isBefore(zeroOriginDT12)) {
//                        columnEndY = topReservedHeight;
//                    } else {
//                        continue;
//                    }
//                } else if (endDateTime.isAfter(zeroOriginDT12)) {
//                    columnEndY = zeroOrigin12Y - (preHouseHeight * (endHouse - zeroOrigin12House)) - (preMinuteHeight * endMinute);
//                } else if (endDateTime.isBefore(zeroOriginDT12)) {
//                    columnEndY = zeroOrigin00Y - preHouseHeight * endHouse - (preMinuteHeight * endMinute);
//                } else {
//                    throw new NullPointerException("错误 endDateTime异常");
//                }
//------------------——-------------------------------
                if (startHouse == 0) {
                    startHouse = 24;
                }
                if (startHouse >= 12) {
                    columnStartY = zeroOrigin12Y - (preHouseHeight * (startHouse - zeroOrigin12House)) - (preMinuteHeight * startMinute);
                } else {
                    columnStartY = zeroOrigin12Y - (preHouseHeight * (startHouse + zeroOrigin12House)) - (preMinuteHeight * startMinute);
                }

                if (endHouse == 0) {
                    endHouse = 24;
                }
                if (endHouse >= 12) {
                    columnEndY = zeroOrigin12Y - (preHouseHeight * (endHouse - zeroOrigin12House)) - (preMinuteHeight * startMinute);
                } else {
                    columnEndY = zeroOrigin12Y - (preHouseHeight * (endHouse + zeroOrigin12House)) - (preMinuteHeight * startMinute);
                }

                testVerticalLinePaint.setColor(getExplainColor(rangesBean.getSleepStatus()));
                canvas.drawLine(startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1),
                        columnStartY, startX + ((getWidth() - rightReservedWidth - startX) / 8) * (i + 1), columnEndY, testVerticalLinePaint);
            }

            //--------测试算法----------------------

//            WeekSleepRangesBean rangesBean = new WeekSleepRangesBean();
//            rangesBean.setStartTime("22:55:00");
//            rangesBean.setEndTime("23:39:00");
//            rangesBean.setSleepStatus(7);
//            String[] startTimeStrs = rangesBean.getStartTime().split(":");
//            String[] endTimeStrs = rangesBean.getEndTime().split(":");
//            int startHouse = Integer.parseInt(startTimeStrs[0]);
//            int startMinute = Integer.parseInt(startTimeStrs[1]);
//            int endHouse = Integer.parseInt(endTimeStrs[0]);
//            int endMinute = Integer.parseInt(endTimeStrs[1]);
//
//            float coordinateHeight = startY - topReservedHeight;//绘制坐标总高度
//            float zeroOrigin12Y = startY;//12点对应Y坐标
//            float zeroOrigin00Y = startY - (startY - topReservedHeight) / 2;//00点对应Y坐标
//
//            float preHouseHeight = coordinateHeight / 24;//每小时高度
//            float preMinuteHeight = preHouseHeight / 60;//每分钟高度
//
//            float columnStartY = 0;
//            float columnEndY = 0;
//            float zeroOriginHouse = 24;
//            float zeroOrigin12House = 12;
//
//            if (startHouse == 0) {
//                startHouse = 24;
//            }
//            if (startHouse >= 12) {
//                columnStartY = zeroOrigin12Y - (preHouseHeight * (startHouse - zeroOrigin12House)) - (preMinuteHeight * startMinute);
//            } else {
//                columnStartY = zeroOrigin12Y - (preHouseHeight * (startHouse + zeroOrigin12House)) - (preMinuteHeight * startMinute);
//            }
//
//            if (endHouse == 0) {
//                endHouse = 24;
//            }
//            if (endHouse >= 12) {
//                columnEndY = zeroOrigin12Y - (preHouseHeight * (endHouse - zeroOrigin12House)) - (preMinuteHeight * startMinute);
//            } else {
//                columnEndY = zeroOrigin12Y - (preHouseHeight * (endHouse + zeroOrigin12House)) - (preMinuteHeight * startMinute);
//            }
//            testVerticalLinePaint.setColor(getExplainColor(rangesBean.getSleepStatus()));
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

    //彩带图颜色
    public int getExplainColor(int status) {
        switch (status) {
            case 1:
                return Color.parseColor("#9AE07E");
            case 2:
                return Color.parseColor("#9AE07E");//青
            case 3:
                return Color.parseColor("#FEC202");
            case 4:
                return Color.parseColor("#FEC202");//橙
            case 5:
                return Color.parseColor("#FFFF00");//黄
            case 6:
                return Color.parseColor("#55B0DD");//蓝
            default:
                return Color.parseColor("#D3D3D3");//灰
        }
    }

    //--------------------------------------------------
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

}
