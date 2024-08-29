package com.eclatsol.userrendomme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eclatsol.userrendomme.adapter.UserAdapter
import com.eclatsol.userrendomme.databinding.ActivityMainBinding
import com.eclatsol.userrendomme.model.PostResponse
import com.eclatsol.userrendomme.model.UserResponse
import com.eclatsol.userrendomme.retrofit.ApiServiceData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiServiceData.apiService3.postApi().enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                Log.e("MainActivityProduct", "apiService3 Success")
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.e("MainActivityProduct", "apiService3 Failed:")
            }

        })

        ApiServiceData.apiService2.temperatureApi("1","true").enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                Log.e("MainActivityProduct", "apiService2 Success: ")
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.e("MainActivityProduct", "apiService2 Failed: ")
            }

        })

        ApiServiceData.apiService.loginApi().enqueue(object  : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    Log.e("MainActivityProduct", "apiService Success: ")

                    binding.rvUserData.layoutManager = LinearLayoutManager(this@MainActivity)
                    userAdapter = UserAdapter(this@MainActivity,response.body()?.results)
                    binding.rvUserData.adapter = userAdapter

                    val result = response.body()
                    for (i in response.body()?.results!!.indices){
                        Log.e("MainActivity", "onResponse: ${response.body()!!.results?.get(i)!!.id}")
                    }

                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed: ")
            }

        })
    }
}