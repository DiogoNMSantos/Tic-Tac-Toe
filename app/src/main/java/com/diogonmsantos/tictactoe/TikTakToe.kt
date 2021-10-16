package com.diogonmsantos.tictactoe

import com.diogonmsantos.tictactoe.Player.*

data class Coordinate(val x: Int, val Y: Int)

enum class Player {
    X,
    O
}

class TikTakToe {
    var lastPlayer = O
    var plays = mutableMapOf<Coordinate, Player>()

    fun play(coordinate: Coordinate): Player {

        if (plays.contains(coordinate)) {
            throw Exception("Can't play in this position")
        }

        val player = alternatePlayers()

        plays[coordinate] = player

        return player
    }

    private fun alternatePlayers(): Player {
        if (lastPlayer == O) {
            lastPlayer = X
            return lastPlayer
        }

        if (lastPlayer == X) {
            lastPlayer = O
            return lastPlayer
        }

        return lastPlayer
    }

    fun isWinner(): Boolean {
        return winnerTopRow()
                || winnerMiddleRow()
                || winnerBottomRow()
                || winnerLeftCloumn()
                || winnerMiddleColumn()
                || winnerRightCloumn()
    }

    fun reset() {
        plays.clear()
        lastPlayer = O
    }

    fun isDraw(): Boolean {
        if(!isWinner()) {
           return plays.size == 9
        }

        return false
    }

    fun winningCoordinates(): List<Coordinate> {
        if (!isWinner())
            return emptyList()

        if(winnerTopRow()) return listOf(Coordinate(0,2), Coordinate(1,2), Coordinate(2,2))
        if(winnerMiddleRow()) return listOf(Coordinate(0,1), Coordinate(1,1), Coordinate(2,1))
        if(winnerBottomRow()) return listOf(Coordinate(0,0), Coordinate(1,0), Coordinate(2,0))
        if(winnerLeftCloumn()) return listOf(Coordinate(0,0), Coordinate(0,1), Coordinate(0,2))
        if(winnerMiddleColumn()) return listOf(Coordinate(1,0), Coordinate(1,1), Coordinate(1,2))
        if(winnerRightCloumn()) return listOf(Coordinate(2,0), Coordinate(2,1), Coordinate(2,2))

        return emptyList()
    }

    private fun winnerTopRow() = (plays[Coordinate(0, 2)] == lastPlayer &&
            plays[Coordinate(1, 2)] == lastPlayer &&
            plays[Coordinate(2, 2)] == lastPlayer)

    private fun winnerMiddleRow() = (plays[Coordinate(0, 1)] == lastPlayer &&
            plays[Coordinate(1, 1)] == lastPlayer &&
            plays[Coordinate(2, 1)] == lastPlayer)

    private fun winnerBottomRow() = (plays[Coordinate(0, 0)] == lastPlayer &&
            plays[Coordinate(1, 0)] == lastPlayer &&
            plays[Coordinate(2, 0)] == lastPlayer)

    private fun winnerLeftCloumn() = (plays[Coordinate(0, 0)] == lastPlayer &&
            plays[Coordinate(0, 1)] == lastPlayer &&
            plays[Coordinate(0, 2)] == lastPlayer)

    private fun winnerMiddleColumn() = (plays[Coordinate(1, 0)] == lastPlayer &&
            plays[Coordinate(1, 1)] == lastPlayer &&
            plays[Coordinate(1, 2)] == lastPlayer)

    private fun winnerRightCloumn() = (plays[Coordinate(2, 0)] == lastPlayer &&
            plays[Coordinate(2, 1)] == lastPlayer &&
            plays[Coordinate(2, 2)] == lastPlayer)
}

