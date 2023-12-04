package com.example.jetbimcalculator.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel: ViewModel() {
    // MainViewModelではMainActivtyと違ってデータの保持が難しくて初期化されないのでrememberはいらない
    // heightの変更を監視していて、変更があったときUIの更新を行う
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    // floatに設定するため0f
    var bmi by mutableStateOf(0f)


    fun calculateBMI() {
        // 数字に変換できないならnullを返す（nullの場合0fを返す）
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNumber = weight.toFloatOrNull() ?: 0f

        // どちらも整数である場合
        bmi = if (heightNumber > 0f && weightNumber > 0f) {
            // BMI = (体重kg) / (身長m) ** 2
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}