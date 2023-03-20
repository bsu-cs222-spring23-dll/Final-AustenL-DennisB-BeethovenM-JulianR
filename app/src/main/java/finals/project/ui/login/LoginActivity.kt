package finals.project.ui.login

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import finals.project.R
import finals.project.databinding.ActivityLoginBinding
import finals.project.data.HomeActivity
import finals.project.smsPage.MainActivity
import finals.project.ui.captcha.CaptchaGame
import finals.project.ui.captcha.FroggerGame

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        /** play frogger game **/
        //playFroggerGame()
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val username = binding.username
        val password = binding.password
        val login = binding.login
        val loading = binding.loading
        val intent = Intent(this, HomeActivity::class.java)
        val postButton = findViewById<View>(R.id.verify)
        postButton.setOnClickListener {
            postButton.visibility = View.INVISIBLE
            username.visibility= View.VISIBLE
            password.visibility=View.VISIBLE
            login.visibility=View.VISIBLE
        }

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
                .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }

        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                username.text.toString(),
                                password.text.toString()

                        )
                }
                false
            }

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())

                startActivity(intent)

            }
        }
    }

   private fun updateUiWithUser(model: LoggedInUserView) {
        // TODO : initiate successful logged in experience
        Toast.makeText(
                applicationContext,
                "User Registered Successfully",
                Toast.LENGTH_LONG
        ).show()

    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    private fun playFroggerGame() {
        val froggerGameBoardTextView = binding.froggerGameBoard

        val game = FroggerGame(11, 7) { board ->
            // Update the UI with the new board state.
            val boardText = board.joinToString(separator = "\n") { row -> row.joinToString("") }
            if (froggerGameBoardTextView != null) {
                froggerGameBoardTextView.text = boardText
            }
        }

        // Example movements: up, right, up, left, up
        game.movePlayer(0, -1)
        game.movePlayer(1, 0)
        game.movePlayer(0, -1)
        game.movePlayer(-1, 0)
        game.movePlayer(0, -1)
    }


}


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

    })

}