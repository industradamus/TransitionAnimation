package com.wispcoolwisp.transitionanimation

import android.content.Context
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionSet
import android.util.AttributeSet


class DetailsTransition @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    TransitionSet(context, attrs) {

    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds())
            .addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
    }
}