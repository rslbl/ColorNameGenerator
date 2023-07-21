package com.github.rslbl.colornamegenerator.data.model

data class ColorResponse(
    val hex: Hex? = null,
    val name: Name? = null
)

data class Hex(
    val value: String? = null,
    val clean: String? = null
)

data class Name(
    val value: String? = null
)