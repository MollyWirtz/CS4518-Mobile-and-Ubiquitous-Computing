package com.bignerdranch.android.basketballscore

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class GameListViewModel : ViewModel() {
    val games = mutableListOf<Game>()

    init{
        for (i in 0 until 100) {
            val game = Game()
            game.index = "#$i"
            game.teamNames = "${getRandomName()} vs ${getRandomName()}"
            game.teamScores = "${getRandomScore()} vs ${getRandomScore()}"
            game.date = getSimpleDate()

            games += game
        }
    }

    fun getRandomName() : String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var name = ""
        for (i in 0..5) {
            name += chars[Math.floor(Math.random() * chars.length).toInt()]
        }
        return name
    }

    fun getRandomScore(): Int {
        return Random.nextInt(0, 100)
    }

    fun getSimpleDate(): String {
        val formatter = SimpleDateFormat("MM/dd/yyyy hh:mm")
        val strDate: String = formatter.format(Date())
        return strDate
    }
}