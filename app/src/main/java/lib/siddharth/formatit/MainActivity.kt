package lib.siddharth.formatit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import lib.siddharth.formatitlib.FormatIt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtView.setOnClickListener {
            startActivity(Intent(applicationContext, JavaActivity::class.java))
        }

        val changeFormatStr = FormatIt.changeFormat("1999/08/18", "yyyy/MM/dd", "dd-MM-yyyy")
        Log.d("changeFormat", changeFormatStr)

        val changeTimeZone = FormatIt.changeTimeZone("1999-08-18 12:00", "+5:30",
            "yyyy-MM-dd hh:mm", "dd-MM-yyyy hh:mm")
        Log.d("changeTimeZone", changeTimeZone)

        val changeZone = FormatIt.changeTimeZone("1999-08-18 12:00", "+5:30",
            "yyyy-MM-dd hh:mm")
        Log.d("changeZone", changeZone)
    }
}
