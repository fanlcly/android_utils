package com.fancy.androidutils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * SharedPreferences 工具类
 *
 * @author fanlei
 * @version 1.0 2018\5\31 0031
 * @since JDK 1.7
 */
public class SpUtils {

    public static String PREFERENCE_NAME = "share_data";
    private static SharedPreferences sp;

    private SpUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    private static SharedPreferences getSp(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE);
        }
        return sp;
    }


    /**
     * 存储List集合
     *
     * @param context 上下文
     * @param key     存储的键
     * @param list    存储的集合
     */
    public static void putList(Context context, String key, List<? extends Serializable> list) {
        try {
            put(context, key, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取List集合
     *
     * @param context 上下文
     * @param key     键
     * @param <E>     指定泛型
     * @return List集合
     */
    public static <E extends Serializable> List<E> getList(Context context, String key) {
        try {
            return (List<E>) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 存储对象
     */
    private static void put(Context context, String key, Object obj)
            throws IOException {
        if (obj == null) {//判断对象是否为空
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        // 将对象放到OutputStream中
        // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        baos.close();
        oos.close();

        putString(context, key, objectStr);
    }

    /**
     * 获取对象
     */
    private static Object get(Context context, String key)
            throws IOException, ClassNotFoundException {
        String wordBase64 = getString(context, key);
        // 将base64格式字符串还原成byte数组
        if (TextUtils.isEmpty(wordBase64)) { //不可少，否则在下面会报java.io.StreamCorruptedException
            return null;
        }
        byte[] objBytes = Base64.decode(wordBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        // 将byte数组转换成product对象
        Object obj = ois.readObject();
        bais.close();
        ois.close();
        return obj;
    }


    /**
     * 存入字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @param value   字符串的值
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        //存入数据
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @return 得到的字符串
     */
    public static String getString(Context context, String key) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, "");
    }

    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @param value   字符串的默认值
     * @return 得到的字符串
     */
    public static String getString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, value);
    }


    public static boolean putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        return editor.commit();
    }


    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public static boolean putLong(Context context, String key, long value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        return editor.commit();
    }


    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }


    public static long getLong(Context context, String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public static boolean putFloat(Context context, String key, float value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }


    public static float getFloat(Context context, String key) {
        return getFloat(context, key, -1);
    }


    public static float getFloat(Context context, String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }


    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }


    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }


    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }


    public static void remove(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        editor.commit();
    }

}
