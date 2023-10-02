package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board06 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            addMobile(Tentaklus(target).withPosition(-0.35f, 0.4f))
            addMobile(Tentaklus(target).withPosition(0f, 0.4f))
            addMobile(Tentaklus(target).withPosition(+0.35f, 0.4f))

            addMobile(Tentaklus(target).withPosition(-0.35f, -0.4f))
            addMobile(Tentaklus(target).withPosition(+0.35f, -0.4f))
            addMobile(Tentaklus(target).withPosition(0f, -0.4f))

            addAction(Click(6349, -0.43243408f, 0.53339887f))
            addAction(Click(23315, 0.19717407f, -0.37397686f))
            addAction(Click(46789, -0.44259644f, 0.53616923f))
            addAction(Click(63905, 0.19995117f, -0.39807218f))
            addAction(BoardLoader(82000))
        }
    }

}