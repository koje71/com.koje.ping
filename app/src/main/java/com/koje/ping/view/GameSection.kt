package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.R
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
            addRelativeLayout {
                setGravityTopLeft()
                setPaddingsDP(5,0)
                addTextView {
                    setTextSizeSP(18)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.Black)
                    setText("Board 1")
                }
            }
        }
    }
}