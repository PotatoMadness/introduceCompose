package com.potatomadness.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.potatomadness.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeMain(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeMain(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            ProfileSection()
            TodayReportSection()
            HomeMenu()
        }
        BottomTabs(modifier = Modifier.align(Alignment.BottomStart))
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(10.dp)) {
        Image(
            painterResource(id = R.drawable.profile_img),
            contentDescription = null,
            modifier
                .width(56.dp)
                .height(56.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = "2024. 10. 01 | 화요일", style = MaterialTheme.typography.bodyMedium)
            Text(text = "관리자님\n즐거운 하루 보내세요", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun TodayReportSection() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Today Report", style = MaterialTheme.typography.titleLarge)
        Card(border = BorderStroke(2.dp, MaterialTheme.colorScheme.tertiary),
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            ) {
        }
    }
}

@Composable
fun HomeMenu() {
    val list = arrayListOf("메뉴1", "메뉴2", "메뉴3", "메뉴4")
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list) {
            Card(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    text = it, textAlign = TextAlign.End)
            }
        }
    }
}

@Composable
fun BottomTabs(modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(colorResource(id = R.color.teal_700))) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()) {
            Image(
                painterResource(id = R.drawable.home_black_88_dp),
                contentDescription = null,
                Modifier
                    .height(24.dp)
                    .align(Alignment.Center)
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()) {
            Image(
                painterResource(id = R.drawable.lan_black_88_dp),
                contentDescription = null,
                Modifier
                    .height(24.dp)
                    .align(Alignment.Center)
            )
        }

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()) {
            Image(
                painterResource(id = R.drawable.main_my_documents_es5),
                contentDescription = null,
                Modifier
                    .align(Alignment.Center)
                    .size(24.dp)
            )
        }
    }
}

@Preview("Home list detail screen", widthDp = 360, heightDp = 600)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeMain(Modifier.padding(innerPadding))
        }
    }
}