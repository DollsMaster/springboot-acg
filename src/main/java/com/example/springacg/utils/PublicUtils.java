package com.example.springacg.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PublicUtils {
    public String getTimestamp(String format) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String time = simpleDateFormat.format(date);
        return time;
    }
}
