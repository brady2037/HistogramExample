package com.example.histogram;

import android.graphics.Color;
import android.graphics.Paint;

import com.example.histogram.bean.RequestResult;
import com.example.histogram.util.JsonUtil;

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws ParseException {
         String resJsonStr = "{\n" +
                "  \"bodyStatusList\": [\n" +
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
                "    },\n" +
                "    {\n" +
                "      \"a\": 0.29,\n" +
                "      \"ahi\": 3,\n" +
                "      \"d\": 5.71,\n" +
                "      \"date\": \"2019-03-23\",\n" +
                "      \"dayOfWeek\": \"03/23\",\n" +
                "      \"sleepRanges\": [\n" +
                "        {\n" +
                "          \"endTime\": \"21:02:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"21:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:10:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:04:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:12:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"21:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:20:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"21:14:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:22:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"21:22:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:32:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:24:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:38:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"21:34:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:42:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"21:40:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:48:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"21:44:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:10:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"21:50:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:24:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"22:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:40:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"22:26:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:42:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"22:42:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:44:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"22:44:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:06:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"22:46:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:08:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:08:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:10:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:12:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:18:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:14:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:22:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:20:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:26:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"23:24:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:28:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:28:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:32:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:34:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"23:34:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:50:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:36:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:52:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"00:52:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:00:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"00:54:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:04:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"01:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:10:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"01:06:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:28:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"01:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:36:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"01:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:40:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"01:38:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:26:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"01:42:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:58:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"02:28:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:00:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"03:00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:02:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:10:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"03:04:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:12:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"03:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:22:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"03:14:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:08:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"03:24:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:10:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"04:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:38:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"04:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:40:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"04:40:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:42:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"04:42:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:46:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"04:44:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:50:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"04:48:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:52:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"04:52:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:08:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"04:54:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:16:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:18:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"05:18:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:22:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"05:20:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:28:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:24:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:30:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"05:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:36:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"05:32:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:38:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"05:38:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:48:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:40:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:58:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"05:50:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:04:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:08:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"06:06:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:10:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"06:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:12:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"06:12:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:14:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"06:14:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:16:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:16:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:18:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"06:18:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:22:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"06:20:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:24:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"06:24:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:26:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:26:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:28:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"06:28:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:28:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"06:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:48:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"07:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"11:35:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"11:35:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"11:37:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"11:37:00\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sleepScore\": 74,\n" +
                "      \"stDev\": \"S091H068B020\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a\": 0.43,\n" +
                "      \"ahi\": 1,\n" +
                "      \"d\": 5.57,\n" +
                "      \"date\": \"2019-03-24\",\n" +
                "      \"dayOfWeek\": \"03/24\",\n" +
                "      \"sleepRanges\": [\n" +
                "        {\n" +
                "          \"endTime\": \"12:04:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"12:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:16:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"12:06:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:28:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"12:18:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:00:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"12:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:08:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"13:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:32:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"13:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:34:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"13:34:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:40:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"13:36:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:42:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"13:42:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:58:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"13:44:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:00:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"14:00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:04:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"14:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:08:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"14:06:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:24:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"14:10:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:26:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"14:26:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:46:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"14:28:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:48:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"14:48:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:50:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"14:50:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"14:54:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"14:52:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"15:16:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"14:56:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:11:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:13:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"21:13:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:27:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:15:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:37:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"21:29:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"21:49:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:39:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:19:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"21:51:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:21:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"22:21:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:29:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"22:23:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:31:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"22:31:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:59:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"22:33:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:01:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:03:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:05:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:05:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:07:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:07:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:09:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:09:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:11:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:11:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:13:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:13:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:21:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"00:15:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:33:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"00:23:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:35:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"00:35:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:39:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"00:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:33:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"00:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:39:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"01:35:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:41:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"01:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:43:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"01:43:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:59:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"01:45:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:01:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"02:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:41:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"02:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:43:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:43:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:45:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"03:45:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:47:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:47:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:01:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"03:49:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:05:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"04:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:27:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"04:07:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:43:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"04:29:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:47:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"04:45:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:01:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"04:49:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:07:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:27:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"05:09:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:39:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:29:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:43:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"05:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:45:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:45:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:49:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"05:47:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:19:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:51:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:39:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"06:21:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:45:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"06:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:55:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"06:47:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:01:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:57:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:25:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"07:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:47:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"07:27:00\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sleepScore\": 73,\n" +
                "      \"stDev\": \"S080H057B024\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a\": 0.29,\n" +
                "      \"ahi\": 1,\n" +
                "      \"d\": 5.71,\n" +
                "      \"date\": \"2019-03-25\",\n" +
                "      \"dayOfWeek\": \"03/25\",\n" +
                "      \"sleepRanges\": [\n" +
                "        {\n" +
                "          \"endTime\": \"12:24:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"12:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:28:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"12:26:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:32:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"12:30:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:36:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"12:34:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"12:52:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"12:38:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:00:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"12:54:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:02:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"13:02:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:04:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"13:04:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:06:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"13:06:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"13:26:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"13:08:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:35:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"21:51:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:45:00\",\n" +
                "          \"sleepStatus\": 1,\n" +
                "          \"startTime\": \"22:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:55:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"22:47:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:57:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"22:57:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"22:59:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"22:59:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:07:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:09:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:09:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:23:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"23:11:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:25:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:25:00\"\n" +
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
                "          \"endTime\": \"23:51:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"23:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"23:53:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"23:53:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:35:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"23:55:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"00:57:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"00:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:25:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"00:59:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:29:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"01:27:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:31:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"01:31:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:37:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"01:33:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"01:39:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"01:39:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:37:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"01:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:39:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"02:39:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:49:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"02:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:51:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"02:51:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"02:59:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"02:53:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:01:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:03:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"03:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:05:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:05:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:07:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"03:07:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:09:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"03:09:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:11:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"03:11:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"03:25:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"03:13:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:13:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"03:27:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:21:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"04:15:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:35:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"04:23:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:37:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"04:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:39:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"04:39:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:45:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"04:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:51:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"04:47:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"04:59:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"04:53:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:01:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"05:01:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:03:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"05:03:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:05:00\",\n" +
                "          \"sleepStatus\": 4,\n" +
                "          \"startTime\": \"05:05:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:11:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"05:07:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:27:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:13:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:35:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"05:29:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:39:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:37:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"05:41:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"05:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:37:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"05:43:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:39:00\",\n" +
                "          \"sleepStatus\": 2,\n" +
                "          \"startTime\": \"06:39:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:41:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:41:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:43:00\",\n" +
                "          \"sleepStatus\": 5,\n" +
                "          \"startTime\": \"06:43:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"06:55:00\",\n" +
                "          \"sleepStatus\": 3,\n" +
                "          \"startTime\": \"06:45:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:31:00\",\n" +
                "          \"sleepStatus\": 6,\n" +
                "          \"startTime\": \"06:57:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"endTime\": \"07:51:00\",\n" +
                "          \"sleepStatus\": 7,\n" +
                "          \"startTime\": \"07:33:00\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sleepScore\": 70,\n" +
                "      \"stDev\": \"S090H067B022\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"errorCode\": -996,\n" +
                "  \"weekSleepEvaluation\": \"\",\n" +
                "  \"weeklyDAinfoVo\": null\n" +
                "}";
        RequestResult requestResult;
        requestResult = JsonUtil.toBean(resJsonStr, RequestResult.class);
        for(int i = 0;i<requestResult.getBodyStatusList().size();i++){
            if(i==3){


            for(int j = 0;j<requestResult.getBodyStatusList().get(i).getSleepRanges().size();j++){

                System.out.println(requestResult.getBodyStatusList().get(i).getSleepRanges().get(j).getStartTime() +"\n"+requestResult.getBodyStatusList().get(i).getSleepRanges().get(j).getEndTime());
                System.out.println("-------------------");
            }
            }
        }
        assertEquals(4, 2 + 2);
    }
}