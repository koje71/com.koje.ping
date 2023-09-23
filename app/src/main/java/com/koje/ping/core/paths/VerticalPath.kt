package com.koje.ping.core.paths

import com.koje.ping.core.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromTop

class VerticalPath(board: Board, posX: Int, posY: Int) : Path(board, posX, posY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 1
            count = 100

            addProcedure {
                rotate(90f)

            }
        }

    }

    override fun enterFromTop(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromTop, locX, locY - 1)
                }
                position.x = path.posX
                position.y = path.posY + size / 2 - 0.1f * progress
            }
        }
    }

    override fun enterFromBottom(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromBottom, locX, locY + 1)
                }
                position.x = path.posX
                position.y = path.posY - size / 2 + 0.1f * progress
            }
        }
    }

}