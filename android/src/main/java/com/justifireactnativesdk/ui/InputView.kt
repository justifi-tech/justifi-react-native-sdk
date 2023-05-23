package com.justifireactnativesdk.ui

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import com.justifireactnativesdk.Utils
import org.json.JSONObject

/**
 * InputView is a customized EditText view that allows you to change certain styles and properties.
 * */
class InputView : AppCompatEditText {

  constructor(context: Context) : super(context) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    init()
  }

  private fun init() {
    inputType = InputType.TYPE_CLASS_NUMBER
  }

  /**
   * setup function receives the font family, labelWeight and margin JSONObject value, and configures them in the corresponding view .
   * @param backgroundColor The color of the background
   * @param textColor A color value in the form 0xAARRGGBB.
   * @param margin margin value
   * @param padding padding JSON values
   * @param lineHeight Information about how tall the view wants to be. Can be one of the constants MATCH_PARENT or WRAP_CONTENT, or an exact size
   * @param fontSize The value to apply the unit to
   * @param fontWeight weight of the font
   * @param borderRadius JSONObject of border radius
   * @param borderWidth value of border width
   * @param borderColor value of border color
   * @param backgroundColorHover the color of the background on hover
   * */
  fun setup(backgroundColor: Int, textColor: Int, margin: Int, padding: JSONObject, lineHeight: Int,
            fontSize: Int, fontWeight: Int, borderRadius: JSONObject, borderWidth: Int, borderColor: Int,
            backgroundColorHover: Int) {
    setBackgroundColor(backgroundColor)
    setTextColor(textColor)
    layoutParams = LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    )
    val param = layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins(margin, margin, margin, margin)
    param.height = lineHeight
    layoutParams = param

    val bottom = if (padding.has("bottom")) padding.getInt("bottom") else 0
    val top = if (padding.has("top")) padding.getInt("top") else 0
    val left = if (padding.has("left")) padding.getInt("left") else 0
    val right = if (padding.has("right")) padding.getInt("right") else 0
    setPadding(left, top, right, bottom)

    val displayMetrics = resources.displayMetrics
    setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
    setTypeface(null, fontWeight)

    val gd = Utils.getDrawable(borderRadius, borderWidth, borderColor, backgroundColor)
    background = gd

    setOnTouchListener { view, event ->
      when (event.action) {
        MotionEvent.ACTION_DOWN -> {
          view.setBackgroundColor(backgroundColorHover)
        }
        MotionEvent.ACTION_UP -> {
          view.setBackgroundColor(backgroundColor)
          view.background = gd
        }
      }
      view.performClick()
    }
  }

}
