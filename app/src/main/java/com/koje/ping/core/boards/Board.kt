package com.koje.ping.core.boards

import android.view.MotionEvent
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.framework.utils.Logger
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.Name
import com.koje.ping.core.names.ToLeft
import com.koje.ping.core.names.ToRight
import com.koje.ping.core.paths.Path
import com.koje.ping.core.paths.Raster
import com.koje.ping.core.supplies.Action
import com.koje.ping.core.supplies.Ping
import com.koje.ping.core.supplies.PowerDisplay

open class Board : ComponentGroup(Playground) {


    val paths = mutableListOf<Path>()
    var pathsVisible = false
    val mobiles = mutableListOf<Mobile>()
    var order = 1
    var pings = 0
    val power = PowerDisplay()
    var playtime = 0L
    val actions = mutableListOf<Action>()


    init {
        addComponent(power)
        addProcedure {
            playtime += surface.loopTime

            actions.forEach {
                if (playtime > it.time && !it.processed) {
                    it.processed = true
                    it.process(this@Board)
                }
            }
        }
        // addRaster()
    }

    fun addRaster() {
        for (xPos in 0..9) {
            for (yPos in 0..13) {
                addComponent(Raster(this, xPos, yPos))
            }
        }

    }

    fun add(path: Path) {
        addComponent(path)
        paths.add(path)
    }

    fun add(mobile: Mobile, direction: Name, locX: Int, locY: Int) {
        add(mobile)
        enter(mobile, direction, locX, locY)
    }

    fun add(mobile: Mobile) {
        mobiles.add(mobile)
        mobile.number = mobiles.size
        addComponent(mobile)
    }

    fun add(action: Action) {
        actions.add(action)
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
            Logger.info(this, "clickOnclickOn: $playtime,${position.x}f, ${position.y}f")
            addComponent(Ping(this, position))
        }
    }

    fun increase(direction: Name) {
        addProcedure {
            if (progress < 1) {
                progress += 0.001f * surface.loopTime
                when (direction) {
                    FromRight -> move(0.4f - 0.4f * progress, 0f)
                    FromLeft -> move(-0.4f + 0.4f * progress, 0f)
                }
                scale(progress)
            }
        }
    }

    fun decrease(direction: Name) {
        addProcedure {
            progress += 0.001f * surface.loopTime
            if (progress < 1) {
                when (direction) {
                    ToLeft -> move(0f - 0.4f * progress, 0f)
                    ToRight -> move(0f + 0.4f * progress, 0f)
                }
                scale(1f - progress)
            } else {
                scale(0f)
                death = true
            }
        }
    }

    companion object {
        val builders = createBoardList()

        private fun createBoardList(): MutableList<BoardBuilder> {
            with(mutableListOf<BoardBuilder>()) {
                add(Board01())
                add(Board02())
                add(Board03())
                add(Board04())
                add(Board05())
                add(Board06())
                for (i in 1..50) add(Board99())
                return this
            }
        }
    }

}