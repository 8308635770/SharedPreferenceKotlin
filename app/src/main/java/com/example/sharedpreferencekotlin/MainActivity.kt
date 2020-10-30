package com.example.sharedpreferencekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var btn_save:Button
    lateinit var btn_apply:Button
    lateinit var switch: Switch

    lateinit var text:String
    var switchState:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textview)
        editText=findViewById(R.id.edittext)
        btn_apply=findViewById(R.id.apply_text_button)
        btn_save=findViewById(R.id.save_button)
        switch=findViewById(R.id.switch1)

        btn_save.setOnClickListener(View.OnClickListener {

             val sharedPreference=getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE)
            val editor=sharedPreference.edit()

            editor.putString(TEXT,editText.text.toString())
            editor.putBoolean(SWITCH,switch.isChecked)
            editor.apply()

        })


        btn_apply.setOnClickListener(View.OnClickListener {
            textView.setText(editText.text.toString())
        })

        loadText()
        updateView()



    }

    fun loadText(){
        val sharedPreference=getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE)

        text= sharedPreference.getString(TEXT,"")!!;
        switchState=sharedPreference.getBoolean(SWITCH,false)

    }

    fun updateView(){
        textView.setText(text)
        switch.isChecked=switchState
    }

    companion object{
        val SHARED_PREFERENCE:String="SHIVAM"
        val TEXT:String="text"
        val SWITCH:String="switch"
    }


}