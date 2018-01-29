package net.portes.examplemvvm.net

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by portes on 28/01/18.
 */
open class RetrofitService {
    private var mRetrofit: Retrofit? = null
    fun getRetrofitInstance(mApplication: Context): Retrofit {
        if (null == mRetrofit) {
            mRetrofit = getHttpPetition(mApplication)
        }
        return mRetrofit!!
    }

    private fun getCache(mApplication: Context): OkHttpClient {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        val mCache = Cache(mApplication.cacheDir, cacheSize.toLong())

        val httpClient = OkHttpClient.Builder()
        httpClient.cache(mCache)
        return httpClient.build()
    }

    private fun getLoggingGson(): Gson {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        return GsonBuilder().setLenient().create()
    }

    private fun getHttpPetition(mApplication: Context): Retrofit {
        mRetrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(getCache(mApplication))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getLoggingGson()))
                .build()
        return mRetrofit!!
    }
}