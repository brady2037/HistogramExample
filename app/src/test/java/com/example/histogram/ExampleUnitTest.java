package com.example.histogram;

import android.graphics.Color;
import android.graphics.Paint;

import com.example.histogram.bean.RequestResult;
import com.example.histogram.util.JsonUtil;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
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
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm:ss");
         DateTime zeroOriginDT12 = null;
         DateTime zeroOriginDT00 = null;
        try {
            zeroOriginDT12 = new DateTime(dateTimeFormatter.parse("12:00:00"));
            zeroOriginDT00 = new DateTime(dateTimeFormatter.parse("00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateTime startDateTime = new DateTime(dateTimeFormatter.parse("12:00:00"));
        DateTime endDateTime = new DateTime(dateTimeFormatter.parse("12:00:00"));
        //12:00 -> 13:00
        if(startDateTime.isEqual(zeroOriginDT12)){

        }else if(startDateTime.isAfter(zeroOriginDT12)){

        }
        if(startDateTime.isAfter(zeroOriginDT12)&&zeroOriginDT00.isAfter(zeroOriginDT00)){

            System.out.println("true");
        }else{
            System.out.println("false");
        }
        assertEquals(4, 2 + 2);
    }
}