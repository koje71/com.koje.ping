package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board15 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addPathSequence(
                1, 12, listOf(
                    BottomRight, LeftRight, LeftRight, LeftRight, LeftRight, LeftRight,
                    LeftRight, LeftBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopLeft, RightLeft, RightTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop, BottomLeft, RightLeft, RightLeft,
                    RightBottom, TopBottom, TopBottom, TopBottom, TopBottom, TopBottom,
                    TopLeft, RightLeft, RightTop, BottomTop, BottomTop, BottomTop,
                    BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                    BottomTop
                )
            )

            //addMobile(Tentaklus(this).withPosition(-0.35f, -0.55f))
            addMobile(Tentaklus(this), FromTop, 1, 3)
            addMobile(Tentaklus(this), FromBottom, 8, 7)
            addMobile(Tentaklus(this), FromRight, 5, 12)


            addAction(Click(17531, -0.019470215f, 0.1954201f))
            addAction(Click(27261, -0.30371094f, -0.50824064f))
            addAction(BoardLoader(34000))
        }
    }

}