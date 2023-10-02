package com.koje.ping.core.supplies

import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board

class BoardLoader(time: Long) : Action(time) {

    override fun process(board: Board) {
        Playground.loadNext()
    }

}