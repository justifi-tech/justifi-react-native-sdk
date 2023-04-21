@file:Suppress("NAME_SHADOWING")

package com.justifi

import android.graphics.Color
import android.graphics.Typeface

import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.react.uimanager.ThemedReactContext
import org.json.JSONObject

class CardView(context: ThemedReactContext) : LinearLayout(context) {
  private var callerContext: ThemedReactContext = context

  private var errorMessage: JSONObject = JSONObject()
  private var formControl: JSONObject = JSONObject()
  private var formLabel: JSONObject = JSONObject()
  private var layout: JSONObject = JSONObject()
  private var validationStrategy: String = ""

  private var formControlBackgroundColor = Color.WHITE
  private var formControlBorderColor = Color.GRAY
  private var formControlBorderColorHover = Color.GRAY
  private var formControlBorderColorFocus = Color.GRAY
  private var formControlBackgroundColorHover = Color.GRAY
  private var formControlColor = Color.BLACK
  private var formControlErrorColor = Color.RED
  private var formControlPadding: JSONObject = JSONObject()
  private var formControlBorderRadius : JSONObject = JSONObject()
  private var formControlMargin = 8
  private var formControlBorderWidth = 2
  private var formControlLineHeight = 80
  private var formControlFontSize = 50
  private var formControlFontWeight = Typeface.NORMAL

  private var formLabelWeight = Typeface.NORMAL
  private var formLabelFontFamily =  "sans-serif"


  init {
    init()
  }

  private fun init() {
    try {
      inflate(callerContext, R.layout.card_view, this)
      customLayout()

      // Card number
      val cardNumberTitle : TextView = findViewById(R.id.card_num_title)
      setupTitle(cardNumberTitle)

      val cardNumber : InputView = findViewById(R.id.cardNumber)
      cardNumber.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      // Expiration
      val expirationTitle : TextView = findViewById(R.id.expiration_title)
      setupTitle(expirationTitle)

      val expirationMM : InputView = findViewById(R.id.mm)
      expirationMM.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      val expirationYY : InputView = findViewById(R.id.yy)
      expirationYY.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      // CVV
      val cvvTitle : TextView = findViewById(R.id.cvv_title)
      setupTitle(cvvTitle)

      val cvvNumber : InputView = findViewById(R.id.cvv)
      cvvNumber.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

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
    if(formControl.has("backgroundColorHover")) {
      val formControlBackgroundHover = formControl.getString("backgroundColorHover")
      formControlBackgroundColorHover = Color.parseColor(formControlBackgroundHover)
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

  fun validateFields() : Boolean {
    val cardNumber : InputView = findViewById(R.id.cardNumber)
    val expirationMM : InputView = findViewById(R.id.mm)
    val expirationYY : InputView = findViewById(R.id.yy)
    val cvvNumber : InputView = findViewById(R.id.cvv)
    val errorTitle = resources.getString(R.string.error_msg)

    if (!Utils.validCard(cardNumber.text.toString())) {
      cardNumber.error = Utils.buildError(formControlErrorColor, errorTitle)
      cardNumber.requestFocus()
      return false
    }
    if (!Utils.validMM(expirationMM.text.toString())) {
      expirationMM.error = Utils.buildError(formControlErrorColor, errorTitle)
      expirationMM.requestFocus()
      return false
    }
    if (!Utils.validYY(expirationYY.text.toString())) {
      expirationYY.error = Utils.buildError(formControlErrorColor, errorTitle)
      expirationYY.requestFocus()
      return false
    }
    if (!Utils.validCVV(cvvNumber.text.toString())) {
      cvvNumber.error = Utils.buildError(formControlErrorColor, errorTitle)
      cvvNumber.requestFocus()
      return false
    }
    return true
  }

}
