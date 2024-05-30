package com.example.newsroom.presentation.Login

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsroom.domain.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    private val _userInfo = MutableLiveData<User?>(null)
    val userInfo: LiveData<User?> = _userInfo


    fun LoginWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("quy", "login success")
                            home()
                        } else {
                            Log.d("quy", "login error: ${task.result.toString()}")
                        }
                    }
            } catch (ex: Exception) {
                Log.d("quy", "login: ${ex.message}")
            }
        }
    }

    private val database = FirebaseDatabase.getInstance().reference

    fun CreateWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val displayName = task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName, email)
                        home()
                    } else {
                        Log.d("create", "Create: ${task.result}")
                    }
                    _loading.value = false
                }
        }
    }

    private fun createUser(displayName: String?, email: String) {
        val userID = auth.currentUser?.uid

        val user = User(
            userid = userID.toString(),
            Email = email.toString(),
            Name = displayName.toString(),
            userVersion = "Entertainment App Version 1.0.0"
        )

        database.child("users").child(userID.toString()).setValue(user.toMap())
            .addOnCompleteListener {
                Log.d("user", "Add user: $it")
            }
            .addOnFailureListener {
                Log.d("user", "Add user error: $it")
            }
    }

    fun getUserInfo() {
        val userID = auth.currentUser?.uid
        database.child("users").child(userID.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val user = dataSnapshot.getValue(User::class.java)
                    _userInfo.value = user
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("user", "Get user error: $error")
                }
            })
    }
}