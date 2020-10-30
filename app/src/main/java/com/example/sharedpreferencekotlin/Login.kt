package com.example.sharedpreferencekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    lateinit var edit_username:EditText
    lateinit var edit_password:EditText
    lateinit var btn_login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edit_username=findViewById(R.id.ed_username)
        edit_password=findViewById(R.id.ed_password)
        btn_login=findViewById(R.id.btn_login)

        val sharedPre =getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE)

        if(sharedPre.contains(USERNAME) && sharedPre.contains(PASSWORD)){
            startActivity(Intent(this@Login,DashboardActivity::class.java))
        }

        btn_login.setOnClickListener(View.OnClickListener {

            if(!edit_password.text.toString().isEmpty() && !edit_username.text.toString().isEmpty()){
                val sharedPref=getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE)
                val editor=sharedPref.edit()

                editor.putString(USERNAME,edit_username.text.toString())
                editor.putString(PASSWORD,edit_password.text.toString())
                editor.apply()

                edit_username.setText("")
                edit_password.setText("")

                startActivity(Intent(this@Login,DashboardActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"Username And password fields are empty",Toast.LENGTH_SHORT).show()
            }



        })

    }

    companion object{
        val SHARED_PREFERENCE:String="Shivam"
        val USERNAME:String="username"
        val PASSWORD:String="password"
    }
}