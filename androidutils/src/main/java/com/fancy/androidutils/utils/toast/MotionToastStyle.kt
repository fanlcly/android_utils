package com.fancy.androidutils.utils.toast

import java.util.*

/**
 * @Description: (FToast)
 * @author fanlei
 * @date  2022/10/22 10:46
 * @version V1.0
 */
enum class MotionToastStyle {
    SUCCESS, ERROR, WARNING, INFO, DELETE, NO_INTERNET,COMMON;

    fun getName(): String {
        if (this.name.contains("_")) {
            return this.name.replaceFirst("_", " ")
        }
        return this.name
    }
}