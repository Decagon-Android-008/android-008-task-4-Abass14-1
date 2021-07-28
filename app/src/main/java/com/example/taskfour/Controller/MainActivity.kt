package com.example.taskfour.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.taskfour.Adapter.RecyclerViewAdapter
import com.example.taskfour.Adapter.ViewPagerAdapter
import com.example.taskfour.Model.Celebrant
import com.example.taskfour.Model.HorizontalMarginItemDecoration
import com.example.taskfour.Model.PendingCelebrants
import com.example.taskfour.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        List for ViewPager Celebrants
        val celebrant = listOf(
            Celebrant("It's Victor's Birthday", "vectorpictureone"),
            Celebrant("It's Ben' Birthday", "benden"),
            Celebrant("It's Charlie's Birthday", "charliegreen"),
            Celebrant("It's Roger's Birthday", "rogermartinpng"),
            Celebrant("It's Nana's Birthday", "syahrulalamsyah"),
            Celebrant("It's Lee's Birthday", "first7")
        )
//        List for RecyclerView Celebrants
        val pendingCelebrants = listOf(
            PendingCelebrants("Aisha Ibrahim", "21.11.2021", "75 days left", "aisha", R.color.black),
            PendingCelebrants("Zully Hadid", "30.12.2021", "85 days left", "syahrulalamsyahtwopng", R.color.teal_200),
            PendingCelebrants("Victor Bamikole", "15.06.2021", "15 days left", "first1", R.color.red),
            PendingCelebrants("Peter Akam", "17.07.2021", "25 days left", "first4", R.color.black),
            PendingCelebrants("Bruce Mark", "22.08.2021", "45 days left", "first3", R.color.teal_200),
            PendingCelebrants("Andre Johnson", "24.06.2021", "20 days left", "first5", R.color.red),
            PendingCelebrants("Olukayode Chima", "22.12.2021", "80 days left", "first6", R.color.black)
        )
//        Connecting the celebrant list data to viewpager UI
        val adapter = ViewPagerAdapter(this, celebrant)
        viewPager2.adapter = adapter

//        Viewpager animation
        viewPager2.offscreenPageLimit = 1
        // Adding a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Scaling the item's height.
            page.scaleY = 1 - (0.25f * abs(position))
        }
        viewPager2.setPageTransformer(pageTransformer)

        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager2.addItemDecoration(itemDecoration)

        //Connecting the celebrant list data to recyclerView UI
        val recAdapter = RecyclerViewAdapter(this, pendingCelebrants)
        recView.adapter = recAdapter
        val layoutManager = LinearLayoutManager(this)
        recView.layoutManager = layoutManager


    }
}