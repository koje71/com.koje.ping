package com.koje.ping.core

import android.view.MotionEvent
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface
import com.koje.framework.utils.StringPreference
import com.koje.ping.R
import com.koje.ping.core.boards.Board
import com.koje.ping.core.boards.Board01
import com.koje.ping.core.boards.BoardBuilder
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.ToLeft
import com.koje.ping.core.names.ToRight
import com.koje.ping.core.supplies.Background
import com.koje.ping.view.GameSection
import com.koje.ping.view.ScoresSection

object Playground : Surface() {

    val picmap = createImageDrawer(R.drawable.picmap)
    var currentName = StringPreference("current-board", "Board01")
    var currentBuilder = findCurrentBuilder()
    var currentBoard: Board? = null
    var pause = false

    init {
        components.addComponent(Background())
        loadBoard(currentBuilder)
    }

    fun findCurrentBuilder(): BoardBuilder {
        Board.builders.forEach {
            if (currentName.contains(it.name)) {
                return it
            }
        }
        return Board01()
    }

    fun loadBoard(builder: BoardBuilder) {
        val oldPos = Board.builders.indexOf(currentBuilder)
        val newPos = Board.builders.indexOf(builder)

        currentBuilder = builder
        GameSection.boardNumber.set(Board.builders.indexOf(builder))
        ScoresSection.required.set(currentBuilder.required.get())
        currentName.set(builder.name)
        var increase = false
        components.components.forEach {
            if (it is Board) {
                increase = true

                it.decrease(
                    when (oldPos < newPos) {
                        true -> ToLeft
                        else -> ToRight
                    }
                )
            }
        }
        val result = Board()
        currentBoard = result
        components.addComponent(result)
        builder.create(result)

        if (increase) {
            result.increase(
                when (oldPos < newPos) {
                    true -> FromRight
                    else -> FromLeft
                }
            )
        }

    }


    override fun onTouch(position: Position, event: MotionEvent) {
        currentBoard?.onTouch(position, event)
    }

}