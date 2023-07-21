package com.github.rslbl.colornamegenerator.actions.generator

import com.github.rslbl.colornamegenerator.data.model.ColorResponse
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.project.Project
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class GeneratorForm(
    val project: Project,
    generatorInjector: GeneratorInjector
) : DialogWrapper(project), GeneratorFormView {

    private var generatorPanel: JPanel? = null
    private var hexCodeTitleLabel: JLabel? = null
    private var hexCodeInput: JTextField? = null
    private var colorNameLabel: JLabel? = null
    private var colorNameTitleLabel: JLabel? = null
    private var colorNameXMLTitleLabel: JLabel? = null
    private var colorNameXMLLabel: JLabel? = null
    private var typeLabel: JLabel? = null
    private var typeCombo: JComboBox<*>? = null

    private val presenter: GeneratorActionPresenter by lazy {
        generatorInjector.generatorActionPresenter(this)
    }

    init {
        init()

        typeCombo?.addActionListener {
            hexCodeInput?.text = ""
            colorNameLabel?.text = ""
            colorNameXMLLabel?.text = ""
        }
    }

    override fun createCenterPanel(): JComponent? = generatorPanel

    override fun showColors(color: ColorResponse) {
        color.name?.value?.let {
            colorNameLabel?.text = it
        }
    }

    override fun doOKAction() {
        var code = hexCodeInput?.text

        if (code?.contains(" ") == true)
            code.replace(" ", "")

        if (code.isNullOrEmpty())
            return

        val index = typeCombo?.selectedIndex
        when (index) {
            0 -> {
                if (code.contains("#"))
                    code.replace("#", "")

                if ((code.length) > 6) {
                    val temp = code.reversed()
                    var tempCode = ""
                    for (i in 0..5) {
                        tempCode += temp[i]
                    }
                    code = tempCode.reversed()
                }

                colorNameXMLLabel?.text = code
                presenter.getColorByHex(code)
            }

            1 -> {
                if (code.contains("("))
                    code.replace("(", "")

                if (code.contains(")"))
                    code.replace(")", "")

                colorNameXMLLabel?.text = code
                presenter.getColorByRGB(code)
            }
        }


    }

    override fun success() {
        TODO("Not yet implemented")
    }

    override fun error(error: Throwable) {
        TODO("Not yet implemented")
    }
}