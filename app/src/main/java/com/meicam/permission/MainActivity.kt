package com.meicam.permission

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onPhoneCall(view: View) {

//        if (allGranted){
//            phoneCall()
//        }else{
//            Toast.makeText(this,"you denied $deniedList",Toast.LENGTH_LONG).show()
//        }
    }

    private fun phoneCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:18810765302")
        startActivity(intent)
    }
}