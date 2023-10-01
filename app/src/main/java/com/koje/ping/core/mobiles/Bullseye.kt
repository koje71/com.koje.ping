package com.koje.ping.core.mobiles

import com.koje.framework.graphics.ComponentGroup
import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board
import com.koje.ping.core.names.Failed
import com.koje.ping.core.names.Solved
import kotlin.random.Random

class Bullseye(board: Board) : Mobile(board) {

    var rotationAngle = Random.nextFloat() * 200
    var rotationDirectionRight = Random.nextBoolean()
    var moveAnimation = Random.nextFloat() * 200

    init {

        addComponentGroup {

            addImageComponent {
                image = Playground.picmap
                count = 100
                index = 16

                addProcedure {
                    scale(1.3f)
                }
            }

            listOf(45f, 135f, 225f, 315f).forEach {
                //  addMovingArrow(this, it)
            }

            addImageComponent {
                image = Playground.picmap
                count = 100

                addProcedure {
                    index = when (state) {
                        Solved -> 19
                        Failed -> 18
                        else -> 17
                    }
                }
                index = 7
            }


            addProcedure {
                rotationAngle += when (rotationDirectionRight) {
                    true -> 0.3f
                    else -> -0.3f
                }
                if (rotationAngle < 0f) rotationAngle += 360f
                if (rotationAngle > 360f) rotationAngle -= 360f
                rotate(rotationAngle)

                moveAnimation += (0.05f + 0.003f) * surface.loopTime
                if (moveAnimation > 360f) {
                    moveAnimation -= 360f
                }
            }
        }

        addImageComponent {
            image = Playground.picmap
            count = 400

            addProcedure {
                index = 80 + number
                move(-0.02f, 0f)
                scale(0.3f)
            }
        }

        addProcedure {
            scale(0.15f)
        }

    }

    fun addMovingArrow(target: ComponentGroup, angle: Float) {

        target.addComponentGroup {
            addImageComponent {
                image = Playground.picmap
                index = 13
                count = 400

                addProcedure {
                    move(0f, 0.6f + 0.1f * sin(moveAnimation))
                    scale(0.5f)
                }
            }

            addProcedure {
                scale(0.8f)
                rotate(angle)
            }
        }
    }

    fun addArrowLine(target: ComponentGroup, angle: Float) {
        target.addComponentGroup {
            listOf(0.25f, 0.5f, 0.75f, 1f).forEach {
                addArrow(this, it)
            }
            addProcedure {
                scale(0.8f)
                rotate(angle)
            }
        }
    }

    fun addArrow(target: ComponentGroup, distance: Float) {
        var pos = distance
        target.addImageComponent {
            image = Playground.picmap
            index = 13
            count = 400

            addProcedure {
                move(0f, pos)
                scale(0.5f)

                opacity = if (pos > 0.5f) {
                    (1f - pos) * 2f
                } else {
                    1f
                }

                if (pos > 0f) {
                    pos -= 0.003f
                }

                if (pos <= 0) {
                    pos = 1f
                }
            }
        }

    }
}