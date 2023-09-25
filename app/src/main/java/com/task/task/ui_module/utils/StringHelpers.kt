package com.task.task.ui_module.utils

/**
 * Created by Mohammed Taguldeen on 25/09/2023.
 */

fun String.getInitials(): String {
    return this.split(' ')
        .mapNotNull { it.firstOrNull()?.toString() }
        .reduce { acc, s -> acc + s }
}