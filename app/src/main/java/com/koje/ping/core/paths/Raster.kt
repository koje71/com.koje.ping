package com.koje.ping.core.paths

import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board

class Raster(board: Board, locX: Int, locY: Int) : Path(board, locX, locY) {

    init {

        addImageComponent {
            image = Playground.picmap
            index = 38
            count = 400

            addProcedure {
                //scale(1.05f)
            }
        }

    }

}