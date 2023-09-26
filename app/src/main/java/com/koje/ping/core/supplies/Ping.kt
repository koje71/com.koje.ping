package com.koje.ping.core.supplies

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.ping.core.boards.Board
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
            if(!Playground.pause) {
                size += 0.0002f * surface.loopTime

                if (size > 1f) {
                    opacity = 2f - size
                }
                if (size > 2f) {
                    remove()
                }

                checkCollision()
            }
            move(position)
            scale(size)
        }
    }

    private fun remove(){
        board.pings--
        if (board.pings == 0) {
            var solvedCount = 0
            board.order = 1
            board.mobiles.forEach {
                if(it.state==Solved){
                    solvedCount++
                }
                it.state = Undefined
            }

            if(solvedCount==board.mobiles.size){
                Playground.currentBoard().solved.increase()
            }
        }
        death = true
    }

    private fun checkCollision(){
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
    }

}