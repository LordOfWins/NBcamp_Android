package com.spartalearning.selfintoduction


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var user: User
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
                    val resultId = data?.getStringExtra("id")
                    val password = data?.getStringExtra("password")
                    showToast(this, "ID: $resultId, Password: $password")

                }
            }
    }

    //회원 가입 버튼을 누르면 SignUpActivity 이동
    fun signUp(view: View) {
        //버튼을 클릭하면 SignUpActivity 이동
        val intent = Intent(this, SignUpActivity::class.java)
        activityResultLauncher.launch(intent)

    }

    fun logIn(view: View) {
        val userId = loginId.text.toString().trim()
        val userPassword = loginPassword.text.toString().trim()
        if (userId.isEmpty() || userPassword.isEmpty()) {
            showToast(
                this, getString(R.string.id_password_msg)
            )
        } else {
            val id = intent.getStringExtra("id").toString()
            val password = intent.getStringExtra("password").toString()
            val name = intent.getStringExtra("name").toString()
            user = User(id, password, name)
            val array = mutableListOf(user)
            array.add(user)
            if (userId == user.id && userPassword == user.password) {
                showToast(this, "로그인 성공")
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", userId) //id라는 key값을 넘긴다.
                startActivity(intent)
            } else {
                showToast(this, "로그인 실패")
            }
        }
    }

    fun showToast(context: Context, message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.custom_toast, null)

        val text: TextView = layout.findViewById(R.id.customToastText)
        text.text = message

        with(Toast(context)) {
            setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 100)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }

}





