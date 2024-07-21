package com.example.kukufmassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kukufmassignment.R
import com.example.kukufmassignment.model.SpaceXItem
import javax.inject.Inject

class SpaceXAdapter @Inject constructor() : RecyclerView.Adapter<SpaceXAdapter.SpaceXViewHolder>() {

    var spaceXList = listOf<SpaceXItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var showFavouriteIcon = true

    var onItemClick: ((SpaceXItem) -> Unit)? = null
    var onFavouriteClick: ((SpaceXItem) -> Unit)? = null


    fun setOnItemClickListener(onItemClick: (SpaceXItem) -> Unit){
        this.onItemClick = onItemClick
    }

    fun setOnFavouriteClickListener(onFavouriteClick: (SpaceXItem) -> Unit){
        this.onFavouriteClick = onFavouriteClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        return SpaceXViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spacex,parent,false))
    }

    override fun getItemCount(): Int {
        return spaceXList.size
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        val spaceXItem = spaceXList[position]
        holder.bind(spaceXItem, position)
    }

    inner class SpaceXViewHolder(private val spacexView: View): RecyclerView.ViewHolder(spacexView){

       fun bind(spaceXItem: SpaceXItem, position: Int){
           spacexView.apply {
               findViewById<TextView>(R.id.tv_mission_value).text = spaceXItem.mission_name
               findViewById<TextView>(R.id.tv_rocket_value).text = spaceXItem.rocket?.rocket_name
               findViewById<TextView>(R.id.tv_launch_year_value).text = spaceXItem.launch_year

               setOnClickListener {
                   onItemClick?.invoke(spaceXItem)
               }

               if(showFavouriteIcon){
                   spacexView.findViewById<ImageView>(R.id.iv_fav).visibility = View.VISIBLE
                   updateFavIcon(spaceXItem.isFavorite)
                   findViewById<ImageView>(R.id.iv_fav).setOnClickListener {
                       spaceXItem.isFavorite = !spaceXItem.isFavorite
                       updateFavIcon(spaceXItem.isFavorite)
                       onFavouriteClick?.invoke(spaceXItem)
                       notifyItemChanged(position)
                   }
               }else{
                   spacexView.findViewById<ImageView>(R.id.iv_fav).visibility = View.GONE
               }
           }
       }

        private fun updateFavIcon(favourite: Boolean) {
            spacexView.findViewById<ImageView>(R.id.iv_fav).setImageResource(
                if(favourite) R.drawable.ic_favourite else R.drawable.ic_un_favourite
            )
        }
    }
}