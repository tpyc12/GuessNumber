package com.myhome.android.guessnumber.data

import com.myhome.android.guessnumber.domain.entity.GameSettings
import com.myhome.android.guessnumber.domain.entity.Level
import com.myhome.android.guessnumber.domain.entity.Question
import com.myhome.android.guessnumber.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(
                3,
                10,
                60,
                8
            )
            Level.EASY -> GameSettings(
                5,
                10,
                80,
                60
            )
            Level.NORMAL -> GameSettings(
                10,
                10,
                100,
                60
            )
            Level.HARD -> GameSettings(
                20,
                10,
                100,
                20
            )
        }
    }
}