package com.kellima.edutrpl.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Semester (
    @StringRes val nameRes : Int,
    @StringRes val descriptionRes : Int,
    @DrawableRes val imageRes : Int,
)

data class Sks(
    val code: String,
    val name: String,
    val sks: Int,
    val theory: Int,
    val lab: Int,
    val practice: Int,
    val totalSks: Int
)
