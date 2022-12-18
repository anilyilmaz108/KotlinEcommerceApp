package com.anilyilmaz.ecommerceapp.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.anilyilmaz.ecommerceapp.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener(View.OnClickListener {
            firebaseAuth.createUserWithEmailAndPassword(binding.loginEmail.text.toString(),binding.loginPassword.text.toString()).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    val intent = Intent(this, BaseActivity::class.java)
                    startActivity(intent)
                    finish()
                    val snackBar = Snackbar.make(
                        it, "Welcome ${firebaseAuth.currentUser?.email}",
                        Snackbar.LENGTH_SHORT
                    ).setAction("Action", null)
                    snackBar.setActionTextColor(Color.WHITE)
                    val snackBarView = snackBar.view
                    snackBarView.setBackgroundColor(Color.BLUE)
                    val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                    textView.setTextColor(Color.WHITE)
                    snackBar.show()

                }

            }.addOnFailureListener { exception ->
                Toast.makeText(this,exception.localizedMessage.toString(), Toast.LENGTH_LONG).show()
            }

        })

        binding.alreadyAccountText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}