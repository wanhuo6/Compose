package com.example.compose.ui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.entity.BottomNavigationItemEntity
import com.example.compose.ui.pages.*
import com.example.compose.ui.pages.WidgetPage
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            ComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    Main()
                }
            }
        }

    }
}

@Composable
fun Main() {
    var currentIndex by remember {
        mutableStateOf(0)
    }
    var currentTitle by remember {
        mutableStateOf("")
    }
    val navigationItems= listOf(
        BottomNavigationItemEntity("首页", Icons.Default.Home),
        BottomNavigationItemEntity("控件", Icons.Default.Widgets),
        BottomNavigationItemEntity("网络", Icons.Default.NetworkCell),
        BottomNavigationItemEntity("个人", Icons.Default.Person)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(text = currentTitle, fontSize = 15.sp)
                    }
                },
            )
        },
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White, modifier = Modifier.navigationBarsPadding()) {
                navigationItems.forEachIndexed { index, bottomNavigationItemEntity ->
                    BottomNavigationItem(
                        selected = currentIndex==index,
                        onClick = { currentIndex=index},
                        icon = {
                            Icon(bottomNavigationItemEntity.icon , bottomNavigationItemEntity.name)
                        },
                        label = {
                            Text(text = bottomNavigationItemEntity.name)
                        },
                        selectedContentColor = Color.Blue,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        },
        drawerContent =  {
            Drawer()
        },
        content = {
            var paddingValues=it
            currentTitle=navigationItems[currentIndex].name
            when(currentIndex){
                0-> HomePage()
                1-> WidgetPage()
                2-> NetPage()
                3-> MinePage()
            }
        },
    )
}
@Composable
fun Drawer(){
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(Icons.Default.Favorite, contentDescription ="")
        Text(text = "drawer")
    }
}

