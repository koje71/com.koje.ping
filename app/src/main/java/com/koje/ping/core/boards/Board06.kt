package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board06 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            add(Tentaklus(target).withPosition(-0.35f, 0.4f))
            add(Tentaklus(target).withPosition(0f, 0.4f))
            add(Tentaklus(target).withPosition(+0.35f, 0.4f))

            add(Tentaklus(target).withPosition(-0.35f, -0.4f))
            add(Tentaklus(target).withPosition(+0.35f, -0.4f))
            add(Tentaklus(target).withPosition(0f, -0.4f))

            add(Click(6349,-0.43243408f, 0.53339887f))
            add(Click(23315,0.19717407f, -0.37397686f))
            add(Click(46789,-0.44259644f, 0.53616923f))
            add(Click(63905,0.19995117f, -0.39807218f))
            add(BoardLoader(82000,6))
        }
    }

}