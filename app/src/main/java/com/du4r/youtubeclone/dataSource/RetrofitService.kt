package com.du4r.youtubeclone.dataSource

import com.du4r.youtubeclone.Models.ListVideo
import com.du4r.youtubeclone.Models.Video
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {

    @GET("Videos")
    fun getVideos(): Call<ListVideo>

    companion object {

        private val retrofitService: RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun  getInstance(): RetrofitService {
            return retrofitService
        }
    }
}

