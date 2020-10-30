package com.example.sharedpreferencekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    lateinit var btn_logout:Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_logout=findViewById(R.id.button_logout)
        textView=findViewById(R.id.tv_username)

        val sharedPreference=getSharedPreferences(Login.SHARED_PREFERENCE, MODE_PRIVATE)
        val editor=sharedPreference.edit()

        val username=sharedPreference.getString(Login.USERNAME,"")
        textView.setText(username)

        btn_logout.setOnClickListener(View.OnClickListener {
            editor.clear()
            editor.apply()
            startActivity(Intent(this,Login::class.java))
            finish()
        })
    }
}