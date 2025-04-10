package br.senai.sp.jandira.bmi.ui.theme

import java.util.Locale

fun convetertNumberToLocale(value: Double): String{
    return String.format(Locale.getDefault(), "%.1f")
}