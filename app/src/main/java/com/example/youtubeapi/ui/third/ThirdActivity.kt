package com.example.youtubeapi.ui.third

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.`object`.Constants
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.model.playlist.Items
import com.example.youtubeapi.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.second_scroll_view.*

class ThirdActivity : BaseActivity(R.layout.activity_detail) {

    private val viewModel: ThirdViewModel by lazy {
        ViewModelProvider(this).get(ThirdViewModel::class.java)
    }

    override fun setupUI() {

        val item: com.example.youtubeapi.model.playlistItem.Items = intent.getSerializableExtra(Constants.ID_DETAIL) as com.example.youtubeapi.model.playlistItem.Items
        Log.e("2", "setupUI: " + item)

        tv_thirdActivity.text = item.snippet.title
        tv_thirdActivity2.text = item.snippet.description

        viewModel.fetchItemPlayList(item.id).observe(this, Observer {
            Log.e("3", "setupUI: " + it?.items?.get(0)?.snippet?.thumbnails?.default?.url)


        })
    }

    override fun setupLiveData() {
    }

    override fun showDisconnectState() {
    }
}