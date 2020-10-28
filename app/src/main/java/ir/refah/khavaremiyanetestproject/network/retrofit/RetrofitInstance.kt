package ir.refah.khavaremiyanetestproject.network.retrofit

import com.google.gson.GsonBuilder
import ir.refah.khavaremiyanetestproject.constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {
        private lateinit var mApiService: ApiService
        private var mInstance: RetrofitInstance? = null
        fun getInstance(): RetrofitInstance {
            if (mInstance == null) {
                synchronized(this) {
                    mInstance = RetrofitInstance()
                }
            }
            return mInstance!!
        }
    }

    init {
        val okHttpClient = OkHttpClient().newBuilder().connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .build();
        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        mApiService = retrofit.create(ApiService::class.java)
    }

    fun getApiService() = mApiService
}