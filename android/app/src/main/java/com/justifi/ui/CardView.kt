@file:Suppress("NAME_SHADOWING")

<<<<<<< HEAD
<<<<<<<< HEAD:android/src/main/java/com/justifireactnativesdk/ui/CardView.kt
package com.justifireactnativesdk.ui
========
package com.justifi.ui
>>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d:android/app/src/main/java/com/justifi/ui/CardView.kt
=======
package com.justifi.ui
>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface

import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
<<<<<<< HEAD
<<<<<<<< HEAD:android/src/main/java/com/justifireactnativesdk/ui/CardView.kt
import com.justifireactnativesdk.R
import com.justifireactnativesdk.Utils
import com.justifireactnativesdk.api.*
========
import com.justifi.R
import com.justifi.Utils
import com.justifi.api.*
>>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d:android/app/src/main/java/com/justifi/ui/CardView.kt
=======
import com.justifi.R
import com.justifi.Utils
import com.justifi.api.*
>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.events.RCTEventEmitter
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import android.util.Base64

@Suppress("DEPRECATION")
class CardView(context: ThemedReactContext) : LinearLayout(context) {
  private var callerContext: ThemedReactContext = context

  private var errorMessage: JSONObject = JSONObject()
  private var formControl: JSONObject = JSONObject()
  private var formLabel: JSONObject = JSONObject()
  private var layout: JSONObject = JSONObject()

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
  private var formLabelMargin = JSONObject()


  init {
    init()
  }

  private fun init() {
    try {
      inflate(callerContext, R.layout.card_view, this)
      customLayout()

      // Card number
      val cardNumberTitle : LabelView = findViewById(R.id.card_num_title)
      cardNumberTitle.setup(formLabelFontFamily, formLabelWeight, formLabelMargin)

      val cardNumber : InputView = findViewById(R.id.cardNumber)
      cardNumber.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      // Expiration
      val expirationTitle : LabelView = findViewById(R.id.expiration_title)
      expirationTitle.setup(formLabelFontFamily, formLabelWeight, formLabelMargin)

      val expirationMM : InputView = findViewById(R.id.mm)
      expirationMM.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      val expirationYY : InputView = findViewById(R.id.yy)
      expirationYY.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      // CVV
      val cvvTitle : LabelView = findViewById(R.id.cvv_title)
      cvvTitle.setup(formLabelFontFamily, formLabelWeight, formLabelMargin)

      val cvvNumber : InputView = findViewById(R.id.cvv)
      cvvNumber.setup(formControlBackgroundColor, formControlColor, formControlMargin, formControlPadding,
        formControlLineHeight, formControlFontSize, formControlFontWeight, formControlBorderRadius,
        formControlBorderWidth, formControlBorderColor, formControlBackgroundColorHover)

      //Submit
      val submitButton : Button = findViewById(R.id.submit_button)
      submitButton.setOnClickListener() {
        Log.d("CardView", "Submit button clicked")
        onSubmit()
      }

    } catch (ex: Exception) {
      Log.e("init", ex.toString())
    }
  }

  /**
   * This function receives a JSON with the styles to be customized and applies them to the CardView.
   * @param style a JSON string with the styles
   **/
  fun setStyleOverrides(style: JSONObject) {
    try {
      if (style.has("layout"))
        layout = style.getJSONObject("layout")
      if (style.has("formLabel"))
        formLabel =  style.getJSONObject("formLabel")
      if (style.has("formControl"))
        formControl = style.getJSONObject("formControl")
      if (style.has("errorMessage"))
        errorMessage = style.getJSONObject("errorMessage")

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
    if (formControl.has("margin")) {
      formControlMargin = formControl.getInt("margin")
    }
    if (formControl.has("padding")) {
      formControlPadding = formControl.getJSONObject("padding")
    }
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
    if (formLabel.has("margin")) {
      formLabelMargin = formLabel.getJSONObject("margin")
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

  private fun getPreferences(): SharedPreferences {
    return callerContext.getSharedPreferences(
      callerContext.getString(R.string.preference_file_key),
      Context.MODE_PRIVATE
    )
  }

  private fun onSubmit() {
    try {
      if (validateFields()) {
        // load data from provider
        val clientId = getPreferences().getString("clientId", "").toString()
        val account = getPreferences().getString("account", "").toString()

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val card = buildCardModel()
        val payMethod = PaymentMethodModel(card = card, bankAccount = null)
        val payModel = NewPaymentModel(paymentMethod = payMethod)
        val idempotencyKey = UUID.randomUUID().toString()

        // auth header
        val encodedClientId = Base64.encodeToString(clientId.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
        val basicAuthHeader = "Basic $encodedClientId:"

        val call = serviceGenerator.createPaymentMethod(
          "application/json",
          idempotencyKey,
          basicAuthHeader,
          account,
          payModel)

        call.enqueue(object : Callback<PaymentModel> {
          override fun onResponse(call: Call<PaymentModel>, response: Response<PaymentModel>) {
            Log.d("response", response.toString())
            if (response.isSuccessful) {
              val resPaymentModel = response.body()
              buildSuccessResponse(response, resPaymentModel.toString())
            } else {
              val responseError = JSONObject(response.errorBody()!!.string())
              val error = responseError.getJSONObject("error")
              val msg = error.getString("message")
              buildErrorResponse(Throwable(msg), response.code())
            }
          }

          override fun onFailure(call: Call<PaymentModel>, t: Throwable) {
            buildErrorResponse(t, 0)
          }
        })
      }
    } catch (e: Exception) {
      Log.e("error", e.message.toString())
      buildErrorResponse(Throwable(resources.getString(R.string.error_alert)), 0)
    }
  }

  private fun buildCardModel(): CardModel {
    val cardNumber: InputView = findViewById(R.id.cardNumber)
    val expirationMM: InputView = findViewById(R.id.mm)
    val expirationYY: InputView = findViewById(R.id.yy)
    val cvvNumber: InputView = findViewById(R.id.cvv)

    return CardModel(
      name = "John Doe",
      number = cardNumber.text.toString().toLong(),
      verification = cvvNumber.text.toString().toInt(),
      month = expirationMM.text.toString().toInt(),
      year = ("20" + expirationYY.text.toString()).toInt(),
      address_postal_code = 55555,
    )
  }

  private fun buildSuccessResponse(response: Response<PaymentModel>, tokenData: String) {
    val args: WritableMap = Arguments.createMap()
    args.putInt("statusCode", response.code())
    args.putString("data", tokenData)
    args.putString("error", null)
    callerContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(
      id, "onSubmit", args
    )
  }

  private fun buildErrorResponse(t: Throwable, code: Int) {
    val args: WritableMap = Arguments.createMap()
    args.putInt("statusCode", code)
    args.putString("data", null)
    args.putString("error", t.message.toString())
    callerContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(
      id, "onSubmit", args
    )
  }

  private fun validateFields() : Boolean {
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
