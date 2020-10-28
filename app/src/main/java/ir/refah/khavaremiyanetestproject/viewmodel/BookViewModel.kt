package ir.refah.khavaremiyanetestproject.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.refah.khavaremiyanetestproject.data.adapter.BookAdapter
import ir.refah.khavaremiyanetestproject.data.repository.BookRepository
import ir.refah.khavaremiyanetestproject.model.Book
import ir.refah.khavaremiyanetestproject.model.TestBook
import ir.refah.khavaremiyanetestproject.network.NetworkHelper
import ir.refah.khavaremiyanetestproject.network.retrofit.NetworkResponseCallback

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private var _mList = MutableLiveData<TestBook>()
    val mlist: LiveData<TestBook>
        get() = _mList
    var mShowProgressBar: MutableLiveData<Boolean> = MutableLiveData()
    private var mShowNetworkError: MutableLiveData<Boolean> = MutableLiveData()
    private var mShowApiError: MutableLiveData<Boolean> = MutableLiveData()
    private var mRepository = BookRepository.getInstance()

    init {
        Log.i("============>", "init:")
        fetchBooksFromServer(application.applicationContext)
    }

    fun fetchBooksFromServer(context: Context): MutableLiveData<TestBook> {
        if (NetworkHelper.isOnline(context)) {
            mShowProgressBar.value = true
            _mList.postValue(mRepository.getBooks(object : NetworkResponseCallback {
                override fun onNetworkFailure(th: Throwable) {
                    Log.i("==========>", "onNetworkFailure:$th")
                    mShowApiError.value = true
                }

                override fun onNetworkSuccess() {
                    Log.i("==========>", "onNetworkSuccess:")
                    mShowProgressBar.value = false
                }
            }).value)
        } else {
            Log.i("==========>", "fetchBooksFromServer: Error network")
            mShowNetworkError.value = true
        }
        return _mList
    }

    fun onRefreshClicked(view: View) {
        fetchBooksFromServer(view.context)
    }
}