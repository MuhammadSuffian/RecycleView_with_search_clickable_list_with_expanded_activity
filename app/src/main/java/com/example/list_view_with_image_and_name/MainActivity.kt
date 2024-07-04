package com.example.list_view_with_image_and_name

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity :AppCompatActivity(){
    lateinit var adapter: CustomAdapter
    lateinit var searchView:SearchView
    lateinit var data: ArrayList<ItemsViewModel>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data =ArrayList<ItemsViewModel>()
        searchView= findViewById<SearchView>(R.id.searchview)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this)
       // val showButton=findViewById<Button>(R.id.showInput)


        var text:String;
         adapter=CustomAdapter(data)
        recyclerView.adapter=adapter
        adapter.onitemclick={
            val intent= Intent(this,detailedActivity::class.java)
            intent.putExtra("ItemsViewModel",it)
            startActivity(intent)
        }
        data.add(ItemsViewModel(R.drawable.images, "Cheese Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images2, "Tikka Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images3, "Crown crust Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images, "Cheese Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images2, "Tikka Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images3, "Crown crust Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images, "Cheese Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images2, "Tikka Pizza","Cheese,Chicken,Olives"))
        data.add(ItemsViewModel(R.drawable.images3, "Crown crust Pizza","Cheese,Chicken,Olives"))

       /* showButton.setOnClickListener {
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Helo World"))
            Toast.makeText(this,"Helo World",Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
        }*/

        /*    for(i in 1..5){
      if(i%2==0){
          data.add(ItemsViewModel(R.drawable.baseline_folder,"Item $text"))
      }
      else{
          data.add(ItemsViewModel(R.drawable.laptop,"Item $i"))
      }
  }*/
        searchView.setOnQueryTextListener( object :  SearchView.OnQueryTextListener  {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterlist(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterlist(newText)
                return true
            }
        }
        )


    }

    private fun filterlist(newText: String?) {
        val filterlist =ArrayList<ItemsViewModel>()
        for(i in data){

            if(i.text.lowercase().trim().contains(newText.toString().lowercase().trim())){
                Log.e("tag","Comparing "+i.text.lowercase().trim()+" With "+ newText.toString().lowercase().trim())
                filterlist.add(i)
            }
        }
        if(filterlist.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show()
            adapter.filterlistupdate(filterlist)
        }
        else{
            adapter.filterlistupdate(filterlist)

        }
    }

}