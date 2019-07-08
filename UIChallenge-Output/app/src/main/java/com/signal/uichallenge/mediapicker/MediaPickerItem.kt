package com.signal.uichallenge.mediapicker

interface MediaPickerItem {
    fun isHeader() : Boolean

    fun isCarousel() : Boolean

    fun isTrack() : Boolean
}