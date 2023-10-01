package com.koje.ping.view

import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.framework.view.ViewBuilder
import com.koje.ping.R
import com.koje.ping.core.Playground
import com.koje.ping.core.boards.BoardBuilder

class DeveloperSettings : FrameLayoutBuilder.Editor {
    override fun edit(target: FrameLayoutBuilder) {
        Playground.pause = true
        target.addRelativeLayout {
            setGravityCenter()
            setSizeMatchParent()
            setBackgroundColorId(R.color.SandTransparent)

            addLinearLayout {
                setOrientationVertical()
                setGravityCenter()
                setMarginsDP(30, 30, 30, 30)
                setPaddingsDP(5, 5)
                format(this)

                addTextView {
                    setText("Deverloper Settings")
                    setTextSizeSP(24)
                    setTextColorID(R.color.White)
                    setPaddingsDP(10, 0)
                    setFontId(R.font.nunito_bold)
                }

            }


            setOnClickListener {
                Activity.overlay.set(EmptyOverlay())

            }
        }
    }

    fun addSelectionButton(target: LinearLayoutBuilder, index: Int, builder: BoardBuilder) {
        target.addLinearLayout {
            setBackgroundColorId(R.color.White)
            setOrientationVertical()
            setPaddingsDP(0, 5)
            setMarginsDP(5, 5, 5, 5)
            setWidthDP(50)
            setGravityCenterVertical()
            setLayoutWeight(1f)

            addTextView {
                setText(index.toString())
                setFontId(R.font.nunito_bold)
                setTextSizeSP(20)
                setWidthMatchParent()
                setGravityCenter()
            }

            addView {
                setWidthMatchParent()
                setHeightDP(2)
                setMarginsDP(3, 0, 3, 0)
                setBackgroundColorId(R.color.DialogBackground)
            }

            addTextView {
                setText("${builder.required.get()}")
                setFontId(R.font.nunito_bold)
                setTextSizeSP(12)
                setWidthMatchParent()
                setGravityCenter()
            }


            setOnClickListener {
                Playground.loadBoard(builder)
                Activity.overlay.set(EmptyOverlay())
            }

            setBackgroundStateList {
                addStatePressedGradient {
                    // setStroke(2, R.color.Black)
                    setCornerRadius(5)
                    setColorId(R.color.ClickBackground)
                }
                addStateWildcardGradient {
                    //  setStroke(2, R.color.Black)
                    setCornerRadius(5)
                    setColorId(R.color.White)
                }
            }
        }
    }

    fun format(target: ViewBuilder) {
        target.setBackgroundGradient {
            setCornerRadius(10)
            // setStroke(2, R.color.Black)
            setColorId(R.color.DialogBackground)
        }

    }

}