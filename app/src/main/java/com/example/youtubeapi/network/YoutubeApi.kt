package com.example.youtubeapi.network

import com.example.youtubeapi.model.playlist.ModelPlaylist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String
    ): Call<ModelPlaylist>
}