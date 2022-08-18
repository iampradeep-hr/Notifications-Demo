package com.pradeep.notificationsdemo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pradeep.notificationsdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service=CounterNotificationService(applicationContext)

        binding.button.setOnClickListener {
            service.showNotification(Counter.value)
        }
    }
}