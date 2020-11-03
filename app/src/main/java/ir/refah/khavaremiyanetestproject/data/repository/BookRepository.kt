package ir.refah.khavaremiyanetestproject.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ir.refah.khavaremiyanetestproject.constants.Constants
import ir.refah.khavaremiyanetestproject.model.TestBook
import ir.refah.khavaremiyanetestproject.network.retrofit.NetworkResponseCallback
import ir.refah.khavaremiyanetestproject.network.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRepository {
    private lateinit var mCallback: NetworkResponseCallback
    private var bookList: MutableLiveData<TestBook> =
        MutableLiveData<TestBook>().apply { value = null }

    companion object {
        private var mInstance: BookRepository? = null
        fun getInstance(): BookRepository {
            if (mInstance == null) {
                synchronized(this) {
                    mInstance = BookRepository()
                }
            }
            return mInstance!!
        }
    }


    private lateinit var bookCallback: Call<TestBook>

    fun getBooks(callback: NetworkResponseCallback,title:String): MutableLiveData<TestBook> {
        mCallback = callback
//        if (bookList.value!=null) {
//            mCallback.onNetworkSuccess()
//            return bookList
//        }
        Log.i("=============>", "title:"+title)
        bookCallback = RetrofitInstance.getInstance().getApiService().getBooks(title,Constants.API_KEY)
        bookCallback.enqueue(object : Callback<TestBook> {

            override fun onResponse(
                call: Call<TestBook>,
                response: Response<TestBook>
            ) {
                Log.i("=========>", "onResponse:"+response.body())
                bookList.value = response.body()
                mCallback.onNetworkSuccess()
            }

            override fun onFailure(call: Call<TestBook>, t: Throwable) {
                bookList.value = null
                mCallback.onNetworkFailure(t)
            }

        })
        return bookList
    }
}