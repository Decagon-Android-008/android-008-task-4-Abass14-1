package com.example.taskfour.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskfour.Model.PendingCelebrants
import com.example.taskfour.R

//RecyclerViewAdapter Class
class RecyclerViewAdapter(val context: Context, val pendingCelebrants: List<PendingCelebrants>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //targeting views in RecyclerView layout and setting them to unique variables
        val pendingCelebText = itemView.findViewById<TextView>(R.id.textViewOne)
        val pendingCelebTextTwo = itemView.findViewById<TextView>(R.id.textViewTwo)
        val pendingCelebTextThree = itemView.findViewById<TextView>(R.id.textViewThree)
        val pendingCelebImage = itemView.findViewById<ImageView>(R.id.pendingCelebImage)
        val viewLine = itemView.findViewById<View>(R.id.viewLine)

        fun bindPendingCelebrant(pendingCelebrants: PendingCelebrants, context: Context){
            //binding targeted views with class pendingCelebrant constructor parameters
            val resourceId = context.resources.getIdentifier(pendingCelebrants.image, "drawable", context.packageName)
            pendingCelebImage.setImageResource(resourceId)
            pendingCelebText.text = pendingCelebrants.textOne
            pendingCelebTextTwo.text = pendingCelebrants.textTwo
            pendingCelebTextThree.text = pendingCelebrants.textThree
            viewLine.setBackgroundResource(pendingCelebrants.viewLine)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //setting the recyclerView layout with the viewHolder class' item View
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_birthdays_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //binding the item Views to the pendingCelebrant's list item positions
        holder.bindPendingCelebrant(pendingCelebrants[position], context)
    }

    override fun getItemCount(): Int {
        return pendingCelebrants.size
    }
}