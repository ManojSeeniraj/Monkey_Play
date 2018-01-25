package com.androidvideoplayer;

/**
 * Created by s.manoj on 23-12-2017.
 */

import android.util.Log;

public class AdsOnUILog {
    private static boolean  enableLog;

    public static final String ADS_TAG="Ad_Module";

    public static void displayLog(String msg) {
        if(enableLog) {
            Log.i(ADS_TAG, msg);
        }
    }

    public static void enableLog()
    {
        enableLog = true;
    }

    public static void disableLog()
    {
        enableLog = false;
    }

}
