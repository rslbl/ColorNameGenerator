package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import com.github.rslbl.colornamegenerator.data.remote.GeneratorServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface GeneratorRepository {
    suspend fun getColorByHex(hex: String): Flow<ColorResponse>
    suspend fun getColorByRGB(rgb: String): Flow<ColorResponse>
}

class GeneratorRepositoryImp(
    private val api: GeneratorServiceApi
) : GeneratorRepository {

    override suspend fun getColorByHex(hex: String): Flow<ColorResponse> =
        flow {
            val data = api.getColorByHex(hex)
            emit(data)
        }.flowOn(Dispatchers.IO)

    override suspend fun getColorByRGB(rgb: String): Flow<ColorResponse> =
        flow {
            val data = api.getColorByRGB(rgb)
            emit(data)
        }.flowOn(Dispatchers.IO)

}