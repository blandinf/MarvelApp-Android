package com.blandinf.marvelapp.networking

import android.os.Build
import android.util.Log
import com.blandinf.marvelapp.BuildConfig
import com.blandinf.marvelapp.extensions.toMD5
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import java.util.*

object NetworkingModules {

    private const val PUBLIC_API_KEY: String = BuildConfig.PUBLIC_API_KEY
    private const val PRIVATE_API_KEY: String = BuildConfig.PRIVATE_API_KEY
    private const val API_URL = "https://gateway.marvel.com:443/v1/public/"

    private const val HEADER_CONTENT_TYPE_KEY = "Content-Type"
    private const val HEADER_ACCEPT_KEY = "Accept"

    private const val MIME_APPLICATION_JSON = "application/json"

    var retrofit: Retrofit

    init {
        retrofit = buildClient()
    }

    /**
     * Configure retrofit
     */
    private fun buildClient(): Retrofit {
        val httpClient = OkHttpClient.Builder().apply {
            addLogInterceptor(this)
            addApiInterceptor(this)
        }.build()

        return Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    /**
     * Add a logger to the client so that we log every request
     */
    private fun addLogInterceptor(builder: OkHttpClient.Builder) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.addNetworkInterceptor(httpLoggingInterceptor)
    }

    /**
     * Intercept every request to the API and automatically add
     * the api key as query parameter
     */
    private fun addApiInterceptor(builder: OkHttpClient.Builder) {
        val ts = System.currentTimeMillis().toString()
        val hashBuilder = StringBuilder().apply {
            append(ts)
            append(PRIVATE_API_KEY)
            append(PUBLIC_API_KEY)
        }
        val hash = hashBuilder.toString().toMD5()

        builder.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl
                .newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apikey", PUBLIC_API_KEY)
                .addQueryParameter("hash", hash)
                .build()

            val requestBuilder = original
                .newBuilder()
                .addHeader(HEADER_ACCEPT_KEY, MIME_APPLICATION_JSON)
                .addHeader(HEADER_CONTENT_TYPE_KEY, MIME_APPLICATION_JSON)
                .url(url)
            val request = requestBuilder.build()

            chain.proceed(request)
        })
    }
}