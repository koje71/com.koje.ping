package com.koje.ping.core.supplies

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.ping.core.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.names.Failed
import com.koje.ping.core.names.Open
import com.koje.ping.core.names.Solved
import com.koje.ping.core.names.Undefined

class Ping(val board: Board, val position: Position) : ComponentGroup(Playground) {

    var size = 0f

    init {
        if (board.pings == 0) {
            board.mobiles.forEach {
                it.state = Open
            }
        }

        board.pings++
        board.power.value = 0f

        addImageComponent {
            image = Playground.picmap
            index = 2
            count = 4
        }

        addProcedure {
            size += 0.0002f * surface.loopTime

            if (size > 1f) {
                opacity = 2f - size
            }
            if (size > 2f) {
                board.pings--
                if (board.pings == 0) {
                    board.order = 1
                    board.mobiles.forEach {
                        it.state = Undefined
                    }
                }
                death = true
            }

            board.mobiles.forEach {
                val distance = it.position.distanceTo(position)
                if (it.state == Open && distance < size / 2) {
                    if (board.order == it.number) {
                        board.order++
                        it.state = Solved
                    } else {
                        it.state = Failed
                    }
                }
            }


            move(position)
            scale(size)
        }
    }


}