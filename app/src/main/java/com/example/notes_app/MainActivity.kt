package com.example.notes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var edn: EditText
    lateinit var add: Button
    lateinit var rv: RecyclerView
    lateinit var dbh: Dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        add.setOnClickListener{
            if(edn.text.isNotEmpty()){
                var st=dbh.addnote(edn.text.toString())
                setuprvdata()
                Toast.makeText(this,"note saved in row$st",Toast.LENGTH_SHORT).show()
                edn.text.clear()
            }
        }
    }
    fun init(){
        edn=findViewById(R.id.ednote)
        add=findViewById(R.id.add)
        rv=findViewById(R.id.rvm)
        dbh=Dbhelper(this)
        setuprvdata()

    }

    fun setuprvdata() {
        var list=dbh.getall()
        rv.adapter=RVAdapter(list,this)
        rv.layoutManager= LinearLayoutManager(this)
    }


}