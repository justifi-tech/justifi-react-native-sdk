package com.justifi

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan

class Utils {

  companion object {
    fun getTypeface(value: String): Int {
      return when (value) {
        "bold" -> Typeface.BOLD
        "100" -> Typeface.ITALIC
        "200" -> Typeface.BOLD_ITALIC
        "700" -> Typeface.BOLD
        "800" -> Typeface.BOLD
        "900" -> Typeface.BOLD
        else -> Typeface.NORMAL
      }
    }

    fun buildError(formControlErrorColor: Int, errorTitle: String): SpannableStringBuilder {
      val fgSpan = ForegroundColorSpan(formControlErrorColor)
      val ssBuilder = SpannableStringBuilder(errorTitle)
      ssBuilder.setSpan(fgSpan, 0, errorTitle.length, 0)
      return ssBuilder
    }

    fun gradientDrawable(
      formControlBorderWidth: Int,
      formControlBorderColor: Int,
      formControlBackgroundColor: Int,
      formControlBorderColorHover: Int,
      formControlBorderColorFocus: Int
    ): GradientDrawable {
      val drawable = GradientDrawable()
      drawable.shape = GradientDrawable.LINE
      drawable.setStroke(formControlBorderWidth, formControlBorderColor)
      drawable.setColor(formControlBackgroundColor)

      // hover and focus border colors
      val states = arrayOf(
        intArrayOf(android.R.attr.state_hovered),
        intArrayOf(android.R.attr.state_focused),
        intArrayOf()
      )
      val colors = intArrayOf(
        formControlBorderColorHover,
        formControlBorderColorFocus,
        formControlBorderColor
      )
      val colorStateList = ColorStateList(states, colors)
      drawable.setTintList(colorStateList)
      return drawable
    }
  }
}
