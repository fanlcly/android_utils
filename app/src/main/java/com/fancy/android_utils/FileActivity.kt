package com.fancy.android_utils

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fancy.androidutils.utils.ReadWriteFileUtils
import com.kongzue.dialogx.dialogs.BottomDialog
import com.kongzue.dialogx.dialogs.MessageDialog
import com.kongzue.dialogx.dialogs.PopTip
import com.kongzue.dialogx.interfaces.OnBindView
import java.io.File

/**
 * @Description: (文件操作业务)
 * @author fanlei
 * @date  2022/11/9 20:58
 * @version V1.0
 */
class FileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        findViewById<View>(R.id.btn1).setOnClickListener {
            BottomDialog.show(object : OnBindView<BottomDialog>(R.layout.layout_custom_reply) {
                override fun onBind(dialog: BottomDialog, v: View) {
                    val btnReplyCommit = v.findViewById<TextView>(R.id.btn_reply_commit)
                    val editReplyCommit = v.findViewById<EditText>(R.id.edit_reply_commit)
                    btnReplyCommit.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        ReadWriteFileUtils.writeFileByTotal(
                            this@FileActivity,
                            "test.txt",
                            editReplyCommit.text.toString().trimIndent()
                        )
//                        PopTip.show(
//                        """
//                                提交内容：
//                                ${editReplyCommit.text}
//                                """.trimIndent()
//                        )
                    })
                }
            }).isAllowInterceptTouch = false
        }

        findViewById<View>(R.id.btn2).setOnClickListener {
            val file = File(getExternalFilesDir(null)!!.path + File.separator + "test.txt")
            val fileStr = ReadWriteFileUtils.txt2String(file)

            MessageDialog.show("标题", fileStr, "确定", "取消")
                .setOkButton { _, _ ->
                    PopTip.show("点击确定按钮")
                    false
                }
        }

    }
}