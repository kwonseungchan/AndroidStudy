package com.example.voca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() , View.OnClickListener, AdapterView.OnItemClickListener {
    var vocaArr : ArrayList<String> = arrayListOf()
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
    }

    override fun onClick(p0: View?) {
        var eng : String = engEt.text.toString()
        var kor : String = korEt.text.toString()
        engEt.setText("")
        korEt.setText("")
        vocaArr.add(eng +"  /  "+ kor)
        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        Log.d("aabb","position: "+p2)
    }
}