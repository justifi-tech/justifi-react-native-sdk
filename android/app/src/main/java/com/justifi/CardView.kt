package com.justifi

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable

import android.text.InputType
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.react.uimanager.ThemedReactContext
import org.json.JSONObject


class CardView : LinearLayout {
  private var callerContext: ThemedReactContext

  private var errorMessage: JSONObject = JSONObject()
  private var formControl: JSONObject = JSONObject()
  private var formLabel: JSONObject = JSONObject()
  private var layout: JSONObject = JSONObject()
  private var validationStrategy: String = ""

  private var formControlBackgroundColor = Color.WHITE
  private var formControlBorderColor = Color.GRAY
  private var formControlBorderColorHover = Color.GRAY
  private var formControlBorderColorFocus = Color.GRAY
  private var formControlMargin = 8
  private var formControlPadding: JSONObject = JSONObject()
  private var formControlColor = Color.BLACK
  private var formControlErrorColor = Color.RED
  private var formControlBorderWidth = 2
  private var formControlLineHeight = 80
  private var formControlFontSize = 50
  private var formControlFontWeight = Typeface.NORMAL
  private var formControlBorderRadius : JSONObject = JSONObject()

  private var formLabelWeight = Typeface.NORMAL
  private var formLabelFontFamily =  "sans-serif"


  constructor(context: ThemedReactContext) : super(context) {
    this.callerContext = context
    init()
  }

  private fun init() {
    try {
      inflate(callerContext, R.layout.card_view, this)
      customLayout()

      // Card number
      val cardNumberTitle : TextView = findViewById(R.id.card_num_title)
      setupTitle(cardNumberTitle)

      val cardNumber : EditText = findViewById(R.id.cardNumber)
      setupEditText(cardNumber)

      // Expiration
      val expirationTitle : TextView = findViewById(R.id.expiration_title)
      setupTitle(expirationTitle)

      val expirationMM : EditText = findViewById(R.id.mm)
      setupEditText(expirationMM)

      val expirationYY : EditText = findViewById(R.id.yy)
      setupEditText(expirationYY)

      // CVV
      val cvvTitle : TextView = findViewById(R.id.cvv_title)
      setupTitle(cvvTitle)

      val cvvNumber : EditText = findViewById(R.id.cvv)
      setupEditText(cvvNumber)

    } catch (ex: Exception) {
      Log.e("init", ex.toString())
    }
  }

  fun setStyleOverrides(styleOverrides: String) {
    try {
      val json = JSONObject(styleOverrides)
      if (json.has("layout"))
        layout = json.getJSONObject("layout")
      if (json.has("formLabel"))
        formLabel =  json.getJSONObject("formLabel")
      if (json.has("formControl"))
        formControl = json.getJSONObject("formControl")
      if (json.has("errorMessage"))
        errorMessage = json.getJSONObject("errorMessage")

      parseValues()
      init()
    } catch (ex: Exception) {
      Log.e("setStyleOverrides", ex.toString())
    }

  }

  private fun parseValues() {
    if (formControl.has("backgroundColor")) {
      val backgroundColor = formControl.getString("backgroundColor")
      Log.d("TAG backgroundColor", backgroundColor.toString())
      formControlBackgroundColor = Color.parseColor(backgroundColor)
    }

    if (formControl.has("borderColor")) {
      val borderColor = formControl.getString("borderColor")
      formControlBorderColor = Color.parseColor(borderColor)
    }

    if (formControl.has("borderColorHover")) {
      val borderColorHover = formControl.getString("borderColorHover")
      formControlBorderColorHover = Color.parseColor(borderColorHover)
    }

    if (formControl.has("borderColorFocus")) {
      val borderColorFocus = formControl.getString("borderColorFocus")
      formControlBorderColorFocus = Color.parseColor(borderColorFocus)
    }
    formControlMargin = formControl.getInt("margin")
    formControlPadding = formControl.getJSONObject("padding")
    if (formControl.has("color")) {
      val color = formControl.getString("color")
      formControlColor= Color.parseColor(color)
    }
    if(formControl.has("lineHeight")) {
      formControlLineHeight = formControl.getInt("lineHeight")
    }
    if(formControl.has("fontSize")) {
      formControlFontSize = formControl.getInt("fontSize")
    }
    if(formControl.has("fontWeight")) {
      val formControlWeight = formControl.getString("fontWeight")
      formControlFontWeight = Utils.getTypeface(formControlWeight)
    }
    if(formControl.has("borderWidth")) {
      formControlBorderWidth = formControl.getInt("borderWidth")
    }
    if(formControl.has("borderRadius")) {
      formControlBorderRadius = formControl.getJSONObject("borderRadius")
    }

    if(errorMessage.has("color")) {
      val errorColor = errorMessage.getString("color")
      formControlErrorColor = Color.parseColor(errorColor)
    }

    if(formLabel.has("fontWeight")) {
      val formLabelFontWeight = formLabel.getString("fontWeight")
      formLabelWeight = Utils.getTypeface(formLabelFontWeight)
    }
    if(formLabel.has("fontFamily")) {
      formLabelFontFamily = formLabel.getString("fontFamily")
    }
  }

