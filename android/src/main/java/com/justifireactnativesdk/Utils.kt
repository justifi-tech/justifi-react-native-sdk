package com.justifireactnativesdk

import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.ReadableType
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class Utils {

  companion object {

    private const val CARD_NUMBER_VALID = "^[0-9]{13,16}\$"
    private const val MM_NUMBER_VALID = "^(0[1-9]|1[0-2])\$"
    private const val YY_NUMBER_VALID = "^\\d{2}\$"
    private const val CVV_NUMBER_VALID = "^[0-9]{3,4}\$"

    private const val ROUTING_NUMBER_VALID = "^[0-9]{9}\$"
    private const val ACCOUNT_NUMBER_VALID = "^[0-9]+$"

    /**
     * This function receives the string value of the font weight and returns the associated Typeface value.
     * @param value of the font weight
     * @return Int associated Typeface value
     * */
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

    /**
     * This function receives the color and title of the error and returns a SpannableStringBuilder with these fields set up.
     * @param errorColor error color value
     * @param errorTitle error title value
     * @return SpannableStringBuilder
     * */
    fun buildError(errorColor: Int, errorTitle: String): SpannableStringBuilder {
      val fgSpan = ForegroundColorSpan(errorColor)
      val ssBuilder = SpannableStringBuilder(errorTitle)
      ssBuilder.setSpan(fgSpan, 0, errorTitle.length, 0)
      return ssBuilder
    }

    /**
     * This function receives radius, width and color of the border, and background color. And returns the GradientDrawable with these fields set up.
     * @param borderRadius JSONObject of border radius
     * @param borderWidth value of border width
     * @param borderColor value of border color
     * @param backgroundColor value of background color
     * @return GradientDrawable
     * */
    fun getDrawable(borderRadius: JSONObject, borderWidth: Int, borderColor: Int, backgroundColor: Int): GradientDrawable {
      val topLeft = if (borderRadius.has("topLeft")) borderRadius.getInt("topLeft") else 0
      val topRight = if (borderRadius.has("topRight")) borderRadius.getInt("topRight") else 0
      val bottomRight = if (borderRadius.has("bottomRight")) borderRadius.getInt("bottomRight") else 0
      val bottomLeft = if (borderRadius.has("bottomLeft")) borderRadius.getInt("bottomLeft") else 0

      val gd = GradientDrawable()
      gd.setStroke(borderWidth, borderColor)
      gd.setColor(backgroundColor)
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

    /**
     * This function receives the card number and returns whether it is valid or not
     * @param cardNumber card number value
     * @return Boolean validation value
     * */
    fun validCard(cardNumber: String): Boolean {
      val regex = Regex(CARD_NUMBER_VALID)
      return regex.matches(cardNumber)
    }


    /**
     * This function receives a value of the month and returns whether it is valid or not
     * @param mm month value
     * @return Boolean validation value
     * */
    fun validMM(mm: String): Boolean {
      val regexMM = Regex(MM_NUMBER_VALID)
      return regexMM.matches(mm)
    }

    /**
     * This function receives a value of the year and returns whether it is valid or not
     * @param yy year value
     * @return Boolean validation value
     * */
    fun validYY(yy: String): Boolean {
      val regexMM = Regex(YY_NUMBER_VALID)
      return regexMM.matches(yy)
    }

    /**
     * This function receives a value of the cvv and returns whether it is valid or not
     * @param cvv year value
     * @return Boolean validation value
     * */
    fun validCVV(cvv: String): Boolean {
      val regexMM = Regex(CVV_NUMBER_VALID)
      return regexMM.matches(cvv)
    }

    /**
     * This function receives the routing number and returns whether it is valid or not
     * @param routingNumber routing number value
     * @return Boolean validation value
     * */
    fun validRoutingNumber(routingNumber: String): Boolean {
      val regex = Regex(ROUTING_NUMBER_VALID)
      return regex.matches(routingNumber)
    }

    /**
     * This function receives the account number and returns whether it is valid or not
     * @param accountNumber account number value
     * @return Boolean validation value
     * */
    fun validAccountNumber(accountNumber: String): Boolean {
      val regex = Regex(ACCOUNT_NUMBER_VALID)
      return regex.matches(accountNumber)
    }

    @Throws(JSONException::class)
    private fun convertArrayToJson(readableArray: ReadableArray): JSONArray? {
      val array = JSONArray()
      for (i in 0 until readableArray.size()) {
        when (readableArray.getType(i)) {
          ReadableType.Null -> {}
          ReadableType.Boolean -> array.put(readableArray.getBoolean(i))
          ReadableType.Number -> array.put(readableArray.getDouble(i))
          ReadableType.String -> array.put(readableArray.getString(i))
          ReadableType.Map -> array.put(convertMapToJson(readableArray.getMap(i)))
          ReadableType.Array -> array.put(convertArrayToJson(readableArray.getArray(i)))
        }
      }
      return array
    }

    /**
     * This function receives the ReadableMap and returns the associated JSONObject.
     * @param readableMap ReadableMap value
     * @return JSONObject
     * */
    @Throws(JSONException::class)
    fun convertMapToJson(readableMap: ReadableMap?): JSONObject? {
      val `object` = JSONObject()
      val iterator = readableMap!!.keySetIterator()
      while (iterator.hasNextKey()) {
        val key = iterator.nextKey()
        when (readableMap.getType(key)) {
          ReadableType.Null -> `object`.put(key, JSONObject.NULL)
          ReadableType.Boolean -> `object`.put(key, readableMap.getBoolean(key))
          ReadableType.Number -> `object`.put(key, readableMap.getDouble(key))
          ReadableType.String -> `object`.put(key, readableMap.getString(key))
          ReadableType.Map -> `object`.put(key, convertMapToJson(readableMap.getMap(key)))
          ReadableType.Array -> `object`.put(
            key,
            readableMap.getArray(key)?.let { convertArrayToJson(it) }
          )
        }
      }
      return `object`
    }

  }
}
