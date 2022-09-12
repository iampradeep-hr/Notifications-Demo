package com.pradeep.notificationsdemo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pradeep.notificationsdemo.databinding.ActivityMainBinding
import com.pradeep.notificationsdemo.demo.DemoNotifications

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
        binding.buttonDemoNotification.setOnClickListener{
            val obj=DemoNotifications(applicationContext)
//            obj.showNotification("Hello there","You can set your username for all repositories at a given site by putting something like the following in your Git configuration file. You'll want to change \"https://example.com\" and \"me\" to the actual URL and your actual username.")
            obj.showImageNotification("title","body")
        }
    }
}