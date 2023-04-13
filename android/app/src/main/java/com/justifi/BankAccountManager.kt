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

class BankAccountManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<LinearLayout>() {

    override fun getName() = "BankAccountFormView"

    override fun createViewInstance(context: ThemedReactContext): LinearLayout {
      val rootLayout = LinearLayout(callerContext)
      // rootLayout.setBackgroundColor(Color.GRAY)
      rootLayout.setPadding(32, 16, 16, 32)
      rootLayout.orientation = LinearLayout.VERTICAL
      rootLayout.layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
      )

      // Routing
      var routingTitle = TextView (callerContext);
      setupTitle(routingTitle, callerContext.resources.getString(R.string.routing_number), rootLayout)

      val routingNumber = EditText(callerContext)
      maxLength(routingNumber, 9)
      setupEditText(routingNumber, "", rootLayout)

      // Account
      var accountTitle = TextView (callerContext);
      setupTitle(accountTitle, callerContext.resources.getString(R.string.account_number), rootLayout)

      val accountNumber = EditText(callerContext)
      maxLength(routingNumber, 17)
      setupEditText(accountNumber, "", rootLayout)

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
