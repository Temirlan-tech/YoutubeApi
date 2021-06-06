package com.example.youtubeapi.network

import com.example.youtubeapi.model.playlist.ModelPlaylist
import com.example.youtubeapi.model.playlistItem.PlayListItems
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String
    ): Call<ModelPlaylist>


    @GET("playlistItems")
    fun fetchPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String
    ): Call<PlayListItems>
}