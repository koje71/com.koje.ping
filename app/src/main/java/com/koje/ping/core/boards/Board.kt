package com.koje.ping.core.boards

import android.view.MotionEvent
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.framework.utils.Logger
import com.koje.ping.core.Playground
import com.koje.ping.core.mobiles.Mobile
import com.koje.ping.core.names.BottomEnd
import com.koje.ping.core.names.BottomLeft
import com.koje.ping.core.names.BottomRight
import com.koje.ping.core.names.BottomTop
import com.koje.ping.core.names.FromLeft
import com.koje.ping.core.names.FromRight
import com.koje.ping.core.names.LeftBottom
import com.koje.ping.core.names.LeftRight
import com.koje.ping.core.names.LeftTop
import com.koje.ping.core.names.Name
import com.koje.ping.core.names.RightBottom
import com.koje.ping.core.names.RightLeft
import com.koje.ping.core.names.RightTop
import com.koje.ping.core.names.ToLeft
import com.koje.ping.core.names.ToRight
import com.koje.ping.core.names.TopBottom
import com.koje.ping.core.names.TopEnd
import com.koje.ping.core.names.TopLeft
import com.koje.ping.core.names.TopRight
import com.koje.ping.core.paths.BottomEndPath
import com.koje.ping.core.paths.BottomLeftPath
import com.koje.ping.core.paths.BottomRightPath
import com.koje.ping.core.paths.HorizontalPath
import com.koje.ping.core.paths.Path
import com.koje.ping.core.paths.Raster
import com.koje.ping.core.paths.TopEndPath
import com.koje.ping.core.paths.TopLeftPath
import com.koje.ping.core.paths.TopRightPath
import com.koje.ping.core.paths.VerticalPath
import com.koje.ping.core.supplies.Action
import com.koje.ping.core.supplies.Ping
import com.koje.ping.core.supplies.PowerDisplay
import com.koje.ping.view.DeveloperSettings

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

            if (DeveloperSettings.autoplay.get()) {
                actions.forEach {
                    if (playtime > it.time && !it.processed) {
                        it.processed = true
                        it.process(this@Board)
                    }
                }
            }

        }

        addComponentGroup {
            for (xPos in 0..9) {
                for (yPos in 0..13) {
                    addComponent(Raster(this@Board, xPos, yPos))
                }
            }
            addProcedure {
                plane = when (DeveloperSettings.raster.get()) {
                    true -> 1
                    else -> -1
                }
            }
        }
    }


    fun addPath(path: Path) {
        addComponent(path)
        paths.add(path)
    }

    fun addMobile(mobile: Mobile, direction: Name, locX: Int, locY: Int) {
        addMobile(mobile)
        enter(mobile, direction, locX, locY)
    }

    fun addMobile(mobile: Mobile) {
        mobiles.add(mobile)
        mobile.number = mobiles.size
        addComponent(mobile)
    }

    fun addPathSequence(startX: Int, startY: Int, paths: List<Name>) {
        var posX = startX
        var posY = startY

        paths.forEach {
            when (it) {
                BottomLeft -> {
                    addPath(BottomLeftPath(this, posX, posY))
                    posX--
                }

                BottomTop -> {
                    addPath(VerticalPath(this, posX, posY))
                    posY++
                }

                BottomRight -> {
                    addPath(BottomRightPath(this, posX, posY))
                    posX++
                }

                LeftTop -> {
                    addPath(TopLeftPath(this, posX, posY))
                    posY++
                }

                LeftRight -> {
                    addPath(HorizontalPath(this, posX, posY))
                    posX++
                }

                LeftBottom -> {
                    addPath(BottomLeftPath(this, posX, posY))
                    posY--
                }

                TopRight -> {
                    addPath(TopRightPath(this, posX, posY))
                    posX++
                }

                TopBottom -> {
                    addPath(VerticalPath(this, posX, posY))
                    posY--
                }

                TopLeft -> {
                    addPath(TopLeftPath(this, posX, posY))
                    posX--
                }

                RightTop -> {
                    addPath(TopRightPath(this, posX, posY))
                    posY++
                }

                RightLeft -> {
                    addPath(HorizontalPath(this, posX, posY))
                    posX--
                }

                RightBottom -> {
                    addPath(BottomRightPath(this, posX, posY))
                    posY--
                }

                TopEnd -> {
                    addPath(TopEndPath(this, posX, posY))
                    posY++
                }

                BottomEnd -> {
                    addPath(BottomEndPath(this, posX, posY))
                    posY--
                }
            }
        }
    }

    fun addAction(action: Action) {
        actions.add(action)
    }

    fun setPathsVisible(start: Int, end: Int) {
        paths.forEachIndexed { index, path ->
            if (index in start..end) {
                path.visible = true
            }
        }
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
                add(Board09())
                add(Board04())
                add(Board15())
                add(Board10())
                add(Board06())
                add(Board07())
                add(Board11())
                add(Board12())
                add(Board13())
                add(Board14())
                add(Board08())
                add(Board05())
                return this
            }
        }
    }

}