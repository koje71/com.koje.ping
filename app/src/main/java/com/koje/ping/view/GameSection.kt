package com.koje.ping.view

import com.koje.framework.events.IntNotifier
import com.koje.framework.events.Notifier
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
                setPaddingsDP(5, 0)
                addTextView {
                    setTextSizeSP(18)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.Black)

                    addReceiver(boardNumber) {
                        setText("Board ${it + 1}")
                    }
                }
            }
            addRelativeLayout {
                setGravityTopRight()
                setPaddingsDP(5, 0)
                addTextView {
                    setTextSizeSP(18)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.Black)

                    addReceiver(points) {
                        setText("$it Points")
                    }
                }
            }
        }
    }

    companion object {
        val boardNumber = Notifier(0)
        val points = IntNotifier(0)
    }
}