package com.tongliu.calculator.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    /**
     * Displays a long-lasting {@link Toast}
     * @param context The Context for current Activity.
     * @param msg The message needs to be displayed.
     * @return The {@link Toast} entity that is shown.
     */
    public static Toast makeLongToast(Context context, String msg){
        return Toast.makeText(context,msg, Toast.LENGTH_LONG);
    }
    /**
     * Displays a short-lasting {@link Toast}
     * @param context The Context for current Activity.
     * @param msg The message needs to be displayed.
     * @return The {@link Toast} entity that is shown.
     */
    public static Toast makeShortToast(Context context, String msg){
        return Toast.makeText(context,msg, Toast.LENGTH_SHORT);
    }
}
