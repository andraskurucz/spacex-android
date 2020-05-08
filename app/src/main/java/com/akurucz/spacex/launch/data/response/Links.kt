package com.akurucz.spacex.launch.data.response

data class Links(
    val article_link: String?,
    val flickr_images: List<String>,
    val mission_patch: String?,
    val mission_patch_small: String?,
    val presskit: String?,
    val reddit_campaign: String?,
    val reddit_launch: String?,
    val reddit_media: String?,
    val reddit_recovery: String?,
    val video_link: String?,
    val wikipedia: String?,
    val youtube_id: String?
)