package com.bignerdranch.android.basketballscore

import java.util.*

data class Game (
    var index: Int = 0,
    var teamA: TeamA = TeamA("", 0),
    var teamB: TeamB = TeamB("", 0),
    var date: Date = Date()
    ){

}