package com.example.compose.ui.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.compose.R

/**
 * ClassName WidgetPage
 * Author LiuHuiJie
 * Date 2023/8/29 14:40
 * Description 控件
 */
@Composable
fun WidgetPage() {
    val context = LocalContext.current
    val text = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = "name: ",
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            CircularProgressIndicator(
                color = Color.Green,
                strokeWidth = 6.dp
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            LinearProgressIndicator(
                color = Color.Red,
                backgroundColor = Color.Gray
            )
            Text(text = "身份证")
            TextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                    Toast.makeText(context, text.value, Toast.LENGTH_LONG).show()
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
        }
        Button(onClick = {
            Toast.makeText(context, "登录 ${text.value}", Toast.LENGTH_LONG).show()
        }, Modifier.background(Color.Gray)) {
            Text(text = "登录")
        }
        Image(
            painter = painterResource(id = R.drawable.ic_dog),
            contentDescription = "test bg"
        )
        Text(text = "网络图片")
        AsyncImage(
            model = "https://img0.baidu.com/it/u=2503372846,402736698&fm=253&fmt=auto&app=120&f=JPEG?w=1280&h=800",
            contentDescription = "net image"
        )
    }
}

