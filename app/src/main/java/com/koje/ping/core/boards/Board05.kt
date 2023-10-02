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
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board05 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            addPathSequence(
                1, 2, listOf(
                    RightTop, BottomTop, BottomRight, LeftRight, LeftBottom, TopLeft, RightTop,
                    BottomTop, BottomTop, BottomTop, BottomRight, LeftBottom, TopLeft, RightLeft,
                    RightTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomRight, LeftRight,
                    LeftRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftTop, BottomLeft,
                    RightLeft, RightLeft, RightBottom, TopBottom, TopBottom, TopRight, LeftRight,
                    LeftRight, LeftBottom, TopBottom, TopLeft, RightLeft, RightLeft, RightBottom,
                    TopBottom, TopRight, LeftRight, LeftRight, LeftBottom, TopBottom, TopLeft,
                    RightLeft, RightLeft, RightBottom, TopBottom, TopRight, LeftRight, LeftTop,
                    BottomLeft, RightLeft, RightLeft, RightLeft, RightLeft, RightLeft
                )
            )

            addMobile(Tentaklus(this), FromTop, 5, 6)
            addMobile(Tentaklus(this), FromTop, 5, 9)
            addMobile(Tentaklus(this), FromTop, 5, 2)
            addMobile(Tentaklus(this), FromBottom, 1, 8)

            addAction(Click(13083, 0.2619934f, -0.22953378f))
            addAction(Click(40132, -0.20187378f, -0.4684254f))
            addAction(Click(61734, -0.39169312f, 0.05651765f))
            addAction(Click(68018, 0.24533081f, 0.27878734f))
            addAction(BoardLoader(88502))
        }
    }

}