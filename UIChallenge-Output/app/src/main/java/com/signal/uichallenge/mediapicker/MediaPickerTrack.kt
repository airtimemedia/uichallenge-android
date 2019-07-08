package com.signal.uichallenge.mediapicker

import com.signal.uichallenge.model.Track

class MediaPickerTrack(val track: Track) : MediaPickerItem {
    override fun isHeader(): Boolean {
        return false
    }

    override fun isCarousel(): Boolean {
        return false
    }

    override fun isTrack(): Boolean {
        return true
    }

}