package com.fancy.androidutils.utils.toast

import android.app.Activity
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.fancy.androidutils.R
import com.fancy.androidutils.databinding.CommonToastBinding

/**
 * @Description: (FToast)
 * @author fanlei
 * @date  2022/10/22 10:46
 * @version V1.0
 */
class FToast {
    companion object {

        const val LONG_DURATION = 5000L // 5 seconds
        const val SHORT_DURATION = 2000L // 2 seconds

        const val GRAVITY_TOP = 10
        const val GRAVITY_CENTER = 20
        const val GRAVITY_BOTTOM = 30

        private lateinit var layoutInflater: LayoutInflater


        fun createToast(context: Activity, layout: View) {
            createToast(context, layout, GRAVITY_BOTTOM, SHORT_DURATION)
        }

         fun createToast(context: Activity, layout: View, gravity: Int, duration: Long) {
            // init toast
            val toast = Toast(context.applicationContext)
            startTimer(duration, toast)
            when (gravity) {
                GRAVITY_BOTTOM -> toast.setGravity(
                    Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM,
                    0,
                    60
                )
                GRAVITY_CENTER -> toast.setGravity(Gravity.CENTER, 0, 0)
                GRAVITY_TOP -> toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.TOP, 0, 60)
            }

            toast.view = layout
            toast.show()
        }


        /**
         * 常规的toast
         */
        fun showToast(context: Activity, msg: String?) {
            showToast(context, msg, GRAVITY_BOTTOM, false)
        }


        fun showToast(context: Activity, message: String?, gravity: Int, isShowImage: Boolean) {
            layoutInflater = LayoutInflater.from(context)
            val binding = CommonToastBinding.inflate(layoutInflater)
            val layout = binding.root

            if (isShowImage) {
                binding.customToastImage.visibility = View.VISIBLE
            } else {
                binding.customToastImage.visibility = View.GONE
            }

            // Pulse Animation for Icon
            startPulseAnimation(context, binding.customToastImage)
            binding.customToastDescription.text = message

            // init toast
            val toast = Toast(context.applicationContext)
            startTimer(SHORT_DURATION, toast)
            when (gravity) {
                GRAVITY_BOTTOM -> toast.setGravity(
                    Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM,
                    0,
                    60
                )
                GRAVITY_CENTER -> toast.setGravity(Gravity.CENTER, 0, 0)
                GRAVITY_TOP -> toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.TOP, 0, 60)
            }

            toast.view = layout
            toast.show()
        }


        private fun startPulseAnimation(context: Activity, customToastImage: ImageView) {
            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
            customToastImage.startAnimation(pulseAnimation)
        }


        private fun startTimer(duration: Long, toast: Toast) {
            val timer = object : CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // do nothing
                }

                override fun onFinish() {
                    toast.cancel()
                }
            }
            timer.start()
        }


    }

}