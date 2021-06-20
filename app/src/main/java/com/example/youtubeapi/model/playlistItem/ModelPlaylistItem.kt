package com.example.youtubeapi.model.playlistItem

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ContentDetails (
    @SerializedName("videoId") var videoId : String,
    @SerializedName("videoPublishedAt") var videoPublishedAt : String
) : Serializable

data class Default (
    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int
) : Serializable

data class High (
    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int
) : Serializable

data class Items (
    @SerializedName("kind") var kind : String,
    @SerializedName("etag") var etag : String,
    @SerializedName("id") var id : String,
    @SerializedName("snippet") var snippet : Snippet,
    @SerializedName("contentDetails") var contentDetails : ContentDetails
) : Serializable

data class Maxres (
    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int
) : Serializable

data class Medium (
    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int
) : Serializable

data class PageInfo (
    @SerializedName("totalResults") var totalResults : Int,
    @SerializedName("resultsPerPage") var resultsPerPage : Int
) : Serializable

data class PlayListItems (
    @SerializedName("kind") var kind : String,
    @SerializedName("etag") var etag : String,
    @SerializedName("items") var items : List<Items>,
    @SerializedName("pageInfo") var pageInfo : PageInfo
) : Serializable

data class ResourceId (
    @SerializedName("kind") var kind : String,
    @SerializedName("videoId") var videoId : String
) : Serializable

data class Snippet (
    @SerializedName("publishedAt") var publishedAt : String,
    @SerializedName("channelId") var channelId : String,
    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("thumbnails") var thumbnails : Thumbnails,
    @SerializedName("channelTitle") var channelTitle : String,
    @SerializedName("playlistId") var playlistId : String,
    @SerializedName("position") var position : Int,
    @SerializedName("resourceId") var resourceId : ResourceId,
    @SerializedName("videoOwnerChannelTitle") var videoOwnerChannelTitle : String,
    @SerializedName("videoOwnerChannelId") var videoOwnerChannelId : String
) : Serializable

data class Standard (
    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int
) : Serializable

data class Thumbnails (
    @SerializedName("default") var default : Default,
    @SerializedName("medium") var medium : Medium,
    @SerializedName("high") var high : High,
    @SerializedName("standard") var standard : Standard,
    @SerializedName("maxres") var maxres : Maxres
) : Serializable
