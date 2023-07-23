package com.github.rslbl.colornamegenerator.utils

class AlphaColorHelper {

    /**
     * First = Alpha name
     * Second = Alpha code
     */
    private val alphaList = listOf(
        Pair("100", "FF"),
        Pair("99", "FC"),
        Pair("98", "FA"),
        Pair("97", "F7"),
        Pair("96", "F5"),
        Pair("95", "F2"),
        Pair("94", "F0"),
        Pair("93", "ED"),
        Pair("92", "EB"),
        Pair("91", "E8"),
        Pair("90", "E6"),
        Pair("89", "E3"),
        Pair("88", "E0"),
        Pair("87", "DE"),
        Pair("86", "DB"),
        Pair("85", "D9"),
        Pair("84", "D6"),
        Pair("83", "D4"),
        Pair("82", "D1"),
        Pair("81", "CF"),
        Pair("80", "CC"),
        Pair("79", "C9"),
        Pair("78", "C7"),
        Pair("77", "C4"),
        Pair("76", "C2"),
        Pair("75", "BF"),
        Pair("74", "BD"),
        Pair("73", "BA"),
        Pair("72", "B8"),
        Pair("71", "B5"),
        Pair("70", "B3"),
        Pair("69", "B0"),
        Pair("68", "AD"),
        Pair("67", "AB"),
        Pair("66", "A8"),
        Pair("65", "A6"),
        Pair("64", "A3"),
        Pair("63", "A1"),
        Pair("62", "9E"),
        Pair("61", "9C"),
        Pair("60", "99"),
        Pair("59", "96"),
        Pair("58", "94"),
        Pair("57", "91"),
        Pair("56", "8F"),
        Pair("55", "8C"),
        Pair("54", "8A"),
        Pair("53", "87"),
        Pair("52", "85"),
        Pair("51", "82"),
        Pair("50", "80"),
        Pair("49", "7D"),
        Pair("48", "7A"),
        Pair("47", "78"),
        Pair("46", "75"),
        Pair("45", "73"),
        Pair("44", "70"),
        Pair("43", "6E"),
        Pair("42", "6B"),
        Pair("41", "69"),
        Pair("40", "66"),
        Pair("39", "63"),
        Pair("38", "61"),
        Pair("37", "5E"),
        Pair("36", "5C"),
        Pair("35", "59"),
        Pair("34", "57"),
        Pair("33", "54"),
        Pair("32", "52"),
        Pair("31", "4F"),
        Pair("30", "4D"),
        Pair("29", "4A"),
        Pair("28", "47"),
        Pair("27", "45"),
        Pair("26", "42"),
        Pair("25", "40"),
        Pair("24", "3D"),
        Pair("23", "3B"),
        Pair("22", "38"),
        Pair("21", "36"),
        Pair("20", "33"),
        Pair("19", "30"),
        Pair("18", "2E"),
        Pair("17", "2B"),
        Pair("16", "29"),
        Pair("15", "26"),
        Pair("14", "24"),
        Pair("13", "21"),
        Pair("12", "1F"),
        Pair("11", "1C"),
        Pair("10", "1A"),
        Pair("9", "17"),
        Pair("8", "14"),
        Pair("7", "12"),
        Pair("6", "0F"),
        Pair("5", "0D"),
        Pair("4", "0A"),
        Pair("3", "08"),
        Pair("2", "05"),
        Pair("1", "03"),
        Pair("0", "00")
    )


    fun getAlphaName(code: String): String {
        val item = alphaList.find { it.second == code }
        return item?.first ?: ""
    }

}