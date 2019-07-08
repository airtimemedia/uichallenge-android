package com.signal.uichallenge.mediapicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.signal.uichallenge.R
import com.signal.uichallenge.model.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_media_picker_carousel.view.*
import kotlinx.android.synthetic.main.item_media_picker_header.view.*
import kotlinx.android.synthetic.main.item_media_picker_track.view.*

class MediaPickerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<MediaPickerItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (::inflater.isInitialized.not()) {
            inflater = LayoutInflater.from(parent.context)
        }

        val viewHolder : RecyclerView.ViewHolder = when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = inflater.inflate(R.layout.item_media_picker_header, parent, false)
                HeaderHolder(view)
            }
            VIEW_TYPE_TRACK -> {
                val view = inflater.inflate(R.layout.item_media_picker_track, parent, false)
                TrackHolder(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.item_media_picker_carousel, parent, false)
                CarouselHolder(view)
            }
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderHolder -> {
                val mediaPickerHeader = items[position] as MediaPickerHeader
                holder.itemView.textView.text = mediaPickerHeader.title
            }
            is CarouselHolder -> {
                val mediaPickerCarousel = items[position] as MediaPickerVideoCarousel
                holder.setItems(mediaPickerCarousel.items)
            }
            is TrackHolder -> {
                val mediaPickerTrack = items[position] as MediaPickerTrack
                val track = mediaPickerTrack.track
                holder.itemView.trackImageView.setImageResource(track.imageRes)
                holder.itemView.trackTitleTextView.text = "${track.artist} - ${track.title}"
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]

        return when {
            item.isCarousel() -> VIEW_TYPE_CAROUSEL
            item.isHeader() -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_TRACK
        }
    }

    companion object {
        const val VIEW_TYPE_CAROUSEL = 0
        const val VIEW_TYPE_HEADER = 1
        const val VIEW_TYPE_TRACK = 2
    }

    class HeaderHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
    class TrackHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
    class CarouselHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val adapter = MediaPickerVideoAdapter()

        init {
            containerView.videosRecyclerView.layoutManager =
                LinearLayoutManager(containerView.context, LinearLayoutManager.HORIZONTAL, false)

            containerView.videosRecyclerView.adapter = adapter
        }

        fun setItems(items: List<Video>) {
            adapter.items = items
        }
    }
}