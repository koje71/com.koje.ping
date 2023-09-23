package com.koje.ping.core.paths

import com.koje.ping.core.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromTop

class BottomEndPath(board: Board, posX: Int, posY: Int) : Path(board, posX, posY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 10
            count = 100

            addProcedure {
                rotate(270f)
            }
        }

    }

    override fun enterFromBottom(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 0.5f) {
                    progress = 1f
                    moveOut(mobile)
                } else {
                    position.x = path.posX
                    position.y = path.posY - size / 2 + 0.1f * progress
                }
            }
        }
    }

    private fun moveOut(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                progress += surface.loopTime * 0.001f * speed
                if (progress >= 0.5f) {
                    progress = 1f
                    board.enter(mobile, FromTop, locX, locY - 1)
                } else {
                    position.x = path.posX
                    position.y = path.posY - 0.1f * progress
                }
            }
        }
    }
}