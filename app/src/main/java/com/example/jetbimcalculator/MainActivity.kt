package com.example.jetbimcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetbimcalculator.ui.theme.JetBIMCalculatorTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.input.KeyboardType


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBIMCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBIMCalculatorTheme {
        MainContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Column(
        horizontalAlignment= Alignment.Start,
        modifier = Modifier.padding(20.dp)
    ){
        Text(
            text = "BMI計算アプリ",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))

        // 身長
        PinkLabeledTextFiled(
            value = "",
            onValueChange = {},
            label = "身長(cm)",
            placeholder = "170"
        )
        Spacer(modifier = Modifier.height(20.dp))

        // 体重
        PinkLabeledTextFiled(
            value = "",
            onValueChange = {},
            label = "体重(kg)",
            placeholder = "65"
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun PinkLabeledTextFiled(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
) {
    Column {
        Text(
            text = label,
            color = Color(0xFFF85F6A),
            fontWeight = FontWeight.Bold
        )
        // テキスト入力欄
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            // 背景色設定
            colors = TextFieldDefaults.textFieldColors(
                Color.Transparent
            ),
            // 薄文字のヒント
            placeholder = { Text(text = placeholder) },
            // 入力時のキーボードを数字のやつにする
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // テキスト欄が一行のみにする
            singleLine = true,
        )
    }
}

