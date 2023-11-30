package com.easycashwallet.tasks.utils.extention

import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

fun Context.getFirebaseRealTimeDataBaseFromPath(
    firebaseRealTimePaths: FirebaseRealTimePaths,
    onResult: (value:String?) -> Unit,
    onFailure: (() -> Unit)? = null,
) {
    val instance = FirebaseDatabase.getInstance()
    val databaseRef = instance.reference.child(firebaseRealTimePaths.path)
    databaseRef.addValueEventListener(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val newValue = snapshot.value?.toString()
            onResult(newValue)
        }

        override fun onCancelled(error: DatabaseError) {
            onFailure?.invoke()
        }

    })
}

enum class FirebaseRealTimePaths(val path : String) {
    BASE_URL("base_url"),
    AUTH_TOKEN("auth_token"),
}