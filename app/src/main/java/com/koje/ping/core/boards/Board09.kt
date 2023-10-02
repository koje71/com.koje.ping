package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.BottomEnd
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromBottom
import com.koje.ping.core.names.FromTop
import com.koje.ping.core.names.TopEnd
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board09 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            listOf(1, 3, 6, 8).forEach {
                addPathSequence(
                    it, 1, listOf(
                        TopEnd, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop, BottomTop,
                        BottomTop, BottomTop, BottomTop, BottomTop, BottomEnd
                    )
                )
            }

            addMobile(Tentaklus(this).speed(0.8f), FromBottom, 1, 2)
            addMobile(Tentaklus(this).speed(0.9f), FromTop, 3, 11)

            addMobile(Tentaklus(this).speed(1.0f), FromBottom, 6, 2)
            addMobile(Tentaklus(this).speed(1.1f), FromTop, 8, 11)

            addAction(Click(4130, -0.37316895f, -0.001787878f))
            addAction(Click(15743, 0.30459595f, 0.26300296f))
            addAction(BoardLoader(30000))
        }
    }

}