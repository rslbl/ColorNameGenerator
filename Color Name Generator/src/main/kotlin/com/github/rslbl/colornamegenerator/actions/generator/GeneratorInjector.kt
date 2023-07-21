package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.remote.GeneratorServiceApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

interface GeneratorInjector {
    val repository: GeneratorRepository
    val api: GeneratorServiceApi

    fun generatorActionPresenter(view: GeneratorFormView): GeneratorActionPresenter
}

class GeneratorInjectorImp : GeneratorInjector {

    override val api: GeneratorServiceApi by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://www.thecolorapi.com/")
            .build()
            .create(GeneratorServiceApi::class.java)
    }

    override val repository: GeneratorRepository by lazy {
        GeneratorRepositoryImp(api)
    }

    override fun generatorActionPresenter(view: GeneratorFormView): GeneratorActionPresenter {
        return GeneratorActionPresenterImp(view, repository)
    }
}