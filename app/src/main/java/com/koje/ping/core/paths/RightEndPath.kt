package com.koje.ping.core.paths

import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromLeft

class RightEndPath(board: Board, locX: Int, locY: Int) : Path(board, locX, locY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 10
            count = 100

            addProcedure {
                plane = when (board.pathsVisible) {
                    true -> 1
                    else -> -1
                }
                rotate(270f)
            }
        }

    }

    override fun enterFromBottom(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                if (!Playground.pause) {
                    progress += surface.loopTime * 0.001f * speed
                }
                if (progress >= 0.5f) {
                    progress = 1f
                    moveOut(mobile)
                } else {
                    position.x = path.posX + size / 2 - 0.1f * progress
                    position.y = path.posY
                }
            }
        }
    }

    private fun moveOut(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                if (!Playground.pause) progress += surface.loopTime * 0.001f * speed

                if (progress >= 0.5f) {
                    progress = 1f
                    board.enter(mobile, FromLeft, locX, locY - 1)
                } else {
                    position.x = path.posX + 0.1f * progress
                    position.y = path.posY
                }
            }
        }
    }
}