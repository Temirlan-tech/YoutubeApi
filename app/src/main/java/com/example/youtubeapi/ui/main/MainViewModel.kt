package com.example.youtubeapi.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.`object`.Constants
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.playlist.ModelPlaylist
import com.example.youtubeapi.network.RetrofitClient
import com.example.youtubeapi.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    private var youtubeApi: YoutubeApi = RetrofitClient.create()

    fun fetchAllPlayList(): LiveData<ModelPlaylist?> {
        return fetchYoutubeApiPlayList()
    }

    // метод который отправляет запрос в бэк
    private  fun fetchYoutubeApiPlayList(): LiveData<ModelPlaylist?> {

        val data = MutableLiveData<ModelPlaylist?>() // мутэблайвдата это слушатель он проверяет пришли ли
                                                    // данные с бэка, если да то храним дата
        youtubeApi.fetchAllPlayList(Constants.PART, Constants.CHANNEL_ID, Constants.API_KEY)
            .enqueue(object: Callback<ModelPlaylist>{

                override fun onResponse(call: Call<ModelPlaylist>, response: Response<ModelPlaylist>
                ) {
                        Log.e("TAG", "onResponse: " + response.message().toString())
                        data.value = response.body()

                }

                override fun onFailure(call: Call<ModelPlaylist>, t: Throwable) {
                    Log.e("TAG", "onResponse: " + t.message.toString())
                }
            })
        
        return data
    }
}