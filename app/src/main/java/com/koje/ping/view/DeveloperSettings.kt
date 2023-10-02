package com.koje.ping.view

import com.koje.framework.utils.BooleanPreference
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.ViewBuilder
import com.koje.ping.R
import com.koje.ping.core.Playground

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

                addCheckbox {
                    setText("Autoplay")
                    setTextSizeSP(20f)
                    setMarginsDP(5, 10, 0, 0)
                    setFontId(R.font.nunito_bold)
                    setColor(R.color.White)

                    addReceiver(autoplay) {
                        setChecked(it)
                    }

                    setOnCheckedChangeListener {
                        autoplay.set(it)
                    }
                }

                addCheckbox {
                    setText("Raster")
                    setTextSizeSP(20f)
                    setMarginsDP(5, 10, 0, 0)
                    setFontId(R.font.nunito_bold)
                    setColor(R.color.White)

                    addReceiver(raster) {
                        setChecked(it)
                    }

                    setOnCheckedChangeListener {
                        raster.set(it)
                    }
                }
            }


            setOnClickListener {
                Activity.overlay.set(EmptyOverlay())

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

    companion object {
        val autoplay = BooleanPreference("autoplay", false)
        val raster = BooleanPreference("raster", false)
    }

}