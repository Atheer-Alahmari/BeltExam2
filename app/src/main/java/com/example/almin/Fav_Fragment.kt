package com.example.almin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.almin.Adapters.RV_Adapter
import com.example.almin.Adapters.RV_AdapterFav
import com.example.almin.DBRoom.TV_ShowEntity
import com.example.almin.View_Model.MyViewModel


class Fav_Fragment : Fragment() {
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}//--------------------------------
    private lateinit var rvAdapter: RV_AdapterFav
    lateinit var rec_view: RecyclerView

    lateinit var favList:List<TV_ShowEntity>
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var view= inflater.inflate(R.layout.fragment_fav_, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("", Context.MODE_PRIVATE)
        favList= listOf()
        rec_view=view.findViewById(R.id.recycler_ViewFav)
//
//        val idn = sharedPreferences.getInt("TV_Id", 0)
//        val name = sharedPreferences.getString("TV_name", "")
//        val languge = sharedPreferences.getString("TV_lang", "")
//        val sum = sharedPreferences.getString("TV_Summ", "")
//        val image = sharedPreferences.getString("TV_image", "")

       // myViewModel.addTV(idn, name.toString(),languge.toString(),sum.toString(),image.toString())



        myViewModel.getAllTVInfo().observe(viewLifecycleOwner, { x ->
            rvAdapter=RV_AdapterFav(this, x)
            rec_view.adapter = rvAdapter
            rec_view.layoutManager = LinearLayoutManager(requireContext())

            rec_view.scrollToPosition(x.size - 1)


        })
        return view
    }

}