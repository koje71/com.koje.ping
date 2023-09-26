package com.koje.ping.view

import com.koje.framework.view.FrameLayoutBuilder
import com.koje.ping.core.Playground

class EmptyOverlay : FrameLayoutBuilder.Editor {
    override fun edit(target: FrameLayoutBuilder) {
        Playground.pause = false
    }

}