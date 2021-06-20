package com.example.youtubeapi.ui.third

import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.`object`.Constants
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.playlistItem.PlayListItems
import com.example.youtubeapi.network.RetrofitClient
import com.example.youtubeapi.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdViewModel : BaseViewModel() {

    private var youtubeApi: YoutubeApi = RetrofitClient.create()

    fun fetchItemPlayList(id: String): MutableLiveData<PlayListItems?> {
        return fetchYoutubeApiThird(id)
    }

    // метод который отправляет запрос в бэк
    private fun fetchYoutubeApiThird(id: String): MutableLiveData<PlayListItems?> {

        val data =
            MutableLiveData<PlayListItems?>() // мутэблайвдата это слушатель он проверяет пришли ли
        // данные с бэка, если да то храним дата

        youtubeApi.fetchPlaylistItems(Constants.PART, id, Constants.API_KEY)
            .enqueue(object : Callback<PlayListItems> {
                override fun onResponse(
                    call: Call<PlayListItems>,
                    response: Response<PlayListItems>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<PlayListItems>, t: Throwable) {

                }
            })
        return data
    }
}