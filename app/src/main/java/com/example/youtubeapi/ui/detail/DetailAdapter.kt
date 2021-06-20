package com.example.youtubeapi.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.SecondPlaylistItemBinding
import com.example.youtubeapi.extension.loadImage
import com.example.youtubeapi.model.playlistItem.Items

class DetailAdapter(private val listener: OnClickListener): RecyclerView.Adapter<DetailAdapter.ViewHolder>()  {

    var itemsThird: List<Items> = ArrayList()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            SecondPlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            context as Context
        )
    }

    override fun getItemCount(): Int {
        return itemsThird.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemsThird[position])
    }

    inner class ViewHolder(
        private val view: SecondPlaylistItemBinding,
        private val context: Context) : RecyclerView.ViewHolder(view.root), View.OnClickListener {

        fun bind(items: Items) {
            view.textTitleSecond.text = items.snippet.title
            view.imageViewSecond.loadImage(context, items.snippet.thumbnails.default.url)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickThird(itemsThird[position] )
            }
        }
    }

}

interface OnClickListener {
    fun onClickThird(items: Items)
}