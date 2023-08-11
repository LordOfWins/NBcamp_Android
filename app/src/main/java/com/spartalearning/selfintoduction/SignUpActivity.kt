package com.spartalearning.selfintoduction

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpName: EditText
    private lateinit var signUpId: EditText
    private lateinit var signUpPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpName = findViewById(R.id.signUpName)
        signUpId = findViewById(R.id.signUpId)
        signUpPassword = findViewById(R.id.signUpPassword)
        signUp(view = View(this))
    }


    fun signUp(view: View) {
        if (view.id == R.id.button) {

            if (signUpName.text.isNotEmpty() && signUpId.text.isNotEmpty() && signUpPassword.text.isNotEmpty()) {
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("id", signUpId.text.toString())
                    putExtra("password", signUpPassword.text.toString())
                    putExtra("name", signUpName.text.toString())
                }

                setResult(RESULT_OK, intent)
                if (!isFinishing) {
                    finish()
                }
            } else {
                val signIn = SignInActivity()
                signIn.showToast(this, getString(R.string.id_password_msg))
            }
        }
    }
}