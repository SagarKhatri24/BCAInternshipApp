package bca.internship

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var login : Button
    lateinit var email : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        login = findViewById(R.id.main_login)
        email = findViewById(R.id.main_username)
        password = findViewById(R.id.main_password)

        login.setOnClickListener {
            if(email.text.toString().trim().equals("")){
                email.error = "Username or Email Required"
            }
            else if(password.text.toString().trim().equals("")){
                password.error = "Password Required"
            }
            else if(password.text.toString().trim().length < 6){
                password.error = "Min. 6 Char Password Required"
            }
            else {
                if((email.text.toString().trim().equals("android") || email.text.toString().trim().equals("android@gmail.com")) && password.text.toString().trim().equals("Android@123")) {
                    System.out.println("Login Successfully")
                    Toast.makeText(this@MainActivity, "Login Successfully", Toast.LENGTH_LONG)
                        .show()
                    Snackbar.make(it, "Login Successfully", Snackbar.LENGTH_LONG).show()

                    var intent : Intent = Intent(this@MainActivity,DashboardActivity::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(this@MainActivity, "Login Unsuccessfully", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}