package com.koje.ping.core.paths

import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromTop

class BottomRightPath(board: Board, locX: Int, locY: Int) : Path(board, locX, locY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 0
            count = 100

            addProcedure {
                plane = when (isVisible()) {
                    true -> 1
                    else -> -1
                }
                rotate(0f)
            }
        }

    }

    override fun enterFromRight(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                if (!Playground.pause) progress += surface.loopTime * 0.001f * speed

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
                if (!Playground.pause) progress += surface.loopTime * 0.001f * speed

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