package com.koje.ping.core.boards

import com.koje.ping.core.mobiles.Tentaklus
import com.koje.ping.core.names.FromTop

class Board99 : BoardBuilder() {

    override fun create(target: Board) {
        with(target) {

            add(Tentaklus(this), FromTop, 7, 3)
        }
    }

}