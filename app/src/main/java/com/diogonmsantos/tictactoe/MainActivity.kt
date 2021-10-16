package com.diogonmsantos.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val game = TikTakToe()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onReset(view: android.view.View) {
        game.reset()

        for(x:Int in 0..2) {
            for (y: Int in 0..2) {
                val cellId = resources.getIdentifier(
                    "Cell_${x}_${y}",
                    "id",
                    packageName
                )

                val cell = findViewById<TextView>(cellId)
                cell.text = " "
                cell.setTextColor(Color.GRAY);
            }
        }

        val reset = findViewById<TextView>(R.id.reset)
        reset.isEnabled = false

        val status = findViewById<TextView>(R.id.status)
        status.setTextColor(Color.parseColor("#000000"));
        status.text = "NO WINNER YET"
    }

    fun onClick(cell: View) {
        val gameCell = cell as TextView
        val idParts = gameCell.tag.toString().split("_")
        val x = idParts[0].toInt()
        val Y = idParts[1].toInt()
        val coordinate = Coordinate(x, Y)
        var player: Player

        val status = findViewById<TextView>(R.id.status)

        if(game.isWinner()) {
            return
        }

        try {
             player = game.play(coordinate)
        }
        catch (exception: Exception) {
            status.text = exception.message
            status.setTextColor(Color.parseColor("#FF0000"));
            return
        }

        gameCell.text = player.toString()

        if(game.isWinner()) {
            DisplayWinner(status, player)
            val reset = findViewById<TextView>(R.id.reset)
            reset.isEnabled = true
            return
        }

        if(game.isDraw()) {
            status.text = "Draw"
            status.setTextColor(Color.MAGENTA);
            val reset = findViewById<TextView>(R.id.reset)
            reset.isEnabled = true
            return
        }

        status.setTextColor(Color.parseColor("#000000"));
        status.text = "NO WINNER YET"
    }

    private fun DisplayWinner(
        status: TextView,
        player: Player
    ) {
        status.text = "Player ${player.toString()} wins"
        status.setTextColor(Color.parseColor("#00FF00"));

        val coordinates = game.winningCoordinates()

        for (coordinate: Coordinate in coordinates) {
            val cellId = resources.getIdentifier(
                "Cell_${coordinate.x}_${coordinate.Y}",
                "id",
                packageName
            )

            val cell = findViewById<TextView>(cellId)
            cell.setTextColor(Color.parseColor("#00FF00"));
        }
    }
}