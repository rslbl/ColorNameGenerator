package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import com.github.rslbl.colornamegenerator.data.remote.GeneratorServiceApi
import hu.akarnokd.rxjava2.swing.SwingSchedulers
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

interface GeneratorRepository {
    fun getColorByHex(hex: String): Single<ColorResponse>
    fun getColorByRGB(rgb: String): Single<ColorResponse>
}

class GeneratorRepositoryImp(
    private val api: GeneratorServiceApi
) : GeneratorRepository {

    override fun getColorByHex(hex: String): Single<ColorResponse> =
        api.getColorByHex(hex)
            .subscribeOn(Schedulers.io())
            .observeOn(SwingSchedulers.edt())

    override fun getColorByRGB(rgb: String): Single<ColorResponse> =
        api.getColorByRGB(rgb)
            .subscribeOn(Schedulers.io())
            .observeOn(SwingSchedulers.edt())

}