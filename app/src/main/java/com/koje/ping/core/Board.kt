package com.koje.ping.core

import android.view.MotionEvent
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.Name
import com.koje.ping.core.paths.Path
import com.koje.ping.core.supplies.Ping
import com.koje.ping.core.supplies.Power

open class Board : ComponentGroup(Playground) {


    val paths = mutableListOf<Path>()
    val mobiles = mutableListOf<Mobile>()
    var order = 1
    var pings = 0
    val power = Power()


    init {
        addComponent(power)
    }

    fun addPath(path: Path) {
        addComponent(path)
        paths.add(path)

    }

    fun add(path: Path) {
        addComponent(path)
        paths.add(path)
    }

    fun add(mobile: Mobile, direction: Name, locX: Int, locY: Int) {
        mobiles.add(mobile)
        mobile.number = mobiles.size
        addComponent(mobile)
        enter(mobile, direction, locX, locY)
    }

    fun enter(mobile: Mobile, direction: Name, locX: Int, locY: Int) {
        paths.forEach {
            if (it.locX == locX && it.locY == locY) {
                it.enter(mobile, direction)
            }
        }
    }


    fun onTouch(position: Position, event: MotionEvent) {
        if (event.action == MotionEvent.ACTION_DOWN && power.value >= 100f) {
            addComponent(Ping(this, position))
        }
    }

}