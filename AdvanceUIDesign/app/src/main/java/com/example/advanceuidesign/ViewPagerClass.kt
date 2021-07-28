package com.example.advanceuidesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * class for recycler view adapter to bind view and
 * display views in pager form
 */
class ViewPagerClass(private var contents:List<Int>, private var names:List<String>):RecyclerView.Adapter<ViewPagerClass.ViewPagerHolder>() {
    inner class ViewPagerHolder(viewItems: View):RecyclerView.ViewHolder(viewItems){
        val imageView = viewItems.findViewById<ConstraintLayout>(R.id.imageView)
        val textContent = viewItems.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_design,parent,false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
    val callContents = contents[position]
        val callNames = names[position]
        
        holder.imageView.setBackgroundResource(callContents)
        holder.textContent.text = callNames
    }

    override fun getItemCount(): Int {
        return contents.size
    }


}