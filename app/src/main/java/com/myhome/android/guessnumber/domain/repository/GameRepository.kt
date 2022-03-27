package com.myhome.android.guessnumber.domain.repository

import com.myhome.android.guessnumber.domain.entity.GameSettings
import com.myhome.android.guessnumber.domain.entity.Level
import com.myhome.android.guessnumber.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}