  private fun customLayout() {
    val rootLayout: LinearLayout = findViewById(R.id.container_layout)

    if(layout.has("padding")) {
      val layoutPadding = layout.getInt("padding")
      rootLayout.setPadding(layoutPadding,layoutPadding,layoutPadding,layoutPadding)
    }

    var formControlSpacingVertical = 0
    var formControlSpacingHorizontal = 0
    if(layout.has("formControlSpacingHorizontal"))
      formControlSpacingHorizontal = layout.getInt("formControlSpacingHorizontal")
    if(layout.has("formControlSpacingVertical"))
      formControlSpacingVertical = layout.getInt("formControlSpacingVertical")

    val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    layoutParams.setMargins(formControlSpacingHorizontal/2, formControlSpacingVertical/2,
      formControlSpacingHorizontal/2, formControlSpacingVertical/2)
    rootLayout.layoutParams = layoutParams
  }

  fun setValidationStrategy(validation: String) {
    validationStrategy = validation
  }

  private fun setupTitle(view: TextView) {
    val myTypeface = Typeface.create(formLabelFontFamily, formLabelWeight)
    view.typeface = myTypeface

    if (formLabel.has("margin")) {
      val formLabelMargin = formLabel.getJSONObject("margin")
      val bottom = if (formLabelMargin.has("bottom")) formLabelMargin.getInt("bottom") else 0
      val top = if (formLabelMargin.has("top")) formLabelMargin.getInt("top") else 0
      val left = if (formLabelMargin.has("left")) formLabelMargin.getInt("left") else 0
      val right = if (formLabelMargin.has("right"))formLabelMargin.getInt("right") else 0
      val param = view.layoutParams as MarginLayoutParams
      param.setMargins(left, top, right, bottom)
    }
  }

  @SuppressLint("ClickableViewAccessibility")
  private fun setupEditText(view: EditText) {
    view.inputType = InputType.TYPE_CLASS_NUMBER
    view.setBackgroundColor(formControlBackgroundColor)
    view.setTextColor(formControlColor)

    view.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    val param = view.layoutParams as MarginLayoutParams
    param.setMargins(formControlMargin, formControlMargin, formControlMargin, formControlMargin)
    param.height = formControlLineHeight
    view.layoutParams = param
    val bottom = if (formControlPadding.has("bottom")) formControlPadding.getInt("bottom") else 0
    val top = if (formControlPadding.has("top")) formControlPadding.getInt("top") else 0
    val left = if (formControlPadding.has("left")) formControlPadding.getInt("left") else 0
    val right = if (formControlPadding.has("right"))formControlPadding.getInt("right") else 0
    view.setPadding(left, top, right, bottom)

    val pixelSize = formControlFontSize // en píxeles
    val displayMetrics = resources.displayMetrics
    val spSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixelSize.toFloat(), displayMetrics) / displayMetrics.scaledDensity
    view.setTextSize(TypedValue.COMPLEX_UNIT_SP, spSize)
    view.setTypeface(null, formControlFontWeight)

    val gd = getDrawable()
    if(formControl.has("backgroundColorHover")) {
      val formControlBackgroundHover = formControl.getString("backgroundColorHover")
      val formControlBackgroundColorHover = Color.parseColor(formControlBackgroundHover)
      view.setOnTouchListener { view, event ->
        when (event.action) {
          MotionEvent.ACTION_DOWN -> {
            view.setBackgroundColor(formControlBackgroundColorHover)
          }
          MotionEvent.ACTION_UP -> {
            view.setBackgroundColor(formControlBackgroundColor)
            view.background = gd
          }
        }
        true
      }
    }
    view.background = gd
  }

  private fun getDrawable(): GradientDrawable {
    val topLeft = if (formControlBorderRadius.has("topLeft")) formControlBorderRadius.getInt("topLeft") else 0
    val topRight = if (formControlBorderRadius.has("topRight"))formControlBorderRadius.getInt("topRight") else 0
    val bottomRight = if (formControlBorderRadius.has("bottomRight")) formControlBorderRadius.getInt("bottomRight") else 0
    val bottomLeft = if (formControlBorderRadius.has("bottomLeft")) formControlBorderRadius.getInt("bottomLeft") else 0

    val gd = GradientDrawable()
    gd.setStroke(formControlBorderWidth, formControlBorderColor)
    gd.setColor(formControlBackgroundColor)
    gd.cornerRadii = floatArrayOf(
      topLeft.toFloat(),
      topLeft.toFloat(),
      topRight.toFloat(),
      topRight.toFloat(),
      bottomRight.toFloat(),
      bottomRight.toFloat(),
      bottomLeft.toFloat(),
      bottomLeft.toFloat()
    )
    return gd
  }

  fun validateFields() {
    val cardNumber : EditText = findViewById(R.id.cardNumber)
    val expirationMM : EditText = findViewById(R.id.mm)
    val expirationYY : EditText = findViewById(R.id.yy)
    val cvvNumber : EditText = findViewById(R.id.cvv)
    val errorTitle = resources.getString(R.string.error_msg)
    if (cardNumber.text.length < 16) {
      cardNumber.error = Utils.buildError(formControlErrorColor, errorTitle)
      cardNumber.requestFocus()
    }
    if (expirationMM.text.length < 2) {
      expirationMM.error = Utils.buildError(formControlErrorColor, errorTitle)
      expirationMM.requestFocus()
    }
    if (expirationYY.text.length < 2) {
      expirationYY.error = Utils.buildError(formControlErrorColor, errorTitle)
      expirationYY.requestFocus()
    }
    if (cvvNumber.text.length < 4) {
      cvvNumber.error = Utils.buildError(formControlErrorColor, errorTitle)
      cvvNumber.requestFocus()
    }
  }

}
