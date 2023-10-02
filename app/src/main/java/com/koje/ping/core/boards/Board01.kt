package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomEnd
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.LeftTop
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopEnd
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

class Board01 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 2, listOf(
                    TopRight, LeftRight, LeftRight, LeftBottom,
                    TopLeft, RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomLeft,
                    RightLeft, RightBottom, TopBottom, TopBottom, TopBottom
                )
            )


            addPathSequence(
                3, 8, listOf(
                    TopBottom, TopRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftTop,
                    BottomTop, BottomTop, BottomTop, BottomTop, BottomLeft, RightLeft, RightBottom,
                    TopBottom, TopBottom, TopLeft, RightLeft, RightLeft, RightBottom
                )
            )

            addPathSequence(
                7, 2, listOf(
                    TopEnd, BottomTop, BottomTop, BottomEnd
                )
            )


            addMobile(Tentaklus(this), FromBottom, 3, 2)
            addMobile(Tentaklus(this), FromRight, 4, 7)
            addMobile(Tentaklus(this), FromTop, 7, 3)

            addAction(Click(6516, -0.14260864f, 0.03248675f))
            addAction(Click(36797, -0.25836182f, -0.036964472f))
            addAction(Click(71718, -0.29815674f, 0.0482067f))
            addAction(BoardLoader(85000))

        }
    }

}