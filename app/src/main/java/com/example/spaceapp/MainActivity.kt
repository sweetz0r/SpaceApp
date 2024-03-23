package com.example.spaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceapp.ui.theme.SpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtworkWork()
                }
            }
        }
    }
}

@Composable
fun ArtworkDisp(
    drawableResourceId: Int,
    textTitleId: Int,
    contentDescriptionResourceId: Int,
    clickNext: () -> Unit,
    clickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

    ) {
        Image(
            painter = painterResource(id = drawableResourceId),
            contentDescription = stringResource(id = contentDescriptionResourceId)
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Text(
            text = stringResource(id = textTitleId),
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(color = Color.LightGray)
        )
    }
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(width = 90.dp, height = 40.dp,)
            .padding(bottom = 32.dp)


    ) {

        Button(
            onClick = clickBack,
            //modifier = Modifier.size(width = 105.dp, height = 40.dp)
                //.padding(bottom = 32.dp)
            ) {

            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.padding(32.dp))
        Button(
            onClick = clickNext,
            //modifier = Modifier.size(width = 105.dp, height = 40.dp)
                //./padding(bottom = 32.dp)
            ) {
            Text(text = "Next")
        }

    }
}

@Composable
fun ArtworkWork() {
    var currentStep by remember { mutableStateOf(1) }
    when(currentStep) {
        1 -> {
            ArtworkDisp(
                drawableResourceId = R.drawable.galleriatbilisi,
                textTitleId = R.string.GalleriTbilisi,
                contentDescriptionResourceId = R.string.GalleriTbilisi,
                clickNext = {
                    currentStep++
                },
                clickBack = { })
        }
        2 -> {
            ArtworkDisp(
                drawableResourceId = R.drawable.kanattbilisi,
                textTitleId = R.string.KanatTbilisi,
                contentDescriptionResourceId = R.string.KanatTbilisi,
                clickNext = { currentStep++},
                clickBack = { currentStep--})
        }
        3 -> {
            ArtworkDisp(
                drawableResourceId = R.drawable.oldcity,
                textTitleId = R.string.OldCity,
                contentDescriptionResourceId = R.string.OldCity,
                clickNext = { currentStep = 1 },
                clickBack = { currentStep-- })
        }
    }

}
