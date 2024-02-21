package com.example.afconquiz.database

import android.database.sqlite.SQLiteDatabase
import com.example.afconquiz.model.FlagsModel

class FlagsDao {
    fun getTenRandomQuestion(helper: DatabaseCopyHelper) : Array<FlagsModel>{
        val recordList : ArrayList<FlagsModel>
        val database : SQLiteDatabase = helper.writableDatabase
    }
}