package com.koje.ping.core.boards

import com.koje.framework.utils.IntPreference

open class BoardBuilder {

    open fun create(target: Board) {
        with(target){

        }
    }


    val solved = IntPreference("${javaClass.simpleName}-solved",0)
    val required = IntPreference("${javaClass.simpleName}-required",0)
}