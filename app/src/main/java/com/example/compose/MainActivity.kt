package com.example.compose
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.compose.entity.Message
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.view.Conversation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            ComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                  //  Test(name = "李梅", age = "12")
                    var messages= mutableListOf<Message>()
                    for (i in 1..100){
                        var message=Message()
                        message.name="limei $i"
                        message.message="水电费速度啊索尼大法以所发生的速度第三方速度低俗低俗水电费速水电费水电费 低俗水电费 \n sdf 低俗度是发多少低俗速度低俗低俗非氨基酸的你是你说的呢为额外二 sdf sfsf sajf lajf lajalfja lsajflsajflkas jfdsajf af jsad fsad jfdsa aj s fsa fsaf slkjf lkjlo $i"
                        messages.add(message)
                    }
                    Conversation(messages)
                }
            }
        }

    }
}


@Composable
fun Test(name: String, age: String) {
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
        Greeting(name = "111")
        Greeting(name = "222")
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = "name: $name age:$age",
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        // Test(name = "李梅", age = "12")
    }
}