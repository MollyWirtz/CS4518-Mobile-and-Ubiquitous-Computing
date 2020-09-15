package com.bignerdranch.android.basketballscore

import androidx.annotation.StringRes

open class Team(open val score: Int){}


class TeamA (override var score: Int): Team(score = score)

class TeamB (override var score: Int): Team(score = score)