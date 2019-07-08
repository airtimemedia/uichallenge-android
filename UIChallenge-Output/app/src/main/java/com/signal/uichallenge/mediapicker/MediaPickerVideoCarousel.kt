package com.signal.uichallenge.mediapicker

import com.signal.uichallenge.model.Video

class MediaPickerVideoCarousel(val items: List<Video>) : MediaPickerItem {
    override fun isHeader(): Boolean {
        return false
    }

    override fun isCarousel(): Boolean {
        return true
    }

    override fun isTrack(): Boolean {
        return false
    }

}