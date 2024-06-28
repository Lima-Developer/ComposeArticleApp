package com.example.composearticle

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeImage(
                        title = stringResource(id = R.string.article_name),
                        firstMessage = stringResource(id = R.string.first_paragraph),
                        secondMessage = stringResource(id = R.string.second_paragraph)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ComposeText(
    title: String,
    firstMessage: String,
    secondMessage: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        ComposeTitle(
            title = title
        )
        Text(
            text = firstMessage,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = secondMessage,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Composable
fun ComposeImage(
    title: String,
    firstMessage: String,
    secondMessage: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Box(modifier) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            ComposeText(
                title = title,
                firstMessage = firstMessage,
                secondMessage = secondMessage
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ComposePreview() {
    ComposeArticleTheme {
        ComposeImage(
            title = stringResource(id = R.string.article_name),
            firstMessage = stringResource(id = R.string.first_paragraph),
            secondMessage = stringResource(id = R.string.second_paragraph)
        )
    }
}

