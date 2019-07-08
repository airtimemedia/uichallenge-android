package com.signal.uichallenge.mediapicker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.signal.uichallenge.R
import com.signal.uichallenge.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_media_picker.*

class MediaPickerFragment : BaseFragment() {

    private val adapter = MediaPickerAdapter()

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        activityFragmentCallback?.setToolbarTitle(getString(R.string.media_picker))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_media_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        val items = loadMediaPickerItems()

        adapter.items = items
    }

    private fun loadMediaPickerItems(): MutableList<MediaPickerItem> {
        val items = mutableListOf<MediaPickerItem>()

        val dataSource = MediaPickerDataSource.getInstance()

        items.add(MediaPickerHeader(getString(R.string.trending_videos)))
        items.add(MediaPickerVideoCarousel(dataSource.getVideos()))
        items.add(MediaPickerHeader(getString(R.string.tracks_we_love)))

        val tracks = dataSource.getTracks().map { MediaPickerTrack(it) }
        items.addAll(tracks)
        return items
    }


    fun initRecyclerView() {
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() : MediaPickerFragment {
            val mediaPickerFragment = MediaPickerFragment()
            return mediaPickerFragment
        }
    }
}