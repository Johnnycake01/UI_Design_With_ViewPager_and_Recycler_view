package com.example.advanceuidesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * class for recycler view adapter to bind view and
 * display in recycler form
 */
class RecycleAdClass(private var itemList:List<Items>):RecyclerView.Adapter<RecycleAdClass.viewHolderRv>(){
inner class viewHolderRv(itemViews:View):RecyclerView.ViewHolder(itemViews)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderRv {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view,parent,false)
        return viewHolderRv(view)
    }

    override fun onBindViewHolder(holder: viewHolderRv, position: Int) {

       holder.apply {
           itemView.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.recycle_card_circle_constraint).setBackgroundResource(itemList[position].image)
           itemView.findViewById<TextView>(R.id.name).text = itemList[position].names
           itemView.findViewById<TextView>(R.id.date).text = itemList[position].date
           itemView.findViewById<TextView>(R.id.date_left).text = itemList[position].dob_left
           itemView.findViewById<View>(R.id.bar).setBackgroundResource(itemList[position].backColor)
       }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}