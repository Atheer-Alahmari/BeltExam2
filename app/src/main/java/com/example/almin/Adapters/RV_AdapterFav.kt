package com.example.almin.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.almin.DBRoom.TV_ShowEntity
import com.example.almin.Fav_Fragment
import com.example.almin.R
import kotlinx.android.synthetic.main.item_row_fav.*
import kotlinx.android.synthetic.main.item_row_fav.view.*

class RV_AdapterFav (val frag1: Fav_Fragment, private var listOfFav: List<TV_ShowEntity> ): RecyclerView.Adapter<RV_AdapterFav.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_fav,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val idn = listOfFav[position].id
        val name = listOfFav[position].name
        val language = listOfFav[position].languge
        val summery = listOfFav[position].summary
        val image = listOfFav[position].image

        holder.itemView.apply {
            text_ViewFav.text = "$name \n $language \n "
if(image!=null) {
    Glide.with(this)
        .load(image)
        .centerCrop()
        .into(image_View)//يعرض الصورة في imageview2 على الشاشة كامله
}
// else{
//    Glide.with(this)
//        .load("https://images.assetsdelivery.com/compings_v2/yehorlisnyi/yehorlisnyi2104/yehorlisnyi210400016.jpg")
//        .centerCrop()
//        .into(image_View)//يعرض الصورة في imageview2 على الشاشة كامله
//}
            text_ViewFav.setOnClickListener {
                Toast.makeText(context, "$summery", Toast.LENGTH_SHORT).show()

            }
            deleteIcon.setOnClickListener {
                frag1.myViewModel.deleteTV(idn)//--------------------------------------------------------------
                Toast.makeText(context, "Delete Success!", Toast.LENGTH_SHORT).show()


            }
        }
    }

    override fun getItemCount() = listOfFav.size

//    fun updateList(fav: List<TV_ShowEntity>) {
//        this.listOfFav = fav
//        notifyDataSetChanged()
//
//    }

}