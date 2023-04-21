package com.justifi

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import org.json.JSONObject

class Utils {

  companion object {

    private const val CARD_NUMBER_VALID = "^[0-9]{13,16}\$"
    private const val MM_NUMBER_VALID = "^(0[1-9]|1[0-2])\$"
    private const val YY_NUMBER_VALID = "^\\d{2}\$"
    private const val CVV_NUMBER_VALID = "^[0-9]{3,4}\$"

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

    fun validCard(cardNumber: String): Boolean {
//            var sum = 0
//            var alternate = false
//            val digits = cardNumber.reversed().map { it.toString().toInt() }
//            for (digit in digits) {
//                if (alternate) {
//                    val doubledDigit = digit * 2
//                    sum += if (doubledDigit > 9) doubledDigit - 9 else doubledDigit
//                } else {
//                    sum += digit
//                }
//                alternate = !alternate
//            }
      val regex = Regex(CARD_NUMBER_VALID)
      return regex.matches(cardNumber)
//            return regex.matches(cardNumber) && sum % 10 == 0
    }

    fun validMM(mm: String): Boolean {
      val regexMM = Regex(MM_NUMBER_VALID)
      return regexMM.matches(mm)
    }

    fun validYY(mm: String): Boolean {
      val regexMM = Regex(YY_NUMBER_VALID)
      return regexMM.matches(mm)
    }

    fun validCVV(cvv: String): Boolean {
      val regexMM = Regex(CVV_NUMBER_VALID)
      return regexMM.matches(cvv)
    }

  }
}
