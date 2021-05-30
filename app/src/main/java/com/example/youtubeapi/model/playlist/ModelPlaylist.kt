package com.example.youtubeapi.model.playlist

import com.google.gson.annotations.SerializedName

data class ModelPlaylist (
    @SerializedName("kind") var kind: String
//    @SerializedName("etag") var etag: String
//    @SerializedName("items") var items: List<Items>,
//    @SerializedName("pageInfo") var pageInfo:

)
