package com.s2d5.myawesomeproject

import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.s2d5.myawesomeproject.databinding.ActivityJoinBinding


class JoinActivity : AppCompatActivity() {

    lateinit var binding:ActivityJoinBinding
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
    }

    fun onClick(view: View) {
        when(view) {
            binding.joinBTN -> {
                val email = binding.idET.text.toString()
                val password = binding.pwET.text.toString()

                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this,
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("JoinActivity", "createUserWithEmail:success")
                                val user: FirebaseUser? = mAuth.getCurrentUser()
                                updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("JoinActivity", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(
                                    this, "Authentication failed.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                updateUI(null)
                            }

                            // ...
                        })
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if(user!=null) {
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}