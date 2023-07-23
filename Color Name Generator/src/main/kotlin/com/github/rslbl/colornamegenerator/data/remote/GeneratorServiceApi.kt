package com.github.rslbl.colornamegenerator.data.remote

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeneratorServiceApi {

    @GET("id")
    suspend fun getColorByHex(@Query("hex") hex: String): ColorResponse

    @GET("id")
    suspend fun getColorByRGB(@Query("rgb") rgb: String): ColorResponse

}