package com.example.almin.DBRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TV_ShowDao {
    //get me all the rows and arrangement by the title ASC
    @Query("SELECT * FROM TVShow ")
    fun getAllTV_ShowInfo(): LiveData<List<TV_ShowEntity>>

    @Insert
    fun insertTV_Show(user: TV_ShowEntity)

    @Delete
    fun deleteTV_Show(user: TV_ShowEntity)


}