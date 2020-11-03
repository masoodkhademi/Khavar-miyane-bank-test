package ir.refah.khavaremiyanetestproject.model

import android.app.Activity
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide

object BindingAdapters {
    @BindingAdapter("app:imageThumb")
    @JvmStatic
    fun loadImage(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)

    }


}