package com.example.almin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.almin.Adapters.RV_Adapter
import com.example.almin.View_Model.MyViewModel
import com.example.almin.retrofit.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TV_ShowFragment : Fragment() {
//Declare
    lateinit var rec_view:RecyclerView
    lateinit var searchBtn:Button
    lateinit var searchED:EditText

    var tvList= ArrayList<ShowItem>()
    lateinit var rvAdapter: RV_Adapter
    lateinit var sharedPreferences: SharedPreferences
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}//--------------------------------

    private val apiInterface by lazy { APIClient().getClient()?.create(APIInterface::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=  inflater.inflate(R.layout.fragment_t_v__show, container, false)

        //initialization
rec_view=view.findViewById(R.id.recycler_view)
        searchBtn=view.findViewById(R.id.search_btn)
        searchED=view.findViewById(R.id.showName_ED)

        //To access MainActivity here
        sharedPreferences = requireActivity().getSharedPreferences(
            "", Context.MODE_PRIVATE
        )



        searchBtn.setOnClickListener {
            var userInput = searchED.text.toString()
            if (userInput.isNotEmpty()) {
                GlobalScope.launch {
                    requestAPI(userInput)

                }
                //RecyclerView adapter section
                rvAdapter = RV_Adapter(this,tvList)
                rec_view.adapter = rvAdapter
                rec_view.layoutManager = LinearLayoutManager(requireContext())

            }else{
                Toast.makeText(activity, "Please Enter Show Name  ", Toast.LENGTH_SHORT).show()

            }

            searchED.text.clear()
        }
        return view
    }

    private fun requestAPI(userInput: String) {
   apiInterface!!.getAllTVs(userInput)?.enqueue(object : Callback<ArrayList<ShowItem>?> {
            //@SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ArrayList<ShowItem>?>, response: Response<ArrayList<ShowItem>?>) {
                val resource: ArrayList<ShowItem>? = response.body()
                for(i in resource!!) {
                    //add to RV
                        if(i.show.name.isNotEmpty()&&i.show.language.isNotEmpty()&&i.show.summary.isNotEmpty()&&i.show.image.medium.isNotEmpty())
                    tvList.add(i)
                    Log.d("photo",tvList.toString())
                }
                rec_view.adapter?.notifyDataSetChanged()            }

            override fun onFailure(call: Call<ArrayList<ShowItem>?>, t: Throwable) {
                Toast.makeText(activity, "Unable to get Info", Toast.LENGTH_LONG).show()

                call.cancel()
            }
        })

    }


}