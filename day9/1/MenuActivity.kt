package com.example.voca

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var manageBt: Button
    lateinit var gameBt: Button
    lateinit var quitBt: Button
    lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        manageBt = findViewById(R.id.manageBt)
        gameBt = findViewById(R.id.gameBt)
        quitBt = findViewById(R.id.quitBt)

        /** test ***/
        MainActivity.oriVocaArr.add(Voca("cat", "고양이"))
        MainActivity.oriVocaArr.add(Voca("dog", "개"))
        MainActivity.oriVocaArr.add(Voca("horse", "말"))
        MainActivity.oriVocaArr.add(Voca("octopus", "문어"))
        /******/

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    result: ActivityResult ->
                    if(result.resultCode == 1000){
                     var intent : Intent = result.data!!
                     Log.d("aabb", intent.getStringExtra("name")!!)
                    }
            }

        manageBt.setOnClickListener {
            var intent: Intent = Intent(this, com.example.voca.MainActivity::class.java)
            intent.putExtra("name","Jane")
            intent.putExtra("age",8000)

            startForResult.launch(intent)
        }

        gameBt.setOnClickListener(this)

        quitBt.setOnClickListener {
            finish()
        }


    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.manageBt -> {
                var intent: Intent = Intent(this, com.example.voca.MainActivity::class.java)
                intent.putExtra("name","Jane")
                intent.putExtra("age",8000)


//                startActivity(intent)
            }

            R.id.gameBt -> {
                var intent = Intent(this, com.example.voca.GameActivity::class.java)
                startActivity(intent)
            }
        }


    }
}