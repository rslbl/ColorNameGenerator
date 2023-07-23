package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse

interface GeneratorFormView {

    fun showHexColor(color: ColorResponse)

    fun showRGBColor(color: ColorResponse)

    fun success()

    fun error(error: Throwable)

}