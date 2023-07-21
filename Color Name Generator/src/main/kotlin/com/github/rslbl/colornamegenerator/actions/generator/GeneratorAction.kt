package com.github.rslbl.colornamegenerator.actions.generator

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class GeneratorAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val dialog = GeneratorForm(event.project!!, GeneratorInjectorImp())
        dialog.show()
    }

}