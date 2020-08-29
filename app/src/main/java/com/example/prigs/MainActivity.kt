package com.example.prigs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.PersistableBundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainactivityViewModelView: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log_in.setOnClickListener {
            startActivity(Intent(this,loginActivity::class.java))
            finish()
        }

        mainactivityViewModelView= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainactivityViewModelView.numOfOnlineHealersLiveData.observe(this, Observer{
            screen_we.text=it.value
        })
       mainactivityViewModelView.numOfOfflineHealersLiveData.observe(this, Observer {
          screen_us.text=it.value
       })

      mainactivityViewModelView.numOfOnlineUsersLiveData.observe(this, Observer {
          screen_pre.text=it.value
      })
       mainactivityViewModelView.numOfOfflineUsersLiveData.observe(this, Observer {
           screen_post.text=it.value
       })
       on_click.setOnClickListener{
           mainactivityViewModelView.pushToDatabase()
       }
    }


}








