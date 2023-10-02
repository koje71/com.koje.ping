package com.koje.ping.core.boards

import com.koje.framework.utils.IntPreference
import com.koje.ping.view.GameSection
import com.koje.ping.view.ScoresSection

open class BoardBuilder {

    val name = javaClass.simpleName

    open fun create(target: Board) {
    }

    fun onSolved() {
        solved.increase()

        if (required.get() > 0) {
            required.decrease()
        } else {
            ScoresSection.score.increase()
            required.set(solved.get())
        }
        ScoresSection.required.set(required.get())
        GameSection.points.set(solved.get())
    }

    val solved = IntPreference("$name-solved", 0)
    val required = IntPreference("$name-required", 0)
}