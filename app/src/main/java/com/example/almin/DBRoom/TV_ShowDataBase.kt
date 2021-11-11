package com.example.almin.DBRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TV_ShowEntity::class],version = 1,exportSchema = false)
abstract class TV_ShowDataBase: RoomDatabase() {
    companion object{
        var instant: TV_ShowDataBase?=null
        fun getInstant(context: Context): TV_ShowDataBase {
            if(instant !=null)
            {
                return instant as TV_ShowDataBase
            }
            instant = Room.databaseBuilder(context, TV_ShowDataBase::class.java,"newname3").run{
                allowMainThreadQueries() }.build()
            return instant as TV_ShowDataBase
        }
    }

    abstract fun TV_ShowDao1():TV_ShowDao;
}