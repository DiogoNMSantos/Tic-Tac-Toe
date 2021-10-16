package com.diogonmsantos.tictactoe

import com.diogonmsantos.tictactoe.Player.X
import com.diogonmsantos.tictactoe.Player.O
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class TikTakToeShould {
    @Test
    fun `The first player must be X`() {
        var game = TikTakToe()

        var player = game.play(Coordinate(0, 1))

        assertEquals(X, player)
    }

    @Test
    fun `The second player must be O`() {
        var game = TikTakToe()

        var player = game.play(Coordinate(0, 1))
        player = game.play(Coordinate(1, 1))

        assertEquals(O, player)
    }

    @Test
    fun `Not allow a player to play on last position`() {
        var game = TikTakToe()

        game.play( Coordinate(0,0))

        assertThrows<Exception> { game.play( Coordinate(0,0)) }
    }

    @Test
    fun `Not allow player to play on any played position`() {
        var game = TikTakToe()

        game.play(Coordinate(0,0))
        game.play(Coordinate(1,1))

        assertThrows<Exception> { game.play( Coordinate(0,0)) }
    }

    @Test
    fun `Declare playerX winner on top row`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(0,2))
        game.play(Coordinate(0,0))
        game.play(Coordinate(1,2))
        game.play(Coordinate(1,1))
        game.play(Coordinate(2,2))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `Declare playerX winner on middle row`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(0,1))
        game.play(Coordinate(0,0))
        game.play(Coordinate(1,1))
        game.play(Coordinate(1,2))
        game.play(Coordinate(2,1))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `Declare playerX winner on bottom row`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(0,0))
        game.play(Coordinate(0,1))
        game.play(Coordinate(1,0))
        game.play(Coordinate(1,2))
        game.play(Coordinate(2,0))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `Declare playerX winner on left column`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(0,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(0,1))
        game.play(Coordinate(1,2))
        game.play(Coordinate(0,2))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `Declare playerX winner on Middle column`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(1,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(1,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(1,2))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `Declare playerX winner on right column`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(2,0))
        game.play(Coordinate(1,1))
        game.play(Coordinate(2,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(2,2))

        isWinner = game.isWinner()
        assertTrue(isWinner)
    }

    @Test
    fun `share no coordinates when there is no winner`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(0,2))
        game.play(Coordinate(0,0))
        game.play(Coordinate(1,2))
        game.play(Coordinate(1,1))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, emptyList<Coordinate>());
    }

    @Test
    fun `share top row winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(0,2))
        game.play(Coordinate(0,0))
        game.play(Coordinate(1,2))
        game.play(Coordinate(1,1))
        game.play(Coordinate(2,2))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(0,2), Coordinate(1,2), Coordinate(2,2)));
    }

    @Test
    fun `share middle row winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(0,1))
        game.play(Coordinate(0,0))
        game.play(Coordinate(1,1))
        game.play(Coordinate(1,2))
        game.play(Coordinate(2,1))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(0,1), Coordinate(1,1), Coordinate(2,1)));
    }

    @Test
    fun `share bottom row winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(0,0))
        game.play(Coordinate(0,1))
        game.play(Coordinate(1,0))
        game.play(Coordinate(1,2))
        game.play(Coordinate(2,0))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(0,0), Coordinate(1,0), Coordinate(2,0)));
    }

    @Test
    fun `share left column winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(0,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(0,1))
        game.play(Coordinate(1,2))
        game.play(Coordinate(0,2))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(0,0), Coordinate(0,1), Coordinate(0,2)));
    }

    @Test
    fun `share middle column winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(1,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(1,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(1,2))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(1,0), Coordinate(1,1), Coordinate(1,2)));
    }

    @Test
    fun `share right column winner coordinates`() {
        var game = TikTakToe()
        var winnerCoordinates = emptyList<Coordinate>()

        game.play(Coordinate(2,0))
        game.play(Coordinate(1,1))
        game.play(Coordinate(2,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(2,2))

        winnerCoordinates = game.winningCoordinates()

        assertEquals(winnerCoordinates, listOf(Coordinate(2,0), Coordinate(2,1), Coordinate(2,2)));
    }

    @Test
    fun `Restart the game after winning`() {
        var game = TikTakToe()
        var isWinner = false

        game.play(Coordinate(1,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(1,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(1,2))

        isWinner = game.isWinner()
        assertTrue(isWinner)

        game.reset()

        isWinner = game.isWinner()
        assertFalse(isWinner)

    }

    @Test
    fun `Declare draw`() {
        var game = TikTakToe()
        var isDraw = false

        game.play(Coordinate(1,0))
        game.play(Coordinate(0,0))
        game.play(Coordinate(0,1))
        game.play(Coordinate(1,1))
        game.play(Coordinate(0,2))
        game.play(Coordinate(2,0))
        game.play(Coordinate(2,1))
        game.play(Coordinate(1,2))
        game.play(Coordinate(2,2))

        isDraw = game.isDraw()
        assertTrue(isDraw)
    }
}