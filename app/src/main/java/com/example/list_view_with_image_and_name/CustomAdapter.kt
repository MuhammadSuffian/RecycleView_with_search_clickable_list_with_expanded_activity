package com.example.list_view_with_image_and_name
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(private var mlist:List<ItemsViewModel>):
RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var onitemclick:((ItemsViewModel)->Unit)?=null

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.card_item_list,parent,false)
        return  ViewHolder(view)
    }
    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        val ItemsViewModel=mlist[position]
        holder.ImageView.setImageResource(ItemsViewModel.image)
        holder.textView.text= ItemsViewModel.text
        holder.textViewv1.text=ItemsViewModel.subtext
        holder.itemView.setOnClickListener{
            onitemclick?.invoke(ItemsViewModel)
        }
    }


    override fun getItemCount():Int{
        return  mlist.size
    }
    fun filterlistupdate(FilterList: ArrayList<ItemsViewModel>){
        mlist= FilterList
        Log.e("Tag","Filter Fun called")
        this.notifyDataSetChanged()
    }
class ViewHolder (ItemView:View):RecyclerView.ViewHolder(ItemView){
    val ImageView:ImageView=itemView.findViewById(R.id.image_view)
    val textView: TextView=itemView.findViewById(R.id.text_view)
    val textViewv1: TextView=itemView.findViewById(R.id.text_viewv1)
}

}