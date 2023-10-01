package com.koje.ping.core.supplies

import com.koje.framework.graphics.Position
import com.koje.ping.core.boards.Board

class Click(time: Long, val xPos: Float, val yPos: Float) : Action(time) {

    override fun process(board: Board) {
        board.addComponent(Ping(board, Position(xPos, yPos)))
    }

}