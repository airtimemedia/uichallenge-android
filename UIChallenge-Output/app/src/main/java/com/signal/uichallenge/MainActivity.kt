package com.signal.uichallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.signal.uichallenge.base.BaseFragment
import com.signal.uichallenge.mediapicker.MediaPickerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseFragment.ActivityFragmentCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val pickerFragment = MediaPickerFragment.newInstance()

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, pickerFragment)
                .commit()
    }

    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }
}
