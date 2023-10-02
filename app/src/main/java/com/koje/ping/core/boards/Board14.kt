package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board14 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 3, listOf(
                    RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop, BottomRight, LeftRight, LeftRight, LeftRight,
                    LeftRight, LeftBottom, TopBottom, TopRight, LeftRight, LeftBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopBottom, TopBottom, TopLeft, RightLeft, RightLeft, RightLeft, RightLeft,
                    RightTop, BottomTop, BottomLeft, RightLeft
                )
            )

            addMobile(Tentaklus(this).withPosition(0.35f, +0.55f))
            addMobile(Tentaklus(this).withPosition(-0.35f, -0.55f))
            addMobile(Tentaklus(this), FromTop, 1, 6)
            addMobile(Tentaklus(this), FromBottom, 8, 6)


            addAction(Click(17000, 0.45736694f, 0.5408079f))
            addAction(Click(22340, -0.11114502f, -0.55082625f))
            addAction(BoardLoader(42000))
        }
    }

}