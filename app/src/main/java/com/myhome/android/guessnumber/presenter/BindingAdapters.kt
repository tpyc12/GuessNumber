package com.myhome.android.guessnumber.presenter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.myhome.android.guessnumber.R
import com.myhome.android.guessnumber.domain.entity.GameResult

@BindingAdapter("requireAnswers")
fun bindRequireAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_right_answers),
        count
    )
}

@BindingAdapter("countOfRightAnswers")
fun bindCountOfRightAnswers(textView: TextView, score: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.count_of_right_answers),
        score
    )
}

@BindingAdapter("requirePercent")
fun bindRequirePercent(textView: TextView, percentage: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage_of_right_answers),
        percentage
    )
}

@BindingAdapter("minPercentOfRightAnswers")
fun bindMinPercentOfRightAnswers(textView: TextView, gameResult: GameResult){
    textView.text = String.format(
       textView.context.getString(R.string.right_answers_percentage),
        getPercentageOfRightAnswers(gameResult)
    )
}

@BindingAdapter("smile")
fun bindSmile(imageView: ImageView, winner: Boolean){
    imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.outline_emoji_emotions_24
    } else {
        R.drawable.outline_sentiment_dissatisfied_24
    }
}

private fun getPercentageOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfRightAnswers == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}