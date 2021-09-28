package com.example.click

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btnP: Button
    lateinit var btnMinus: Button
    lateinit var btnD: Button
    lateinit var btnM: Button
    lateinit var btnC: Button
    lateinit var btnE: Button
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
        btn0 = findViewById(R.id.tv0)
        btn1 = findViewById(R.id.tv1)
        btn2 = findViewById(R.id.tv2)
        btn3 = findViewById(R.id.tv3)
        btn4 = findViewById(R.id.tv4)
        btn5 = findViewById(R.id.tv5)
        btn6 = findViewById(R.id.tv6)
        btn7 = findViewById(R.id.tv7)
        btn8 = findViewById(R.id.tv8)
        btn9 = findViewById(R.id.tv9)
        btnP = findViewById(R.id.tv_plus)
        btnC = findViewById(R.id.tv_clear)
        btnE = findViewById(R.id.tv_equ)
        tv = findViewById(R.id.tv)

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnP.setOnClickListener(this)
        btnE.setOnClickListener(this)
        btnC.setOnClickListener(this)
    }

    var num1: Int = 0
    var op: Int = -1  //0 더하기  1 빼기  2 곱하기 3 나누기
    override fun onClick(v: View?) {
        if (v!!.id == R.id.tv_equ) {

            var curValue: String = tv.text.toString()
            var num2 = curValue.toInt()

            if (op == 0) {
                var num3: Int = num1 + num2
                tv.text = num3.toString()
                num1 = -1
            } else if (op == 1) {

            } else if (op == 2) {

            } else if (op == 3) {

            }

        } else if (v!!.id == R.id.tv_clear) {
            tv.text = "0"
        } else if (v!!.id == R.id.tv_plus) {
            var curValue: String = tv.text.toString()
            num1 = curValue.toInt()
            tv.text = "0"
            op = 0
        } else {
            var curValue: String = tv.text.toString()
            var newValue: String = (v as Button).text.toString()
            if (curValue == "0") {
                tv.text = newValue
            } else {
                tv.text = curValue + newValue
            }
        }
    }


}