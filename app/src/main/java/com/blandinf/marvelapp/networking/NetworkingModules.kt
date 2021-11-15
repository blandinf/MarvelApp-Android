package com.blandinf.marvelapp.networking

import android.os.Build
import com.blandinf.marvelapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object NetworkingModules {

    private const val apiKey: String = BuildConfig.ApiKey
    private const val apiUrl = "https://gateway.marvel.com:443/v1/public/"

    private const val HEADER_CONTENT_TYPE_KEY = "Content-Type"
    private const val HEADER_ACCEPT_KEY = "Accept"
    private const val HEADER_LANGUAGE_KEY = "Accept-Language"
    private const val HEADER_USER_AGENT_KEY = "User-Agent"

    private const val MIME_APPLICATION_JSON = "application/json"

    var retrofit: Retrofit

    init {
        retrofit = buildClient()
    }

    /**
     * Configure retrofit
     */
    private fun buildClient(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        addLogInterceptor(httpClient)
        addApiInterceptor(httpClient)

        return Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
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
        builder.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl
                .newBuilder()
                .addQueryParameter("apiKey", apiKey)
                .build()

            val device = Build.MANUFACTURER + "-" + Build.MODEL

            val requestBuilder = original.newBuilder()
                .addHeader(HEADER_USER_AGENT_KEY, "Android-${BuildConfig.VERSION_CODE}-($device)")
                .addHeader(HEADER_LANGUAGE_KEY, Locale.getDefault().language)
                .addHeader(HEADER_ACCEPT_KEY, MIME_APPLICATION_JSON)
                .addHeader(HEADER_CONTENT_TYPE_KEY, MIME_APPLICATION_JSON)
                .url(url)
            val request = requestBuilder.build()

            chain.proceed(request)
        })
    }
}