package com.example.skillbox_hw_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.skillbox_hw_quiz.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        supportFragmentManager.commit {
//            replace<StartFragment>(R.id.nav_host)
//            addToBackStack(StartFragment::class.java.simpleName)
//
//        }

    }
}