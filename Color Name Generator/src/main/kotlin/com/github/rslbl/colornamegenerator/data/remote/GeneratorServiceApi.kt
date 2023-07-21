package com.github.rslbl.colornamegenerator.data.remote

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GeneratorServiceApi {

    @GET("id")
    fun getColorByHex(@Query("hex") hex: String): Single<ColorResponse>

    @GET("id")
    fun getColorByRGB(@Query("rgb") rgb: String): Single<ColorResponse>

}