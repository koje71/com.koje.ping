package com.koje.ping.view

import com.koje.framework.events.IntNotifier
import com.koje.framework.utils.IntPreference
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.R
import com.koje.ping.core.Playground

class ScoresSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            setPaddingsDP(10, 0)
            addRelativeLayout {
                setGravityCenterLeft()
                setSizeMatchParent()
                addTextView {
                    setLayoutWeight(1f)
                    setTextColorID(R.color.White)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(20)

                    addReceiver(score) {
                        setText("score $it")
                    }
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
                    setTextColorID(R.color.White)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(20)

                    addReceiver(required) {
                        setText("$it required")
                    }
                }
            }
        }
    }

    companion object {
        val score = IntPreference("score", 0)
        val required = IntNotifier(Playground.currentBuilder.required.get())
    }
}