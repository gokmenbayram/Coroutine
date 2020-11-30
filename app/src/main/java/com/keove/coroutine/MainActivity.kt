package com.keove.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keove.coroutine_retrofit.adapter.UsersAdapter
import com.keove.coroutine_retrofit.component.LoadingBar
import com.keove.coroutine_retrofit.model.Users
import com.keove.coroutine_retrofit.service.ApiClient
import com.keove.coroutine_retrofit.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    private lateinit var usersRecyclerView: RecyclerView
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        CoroutineScope(Dispatchers.Main).launch {

            val response = ApiClient.api()
                .create(ApiService::class.java)
                .getUsers()

            if (response.isSuccessful) {

                var usersList = (response.body() as ArrayList<Users>)
                usersAdapter = UsersAdapter(usersList)
                usersRecyclerView.layoutManager = GridLayoutManager(applicationContext, 1)
                usersRecyclerView.adapter = usersAdapter

            } else {
                Toast.makeText(applicationContext,"Hay aksi! Bir hata oldu :(", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun init() {
        usersRecyclerView = findViewById(R.id.usersRecyclerView)
        builder = LoadingBar.dialogBar(this, layoutInflater)
        alertDialog = builder.create()
    }
}