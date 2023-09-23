package com.koje.ping.core.paths

import com.koje.ping.core.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromTop

class BottomRightPath(board: Board, posX: Int, posY: Int) : Path(board, posX, posY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 0
            count = 100

            addProcedure {
                rotate(0f)
            }
        }

    }

    override fun enterFromRight(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromTop, locX, locY - 1)
                }
                position.x = path.posX + size / 2 - size / 2 * sin90()
                position.y = path.posY - size / 2 + size / 2 * cos90()
            }
        }
    }

    override fun enterFromBottom(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 1) {
                    progress = 1f
                    board.enter(mobile, FromLeft, locX + 1, locY)
                }
                position.x = path.posX + size / 2 - size / 2 * cos90()
                position.y = path.posY - size / 2 + size / 2 * sin90()
            }
        }
    }
}