package com.zyl.demo.launchmode.util;

import android.util.Log;

/**
 * Created by JasonZhao on 16/5/17.
 */
public class LogUtil {

  private static final String TAG = "AndroidLaunchModeDemo";

  public static void DEBUG(String tag, String msg) {
    Log.d(TAG + ":" + tag, msg);
  }
}
