package ir.refah.khavaremiyanetestproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Isbn(
    @SerializedName("isbn10")
    @Expose
    val isbn10: String,
    @SerializedName("isbn13")
    @Expose
    val isbn13: String
)