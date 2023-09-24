package com.task.task.ui_module.utils

import android.view.View
import androidx.core.view.isVisible

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */


 fun View.toggleVisibility() {
    isVisible = isVisible.not()
}