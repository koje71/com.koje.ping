package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.R

class HeaderSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            setPaddingsDP(5,5)
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenterLeft()
                addTextView {
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.White)
                    setTextSizeSP(28)
                    setText("Ping")
                }
            }
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenter()
                addTextView {
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.White)
                    setTextSizeSP(28)
                }
            }
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenterRight()
                addImageView {
                    setSizeDP(40)
                    setDrawableId(R.drawable.menu)

                    setOnClickListener {
                        Activity.overlay.set(when(Activity.overlay.get()){
                            is EmptyOverlay -> BoardSelection()
                            else -> EmptyOverlay()
                        })
                    }
                }
            }
        }
    }
}