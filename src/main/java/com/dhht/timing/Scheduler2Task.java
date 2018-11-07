package com.dhht.timing;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Scheduler2Task {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public String reportCurrentTime() {
        String time = "现在时间：" + dateFormat.format(new Date()).toString();
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        return time;
    }
}
