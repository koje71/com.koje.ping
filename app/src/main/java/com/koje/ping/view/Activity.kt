package com.koje.ping.view

import com.koje.framework.view.BaseActivity
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.ping.R


class Activity : BaseActivity() {

    override fun createLayout(target: FrameLayoutBuilder) {

        with(target) {
            addLinearLayout {
                setOrientationVertical()
                setBackgroundColorId(R.color.Background)
                add(HeaderSection())
                add(GameSection())
                add(ScoresSection())
            }
        }
    }
}

