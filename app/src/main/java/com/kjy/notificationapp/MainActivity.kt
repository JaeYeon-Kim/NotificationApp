package com.kjy.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private val resultTextView: TextView by lazy {
        findViewById(R.id.resultTextView)
    }

    private val firebaseToken: TextView by lazy {
        findViewById(R.id.firebaseTokenTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebase()

    }

    private fun initFirebase() {
        // 파이어베이스로 테스트 메시지 띄워주기
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                // 성공적일때
                if(task.isSuccessful) {
                    Log.d("파이어베이스 토큰" ,"${task.result}")
                    // 성공적으로 파이어베이스의 토큰을 가져옴.
                    firebaseToken.text = task.result
                }
            }
    }
}