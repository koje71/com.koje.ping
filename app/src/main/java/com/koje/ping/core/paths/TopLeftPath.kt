package com.koje.ping.core.paths

import com.koje.ping.core.boards.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromRight

class TopLeftPath(board: Board, locX: Int, locY: Int) : Path(board, locX, locY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 0
            count = 100

            addProcedure {
                rotate(180f)
            }
        }

    }

    override fun enterFromTop(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                if(!Playground.pause) {
                    progress += surface.loopTime * 0.001f * speed
                    if (progress >= 1) {
                        progress = 1f
                        board.enter(mobile, FromRight, locX - 1, locY)
                    }
                    position.x = path.posX - size / 2 + size / 2 * cos90()
                    position.y = path.posY + size / 2 - size / 2 * sin90()
                }
            }
        }
    }

    override fun enterFromLeft(mobile: Mobile) {
        with(mobile) {
            addProcedure {
                if(!Playground.pause) {
                    progress += surface.loopTime * 0.001f * speed
                    if (progress >= 1) {
                        progress = 1f
                        board.enter(mobile, FromBottom, locX, locY + 1)
                    }
                    position.x = path.posX - size / 2 + size / 2 * sin90()
                    position.y = path.posY + size / 2 - size / 2 * cos90()
                }
            }
        }
    }

}