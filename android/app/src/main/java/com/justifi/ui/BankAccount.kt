package com.justifi.ui

import android.graphics.Color
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.justifi.R
import com.facebook.react.uimanager.ThemedReactContext

class BankAccount(context: ThemedReactContext) : LinearLayout(context) {
  private var callerContext: ThemedReactContext = context

  private var styleOverrides: String = ""
  private var validationStrategy: String = ""

  init {
    init()
  }

  private fun init() {
    inflate(callerContext, R.layout.bank_account, this)
    val rootLayout : LinearLayout = findViewById(R.id.container_bank_account)

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
  }

  fun setStyleOverrides(style: String) {
    styleOverrides = style
  }

  fun setValidationStrategy(validation: String) {
    validationStrategy = validation
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
