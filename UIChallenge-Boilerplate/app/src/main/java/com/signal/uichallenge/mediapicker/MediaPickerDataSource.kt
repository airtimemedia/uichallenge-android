package com.signal.uichallenge.mediapicker

import com.signal.uichallenge.R
import com.signal.uichallenge.model.Track
import com.signal.uichallenge.model.Video

class MediaPickerDataSource {
    companion object {

        private val INSTANCE = MediaPickerDataSource()

        private val VIDEOS = listOf(
            Video("Casey Neistat", R.drawable.casey),
            Video("Game of Thrones", R.drawable.got),
            Video("Space Travel", R.drawable.nasa),
            Video("Pulp Fiction", R.drawable.pulp)
        )

        private val TRACKS = listOf(
            Track("Scorpion", "Drake", R.drawable.drake_1),
            Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
            Track("Views", "Drake", R.drawable.drake_3),
            Track("More Life", "Drake", R.drawable.drake_4),
            Track("Scorpion", "Drake", R.drawable.drake_1),
            Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
            Track("Views", "Drake", R.drawable.drake_3),
            Track("More Life", "Drake", R.drawable.drake_4),
            Track("Scorpion", "Drake", R.drawable.drake_1),
            Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
            Track("Views", "Drake", R.drawable.drake_3),
            Track("More Life", "Drake", R.drawable.drake_4),
            Track("Scorpion", "Drake", R.drawable.drake_1),
            Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
            Track("Views", "Drake", R.drawable.drake_3),
            Track("More Life", "Drake", R.drawable.drake_4),
            Track("Scorpion", "Drake", R.drawable.drake_1),
            Track("Take Care (Deluxe)", "Drake", R.drawable.drake_2),
            Track("Views", "Drake", R.drawable.drake_3),
            Track("More Life", "Drake", R.drawable.drake_4)
        )

        fun getInstance(): MediaPickerDataSource {
            return INSTANCE
        }
    }


    fun getVideos(): List<Video> {
        return VIDEOS
    }

    fun getTracks(): List<Track> {
        return TRACKS
    }
}