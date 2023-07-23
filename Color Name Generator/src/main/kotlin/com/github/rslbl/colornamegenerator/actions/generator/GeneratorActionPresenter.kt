package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.base.BasePresenter
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

interface GeneratorActionPresenter {
    fun getColorByHex(hex: String)
    fun getColorByRGB(rgb: String)
}

class GeneratorActionPresenterImp(
    private val view: GeneratorFormView,
    private val repository: GeneratorRepository
) : GeneratorActionPresenter, BasePresenter() {

    override fun getColorByHex(hex: String) {
        launch {
            repository.getColorByHex(hex)
                .catch { view.error(it) }
                .collect { view.showHexColor(it) }
        }
    }

    override fun getColorByRGB(rgb: String) {
        launch {
            repository.getColorByRGB(rgb)
                .catch { view.error(it) }
                .collect { view.showRGBColor(it) }
        }
    }

}