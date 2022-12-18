package com.anilyilmaz.ecommerceapp.Activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.anilyilmaz.ecommerceapp.R
import com.anilyilmaz.ecommerceapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener(View.OnClickListener {
            firebaseAuth.signInWithEmailAndPassword(binding.loginEmail.text.toString(),binding.loginPassword.text.toString()).addOnCompleteListener {task ->
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

        binding.NotMemberYetText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.forgetPasswordText.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
                .create()
            val view = layoutInflater.inflate(R.layout.alert_layout,null)
            val  closeButton = view.findViewById<Button>(R.id.ok_button)
            val  okButton = view.findViewById<Button>(R.id.close_button)
            builder.setView(view)
            closeButton.setOnClickListener {
                builder.dismiss()
            }
            okButton.setOnClickListener {
                val resetEmail = view.findViewById<TextView>(R.id.resetPasswordByEmailText)
                FirebaseAuth.getInstance().sendPasswordResetEmail(resetEmail.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                        }
                    }
                Toast.makeText(this,"Password reset link has been sent to your e-mail", Toast.LENGTH_SHORT).show()

            }
            builder.setCanceledOnTouchOutside(false)
            builder.show()

        }
    }

}