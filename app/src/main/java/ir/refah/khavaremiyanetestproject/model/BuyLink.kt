package ir.refah.khavaremiyanetestproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BuyLink(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String
)