package ir.refah.khavaremiyanetestproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("bestsellers_date")
    @Expose
    val bestsellers_date: String,
    @SerializedName("books")
    @Expose
    val books: List<Book>,
    @SerializedName("corrections")
    @Expose
    val corrections: List<Any>,
    @SerializedName("display_name")
    @Expose
    val display_name: String,
    @SerializedName("list_name")
    @Expose
    val list_name: String,
    @SerializedName("list_name_encoded")
    @Expose
    val list_name_encoded: String,
    @SerializedName("next_published_date")
    @Expose
    val next_published_date: String,
    @SerializedName("normal_list_ends_at")
    @Expose
    val normal_list_ends_at: Int,
    @SerializedName("previous_published_date")
    @Expose
    val previous_published_date: String,
    @SerializedName("published_date")
    @Expose
    val published_date: String,
    @SerializedName("published_date_description")
    @Expose
    val published_date_description: String,
    @SerializedName("updated")
    @Expose
    val updated: String
)