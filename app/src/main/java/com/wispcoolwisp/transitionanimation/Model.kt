package com.wispcoolwisp.transitionanimation

import androidx.annotation.AnimRes
import androidx.annotation.StringRes

data class Model(@StringRes val nameRes: Int, @AnimRes val resourceId: Int)
