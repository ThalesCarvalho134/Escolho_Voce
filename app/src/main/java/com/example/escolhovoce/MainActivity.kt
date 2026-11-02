package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.escolhovoce.R
import com.example.escolhovoce.ui.theme.EscolhoVoceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EscolhoVoceTheme{
                EeveeRollerApp()
            }
        }
    }
}

@Composable
fun EeveeRollerApp() {
    PokemonWithButtonAndImage()
}

@Preview(showBackground = true)
@Composable
fun PokemonWithButtonAndImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.vaporeon
        2 -> R.drawable.flareon
        3 -> R.drawable.jolteon
        4 -> R.drawable.espeon
        5 -> R.drawable.glaceon
        6 -> R.drawable.sylveon
        7 -> R.drawable.umbreon
        else -> R.drawable.leafeon
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { result = (1..8).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}