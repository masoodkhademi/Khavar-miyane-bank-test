package ir.refah.khavaremiyanetestproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("age_group")
    @Expose
    val age_group: String,
    @SerializedName("amazon_product_url")
    @Expose
    val amazon_product_url: String,
    @SerializedName("article_chapter_link")
    @Expose
    val article_chapter_link: String,
    @SerializedName("asterisk")
    @Expose
    val asterisk: Int,
    @SerializedName("author")
    @Expose
    val author: String,
    @SerializedName("book_image")
    @Expose
    val book_image: String,
    @SerializedName("book_image_height")
    @Expose
    val book_image_height: Int,
    @SerializedName("book_image_width")
    @Expose
    val book_image_width: Int,
    @SerializedName("book_review_link")
    @Expose
    val book_review_link: String,
    @SerializedName("book_uri")
    @Expose
    val book_uri: String,
    @SerializedName("buy_links")
    @Expose
    val buy_links: List<BuyLink>,
    @SerializedName("contributor")
    @Expose
    val contributor: String,
    @SerializedName("contributor_note")
    @Expose
    val contributor_note: String,
    @SerializedName("dagger")
    @Expose
    val dagger: Int,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("first_chapter_link")
    @Expose
    val first_chapter_link: String,
    @SerializedName("isbns")
    @Expose
    val isbns: List<Isbn>,
    @SerializedName("price")
    @Expose
    val price: Int,
    @SerializedName("primary_isbn10")
    @Expose
    val primary_isbn10: String,
    @SerializedName("primary_isbn13")
    @Expose
    val primary_isbn13: String,
    @SerializedName("publisher")
    @Expose
    val publisher: String,
    @SerializedName("rank")
    @Expose
    val rank: Int,
    @SerializedName("rank_last_week")
    @Expose
    val rank_last_week: Int,
    @SerializedName("sunday_review_link")
    @Expose
    val sunday_review_link: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("weeks_on_list")
    @Expose
    val weeks_on_list: Int
)