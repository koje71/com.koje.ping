package com.koje.ping.core.paths

import com.koje.framework.graphics.ComponentGroup
import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.Name

open class Path(val board: Board, val locX: Int, val locY: Int) : ComponentGroup(Playground) {

    val size = 0.1f
    val posX = -0.45f + locX * size
    val posY = -0.65f + locY * size
    val path = this

    init {

        addProcedure {
            move(posX, posY)
            scale(size)
        }
    }

    fun enter(mobile: Mobile, direction: Name) {
        when (direction) {
            FromLeft -> enterFromLeft(mobile)
            FromTop -> enterFromTop(mobile)
            FromRight -> enterFromRight(mobile)
            FromBottom -> enterFromBottom(mobile)
            else -> {}
        }
    }

    open fun enterFromLeft(mobile: Mobile) {
    }

    open fun enterFromTop(mobile: Mobile) {
    }

    open fun enterFromRight(mobile: Mobile) {
    }

    open fun enterFromBottom(mobile: Mobile) {
    }

}