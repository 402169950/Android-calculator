package com.tongliu.calculator.utils;

import android.util.Log;

import androidx.viewbinding.BuildConfig;

public class LogUtils {
    /**
     * Make a debug log output, this log will only be printed when the app is running in debugging mode.
     * @param tag the tag of the log.
     * @param msg the message of the log.
     */
    public static void makeDebugLog(String tag,String msg){
        if(BuildConfig.DEBUG)
            Log.d(tag, msg);
    }
}
