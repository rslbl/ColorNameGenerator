package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import com.github.rslbl.colornamegenerator.utils.AlphaColorHelper
import com.intellij.codeInsight.editorActions.CopyPastePostProcessor
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.project.Project
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class GeneratorForm(
    val project: Project,
    generatorInjector: GeneratorInjector
) : DialogWrapper(project), GeneratorFormView {

    // region Variable
    private var generatorPanel: JPanel? = null
    private var hexCodeTitleLabel: JLabel? = null
    private var hexCodeInput: JTextField? = null
    private var colorNameLabel: JLabel? = null
    private var colorNameTitleLabel: JLabel? = null
    private var colorNameXMLTitleLabel: JLabel? = null
    private var colorNameXMLInput: JTextField? = null
    private var typeLabel: JLabel? = null
    private var typeCombo: JComboBox<*>? = null

    //endregion

    private val presenter: GeneratorActionPresenter by lazy {
        generatorInjector.generatorActionPresenter(this)
    }

    init {
        init()

        typeCombo?.addActionListener {
            hexCodeInput?.text = ""
            colorNameLabel?.text = ""
            colorNameXMLInput?.text = ""
        }
    }

    override fun createCenterPanel(): JComponent? = generatorPanel

    override fun showHexColor(color: ColorResponse) {
        color.name?.value?.let { colorName ->
            colorNameLabel?.text = colorName

            var code = hexCodeInput?.text

            if (code?.contains("#") == true)
                code = code.replace("#", "")

            var name = colorName.replace(" ", "_").lowercase()

            if ((code?.length ?: 0) == 8) {
                val alphaCode = code?.take(2)
                alphaCode?.let {
                    val alphaName = AlphaColorHelper().getAlphaName(it)
                    name += "_alpha_$alphaName"
                }
            }
            val xmlName = "<color name=\"$name\">#${code}</color>"
            colorNameXMLInput?.text = xmlName
        }
    }

    override fun showRGBColor(color: ColorResponse) {
        val name = color.name?.value?.lowercase()
        val xmlName = "<color name=\"${name}\">#${color.hex?.clean}</color>"

        colorNameLabel?.text = color.name?.value
        colorNameXMLInput?.text = xmlName
    }

    override fun doOKAction() {
        var code = hexCodeInput?.text

        if (code?.contains(" ") == true)
            code = code.replace(" ", "")

        if (code.isNullOrEmpty())
            return

        val index = typeCombo?.selectedIndex
        when (index) {
            0 -> {
                if (code.contains("#"))
                    code = code.replace("#", "")

                if (code.length == 8) {
                    val alphaCode = code.take(2)
                    code = code.removeRange(0, 2)
                }

                if (code.length == 6) {
                    presenter.getColorByHex(code)
                }
            }

            1 -> {
                if (code.contains("("))
                    code = code.replace("(", "")

                if (code.contains(")"))
                    code = code.replace(")", "")

                presenter.getColorByRGB(code)
            }
        }

    }

    override fun success() {
        TODO("Not yet implemented")
    }

    override fun error(error: Throwable) {
        print(error)
    }
}