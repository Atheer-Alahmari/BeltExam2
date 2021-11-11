package com.example.almin.View_Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.almin.DBRoom.TV_ShowDataBase
import com.example.almin.DBRoom.TV_ShowEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyViewModel(application: Application): AndroidViewModel(application) {

    private var userInfo: LiveData<List<TV_ShowEntity>>
    private val databaseObject: TV_ShowDataBase


    init {
        databaseObject = TV_ShowDataBase.getInstant(application)
        userInfo = databaseObject.TV_ShowDao1().getAllTV_ShowInfo()   }

    fun getAllTVInfo(): LiveData<List<TV_ShowEntity>> {
        return userInfo
    }

    fun addTV(pk:Int, name: String,languge:String,summery:String ,image:String) {
        CoroutineScope(Dispatchers.IO).launch {
            databaseObject.TV_ShowDao1().insertTV_Show(TV_ShowEntity(0,pk,name,languge,summery, image))
            //userInfo = databaseObject.getAllTV_ShowInfo()
        }
    }
    fun deleteTV(id:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            databaseObject.TV_ShowDao1().deleteTV_Show(TV_ShowEntity(id))
          //  userInfo = databaseObject.getAllTV_ShowInfo()
        }
    }
}