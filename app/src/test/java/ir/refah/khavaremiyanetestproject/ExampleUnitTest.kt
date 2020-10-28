package ir.refah.khavaremiyanetestproject

import ir.refah.khavaremiyanetestproject.model.TestBook
import ir.refah.khavaremiyanetestproject.network.retrofit.ApiService
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Matchers.any
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}