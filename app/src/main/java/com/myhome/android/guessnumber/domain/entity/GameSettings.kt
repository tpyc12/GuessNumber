package com.myhome.android.guessnumber.domain.entity

import java.io.Serializable

data class GameSettings (
    val minCountOfRightAnswers: Int,
    val maxSumValue: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeSeconds: Int
): Serializable