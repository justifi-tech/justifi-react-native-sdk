package com.justifi

import android.graphics.Color
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
      rootLayout.setPadding(16, 16, 16, 16)
      rootLayout.orientation = LinearLayout.VERTICAL
      rootLayout.layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
      )

      var textView = TextView (callerContext);
      textView.setText("Card Number")
      textView.setTextColor(Color.BLACK);
      rootLayout.addView(textView);

      val emailEditText = EditText(callerContext)
      emailEditText.layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
      )
      emailEditText.hint = "1234 1234 1234 1234"
      emailEditText.inputType = InputType.TYPE_NUMBER_FLAG_SIGNED
      rootLayout.addView(emailEditText)
      return rootLayout;
    }
  }

