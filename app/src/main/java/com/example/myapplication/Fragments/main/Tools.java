/*
 * Created By Yaman Alkhateeb
 */

package com.example.myapplication.Fragments.main;

import java.text.SimpleDateFormat;
import java.util.Date;

class Tools {

    public static String getFormattedDateEvent(Long dateTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
        return newFormat.format(new Date(dateTime));
    }
}
