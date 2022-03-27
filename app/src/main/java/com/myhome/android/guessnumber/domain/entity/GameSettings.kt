package com.myhome.android.guessnumber.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val minCountOfRightAnswers: Int,
    val maxSumValue: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeSeconds: Int
) : Parcelable