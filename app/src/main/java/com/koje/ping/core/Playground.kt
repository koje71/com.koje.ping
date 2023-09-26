package com.koje.ping.core

import android.view.MotionEvent
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface
import com.koje.framework.utils.IntPreference
import com.koje.ping.R
import com.koje.ping.core.boards.Board
import com.koje.ping.core.boards.Board01
import com.koje.ping.core.boards.BoardBuilder
import com.koje.ping.core.supplies.Background

object Playground : Surface() {

    val picmap = createImageDrawer(R.drawable.picmap)
    var currentBoard:Board? = null
    var pause = false
    var currentGame = IntPreference("current-game",0)

    init {
        components.addComponent(Background())
        loadBoard(currentGame.get())
    }

    fun loadBoard(index:Int){
        val result = Board()
        components.addComponent(result)
        Board.builders[index].create(result)
        currentBoard = result
    }

    fun currentBoard():BoardBuilder{
        return Board.builders[currentGame.get()]
    }

    override fun onTouch(position: Position, event: MotionEvent) {
        currentBoard?.onTouch(position,event)
    }

}