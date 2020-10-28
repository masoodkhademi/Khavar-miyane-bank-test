package ir.refah.khavaremiyanetestproject.network.retrofit

import ir.refah.khavaremiyanetestproject.model.TestBook
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json?api-key=OvAPViP78v16Gv9euS1XeC9o9pCVga3W")
    fun getBooks() : Call<TestBook>

}