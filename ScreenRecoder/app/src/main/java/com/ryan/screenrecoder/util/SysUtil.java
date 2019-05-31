package com.ryan.screenrecoder.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/**
 * Created by zx315476228 on 17-3-10.
 */

public class SysUtil {
    private static String ipRegex = "^(1\\d{2}|2[0-4 ]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
            + "(1\\d{2}|2[0-4]\\ d|25[0-5]|[1-9]\\d|\\d)\\."
            + "(1\\d{2}|2[0-4]\\ d|25[0-5]|[1-9]\\d|\\d)\\."
            + "(1\\d{2}|2[0-4]\\ d|25[0-5]|[1-9]\\d|\\d)$";

    /**
     * 获取手机高宽密度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 手机屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 手机屏幕DPI
     *
     * @param context
     * @return
     */
    public static int getScreenDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;

    }

    public static int getVersionCode() {
        return Build.VERSION.SDK_INT;
    }
    public static boolean isIpAddress(String ip){
        return ip.matches(ipRegex);
    }
}
