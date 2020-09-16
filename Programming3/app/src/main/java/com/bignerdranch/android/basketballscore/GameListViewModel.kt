package com.bignerdranch.android.basketballscore

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameListViewModel : ViewModel() {
    val games = mutableListOf<Game>()

    init{
        for (i in 0 until 100) {
            val game = Game()
            game.index = "#$i"
            game.teamNames = "${getRandomName()} vs ${getRandomName()}"
            game.teamScores = "${getRandomScore()} vs ${getRandomScore()}"

            games += game
        }
    }

    fun getRandomName() : String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var name = ""
        for (i in 0..20) {
            name += chars[Math.floor(Math.random() * chars.length).toInt()]
        }
        return name
    }

    fun getRandomScore(): Int {
        return Random.nextInt(0, 100)
    }
}