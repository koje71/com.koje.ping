package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.R

class ScoresSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            setPaddingsDP(10, 0)
            addRelativeLayout {
                setGravityCenterLeft()
                setSizeMatchParent()
                addTextView {
                    setLayoutWeight(1f)
                    setText("score 5")
                    setTextColorID(R.color.Blue)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(20)
                }
            }
            addRelativeLayout {
                setGravityCenter()
                setSizeMatchParent()
                addImageView {
                    setSizeDP(30)
                    setDrawableId(R.drawable.star)
                }
            }
            addRelativeLayout {
                setGravityCenterRight()
                setSizeMatchParent()
                addTextView {
                    setLayoutWeight(1f)
                    setText("2 required")
                    setTextColorID(R.color.Blue)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(20)
                }
            }
        }
    }
}