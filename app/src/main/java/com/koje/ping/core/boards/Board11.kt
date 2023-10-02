package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board11 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 1, listOf(
                    RightTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight,
                    LeftRight, LeftBottom, TopBottom, TopBottom, TopBottom, TopLeft,
                    RightLeft, RightLeft, RightLeft, RightLeft, RightBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopLeft, RightLeft
                )
            )

            addMobile(Tentaklus(this).withPosition(0.35f, -0.20f))
            addMobile(Tentaklus(this), FromBottom, 1, 9)
            addMobile(Tentaklus(this).withPosition(0.2f, -0.32f))
            addMobile(Tentaklus(this), FromBottom, 1, 6)
            addMobile(Tentaklus(this), FromBottom, 1, 3)

            addAction(Click(21712, 0.35549927f, -0.010098832f))
            addAction(BoardLoader(40000))
        }
    }

}