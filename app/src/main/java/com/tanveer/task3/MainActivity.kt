package com.tanveer.task3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tanveer.task3.R.id.btnSnackBar
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var btnWebsite: Button? = null
    var btnDial: Button? = null
    var btnSms: Button? = null
    var btnEmail: Button? = null
    var btnSnackBar : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWebsite = findViewById(R.id.btnWebsite)
        btnDial = findViewById(R.id.btnDial)
        btnSms = findViewById(R.id.btnSms)
        btnEmail = findViewById(R.id.btnEmail)
        btnSnackBar = findViewById(R.id.btnSnackBar)
        btnWebsite?.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://kotlinlang.org/"))
            startActivity(intent)
        }
        btnDial?.setOnClickListener {
            try {
                var intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:XXXXXXXXXX"))
                startActivity(intent)
            } catch (exception: Exception) {
                Toast.makeText(this, "Sorry cannot dial a number", Toast.LENGTH_SHORT).show()
            }
            btnSms?.setOnClickListener {
                var intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse( "sms:XXXXXXXXXX"))
                startActivity(intent)
            }
            btnEmail?.setOnClickListener {
                try{
                var intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/email")
                startActivity(intent)
            } catch(exception : Exception){
                    Toast.makeText(this, "sorry cannot open email", Toast.LENGTH_SHORT).show()}
            }
            btnSnackBar?.setOnClickListener {
                Snackbar.make(it,"This is the snackbar",Snackbar.LENGTH_SHORT)
                    .setAnchorView(btnSms)
                    .setAction("Undo",{_->
                        Toast.makeText(this, "this is toast", Toast.LENGTH_SHORT).show()
                    })
                    .show()
            }
        }
    }
}