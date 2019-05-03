package com.example.baitaptuan5

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item_film.view.*

class FilmAdapter(var  items: ArrayList<film.Results>, val context: Context) : RecyclerView.Adapter<FilmViewHolder>(){
    lateinit var mListener: FilmItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_item_film, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(filmViewHolder: FilmViewHolder, position: Int) {
        filmViewHolder.tvTitle.text = "#$position ${items[position].title}"
        filmViewHolder.tvdescription.text = items[position].overview
        Glide.with(context)
            .load( "https://image.tmdb.org/t/p/w500/"+ items[position].poster_path)
            .centerCrop()
            .into(filmViewHolder.ivAvatar)


        filmViewHolder.itemView.setOnClickListener {
            mListener.onItemCLicked(position)
        }

    }

    fun setListener(listener: FilmItemClickListener) {
        this.mListener = listener
   }

}


class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvTitle = view.tvTitle
    var tvdescription = view.tvDes
    var ivAvatar = view.ivAvatar
}
