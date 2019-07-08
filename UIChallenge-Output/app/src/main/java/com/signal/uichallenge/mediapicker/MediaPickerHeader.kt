package com.signal.uichallenge.mediapicker

class MediaPickerHeader(val title: String) : MediaPickerItem {
    override fun isHeader(): Boolean {
        return true
    }

    override fun isCarousel(): Boolean {
        return false
    }

    override fun isTrack(): Boolean {
        return false
    }

}
