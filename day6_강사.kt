package com.example.voca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() , View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    var editIdx : Int = -1
    var vocaArr : ArrayList<String> = arrayListOf()
    var engArr : ArrayList<String> = arrayListOf()
    var korArr : ArrayList<String> = arrayListOf()
    lateinit var btn : Button
    lateinit var engEt : EditText
    lateinit var korEt : EditText
    lateinit var listV : ListView
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        engEt = findViewById(R.id.engEt)
        korEt = findViewById(R.id.korEt)
        listV = findViewById(R.id.listV)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, vocaArr)
        listV.adapter = adapter

        btn.setOnClickListener(this)
        listV.onItemClickListener = this
        listV.onItemLongClickListener = this
    }

    fun resetData(){
        vocaArr.clear()
        for (i in 0 until engArr.size step 1){
            var voca :String = engArr.get(i) +"  /  "+korArr.get(i)
            vocaArr.add(voca)
        }
        adapter.notifyDataSetChanged()
    }

    override fun onClick(p0: View?) {
        var eng: String = engEt.text.toString()
        var kor: String = korEt.text.toString()
        engEt.setText("")
        korEt.setText("")
        if(editIdx != -1){
            engArr.set(editIdx,eng)
            korArr.set(editIdx,kor)
            editIdx = -1;
            btn.setText("클릭")
        } else {
            engArr.add(eng)
            korArr.add(kor)
        }

        resetData()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        engEt.setText(engArr.get(p2))
        korEt.setText(korArr.get(p2))
        btn.setText("수정")
        editIdx = p2
    }

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean {

        return true
    }
}