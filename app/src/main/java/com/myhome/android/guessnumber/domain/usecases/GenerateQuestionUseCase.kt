package com.myhome.android.guessnumber.domain.usecases

import com.myhome.android.guessnumber.domain.entity.Question
import com.myhome.android.guessnumber.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    companion object {

        private const val COUNT_OF_OPTIONS = 6
    }
}