package com.ruiqin.tinkerdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ruiqin.shen
 * 类说明：SP保存
 */

public class SPUtils {

    static SharedPreferences mSharedPreferences;

    /**
     * 初始化，在MyApplication中
     *
     * @param context
     */
    public static void init(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 保存String到SP中
     *
     * @param name
     * @param content
     */
    public static void putString(String name, String content) {
        mSharedPreferences.edit().putString(name, content).apply();
    }


    /**
     * 保存Boolean到SP中
     *
     * @param name
     * @param content
     */
    public static void putBoolean(String name, boolean content) {
        mSharedPreferences.edit().putBoolean(name, content).apply();
    }


    /**
     * 从SP中获取String
     *
     * @param name
     * @return
     */
    public static String getString(String name) {
        return mSharedPreferences.getString(name, "");
    }

    /**
     * 从SP中获取Boolean
     *
     * @param name
     * @return
     */
    public static boolean getBoolean(String name) {
        return mSharedPreferences.getBoolean(name, false);
    }

    /**
     * 清除保存到本地SP的数据
     */
    public static void clean() {
        mSharedPreferences.edit().clear();
    }
}
