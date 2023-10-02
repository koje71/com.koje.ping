package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.LeftTop
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board08 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = false

            addPathSequence(
                1, 1, listOf(
                    RightTop, BottomTop, BottomTop, BottomRight, LeftRight,
                    LeftRight, LeftTop, BottomTop, BottomLeft, RightLeft, RightLeft, RightTop,
                    BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomRight, LeftRight,
                    LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftBottom, TopBottom,
                    TopLeft, RightLeft, RightLeft, RightBottom, TopBottom, TopBottom, TopBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopLeft, RightLeft,
                    RightLeft, RightLeft
                )
            )

            addPathSequence(
                2, 2, listOf(
                    RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomRight,
                    LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftBottom, TopBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopLeft, RightLeft,
                    RightLeft, RightLeft, RightLeft, RightLeft
                )
            )


            addMobile(Tentaklus(this), FromBottom, 1, 9)
            addMobile(Tentaklus(this), FromTop, 8, 6)
            addMobile(Tentaklus(this), FromBottom, 2, 5)
            addMobile(Tentaklus(this), FromTop, 5, 5)

            addAction(Click(38242, 0.14163208f, -0.13328134f))
            addAction(Click(47729, -0.22872925f, 0.46858633f))

            addAction(Click(122837, -0.035217285f, -0.11749697f))
            addAction(Click(132738, -0.21762085f, 0.45280197f))

            addAction(BoardLoader(138019))
        }
    }

}