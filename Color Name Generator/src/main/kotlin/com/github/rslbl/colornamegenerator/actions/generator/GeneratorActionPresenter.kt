package com.github.rslbl.colornamegenerator.actions.generator

interface GeneratorActionPresenter {
    fun getColorByHex(hex: String)
    fun getColorByRGB(rgb: String)
}

class GeneratorActionPresenterImp(
    private val view: GeneratorFormView,
    private val repository: GeneratorRepository
) : GeneratorActionPresenter {

    override fun getColorByHex(hex: String) {
        repository.getColorByHex(hex)
            .subscribe(
                { color -> view.showColors(color) },
                { error -> view.error(error) }
            )
    }

    override fun getColorByRGB(rgb: String) {
        repository.getColorByRGB(rgb)
            .subscribe(
                { color -> view.showColors(color) },
                { error -> view.error(error) }
            )
    }

}