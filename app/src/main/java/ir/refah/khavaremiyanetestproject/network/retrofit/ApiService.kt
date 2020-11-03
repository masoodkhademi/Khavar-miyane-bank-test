package ir.refah.khavaremiyanetestproject.network.retrofit

import ir.refah.khavaremiyanetestproject.model.TestBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json?")
    fun getBooks(@Query(value="title", encoded=true) title:String,@Query(value="api-key", encoded=true) apiKey:String ) : Call<TestBook>

}