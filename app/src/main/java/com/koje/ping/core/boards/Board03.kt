package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.paths.BottomLeftPath
import com.koje.ping.core.paths.BottomRightPath
import com.koje.ping.core.paths.HorizontalPath
import com.koje.ping.core.paths.TopLeftPath
import com.koje.ping.core.paths.TopRightPath
import com.koje.ping.core.paths.VerticalPath
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

class Board03 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true
            add(TopRightPath(this, 1, 2))
            add(VerticalPath(this, 1, 3))
            add(BottomRightPath(this, 1, 4))
            add(VerticalPath(this, 2, 4))
            add(HorizontalPath(this, 2, 4))
            add(BottomLeftPath(this, 3, 4))
            add(TopRightPath(this, 2, 3))
            add(TopLeftPath(this, 3, 3))

            add(VerticalPath(this, 2, 5))

            add(VerticalPath(this, 2, 6))
            add(HorizontalPath(this, 2, 6))

            add(BottomRightPath(this, 2, 7))
            add(BottomLeftPath(this, 3, 7))
            add(TopLeftPath(this, 3, 6))

            add(TopRightPath(this, 1, 6))
            add(VerticalPath(this, 1, 7))
            add(VerticalPath(this, 1, 8))
            add(VerticalPath(this, 1, 9))
            add(VerticalPath(this, 1, 10))

            add(BottomRightPath(this, 1, 11))
            add(HorizontalPath(this, 2, 11))
            add(HorizontalPath(this, 3, 11))
            add(HorizontalPath(this, 4, 11))
            add(HorizontalPath(this, 5, 11))
            add(HorizontalPath(this, 6, 11))
            add(HorizontalPath(this, 7, 11))
            add(TopLeftPath(this, 8, 11))
            add(BottomLeftPath(this, 8, 12))
            add(HorizontalPath(this, 7, 12))
            add(HorizontalPath(this, 6, 12))
            add(BottomRightPath(this, 5, 12))
            add(VerticalPath(this, 5, 11))

            add(VerticalPath(this, 5, 10))
            add(TopRightPath(this, 5, 9))
            add(HorizontalPath(this, 6, 9))
            add(HorizontalPath(this, 7, 9))
            add(BottomLeftPath(this, 8, 9))
            add(VerticalPath(this, 8, 8))
            add(TopLeftPath(this, 8, 7))
            add(HorizontalPath(this, 7, 7))
            add(HorizontalPath(this, 6, 7))
            add(BottomRightPath(this, 5, 7))

            add(VerticalPath(this, 5, 6))
            add(TopRightPath(this, 5, 5))
            add(HorizontalPath(this, 6, 5))
            add(HorizontalPath(this, 7, 5))
            add(BottomLeftPath(this, 8, 5))

            add(VerticalPath(this, 8, 4))
            add(TopLeftPath(this, 8, 3))
            add(HorizontalPath(this, 7, 3))
            add(HorizontalPath(this, 6, 3))
            add(BottomRightPath(this, 5, 3))

            add(VerticalPath(this, 5, 2))
            add(TopRightPath(this, 5, 1))
            add(HorizontalPath(this, 6, 1))
            add(TopLeftPath(this, 7, 1))
            add(BottomLeftPath(this, 7, 2))
            add(HorizontalPath(this, 6, 2))
            add(HorizontalPath(this, 5, 2))
            add(HorizontalPath(this, 4, 2))
            add(HorizontalPath(this, 3, 2))
            add(HorizontalPath(this, 2, 2))

            add(Tentaklus(this), FromTop, 5, 6)
            add(Tentaklus(this), FromTop, 5, 9)
            add(Tentaklus(this), FromTop, 5, 2)

            add(Click(2962, 0.13885498f, -0.045275427f))
            add(Click(25161, 0.27774048f, -0.40361282f))
            add(Click(49350, -0.11114502f, -0.36102724f))
            add(Click(54567, -0.18057251f, 0.43985233f))
            add(BoardLoader(62268, 3))
        }
    }

}