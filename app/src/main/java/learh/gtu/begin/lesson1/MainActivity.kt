package learh.gtu.begin.lesson1

import android.content.res.Resources
import android.hardware.biometrics.BiometricManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "MainActivity"
lateinit var stringsPoem:Array<String>
var activityChangeState:Int = 0

fun writeLog(msg: String)
{
    Log.d(TAG, msg)
    activityChangeState += 1
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = getResources()
        stringsPoem = res.getStringArray(R.array.arrayStringPoem)

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onStart() {
        super.onStart()

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onResume() {
        super.onResume()

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onPause() {
        super.onPause()

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onStop() {
        super.onStop()

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onDestroy() {
        super.onDestroy()

        writeLog(stringsPoem[activityChangeState].toString())
    }

    override fun onRestart() {
        super.onRestart()

        writeLog(stringsPoem[activityChangeState].toString())
    }


}