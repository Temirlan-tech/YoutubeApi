package com.example.youtubeapi.ui.playlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import com.example.youtubeapi.extension.loadImage
import com.example.youtubeapi.model.playlist.Items

class PlaylistsAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {

    var items: List<Items> = ArrayList()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            context as Context
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }

    inner class ViewHolder(
        private val view: ItemPlaylistBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(view.root), View.OnClickListener {
        @SuppressLint("SetTextI18n")
        fun bind(items: Items) {
            view.textTitle.text = items.snippet.title
            view.imageView.loadImage(context, items.snippet.thumbnails.default.url)
            view.textSubtitle.text = "${items.contentDetails.itemCount} video series"
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClick(items[position])
            }
        }

    }
}

interface OnItemClickListener {
    fun onClick(items: Items)
}
