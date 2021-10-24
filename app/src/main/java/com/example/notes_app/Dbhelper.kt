package com.example.notes_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Dbhelper(cont: Context): SQLiteOpenHelper(cont, "notes",null, 1) {

    private val sqldb:SQLiteDatabase =writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            db.execSQL("create table note(Content text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addnote(n:String): Long {
        val cv= ContentValues()
        cv.put("Content",n)
        var st= sqldb.insert("note",null,cv)
        return st
    }
}