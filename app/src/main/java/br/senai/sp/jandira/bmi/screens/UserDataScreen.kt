package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserDataFun(modifier: Modifier = Modifier) {

    var nameState = remember {
        mutableStateOf("Senai")
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
                    .padding(horizontal = 22.dp),
                text = stringResource(
                    br.senai.sp.jandira.bmi.R.string.hi
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
                                            br.senai.sp.jandira.bmi.R.drawable.macho

                                        ),
                                        contentDescription = stringResource(
                                            br.senai.sp.jandira.bmi.R.string.logo
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
                                                br.senai.sp.jandira.bmi.R.string.male
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
                                        br.senai.sp.jandira.bmi.R.drawable.femea

                                    ),
                                    contentDescription = stringResource(
                                        br.senai.sp.jandira.bmi.R.string.logo
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
                                            br.senai.sp.jandira.bmi.R.string.female
                                        )
                                    )
                                }
                            }

                        }

                    }
                    OutlinedTextField(
                        value = nameState.value,
                        onValueChange = {
                            nameState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                }
            }
        }
    }


}


@Preview(showSystemUi = true)
@Composable
private fun UserDataPreview() {
    UserDataFun()
}