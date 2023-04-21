package com.justifi

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import org.json.JSONObject

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
            val spSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, fontSize.toFloat(), displayMetrics) / displayMetrics.scaledDensity
            setTextSize(TypedValue.COMPLEX_UNIT_SP, spSize)
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
