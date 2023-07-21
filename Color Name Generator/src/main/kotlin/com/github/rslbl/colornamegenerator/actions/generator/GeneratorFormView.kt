package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse

interface GeneratorFormView {

    fun showColors(color: ColorResponse)

    fun success()

    fun error(error: Throwable)

}