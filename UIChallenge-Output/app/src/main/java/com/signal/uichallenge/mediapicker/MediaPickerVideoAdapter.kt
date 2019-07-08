package com.signal.uichallenge.mediapicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.signal.uichallenge.R
import com.signal.uichallenge.model.Video
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_media_picker_video.view.*

class MediaPickerVideoAdapter : RecyclerView.Adapter<MediaPickerVideoAdapter.VideoHolder>() {

    var items : List<Video> = mutableListOf()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        if (::inflater.isInitialized.not()) {
            inflater = LayoutInflater.from(parent.context)
        }

        val view = inflater.inflate(R.layout.item_media_picker_video, parent, false)

        return VideoHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        val video = items[position]

        holder.itemView.trackImageView.setImageResource(video.imageRes)
        holder.itemView.trackTitleTextView.text = video.title
    }

    class VideoHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
}
