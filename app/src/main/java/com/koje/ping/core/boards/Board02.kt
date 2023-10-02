package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.LeftTop
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

class Board02 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 11, listOf(
                    TopRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight,
                    LeftTop, BottomLeft, RightLeft, RightLeft, RightLeft, RightLeft, RightLeft,
                    RightLeft, RightBottom
                )
            )

            addPathSequence(
                1, 9, listOf(
                    BottomRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight,
                    LeftBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopBottom, TopLeft, RightLeft, RightLeft, RightLeft, RightLeft, RightLeft,
                    RightLeft, RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop
                )
            )

            addPathSequence(
                3, 7, listOf(
                    BottomRight, LeftRight, LeftRight, LeftBottom, TopBottom, TopBottom, TopBottom,
                    TopLeft, RightLeft, RightLeft, RightTop, BottomTop, BottomTop, BottomTop
                )
            )


            addMobile(Tentaklus(this), FromLeft, 5, 11)
            addMobile(Tentaklus(this).speed(2f), FromLeft, 4, 3)
            addMobile(Tentaklus(this), FromBottom, 1, 3)

            addAction(Click(2731, 0.31292725f, 0.25469202f))
            addAction(Click(22863, -0.42687988f, 0.35931984f))
            addAction(Click(36458, 0.28607178f, -0.298985f))
            addAction(Click(61922, 0.32589722f, 0.29263893f))
            addAction(BoardLoader(79022))
        }
    }

}