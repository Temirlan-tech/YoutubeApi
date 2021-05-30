package com.example.youtubeapi.ui.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    private var viewModel : MainViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override  fun setupLiveData() {

        viewModel?.fetchAllPlayList()?.observe(this, Observer{
            Toast.makeText(this, " njfnv" + it?.kind.toString(), Toast.LENGTH_SHORT).show()
            Log.e("TAG", "onResponse: ")

        })
    }

    override fun showDisconnectState() {
    }

}

