package com.example.almin.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.almin.DBRoom.SaveData
import com.example.almin.R
import com.example.almin.TV_ShowFragment
import com.example.almin.View_Model.MyViewModel
import com.example.almin.retrofit.ShowItem
import kotlinx.android.synthetic.main.item_row_tv.view.*
class RV_Adapter (private var frag1: TV_ShowFragment, private var tvList: ArrayList<ShowItem>): RecyclerView.Adapter<RV_Adapter.ItemViewHolder>() {
    val myViewModel by lazy { ViewModelProvider(frag1).get(MyViewModel::class.java)}//--------------------------------

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_tv, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val idTv = tvList[position].show.pk
        val nameTv = tvList[position].show.name
        val langugeTv = tvList[position].show.language
        val summaryTv = tvList[position].show.summary
        val imegeTv = tvList[position].show.image.medium

        holder.itemView.apply {
            text_ViewTV.text = nameTv
            println(nameTv)
            text_ViewTV.setOnClickListener {
//                with(frag1.sharedPreferences.edit()) {
//                    putInt("TV_Id", idTv)
//                    putString("TV_name", nameTv)
//                    putString("TV_lang", langugeTv)
//                    putString("TV_Summ", summaryTv)
//                    putString("TV_image", imegeTv)
//
//                    apply()
//                }


//SaveData.pk=idTv
//SaveData.name=nameTv
//SaveData.languge=langugeTv
//SaveData.summery=summaryTv
//SaveData.image=imegeTv

                   frag1.myViewModel.addTV(idTv,nameTv,langugeTv,summaryTv,imegeTv)

            }



        }
    }

    override fun getItemCount() = tvList.size

}