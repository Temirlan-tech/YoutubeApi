package com.example.youtubeapi.ui.detail

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.`object`.Constants.ID_DETAIL
import com.example.youtubeapi.`object`.Constants.ID_VIDEO
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.model.playlist.Items
import com.example.youtubeapi.network.Connection
import com.example.youtubeapi.ui.playlist.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlinx.android.synthetic.main.second_scroll_view.*

class DetailActivity : BaseActivity(R.layout.activity_detail), OnClickListener {

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    private val adapter: DetailAdapter = DetailAdapter(this)

    override fun setupUI() {

        val item: Items = intent.getSerializableExtra(ID_VIDEO) as Items
        Log.e("2", "setupUI: " + item)
        rv_second.adapter = adapter

        tv_title2.text = item.snippet.title
        tv_subtitle2.text = item.snippet.description

        viewModel.fetchItemPlayList(item.id).observe(this, Observer {
            Log.e("3", "setupUI: " + it?.items?.get(0)?.snippet?.thumbnails?.default?.url)
            it?.items?.let {
                adapter.itemsThird = it
                adapter.notifyDataSetChanged()
            }
        })

        tv_back.setOnClickListener {
            back()
        }
    }

    private fun back() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun setupLiveData() {

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

    override fun onClickThird(items: com.example.youtubeapi.model.playlistItem.Items) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(ID_VIDEO, items)
        }
        startActivity(intent)
    }
}

