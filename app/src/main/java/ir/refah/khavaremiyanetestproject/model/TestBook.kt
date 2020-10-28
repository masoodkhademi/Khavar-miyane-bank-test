package ir.refah.khavaremiyanetestproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TestBook(
    @SerializedName("copyright")
    @Expose
    val copyright: String,
    @SerializedName("last_modified")
    @Expose
    val last_modified: String,
    @SerializedName("num_results")
    @Expose
    val num_results: Int,
    @SerializedName("results")
    @Expose
    val results: Results,
    @SerializedName("status")
    @Expose
    val status: String
)