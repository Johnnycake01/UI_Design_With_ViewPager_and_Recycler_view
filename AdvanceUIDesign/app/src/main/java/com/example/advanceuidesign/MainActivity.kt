package com.example.advanceuidesign


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *setting the view pager view to display the content of the list
         * this is achieved by calling the adapter class of the viewHolder and
         * passing in the list as parameter for the adapter class
         * */
        //lists of contents to populate
        val content = listOf(R.drawable.pexels1,R.drawable.pexels2,R.drawable.pexels3,R.drawable.pexels4)
        val names = listOf("It's Katherina's birthday","It's Naomi's birthday","It's Chinedu's birthday","It's Sarah's birthday")

        //call the adapter class and pass in the two list and asign value to list
        val adapter = ViewPagerClass(content,names)
        val view = findViewById<ViewPager2>(R.id.view_pager_layout)//get view layout or container through its id
        view.adapter = adapter

        //<view pager anime effect>

        /**
         * set animation for view pager  image slide
         * */
        view.clipToPadding = false
        view.clipChildren = false
        view.offscreenPageLimit = 1

        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)       //visible section of next item in viewpager2
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)            //margin between item and next item
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx

        view.setPageTransformer{ page: View, position:Float ->
            page.translationX = -pageTranslationX * position
            // this line scales the item's height
            page.scaleY = 1-(0.25f * abs(position))

            //fading effect
             page.alpha = 0.25f + (1 - abs(position))
        }

        val itemDecoration = HorizontalMaginDecorationForViewPager(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        view.addItemDecoration(itemDecoration)




        /**
         *setting the Recycler view view to display the content of the list of type data class of item
         * this is achieved by calling the adapter class of the Recyler view and
         * passing in the list as parameter for the adapter class
         * */
        //list of items(data class holding items)
        val listToDisplay = mutableListOf(
            Items(R.drawable.pexels_ali_madad_28,"Ali Madad","28/08/20","30 days left",R.color.custom_red),
            Items(R.drawable.pexels_bess_hamiti_29,"Blessing & Hamitti","29/08/20","31 days left",R.color.custom_black),
            Items(R.drawable.pexels_carmen_attal_30,"Camel Smith","30/08/20","32 days left",R.color.custom_pink),
            Items(R.drawable.pexels_gaspar_zaldo_31,"Zaldo Gasper","31/08/20","33 days left",R.color.custom_purple),
            Items(R.drawable.pexels_joshua_mcknight_32,"Joshua Angel","1/09/20","34 days left",R.color.custom_black),
            Items(R.drawable.pexels_laura_james_28,"Laura James","2/09/20","35 days left",R.color.custom_pink),
            Items(R.drawable.pexels_lina_lisitsyna_32,"Lina Lisitsyna","3/09/20","36 days left",R.color.custom_red),
            Items(R.drawable.pexels_raydar,"Catherina Raydar","4/09/20","37 days left",R.color.custom_purple),
            Items(R.drawable.pexels_rfstudio,"Custard Princess","5/09/20","38 days left",R.color.custom_pink),
            Items(R.drawable.pexels_sharefaith,"James Bond","6/09/20","39 days left",R.color.custom_black),
            Items(R.drawable.pexels_slaytina_35,"Gun Jun Pyo","7/09/20","40 days left",R.color.custom_pink),
            Items(R.drawable.pexels_tuan_kiet_jr,"Chun chin chi","8/09/20","41 days left",R.color.custom_red),
        )

        //call the adapter class for recycler view and pass the list to display
        val adapterRv = RecycleAdClass(listToDisplay)
        val recycleViewLayout = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recycleViewLayout)
        recycleViewLayout.adapter = adapterRv
        recycleViewLayout.layoutManager = LinearLayoutManager(this)
    }

}