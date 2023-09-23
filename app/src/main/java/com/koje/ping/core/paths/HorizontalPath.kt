package com.koje.ping.core.paths

import com.koje.ping.core.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromRight

class HorizontalPath(board: Board, posX: Int, posY: Int) : Path(board, posX, posY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 1
            count = 100
        }

    }

    override fun enterFromRight(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromRight, locX - 1, locY)
                }
                position.x = path.posX + size / 2 - 0.1f * progress
                position.y = path.posY
            }
        }
    }

    override fun enterFromLeft(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromLeft, locX + 1, locY)
                }
                position.x = path.posX - size / 2 + 0.1f * progress
                position.y = path.posY
            }
        }
    }

}