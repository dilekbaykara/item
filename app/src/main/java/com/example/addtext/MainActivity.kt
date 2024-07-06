package com.example.addtext

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addtext.ui.theme.AddTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = remember {mutableStateListOf<String>()}
            var text by remember { mutableStateOf("") }
            val listIndex = list.size - 1

            AddTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary

                ) {
                    Column(Modifier
                        .padding(50.dp)
                        .fillMaxWidth(),

                        horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                        Row() {
                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                label = { Text("Add input") }
                            )
                        }
                        Row( modifier = Modifier
                            .padding(20.dp)
                        ){

                            MainButton( onClick = {
                                list.add(text)
                            })

                            RemoveButton(
                                onClick = {list.removeAt(index = listIndex)

                                }

                            )
                        }
                        Column {
                            LazyColumn {
                                items(list){
                                    Text(it)

                                }
                            }
                        }


                    }



                }
            }
        }
    }
}





// Text Field Composable
//@Composable
//fun NewText() {
//    var text by remember { mutableStateOf("") }
//    TextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Add input") }
//    )
//}

@Composable
fun NewText() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Add input") }
    )
}


@Composable
fun MainButton(onClick: () -> Unit){
    ElevatedButton(onClick = { onClick() }) {
        Text("Add")
    }

    }

@Composable
fun RemoveButton(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick()}) {
        Text("Remove")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AddTextTheme {
        Greeting("Android")
    }
}