package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.paths.BottomLeftPath
import com.koje.ping.core.paths.BottomRightPath
import com.koje.ping.core.paths.HorizontalPath
import com.koje.ping.core.paths.TopLeftPath
import com.koje.ping.core.paths.TopRightPath
import com.koje.ping.core.paths.VerticalPath
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

class Board02 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true
            add(TopRightPath(this, 1, 11))
            add(TopLeftPath(this, 8, 11))
            add(BottomRightPath(this, 1, 12))
            add(BottomLeftPath(this, 8, 12))

            for (locX in 2..7) {
                add(HorizontalPath(this, locX, 11))
                add(HorizontalPath(this, locX, 12))
            }

            add(BottomRightPath(this, 1, 9))
            add(BottomLeftPath(this, 8, 9))
            add(TopRightPath(this, 1, 1))
            add(TopLeftPath(this, 8, 1))

            for (locY in 2..8) {
                add(VerticalPath(this, 1, locY))
                add(VerticalPath(this, 8, locY))
            }

            for (locX in 2..7) {
                add(HorizontalPath(this, locX, 1))
                add(HorizontalPath(this, locX, 9))

            }

            add(BottomRightPath(this, 3, 7))
            add(BottomLeftPath(this, 6, 7))
            add(TopRightPath(this, 3, 3))
            add(TopLeftPath(this, 6, 3))

            for (locY in 4..6) {
                add(VerticalPath(this, 3, locY))
                add(VerticalPath(this, 6, locY))
            }

            for (locX in 4..5) {
                add(HorizontalPath(this, locX, 3))
                add(HorizontalPath(this, locX, 7))

            }

            add(Tentaklus(this), FromLeft, 5, 11)
            add(Tentaklus(this).speed(2f), FromLeft, 4, 3)
            add(Tentaklus(this), FromBottom, 1, 3)

            add(Click(2731, 0.31292725f, 0.25469202f))
            add(Click(22863, -0.42687988f, 0.35931984f))
            add(Click(36458, 0.28607178f, -0.298985f))
            add(Click(61922, 0.32589722f, 0.29263893f))
            add(BoardLoader(79022, 2))
        }
    }

}