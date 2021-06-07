package com.example.youtubeapi.ui.playlist

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.`object`.Constants.ID_VIDEO
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.model.playlist.Items
import com.example.youtubeapi.network.Connection
import com.example.youtubeapi.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlinx.android.synthetic.main.scroll_view.*

class MainActivity : BaseActivity(R.layout.activity_main), OnItemClickListener {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val adapter: PlaylistsAdapter = PlaylistsAdapter(this)

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

    override fun onClick(items: Items) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(ID_VIDEO, items)
        }
        startActivity(intent)

    }
}


