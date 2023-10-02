package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
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

open class Board04 : BoardBuilder() {

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

            addAction(Click(2962, 0.13885498f, -0.045275427f))
            addAction(Click(25161, 0.27774048f, -0.40361282f))
            addAction(Click(49350, -0.11114502f, -0.36102724f))
            addAction(Click(54567, -0.18057251f, 0.43985233f))
            addAction(BoardLoader(62268))
        }

    }

}