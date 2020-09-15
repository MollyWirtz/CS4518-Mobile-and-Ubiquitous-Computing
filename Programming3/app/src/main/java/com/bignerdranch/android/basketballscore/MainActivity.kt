package com.bignerdranch.android.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private const val TEAM_A = "teamA"
private const val TEAM_B = "teamB"


class MainActivity : AppCompatActivity() {

    private lateinit var threePointBtnA: Button
    private lateinit var threePointBtnB: Button
    private lateinit var twoPointBtnA: Button
    private lateinit var twoPointBtnB: Button
    private lateinit var freeThrowBtnA: Button
    private lateinit var freeThrowBtnB: Button
    private lateinit var resetBtn: Button
    private lateinit var scoreA: TextView
    private lateinit var scoreB: TextView

    // Create a ScoreViewModel
    private val scoreViewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve saved instance state
        val teamA = savedInstanceState?.getInt(TEAM_A, 0) ?: 0
        val teamB = savedInstanceState?.getInt(TEAM_B, 0) ?: 0
        scoreViewModel.teamA.score = teamA
        scoreViewModel.teamB.score = teamB

        // Assign variables to views
        threePointBtnA = findViewById(R.id.three_points_a)
        threePointBtnB = findViewById(R.id.three_points_b)
        twoPointBtnA = findViewById(R.id.two_points_a)
        twoPointBtnB = findViewById(R.id.two_points_b)
        freeThrowBtnA = findViewById(R.id.free_throw_a)
        freeThrowBtnB = findViewById(R.id.free_throw_b)
        resetBtn = findViewById(R.id.reset)
        scoreA = findViewById(R.id.score_a)
        scoreB = findViewById(R.id.score_b)

        // Set initial score
        scoreA.setText(scoreViewModel.teamA.score.toString())
        scoreB.setText(scoreViewModel.teamB.score.toString())

        // Set button listeners
        threePointBtnA.setOnClickListener {
            scoreViewModel.addScore(3, 'A')
            scoreA.setText(scoreViewModel.teamA.score.toString())
        }
        threePointBtnB.setOnClickListener {
            scoreViewModel.addScore(3, 'B')
            scoreB.setText(scoreViewModel.teamB.score.toString())
        }
        twoPointBtnA.setOnClickListener {
            scoreViewModel.addScore(2, 'A')
            scoreA.setText(scoreViewModel.teamA.score.toString())
        }
        twoPointBtnB.setOnClickListener {
            scoreViewModel.addScore(2, 'B')
            scoreB.setText(scoreViewModel.teamB.score.toString())
        }
        freeThrowBtnA.setOnClickListener {
            scoreViewModel.addScore(2, 'A')
            scoreA.setText(scoreViewModel.teamA.score.toString())
        }
        freeThrowBtnB.setOnClickListener {
            scoreViewModel.addScore(2, 'B')
            scoreB.setText(scoreViewModel.teamB.score.toString())
        }
        resetBtn.setOnClickListener {
            scoreViewModel.addScore(0, 'A')
            scoreViewModel.addScore(0, 'B')
            scoreA.setText(scoreViewModel.teamA.score.toString())
            scoreB.setText(scoreViewModel.teamB.score.toString())
        }

    }

    // Override the lifecycle functions to log data
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestory() called")
    }

    // Override onSaveInstanceState to save scores for each team
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(TEAM_A, scoreViewModel.teamA.score)
        savedInstanceState.putInt(TEAM_B, scoreViewModel.teamB.score)
    }
}
