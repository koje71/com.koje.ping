package com.koje.ping.view

import com.koje.framework.events.Notifier
import com.koje.framework.view.BaseActivity
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.ping.R
import com.koje.ping.core.supplies.Sound


class Activity : BaseActivity() {

    override fun createLayout(target: FrameLayoutBuilder) {
        Sound.bubble.play()

        with(target) {
            addLinearLayout {
                setOrientationVertical()
                setBackgroundColorId(R.color.Background)
                addFrameLayout {
                    addLinearLayout {
                        setSizeMatchParent()
                        setOrientationVertical()
                        add(HeaderSection())
                        add(GameSection())
                        add(ScoresSection())
                    }
                    addFrameLayout {
                        setSizeMatchParent()
                        addReceiver(overlay) {
                            replaceWithFade(it)
                        }
                    }
                }
            }
        }
    }

    companion object {
        val overlay = Notifier<FrameLayoutBuilder.Editor>(EmptyOverlay())
    }
}

