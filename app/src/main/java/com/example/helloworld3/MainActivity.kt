package com.example.helloworld3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld3.ui.theme.HelloWorld3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorld3Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (modifier = Modifier.padding(vertical = 4.dp)) {
            Surface(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Column {
                    Row (modifier = Modifier.padding(24.dp)){
                        Image(
                            painter = painterResource(R.drawable.profile_picture),
                            contentDescription = "Profile picture",
                            modifier = Modifier.size(80.dp)
                        )
                    }
                    Row (modifier = Modifier.padding(24.dp)){
                        Column(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .weight(1f)
                        ){
                            Text(
                                text = "Hello,",
                                fontSize = 60.sp
                            )
                            Text(
                                text = "World!",
                                fontSize = 60.sp
                            )
                            Text(
                                text = ";)",
                                fontSize = 60.sp
                            )
                        }
                    }
                    Row (modifier = Modifier.padding(24.dp)){
                        Text(
                            text = "My name is Arya Widia Putra, an Informatics student of ITS Surabaya.",
                            fontSize = 18.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row (modifier = Modifier.padding(24.dp)){
                        val context = LocalContext.current
                        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/arya-widia-putra/")) }
                        Button(onClick = { context.startActivity(intent) }) {
                            Text(
                                text = "Get to know me"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    HelloWorld3Theme {
        MyApp()
    }
}