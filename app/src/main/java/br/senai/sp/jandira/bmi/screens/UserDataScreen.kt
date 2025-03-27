package br.senai.sp.jandira.bmi.screens

import android.content.Context
import android.media.tv.TvRecordingClient.RecordingCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssistWalker
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataFun(navegacao: NavHostController) {

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val editor = userFile.edit()

    val userName = userFile.getString("user_name", "User name not found!")

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var ageState = remember {
        mutableStateOf(value = "")
    }

    var weightState = remember {
        mutableStateOf(value = "")
    }

    var heightState = remember {
        mutableStateOf(value = "")
    }

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
                    .padding(horizontal = 10.dp),
                text = stringResource(
                    R.string.hi) + ", $userName!",
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
                        .padding(32.dp)
//                        .background(Color.Blue)
                ){
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
//                      colors = CardDefaults.cardColors(
//                          containerColor = Color.Yellow
//                      )
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
//                                .background(Color.Cyan)
                        ){
                                Card (
                                    modifier = Modifier
                                        .width(165.dp)

                                ) {
                                    Image(
                                        painter = painterResource(
                                            R.drawable.macho

                                        ),
                                        contentDescription = stringResource(
                                            R.string.logo
                                        ),
                                        modifier = Modifier
                                            .size(150.dp)
                                            .padding(start = 12.dp, top = 12.dp)
                                    )
                                    Button(
                                        modifier = Modifier
                                            .padding(start = 21.dp)
                                            .width(120.dp),
                                        onClick = {},
                                        colors = ButtonDefaults.buttonColors(
                                            Color(0xFF8FC96F)
                                        )
                                    ) {
                                        Text(
                                            text = stringResource(
                                                R.string.male
                                            )
                                        )
                                    }
                                }
                            Card(
                                modifier = Modifier
                                    .width(165.dp)

                            ) {
                                Image(
                                    painter = painterResource(
                                        R.drawable.femea

                                    ),
                                    contentDescription = stringResource(
                                        R.string.logo
                                    ),
                                    modifier = Modifier
                                        .size(150.dp)
                                        .padding(start = 12.dp, top = 12.dp)
                                )
                                Button(
                                    modifier = Modifier
                                        .padding(start = 21.dp)
                                        .width(120.dp),
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(
                                        Color(0xFF8FC96F)
                                    )
                                ) {
                                    Text(
                                        text = stringResource(
                                            R.string.female
                                        )
                                    )
                                }
                            }

                        }

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = { nome ->
                                ageState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.age)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AssistWalker,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF8FC96F)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFFEF9106),
                                cursorColor = Color(color = 0xFF8FC96F)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {nome ->
                                weightState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.weight)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF8FC96F)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFFEF9106),
                                cursorColor = Color(color = 0xFFEF9106)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {nome ->
                                heightState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.hight)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF8FC96F)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFFEF9106),
                                cursorColor = Color(color = 0xFFEF9106)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                    }

                    Button(
                        onClick = {
                            editor.putInt("age_value", ageState.value.toInt())
                            editor.putFloat("weight_value", weightState.value.toFloat())
                            editor.putFloat("height_value", heightState.value.toFloat())
                            editor.apply()
                            navegacao.navigate(route = "result")
                        },
                        modifier = Modifier
                            .padding(start = 10.dp, top = 70.dp, end = 10.dp)
                            .height(55.dp)
                            .width(300.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF8FC96F)
                        )
                    ) {
                        Text(
                            text = stringResource(
                                R.string.calcul
                            ),
                                    fontSize = 20.sp,
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
private fun UserDataPreview() {
    //UserDataFun()
}