package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.R

class HeaderSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenterLeft()
                addTextView {
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.Blue)
                    setTextSizeSP(28)
                    setText("Ping")
                }
            }
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenter()
                addTextView {
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.Blue)
                    setTextSizeSP(28)
                    setText("Board 1")
                }
            }
        }
    }
}