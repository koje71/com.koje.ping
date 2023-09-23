package com.koje.ping.core.supplies

import com.koje.framework.graphics.ComponentGroup
import com.koje.ping.core.Playground
import kotlin.random.Random

class Background : ComponentGroup(Playground) {

    var angle = Random.nextFloat() * 200

    init {

        // herkunft: https://unsplash.com/de/fotos/NkQD-RHhbvY
        addImageComponent {
            image = Playground.picmap
            index = 3
            count = 4

            addProcedure {
                move(0f, 0f)
                scale(Playground.ratio * 1.3f)
                rotate(angle)

                angle += 0.01f
                if (angle > 360f) angle -= 360f

            }
        }
        addImageComponent {
            image = Playground.picmap
            index = 100
            count = 400

            addProcedure {
                move(-1.5f, 0f)
                scale(1.8f)
            }
        }
        addImageComponent {
            image = Playground.picmap
            index = 100
            count = 400

            addProcedure {
                move(1.5f, 0f)
                scale(1.8f)
            }
        }
    }
}