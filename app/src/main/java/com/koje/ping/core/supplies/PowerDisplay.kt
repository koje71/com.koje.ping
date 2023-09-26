package com.koje.ping.core.supplies

import com.koje.framework.graphics.ComponentGroup
import com.koje.ping.core.Playground

class PowerDisplay : ComponentGroup(Playground) {


    init {

        for (i in 0..9) {
            addLamp(i)
        }

        addProcedure {
            move(0.08f, -1f * Playground.ratio / 2 + 0.07f)
            scale(0.07f)

            if(!Playground.pause) {
                value += 0.02f * surface.loopTime
                if (value > 200) value = 100f
            }
        }
    }

    fun addLamp(number: Int) {

        addImageComponent {
            image = Playground.picmap
            count = 400

            addProcedure {
                index = when (value >= 10f * number) {
                    true -> 19
                    else -> 18
                }
                move(5.5f - 0.6f * number, 0f)
            }
        }

    }

    var value = 50f
}