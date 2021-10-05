package com.example.voca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity(), View.OnClickListener {
    var idx: Int = 0
    lateinit var queTv: TextView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        queTv = findViewById(R.id.queTv);
        btn = findViewById(R.id.btn)

        setQuestion()

        btn.setOnClickListener(this)
    }

    fun setQuestion() {
        if (MainActivity.oriVocaArr.size == 0) {
            queTv.text = "단어 없다"
        } else if (MainActivity.oriVocaArr.size <= idx) {
            queTv.text = "다 풀었다"
        } else if (MainActivity.oriVocaArr.size > 0) {
            queTv.text = MainActivity.oriVocaArr.get(idx).eng
        }
    }

    override fun onClick(p0: View?) {
        idx++
        setQuestion()
    }
}
