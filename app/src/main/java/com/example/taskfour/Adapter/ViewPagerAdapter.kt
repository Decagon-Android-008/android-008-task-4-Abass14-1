package com.example.taskfour.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskfour.Model.Celebrant
import com.example.taskfour.R

class ViewPagerAdapter(val context: Context, val celebrant: List<Celebrant>) : RecyclerView.Adapter<ViewPagerAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //targeting views in viewPager layout and setting them to unique variables
        val celebrantText = itemView.findViewById<TextView>(R.id.ivTextTwo)
        val celebrantImage = itemView.findViewById<ImageView>(R.id.ivImage)

        fun bindCelebrant(celebrant: Celebrant, context: Context){
            //binding targeted views with class Celebrant constructor parameters
            val resourceId = context.resources.getIdentifier(celebrant.images, "drawable", context.packageName)
            celebrantImage.setImageResource(resourceId)
            celebrantText.text = celebrant.textOne

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //setting the viewPager layout with the viewHolder class' item View
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //binding the item Views to the Celebrant's list item positions
        holder.bindCelebrant(celebrant[position], context)
    }

    override fun getItemCount(): Int {
        return celebrant.size
    }
}