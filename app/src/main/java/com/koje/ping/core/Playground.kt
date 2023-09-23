package com.koje.ping.core

import android.view.MotionEvent
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface
import com.koje.ping.R
import com.koje.ping.core.boards.Board01
import com.koje.ping.core.supplies.Background

object Playground : Surface() {

    val picmap = createImageDrawer(R.drawable.picmap)
    var currentBoard = Board01()

    init {
        components.addComponent(Background())
        components.addComponent(currentBoard)

    }

    override fun onTouch(position: Position, event: MotionEvent) {
        currentBoard.onTouch(position, event)
    }

}