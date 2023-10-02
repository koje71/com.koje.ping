package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board13 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 1, listOf(
                    RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop, BottomTop, BottomTop, BottomRight, LeftRight,
                    LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopBottom, TopBottom, TopBottom, TopLeft, RightLeft, RightLeft,
                    RightLeft, RightLeft, RightLeft, RightLeft
                )
            )

            addMobile(Tentaklus(this).withPosition(0f, +0f))
            addMobile(Tentaklus(this).withPosition(0f, +0.35f))
            addMobile(Tentaklus(this).withPosition(0f, -0.35f))

            addMobile(Tentaklus(this).speed(1.5f), FromBottom, 1, 4)

            addAction(Click(11761, -0.15371704f, 0.11301925f))
            addAction(BoardLoader(27316))
        }
    }

}