package com.fancy.android_utils.widget

import android.view.View
import android.widget.TextView
import com.fancy.android_utils.R
import com.kongzue.dialogx.dialogs.CustomDialog
import com.kongzue.dialogx.interfaces.OnBindView

/**
 * @Description: (用一句话描述)
 * @author fanlei
 * @date  2022/10/23 15:56
 * @version V1.0
 */
class DialogBindView : OnBindView<CustomDialog>(R.layout.view_dialog_bind) {
    private var tvDesc: TextView? = null
    var dialog: CustomDialog? = null

    override fun onBind(dialog: CustomDialog?, v: View?) {
        this.dialog = dialog
        dialog?.restartDialog()
        tvDesc = v?.findViewById(R.id.tv_desc)
        tvDesc?.text = "重新赋值。"
    }

    fun setText(msg: String) {
        tvDesc?.text = msg
        dialog?.refreshUI()
    }


}