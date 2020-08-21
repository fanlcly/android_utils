package com.fancy.androidutils.encrypt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.UUID;

/**
 * Safeguard
 *
 * @author fanlei
 * @version 1.0 2018\5\31 0031
 * @since JDK 1.7
 */
public class Safeguard {


    private Safeguard() {}

    private static final String TAG = "Safeguard";
    private static final String KEY_SAFEGUARD_CLUE = "safeguardClue";
    private volatile static String safeguardClue = null;


    /**
     * getSharedPreferences( Context.MODE_PRIVATE)
     *
     * @param context
     * @return
     */
    private static SharedPreferences getSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(Digest.MD5.getHex(TAG), Context.MODE_PRIVATE);
    }

    /**
     * 获取加串，<br/>
     * 如果本地存储中获取未空，就生成新的加密串并存储在本地
     *
     * @param context
     * @return
     */
    @NonNull
    public static String getSafeguardClue(@NonNull Context context) {
        if (TextUtils.isEmpty(safeguardClue)) {
            synchronized (Safeguard.class) {
                if (TextUtils.isEmpty(safeguardClue)) {
                    safeguardClue = getSharedPreferences(context).getString(KEY_SAFEGUARD_CLUE, null);
                }
                if (TextUtils.isEmpty(safeguardClue)) {
                    safeguardClue = UUID.randomUUID().toString();
                    getSharedPreferences(context).edit().putString(KEY_SAFEGUARD_CLUE, safeguardClue).apply();
                }
            }
        }
        return safeguardClue;
    }


}
