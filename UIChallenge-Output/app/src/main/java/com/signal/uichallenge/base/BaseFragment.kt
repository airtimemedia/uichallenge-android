package com.signal.uichallenge.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    var activityFragmentCallback: ActivityFragmentCallback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is ActivityFragmentCallback) {
            activityFragmentCallback = context
        }
    }

    interface ActivityFragmentCallback {
        fun setToolbarTitle(title: String)
    }
}