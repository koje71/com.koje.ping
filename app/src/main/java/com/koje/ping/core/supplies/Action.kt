package com.koje.ping.core.supplies

import com.koje.ping.core.boards.Board

open class Action(val time: Long) {

    var processed = false

    open fun process(board: Board) {

    }
}