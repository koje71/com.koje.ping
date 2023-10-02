package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.supplies.BoardLoader
import com.koje.ping.core.supplies.Click

open class Board12 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {
            pathsVisible = true

            addMobile(Tentaklus(this).withPosition(-0.35f, +0.35f))
            addMobile(Tentaklus(this).withPosition(-0.35f, +0f))
            addMobile(Tentaklus(this).withPosition(0f, +0.35f))
            addMobile(Tentaklus(this).withPosition(0f, +0f))
            addMobile(Tentaklus(this).withPosition(-0.35f, -0.35f))
            addMobile(Tentaklus(this).withPosition(0f, -0.35f))

            addMobile(Tentaklus(this).withPosition(+0.35f, +0.35f))
            addMobile(Tentaklus(this).withPosition(+0.35f, +0f))
            addMobile(Tentaklus(this).withPosition(+0.35f, -0.35f))

            addAction(Click(5050, -0.35186768f, 0.20933612f))
            addAction(BoardLoader(25000))
        }
    }

}