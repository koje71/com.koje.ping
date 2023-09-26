package com.koje.ping.view

import com.koje.framework.view.FrameLayoutBuilder
import com.koje.ping.R
import com.koje.ping.core.Playground

class BoardSelection : FrameLayoutBuilder.Editor {
    override fun edit(target: FrameLayoutBuilder) {
        Playground.pause = true
        target.addRelativeLayout {
            setGravityCenter()
            setSizeMatchParent()
            setBackgroundColorId(R.color.SandTransparent)


            addLinearLayout {
                setBackgroundColorId(R.color.White)

                addTextView {
                    setText("1")
                    setPaddingsDP(10,10)
                }
                addTextView {
                    setText("2")
                    setPaddingsDP(10,10)
                }
            }

            setOnClickListener {
                Activity.overlay.set(EmptyOverlay())

            }
        }
    }

    fun addSelectionButton(index:Int){

    }
}