package com.spartalearning.selfintoduction


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var loginId: EditText
    private lateinit var loginPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginId = findViewById(R.id.loginId)
        loginPassword = findViewById(R.id.loginPassword)

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    val id = data?.getStringExtra("id")
                    val password = data?.getStringExtra("password")
                    Toast.makeText(this, "ID: $id, Password: $password", Toast.LENGTH_SHORT).show()

                }
            }
    }

    //login 버튼을 누르면 loginActivity로 이동
    fun signUp(view: View) {
        //버튼을 클릭하면 SignInActivity로 이동
        val intent = Intent(this, SignUpActivity::class.java)
        activityResultLauncher.launch(intent)

    }

    fun logIn(view: View) {
        val userId = loginId.text.toString().trim()
        val userPassword = loginPassword.text.toString().trim()
        if (userId.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(
                this, getString(R.string.id_password_msg), Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", userId) //id라는 key값을 넘긴다.
            startActivity(intent)
        }
    }


}





