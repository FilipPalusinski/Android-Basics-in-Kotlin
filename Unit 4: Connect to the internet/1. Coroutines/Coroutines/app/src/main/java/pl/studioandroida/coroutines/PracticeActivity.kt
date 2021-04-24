package pl.studioandroida.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)


            val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
            repeat(3) {
                GlobalScope.launch {
                    Log.d("debugg3","${Thread.currentThread()} has started")
                    for (i in states) {
                        Log.d("debugg3","${Thread.currentThread()} - $i")
                        delay(5000)
                    }
                }
            }




    }
}