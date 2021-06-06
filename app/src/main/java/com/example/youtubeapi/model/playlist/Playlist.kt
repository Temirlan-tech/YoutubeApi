package com.example.youtubeapi.model.playlist

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ModelPlaylist(
    @SerializedName("kind") var kind: String,
    @SerializedName("etag") var etag: String,
    @SerializedName("items") var items: List<Items>,
    @SerializedName("pageInfo") var pageInfo: PageInfo
) : Serializable

data class Thumbnails(
    @SerializedName("default") var default: Default,
    @SerializedName("medium") var medium: Medium,
    @SerializedName("high") var high: High
) : Serializable

data class Snippet(
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("channelId") var channelId: String,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("thumbnails") var thumbnails: Thumbnails,
    @SerializedName("channelTitle") var channelTitle: String,
    @SerializedName("tags") var tags: List<String>,
    @SerializedName("categoryId") var categoryId: String,
    @SerializedName("liveBroadcastContent") var liveBroadcastContent: String,
    @SerializedName("localized") var localized: Localized
) : Serializable

data class PageInfo(
    @SerializedName("totalResults") var totalResults: Int,
    @SerializedName("resultsPerPage") var resultsPerPage: Int
) : Serializable

data class Medium(
    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int
) : Serializable

data class Localized(
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String
) : Serializable

data class Items(
    @SerializedName("kind") var kind: String,
    @SerializedName("etag") var etag: String,
    @SerializedName("id") var id: String,
    @SerializedName("snippet") var snippet: Snippet,
    @SerializedName("contentDetails") var contentDetails: ContentDetails
) : Serializable

data class High(
    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int
) : Serializable

data class Default(
    @SerializedName("url") var url: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int
) : Serializable

data class ContentRating(
    val name: String = ""
) : Serializable

data class ContentDetails(
    @SerializedName("duration") var duration: String,
    @SerializedName("dimension") var dimension: String,
    @SerializedName("definition") var definition: String,
    @SerializedName("caption") var caption: String,
    @SerializedName("licensedContent") var licensedContent: Boolean,
    @SerializedName("contentRating") var contentRating: ContentRating,
    @SerializedName("projection") var projection: String,
    var itemCount: Int
) : Serializable




