package com.androidstudio.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidstudio.intro.databinding.ActivityLoginBinding
import com.androidstudio.intro.model.ResponseLogin
import com.androidstudio.intro.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {
    private var binding : ActivityLoginBinding? = null
    private var user : String = ""
    private var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnsubmit.setOnClickListener{
            user = binding!!.username.text.toString()
            pass = binding!!.password.text.toString()

            when {
                user == "" -> {
                    binding!!.username.error = "Username can't be empty"
                }
                pass == "" -> {
                    binding!!.password.error = "Password can't be empty"
                }
                else -> {
                    getData()
                }
            }
        }
    }

    private  fun getData() {
        val api = RetrofitClient().getInstance()
        api.login(user, pass).enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    if (response.body()?.response == true) {
                        startActivity(Intent(this@login, dashboard::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@login,
                            "Login gagal, Periksa kembali username dan password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@login,
                        "Login gagal, Terjadi kesalahan",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
               Log.e("pesan error", "${t.message}")
            }

        })
    }
}