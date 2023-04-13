package com.justifi

import android.graphics.Color
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

class CardViewManager (
  private val callerContext: ReactApplicationContext
  ) : SimpleViewManager<LinearLayout>() {

    override fun getName() = "CardFormView"

    override fun createViewInstance(context: ThemedReactContext): LinearLayout {
      val rootLayout = LinearLayout(callerContext)
      // rootLayout.setBackgroundColor(Color.GRAY)
      rootLayout.setPadding(32, 16, 16, 32)
      rootLayout.orientation = LinearLayout.VERTICAL
      rootLayout.layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
      )

      // Card number
      var cardNumberTitle = TextView (callerContext);
      setupTitle(cardNumberTitle, callerContext.resources.getString(R.string.card_number), rootLayout)

      val cardNumber = EditText(callerContext)
      maxLength(cardNumber, 12)
      setupEditText(cardNumber, callerContext.resources.getString(R.string.card_number_hint), rootLayout)

      // Expiration
      var expirationTitle = TextView (callerContext);
      setupTitle(expirationTitle, callerContext.resources.getString(R.string.expiration), rootLayout)

      val expirationMM = EditText(callerContext)
      maxLength(expirationMM, 2)
      setupEditText(expirationMM, callerContext.resources.getString(R.string.expiration_mm), rootLayout)

      val expirationYY = EditText(callerContext)
      maxLength(expirationYY, 2)
      setupEditText(expirationYY, callerContext.resources.getString(R.string.expiration_yy), rootLayout)

      // CVV
      var cvvTitle = TextView (callerContext);
      setupTitle(cvvTitle, callerContext.resources.getString(R.string.cvv), rootLayout)

      val cvvNumber = EditText(callerContext)
      maxLength(cvvNumber, 4)
      setupEditText(cvvNumber, callerContext.resources.getString(R.string.cvv), rootLayout)
      return rootLayout;
    }

    private fun maxLength(view: EditText, max: Int) {
      val filterArray = arrayOfNulls<InputFilter>(1)
      filterArray[0] = InputFilter.LengthFilter(max)
      view.filters = filterArray
    }

    private fun setupTitle(view: TextView, title: String, layout: LinearLayout) {
      view.text = title
      view.setTextColor(Color.BLACK);
      layout.addView(view);
    }

    private fun setupEditText(view: EditText, hint: String, layout: LinearLayout) {
      view.layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
      )
      view.hint = hint
      view.inputType = InputType.TYPE_CLASS_NUMBER
      layout.addView(view)
    }
  }

