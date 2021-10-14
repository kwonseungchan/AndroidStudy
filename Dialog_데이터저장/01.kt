package com.mp.dialog

import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ShareActionProvider
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var eng = arrayListOf<String>("cat", "puppy", "dog")
        var kor = arrayListOf<String>("고양이", "강아지", "개")
        var index_1 : Int = 0
        var index_2 : Int = 0
        var et : EditText = findViewById(R.id.edt)
        var saveBt  : Button = findViewById(R.id.saveButton)
        var tv : TextView = findViewById(R.id.tv)
        var btn : Button = findViewById(R.id.btn)

        var get : SharedPreferences = getSharedPreferences("tags", MODE_PRIVATE)
        var tag : Int = 0

        tag = get.getInt("tag", 0)
        if(tag == 1){
            tv.setText(eng[0])
        }
        else if(tag == -1){
            tv.setText(kor[0])
        }
        else {
            tv.setText("못가져왔습니다!!")
        }

        saveBt.setOnClickListener{
            var str = et.text.toString()
            var pref : SharedPreferences = getSharedPreferences("wordPref", MODE_PRIVATE)
            var edit : SharedPreferences.Editor = pref.edit()


            edit.putString("content", str)
            edit.putInt("age", 1000)
            edit.commit()
        }

        btn.setOnClickListener{

            var str = ""
            var pref : SharedPreferences = getSharedPreferences("wordPref", MODE_PRIVATE)
            var tag_btn : SharedPreferences = getSharedPreferences("tags", MODE_PRIVATE)
            var tag_edit : SharedPreferences.Editor = tag_btn.edit()

            str = pref.getString("content", "nothing")!!

            var ab : AlertDialog.Builder = AlertDialog.Builder(this)

            ab.setTitle("제목이 들어갑니다!!" )
            ab.setMessage("내용이 들어갑니다!!")
            ab.setNegativeButton("영어", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int){
                    tag_edit.putInt("tag", 1)
                    tag_edit.commit()
                    index_2 = 0
                    if(index_1 == eng.size){
                        tv.setText("문제를 다 푸셨습니다!!")
                        index_1 = 0
                    }
                    else {
                        tv.setText(eng[index_1])
                        Log.d("aabb", index_1.toString() + " " + eng.size.toString())
                        if (index_1 <= eng.size) index_1++
                    }
                }
            })
            ab.setPositiveButton("한글", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int){
                    tag_edit.putInt("tag", -1)
                    tag_edit.commit()

                    index_1 = 0
                    if(index_2 == kor.size){
                        tv.setText("문제를 다 푸셨습니다!!")
                        index_2 = 0
                    }
                    else {
                        tv.setText(kor[index_2])
                        Log.d("aabb", index_2.toString() + " " + kor.size.toString())
                        if (index_2 <= kor.size) index_2++
                    }
                }
            })
        ab.setCancelable(false) //무조건 버튼을 눌러야 꺼짐(back 삭제키 안먹음
        ab.show()
        //ab.dismiss(는 show의 반대 꺼진다)
        }
    }
}
