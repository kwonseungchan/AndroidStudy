package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var vocaArr : ArrayList<String> = arrayListOf()
    lateinit var btn : Button
    lateinit var tv : TextView
    lateinit var engEt : EditText
    lateinit var korEt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        tv = findViewById(R.id.tv)
        engEt = findViewById(R.id.engEt)
        korEt = findViewById(R.id.korEt)

        btn.setOnClickListener(this)
    }

    fun setVoca(){
        var tempStr : String = ""
        for (i in 0 until vocaArr.size step 1){
            tempStr = tempStr + vocaArr.get(i) + "\n"
        }
        tv.text = tempStr
    }

    override fun onClick(p0: View?) {
        var eng : String = engEt.text.toString()
        var kor : String = korEt.text.toString()
        engEt.setText("")
        korEt.setText("")
        vocaArr.add(eng +"  /  "+ kor)
        setVoca()
    }
}