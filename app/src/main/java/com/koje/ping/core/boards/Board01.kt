package com.koje.ping.core.boards

import com.koje.ping.core.Board
import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.paths.BottomEndPath
import com.koje.ping.core.paths.BottomLeftPath
import com.koje.ping.core.paths.BottomRightPath
import com.koje.ping.core.paths.HorizontalPath
import com.koje.ping.core.paths.TopEndPath
import com.koje.ping.core.paths.TopLeftPath
import com.koje.ping.core.paths.TopRightPath
import com.koje.ping.core.paths.VerticalPath

class Board01 : Board() {

    init {
        add(TopRightPath(this, 1, 2))
        add(HorizontalPath(this, 2, 2))
        add(HorizontalPath(this, 3, 2))
        add(BottomLeftPath(this, 4, 2))
        add(TopLeftPath(this, 4, 1))
        add(TopRightPath(this, 3, 1))
        add(VerticalPath(this, 3, 2))
        add(VerticalPath(this, 3, 3))
        add(VerticalPath(this, 3, 4))
        add(VerticalPath(this, 3, 5))
        add(BottomLeftPath(this, 3, 6))
        add(HorizontalPath(this, 2, 6))
        add(BottomRightPath(this, 1, 6))
        add(VerticalPath(this, 1, 5))
        add(VerticalPath(this, 1, 4))
        add(VerticalPath(this, 1, 3))

        add(Tentaklus(this), FromBottom, 3, 2)

        add(VerticalPath(this, 3, 8))
        add(TopRightPath(this, 3, 7))
        add(HorizontalPath(this, 4, 7))
        add(HorizontalPath(this, 5, 7))
        add(HorizontalPath(this, 6, 7))
        add(HorizontalPath(this, 7, 7))
        add(TopLeftPath(this, 8, 7))
        add(VerticalPath(this, 8, 8))
        add(VerticalPath(this, 8, 9))
        add(VerticalPath(this, 8, 10))
        add(VerticalPath(this, 8, 11))
        add(BottomLeftPath(this, 8, 12))
        add(HorizontalPath(this, 7, 12))
        add(BottomRightPath(this, 6, 12))
        add(VerticalPath(this, 6, 11))
        add(VerticalPath(this, 6, 10))
        add(TopLeftPath(this, 6, 9))
        add(HorizontalPath(this, 5, 9))
        add(HorizontalPath(this, 4, 9))
        add(BottomRightPath(this, 3, 9))

        add(Tentaklus(this), FromRight, 4, 7)

        add(TopEndPath(this, 7, 2))
        add(VerticalPath(this, 7, 3))
        add(VerticalPath(this, 7, 4))
        add(BottomEndPath(this, 7, 5))

        add(Tentaklus(this), FromTop, 7, 3)
    }

}