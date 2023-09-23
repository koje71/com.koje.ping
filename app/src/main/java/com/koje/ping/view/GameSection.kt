package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.core.Playground

class GameSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            setLayoutWeight(1f)
            addSurfaceView {
                setWidthMatchParent()
                setWidthMatchParent()
                setSurface(Playground)
            }
        }
    }
}