package com.koje.ping.core.mobiles

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.ping.core.boards.Board
import com.koje.ping.core.Playground
import com.koje.ping.core.names.Name
import com.koje.ping.core.names.Open

open class Mobile(val board: Board) : ComponentGroup(Playground) {

    var position = Position(0f, 0f)
    var speed = 0.5f
    var number = 0
    var state: Name = Open


    init {

        addProcedure {
            move(position)
        }

    }

}