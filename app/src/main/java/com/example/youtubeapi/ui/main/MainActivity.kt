package com.example.youtubeapi.ui.main

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.network.Connection
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlinx.android.synthetic.main.scroll_view.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val adapter: PlaylistsAdapter = PlaylistsAdapter()

    override fun setupUI() {
        rv_playlist.adapter = adapter
    }

    override fun setupLiveData() {
        viewModel.fetchAllPlayList().observe(this, Observer {
            it?.items?.let {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun showDisconnectState() {
        val networkConnection = Connection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected) {

            } else {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.alert_dialog)
                dialog.setCanceledOnTouchOutside(false)
                dialog.window!!.setLayout(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT
                )
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.btn_ty.setOnClickListener {
                    recreate()
                }
                dialog.show()
            }
        })
    }
}


