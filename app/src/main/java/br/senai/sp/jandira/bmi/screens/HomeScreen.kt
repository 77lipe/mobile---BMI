package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
fun HomeScreen(navegacao: NavHostController) {

    var nameState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    // Abrir ou criar um arquivo SharedPreferences
    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    //Colocar o arquivo em modo de edição
    val editor = userFile.edit()


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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment =  Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(
                R.drawable.workout
            ),
            contentDescription = stringResource(
                R.string.logo
            ),
            modifier = Modifier
                .padding(top = 60.dp)
        )
        Text(
            text = stringResource(
                R.string.welcome
            ),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = RoundedCornerShape(
                topStart = 40.dp,
                topEnd = 40.dp
            ),
            colors = CardDefaults
                .cardColors(
                    containerColor = Color.White
                ),


        ){ Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()

            ){
                Text(
                    text = stringResource(
                        R.string.your_name
                    ),
                    color = Color.Black,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold

                )
                OutlinedTextField(
                    value = nameState.value,
                    onValueChange = {
                        nameState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(R.string.your_name)) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                        capitalization = KeyboardCapitalization.Words
                    ),
//                    trailingIcon = {},
                    trailingIcon = {
                        if ( isErrorState.value){
                            Icon(
                                imageVector = Icons.Default.ErrorOutline,
                                contentDescription = "",
                                tint = Color.Red
                            )
                        }else{
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = "",
                                tint = Color(color = 0xFF8FC96F)
                            )
                        }
                    },

                    isError = isErrorState.value,
                    supportingText = {
                        if ( isErrorState.value){
                            Text(
                                text = stringResource(R.string.error_name)
                            )
                        }
                    }

                )
            }
            Button(
                onClick = {
                    if (nameState.value.isEmpty()){
                        isErrorState.value = true
                    } else {
                        editor.putString("user_name", nameState.value)
                        editor.apply()
                        navegacao.navigate(route = "dados")
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF8FC96F)
                )
            ) {
                Text(
                    text = stringResource(
                        R.string.next
                    )
                )
            }
        }


        }
    }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
//        HomeScreen(navegacao)
}