package com.example.afconquiz.database

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.afconquiz.model.FlagsModel

class FlagsDao {
    fun getTenRandomQuestion(helper: DatabaseCopyHelper) : Array<FlagsModel>{
        val recordList : ArrayList<FlagsModel>
        val database : SQLiteDatabase = helper.writableDatabase
        val cursor : Cursor = database.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 10", null)

        val idIndex = cursor.getColumnIndex("flag_id")
        val countryNameIndex = cursor.getColumnIndex("country_name")
        val flagNameIndex = cursor.getColumnIndex("flag_name")


    }
}