package com.example.iecaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var edtPass: EditText
    private lateinit var edtMail: EditText
    private lateinit var btnAceptar: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //inicia
        btnAceptar = findViewById(R.id.btnAceptar)
        edtMail = findViewById(R.id.edtMail)
        edtPass = findViewById(R.id.edtPass)
        auth = FirebaseAuth.getInstance()
        //loginAnonymously()



        btnAceptar.setOnClickListener {

            login()
            database = FirebaseDatabase.getInstance()

                }



        //termina


    }
    fun login(){
        auth = FirebaseAuth.getInstance()
       // val email = "a_crespo24@hotmail.com"
       // val  password = "1234Secu"


        val email = edtMail.text.toString()
        val  password = edtPass.text.toString()

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    Toast.makeText(this,"inicio exitoso para : " + user?.email,Toast.LENGTH_LONG).show()
                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Error en inicio de sesion ${task.exception?.message}",Toast.LENGTH_LONG).show()
                }
            }
    }

    fun loginAnonymously(){
        val auth = FirebaseAuth.getInstance()
        auth.signInAnonymously()
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    Toast.makeText(this,"inicio exitoso para Anonimo", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"Error en inicio de sesion ${task.exception?.message}",Toast.LENGTH_LONG).show()
                }

            }
    }
}