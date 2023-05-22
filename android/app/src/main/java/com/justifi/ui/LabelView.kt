package com.justifi.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import org.json.JSONObject

/**
 * LabelView is a customized TextView view that allows you to change certain styles and properties.
 * */
class LabelView (context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

  init {
  }

  /**
   * setup function receives the font family, labelWeight and margin JSONObject value, and configures them in the corresponding view .
   * @param fontFamily The name of the font family
   * @param labelWeight The style (normal, bold, italic) of the typeface
   * @param margin JSON with margin values
   * */
  fun setup(fontFamily: String, labelWeight: Int, margin: JSONObject) {
    val myTypeface = Typeface.create(fontFamily, labelWeight)
    typeface = myTypeface

    val bottom = if (margin.has("bottom")) margin.getInt("bottom") else 0
    val top = if (margin.has("top")) margin.getInt("top") else 0
    val left = if (margin.has("left")) margin.getInt("left") else 0
    val right = if (margin.has("right")) margin.getInt("right") else 0
    val param = layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins(left, top, right, bottom)
    layoutParams = param
  }
}
