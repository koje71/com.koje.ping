package com.koje.ping.view

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.ping.BuildConfig
import com.koje.ping.R
import com.koje.ping.core.supplies.Sound

class HeaderSection : LinearLayoutBuilder.Editor {
    override fun edit(target: LinearLayoutBuilder) {
        target.addFrameLayout {
            setPaddingsDP(5, 5)
            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenterLeft()
                addTextView {
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.White)
                    setTextSizeSP(28)
                    setText("Ping")

                    if(BuildConfig.DEBUG) {
                        setOnClickListener {
                            Sound.knock.play()
                            Activity.overlay.set(
                                when (Activity.overlay.get()) {
                                    is EmptyOverlay -> DeveloperSettings()
                                    else -> EmptyOverlay()
                                }
                            )
                        }
                    }
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
                        Sound.knock.play()
                        Activity.overlay.set(
                            when (Activity.overlay.get()) {
                                is EmptyOverlay -> BoardSelection()
                                else -> EmptyOverlay()
                            }
                        )
                    }
                }
            }
        }
    }
}