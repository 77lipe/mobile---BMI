package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.BmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel

@Composable
fun ResultBMI(navegacao: NavHostController) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val userWeight = userFile.getFloat("weight_value", 0.0f)
    val userHight = userFile.getFloat("height_value", 0.0f)
    val userAge = userFile.getInt("age_value", 0)

    val bmi = BmiCalculate(
        userWeight, userHight.toFloat().div(100))


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF9FCE86),
                        Color(0xFFA6E14D)
                    )
                )
            )
    ){
        Column {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(horizontal = 22.dp),
                text = stringResource(
                    R.string.bmiresult
                ),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold

            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 50.dp),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                )
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment =  Alignment.CenterHorizontally
//                        .background(
//                            color = Color.Cyan
//                        )
                ){
                    Card (
                        modifier = Modifier
//                            .padding(10.dp)
                            .fillMaxWidth()
                            .height(160.dp)
//                            .background(color = Color.Yellow),
                    ){
                        Column (
                            modifier = Modifier
//                                .background(color = Color.Black)
                                .fillMaxSize(),
//                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment =  Alignment.CenterHorizontally
                        ){
                            Card(
                                shape = CircleShape, // Define a forma do Card como um círculo
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .size(110.dp) // Define o tamanho do Card
                                    .border(8.dp, color = bmi.bmiColor, CircleShape), // Adiciona uma borda vermelha com 4dp de espessura
                            ) {
                                Column (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    horizontalAlignment =  Alignment.CenterHorizontally
                                ){
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 38.dp)
                                            .padding(horizontal = 22.dp),
                                        color = Color.Black,
                                        text = String.format(
                                            java.util.Locale.getDefault(),
                                            "%.1f",
                                            bmi.bmi.second
                                        ),
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .padding(horizontal = 22.dp),
                                text = bmi.bmi.first,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .padding(start = 12.dp, end = 12.dp, top = 10.dp),
                             colors = CardDefaults.cardColors(containerColor = Color(0xFFA7D58B))
                    ){
                            Row (
                                modifier = Modifier
                                    .fillMaxSize()
                            ){
                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(120.dp),
//                                        .background(color = Color.Black),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        text = stringResource(
                                            R.string.age
                                        ),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        color = Color.Black,
                                        text = "$userAge",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(top = 9.dp, bottom = 9.dp)
                                        .width(1.dp)  // Largura do divisor
                                        .height(70.dp)
                                )
                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(120.dp),
//                                        .background(color = Color.Black),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        text = stringResource(
                                            R.string.weight
                                        ),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        color = Color.Black,
                                        text = "$userWeight Kg",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(top = 9.dp, bottom = 9.dp)
                                        .width(1.dp)  // Largura do divisor
                                        .height(70.dp)
                                )
                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(120.dp),
//                                        .background(color = Color.Black),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        text = stringResource(
                                            R.string.hight
                                        ),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(top = 12.dp)
                                            .padding(horizontal = 22.dp),
                                        color = Color.Black,
                                        text = String.format(java.util.Locale.getDefault(), format = "%.2f", userHight),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                    }
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                            .padding(start = 12.dp, end = 12.dp, top = 10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFA7D58B))
                    ){
                        BmiLevel(
                         bulletColor = colorResource(R.color.light_blue),
                            leftText = stringResource(R.string.underweight),
                            rightText = "< ${}",
                            isFilled = if (bmi.bmiStatus == BmiStatus.UNDER_WEIGHT) true else false
                        )
                        BmiLevel()
                        BmiLevel()
                        BmiLevel()
                        BmiLevel()
                        BmiLevel()
                    }
                    Divider(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        color = Color.Black,
                        thickness = 1.dp
                    )
                    Button(
                        onClick = {
                            navegacao.navigate(route = "dados")
                        },
                        modifier = Modifier
                            .padding(20.dp)
                            .height(80.dp)
                            .width(300.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF81AF3D)
                        )
                    ) {
                        Text(
                            text = stringResource(
                                R.string.newcalc
                            ),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun ResultPreview() {
//    ResultBMI()
}