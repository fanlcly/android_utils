package com.fancy.android_utils

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fancy.android_utils.widget.DialogBindView
import com.fancy.androidutils.utils.DensityUtils
import com.kongzue.dialogx.dialogs.*
import com.kongzue.dialogx.interfaces.OnBindView
import com.kongzue.dialogx.interfaces.OnIconChangeCallBack
import com.kongzue.dialogx.util.TextInfo

/**
 * @Description: (DialogXActivity)
 * @author fanlei
 * @date  2022/10/22 16:57
 * @version V1.0
 */
class DialogXActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogx)

//        DialogX.globalStyle = IOSStyle.style()

        findViewById<View>(R.id.btn3).setOnClickListener {
            MessageDialog.show("标题", "这里是正文内容。", "确定", "取消")
                .setOkButton { _, _ ->
                    PopTip.show("点击确定按钮")
                    false
                }
        }

        findViewById<View>(R.id.btn4).setOnClickListener {
            val messageDialog =
                MessageDialog("多选对话框", "移除App会将它从主屏幕移除并保留其所有数据。", "删除App", "取消", "移至App资源库")
                    .setButtonOrientation(LinearLayout.VERTICAL)
            messageDialog.okTextInfo =
                TextInfo().setFontColor(Color.parseColor("#EB5545")).setBold(true)
            messageDialog.show()
        }


        findViewById<View>(R.id.btn5).setOnClickListener {
            InputDialog("标题", "正文内容", "确定", "取消", "正在输入的文字")
                .setInputText("默认输入的内容")
                .setOkButton { baseDialog, v, inputStr ->
                    PopTip.show("输入的内容：$inputStr")
                    false
                }
                .show()
        }


        // 右边弹窗
        findViewById<View>(R.id.btn6).setOnClickListener {
            val s = "你可以向下滑动来关闭这个对话框"
            BottomDialog("标题", "这里是对话框内容。\n$s。\n底部对话框也支持自定义布局扩展使用方式。",
                object : OnBindView<BottomDialog>(R.layout.layout_custom_view) {
                    override fun onBind(dialog: BottomDialog, v: View) {
                        if (dialog.dialogImpl.imgTab != null) {
                            (dialog.dialogImpl.imgTab.parent as ViewGroup).removeView(dialog.dialogImpl.imgTab)
                        }
                        v.setOnClickListener {
                            dialog.dismiss()
                            PopTip.show("Click Custom View")
                        }
                    }
                })
                .show()
        }



        findViewById<View>(R.id.btn8).setOnClickListener {

            //Material 可滑动展开 BottomMenu 演示
            BottomMenu.build()
                .setBottomDialogMaxHeight(0.6f)
                .setMenuList(
                    arrayOf(
                        "添加",
                        "查看",
                        "编辑",
                        "删除",
                        "分享",
                        "评论",
                        "下载",
                        "收藏",
                        "赞！",
                        "不喜欢",
                        "所属专辑",
                        "复制链接",
                        "类似推荐",
                        "添加",
                        "查看",
                        "编辑",
                        "删除",
                        "分享",
                        "评论",
                        "下载",
                        "收藏",
                        "赞！",
                        "不喜欢",
                        "所属专辑",
                        "复制链接",
                        "类似推荐"
                    )
                )
                .setOnIconChangeCallBack(object : OnIconChangeCallBack<BottomMenu?>(true) {
                    override fun getIcon(
                        bottomMenu: BottomMenu?,
                        index: Int,
                        menuText: String
                    ): Int {
                        when (menuText) {
                            "添加" -> return R.mipmap.img_dialogx_demo_add
                            "查看" -> return R.mipmap.img_dialogx_demo_view
                            "编辑" -> return R.mipmap.img_dialogx_demo_edit
                            "删除" -> return R.mipmap.img_dialogx_demo_delete
                            "分享" -> return R.mipmap.img_dialogx_demo_share
                            "评论" -> return R.mipmap.img_dialogx_demo_comment
                            "下载" -> return R.mipmap.img_dialogx_demo_download
                            "收藏" -> return R.mipmap.img_dialogx_demo_favorite
                            "赞！" -> return R.mipmap.img_dialogx_demo_good
                            "不喜欢" -> return R.mipmap.img_dialogx_demo_dislike
                            "所属专辑" -> return R.mipmap.img_dialogx_demo_album
                            "复制链接" -> return R.mipmap.img_dialogx_demo_link
                            "类似推荐" -> return R.mipmap.img_dialogx_demo_recommend
                        }
                        return 0
                    }
                })
                .setOnMenuItemClickListener { dialog, text, index ->
                    PopTip.show(text)
                    false
                }
                .show()
        }

        findViewById<View>(R.id.btn9).setOnClickListener {
            BottomDialog.show(object : OnBindView<BottomDialog>(R.layout.layout_custom_reply) {
                override fun onBind(dialog: BottomDialog, v: View) {
                    val btnReplyCommit = v.findViewById<TextView>(R.id.btn_reply_commit)
                    val editReplyCommit = v.findViewById<EditText>(R.id.edit_reply_commit)
                    btnReplyCommit.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        PopTip.show(
                            """
                                提交内容：
                                ${editReplyCommit.text}
                                """.trimIndent()
                        )
                    })
                    editReplyCommit.postDelayed(Runnable { showIME(editReplyCommit) }, 300)
                }
            }).isAllowInterceptTouch = false
        }

        findViewById<View>(R.id.btn10).setOnClickListener {
            CustomDialog.show(object : OnBindView<CustomDialog>(R.layout.layout_custom_dialog) {
                override fun onBind(dialog: CustomDialog, v: View) {
                    val btnOk: ImageView
                    btnOk = v.findViewById(R.id.btn_ok)
                    btnOk.setOnClickListener { dialog.dismiss() }
                }
            }).maskColor = resources.getColor(R.color.black30)
        }

        findViewById<View>(R.id.btn11).setOnClickListener {
            CustomDialog.show(object :
                OnBindView<CustomDialog>(R.layout.layout_custom_dialog_align) {
                private var btnSelectPositive: TextView? = null
                override fun onBind(dialog: CustomDialog, v: View) {
                    btnSelectPositive = v.findViewById(R.id.btn_selectPositive)
                    btnSelectPositive?.setOnClickListener {
                        PopTip.show("我知道了")
                        dialog.dismiss()
                    }
                }
            })
                .setCancelable(false)
                .setMaskColor(resources.getColor(R.color.black30))
                .setEnterAnimResId(R.anim.anim_custom_pop_enter)
                .setExitAnimResId(R.anim.anim_custom_pop_exit)
                .setAlignBaseViewGravity(
                    findViewById<View>(R.id.btn11),
                    Gravity.TOP or Gravity.CENTER_HORIZONTAL
                )
                .setBaseViewMarginBottom(-DensityUtils.dp2px(this, 45F))
                .show()
        }


        findViewById<View>(R.id.btn12).setOnClickListener {
            val bindView = DialogBindView()
            CustomDialog.show(bindView).maskColor = resources.getColor(R.color.black30)
            bindView.setText("动态赋值")
        }


    }


    fun showIME(editText: EditText?) {
        if (editText == null) {
            return
        }
        editText.requestFocus()
        editText.isFocusableInTouchMode = true
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}