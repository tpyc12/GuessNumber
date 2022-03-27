package com.myhome.android.guessnumber.domain.usecases

import com.myhome.android.guessnumber.domain.entity.GameSettings
import com.myhome.android.guessnumber.domain.entity.Level
import com.myhome.android.guessnumber.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}