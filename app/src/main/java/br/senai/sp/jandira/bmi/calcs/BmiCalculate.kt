package br.senai.sp.jandira.bmi.calcs

import androidx.compose.ui.graphics.Color
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

fun BmiCalculate(weight: Float, height: Float): Bmi {

//    val bmiResult = weight / height.pow(2)
//    val bmiResult = weight / (height * height)
    val bmiResult = weight.div(height.pow(2))

    when {
        bmiResult < 18.5 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Cyan,
                bmiStatus = BmiStatus.UNDER_WEIGHT
            )

        bmiResult >= 18.5 && bmiResult > 25.0 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Cyan,
                bmiStatus = BmiStatus.NORMAL
            )

        bmiResult >= 25.0 && bmiResult > 30.0 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Cyan,
                bmiStatus = BmiStatus.OVER_WEIGHT
            )

        bmiResult >= 30.0 && bmiResult > 35.0 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Cyan,
                bmiStatus = BmiStatus.OBESITY_1
            )
        bmiResult >= 35.0 && bmiResult > 40.0 ->
        return Bmi(
            bmi = Pair("", bmiResult),
            bmiColor = Color.Cyan,
            bmiStatus = BmiStatus.OBESITY_2
        )
        else -> Bmi(
            bmi = Pair("", bmiResult),
            bmiColor = Color.Cyan,
            bmiStatus = BmiStatus.OBESITY_3
        )
    }
}

