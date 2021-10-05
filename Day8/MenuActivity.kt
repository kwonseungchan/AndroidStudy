package com.example.voca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var manageBt: Button
    lateinit var gameBt: Button
    lateinit var quitBt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        manageBt = findViewById(R.id.manageBt)
        gameBt = findViewById(R.id.gameBt)
        quitBt = findViewById(R.id.quitBt)

        /** test ***/
        MainActivity.oriVocaArr.add(Voca("cat","고양이"))
        MainActivity.oriVocaArr.add(Voca("dog","개"))
        MainActivity.oriVocaArr.add(Voca("horse","말"))
        MainActivity.oriVocaArr.add(Voca("octopus","문어"))
        /******/

        manageBt.setOnClickListener(this)

        gameBt.setOnClickListener(this)

        quitBt.setOnClickListener {
            finish()
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.manageBt -> {
                var intent: Intent = Intent(this, com.example.voca.MainActivity::class.java)
                startActivity(intent)
            }

            R.id.gameBt -> {
                var intent: Intent = Intent(this, com.example.voca.GameActivity::class.java)
                startActivity(intent)
            }
        }

    }
}