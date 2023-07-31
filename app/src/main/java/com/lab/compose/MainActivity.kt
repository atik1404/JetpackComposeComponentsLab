package com.lab.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.lab.compose.ui.theme.JetpackComposeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UserCardItem()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserCardItem(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Compose Lab")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {
        val modifier = Modifier.padding(it)
        Column(modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
        ){
            ConstraintLayout{
                val (userItem, addButton) = createRefs()
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(shape = RoundedCornerShape(10.dp), color = Color.White)
                        .constrainAs(userItem) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                ){
                    Column {
                        Spacer(modifier = Modifier.height(40.dp))
                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(50.dp)
                                .align(Alignment.CenterHorizontally)
                                .border(1.dp, Color.Gray, CircleShape),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Atik faysal",
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(6.dp, 5.dp))
                        Text(
                            text = "Software Engineer",
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(6.dp, 5.dp))
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                        .constrainAs(addButton) {
                            start.linkTo(userItem.start)
                            end.linkTo(userItem.end)
                            bottom.linkTo(userItem.bottom)
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun displayUser(users : List<User>){
//    LazyColumn(modifier = Modifier) {
//        items(users.size) { data ->
//            UserCardItem(users = data)
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLabTheme {
        UserCardItem()
    }
}

fun getUsers() : List<User>{
    return listOf(
        User("Atik Faysal", "Software Eng", 1),
        User("Tom cruis", "Actor", 2),
        User("Abc xyz", "Actor", 3),
    )
}

data class User(
    val name : String,
    val designation : String,
    val id : Int
)