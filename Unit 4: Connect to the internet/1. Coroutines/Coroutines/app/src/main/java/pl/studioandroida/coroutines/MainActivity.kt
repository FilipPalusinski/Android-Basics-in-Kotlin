package pl.studioandroida.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        repeat(3) {
            GlobalScope.launch {
                Log.d("debugg","Hi from ${Thread.currentThread()}")
            }
        }

        runBlocking {
            val num1 = async { getValue() }
            val num2 = async { getValue() }
            println("result of num1 + num2 is ${num1.await() + num2.await()}")
        }


    }

    val formatter = DateTimeFormatter.ISO_LOCAL_TIME
    val time = { formatter.format(LocalDateTime.now()) }

    suspend fun getValue(): Double {
        Log.d("debugg2","entering getValue() at ${time()}")
        delay(3000)
        Log.d("debugg2","leaving getValue() at ${time()}")
        return Math.random()
    }


}

