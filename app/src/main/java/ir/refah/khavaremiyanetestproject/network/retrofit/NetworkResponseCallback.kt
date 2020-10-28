package ir.refah.khavaremiyanetestproject.network.retrofit

interface NetworkResponseCallback {
    fun onNetworkSuccess()
    fun onNetworkFailure(th : Throwable)
}