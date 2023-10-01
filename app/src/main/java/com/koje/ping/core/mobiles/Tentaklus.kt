package com.koje.ping.core.mobiles

import com.koje.framework.graphics.ComponentGroup
import com.koje.ping.core.Playground
import com.koje.ping.core.boards.Board
import com.koje.ping.core.names.Failed
import com.koje.ping.core.names.Solved
import kotlin.random.Random

class Tentaklus(board: Board) : Mobile(board) {

    var rotationAngle = Random.nextFloat() * 200
    var rotationDirectionRight = Random.nextBoolean()

    init {

        addComponentGroup {

            listOf(0f, 120f, 240f).forEach {
                addTentakle(this, it)
            }

            addImageComponent {
                image = Playground.picmap
                count = 100
                index = 7
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
                    true -> 0.03f * surface.loopTime * speed
                    else -> -0.03f * surface.loopTime * speed
                }
                if (rotationAngle < 0f) rotationAngle += 360f
                if (rotationAngle > 360f) rotationAngle -= 360f
                rotate(rotationAngle)
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

    private fun addTentakle(target: ComponentGroup, angle: Float) {
        var animation = Random.nextFloat() * 200f
        val animationSpeed = Random.nextFloat() * 0.05f
        target.addImageComponent {
            image = Playground.picmap
            count = 100
            index = 8

            addProcedure {
                rotate(angle)
                move(0f, 0.35f + 0.1f * sin(animation))
                animation += (0.05f + animationSpeed) * surface.loopTime
                if (animation > 360f) {
                    animation -= 360f
                }
            }
        }
    }
}