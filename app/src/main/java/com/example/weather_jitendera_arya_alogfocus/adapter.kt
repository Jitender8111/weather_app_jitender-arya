package com.example.weather_jitendera_arya_alogfocus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class adapter(val text1:List<String>,val text2:List<String>,val text3:List<String>):RecyclerView.Adapter<adapter.MyViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
          val inflater = LayoutInflater.from(parent.context);
          val view = inflater.inflate(R.layout.example_item,parent,false);
          return MyViewHolder(view);
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.text1.text=text1[position]
          holder.text2.text=text2[position]
          holder.text3.text=text3[position]
          //holder.text1.text=text1[position]
     }

     override fun getItemCount(): Int {
          //return image.size;
          return text1.size;
          return text2.size;
          return text3.size;
     }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

          var text1=itemView.findViewById<TextView>(R.id.txt_one);
          var text2=itemView.findViewById<TextView>(R.id.txt_two);
          var text3=itemView.findViewById<TextView>(R.id.txt_three);
     }

}
