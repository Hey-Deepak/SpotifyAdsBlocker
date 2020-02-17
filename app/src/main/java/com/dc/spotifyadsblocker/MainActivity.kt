package com.dc.spotifyadsblocker

import android.content.ComponentName
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sw1 = findViewById<Switch>(R.id.switch1)
        val sw2 = findViewById<Switch>(R.id.switch2)
        val leftLinearLayout = findViewById<LinearLayout>(R.id.left_layout)
        val rightLinearLayout = findViewById<LinearLayout>(R.id.right_layout)

        sw1?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                right_layout.visibility = View.GONE
                if(sw2.isChecked)
                    sw2.isChecked = false
            }else{
                right_layout.visibility = View.VISIBLE
            }
        }

        sw2?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                leftLinearLayout.visibility = View.GONE
                if(sw1.isChecked)
                    sw1.isChecked = false
            }else{
                leftLinearLayout.visibility = View.VISIBLE
            }
        }

        /*if(!isNotificationServiceEnabled())
            startActivity(Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS))*/
    }

    private fun isNotificationServiceEnabled(): Boolean {
        val pkgName = packageName
        val flat: String = Settings.Secure.getString(
            contentResolver,
            "enabled_notification_listeners"
        )
        if (!TextUtils.isEmpty(flat)) {
            val names = flat.split(":").toTypedArray()
            for (name in names) {
                val cn = ComponentName.unflattenFromString(name)
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.packageName)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}