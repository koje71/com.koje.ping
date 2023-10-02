package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.LeftTop
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board10 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            listOf(1, 6).forEach { locX ->
                listOf(1, 9).forEach { locY ->
                    addPathSequence(
                        locX, locY, listOf(
                            TopRight, LeftRight, LeftTop, BottomTop, BottomTop, BottomLeft,
                            RightLeft, RightBottom, TopBottom, TopBottom
                        )
                    )
                }
            }

            addMobile(Tentaklus(this), FromBottom, 1, 2)
            addMobile(Tentaklus(this), FromTop, 6, 2)
            addMobile(Tentaklus(this), FromBottom, 3, 11)
            addMobile(Tentaklus(this), FromTop, 8, 11)

            addAction(Click(10945, -0.040771484f, -0.6314232f))
            addAction(Click(17537, 0.015716553f, 0.41762537f))
            addAction(BoardLoader(25000))
        }
    }

}