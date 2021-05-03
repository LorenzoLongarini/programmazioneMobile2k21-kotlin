package com.example.easycooking.database

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class OfflineActivity : AppCompatActivity() {

    private fun enablePersistence() {
        // Setta la persistenza del realtime database
        Firebase.database.setPersistenceEnabled(true)
    }

    private fun keepSynced() {
        //Mantiene il realtime database sincronizzato
        val ricetteRef = Firebase.database.getReference("ricette")
        ricetteRef.keepSynced(true)

        // [START rtdb_undo_keep_synced]
        ricetteRef.keepSynced(false)

    }


    private fun onDisconnect() {
        //Setta la disconnessione per il realtime database
        val presenceRef = Firebase.database.getReference("messaggiodidisconnessione")
        // Quando il client perde la connessione scrive un messaggio
        presenceRef.onDisconnect().setValue("Ti sei disconnesso!")


        // [START rtdb_on_disconnect_remove]
        presenceRef.onDisconnect().removeValue { error, reference ->
            error?.let {
                Log.d(TAG, "Non riesco a disconnettermi: ${error.message}")
            }
        }


        // [START rtdb_on_disconnect_cancel]
        val onDisconnectRef = presenceRef.onDisconnect()
        onDisconnectRef.setValue("Mi sono disconnesso")
        // ...
        // some time later when we change our minds
        // ...
        onDisconnectRef.cancel()

    }

    private fun getConnectionState() {
        // [START rtdb_listen_connected]
        val connectedRef = Firebase.database.getReference(".info/connected")
        connectedRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val connected = snapshot.getValue(Boolean::class.java) ?: false
                if (connected) {
                    Log.d(TAG, "connesso")
                } else {
                    Log.d(TAG, "non connesso")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Non mi sono aggiornato")
            }
        })

    }


    private fun getServerTimeOffset() {
        // [START rtdb_server_time_offset]
        val offsetRef = Firebase.database.getReference(".info/serverTimeOffset")
        offsetRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val offset = snapshot.getValue(Double::class.java) ?: 0.0
                val estimatedServerTimeMs = System.currentTimeMillis() + offset
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Non mi sono aggiornato")
            }
        })
        // [END rtdb_server_time_offset]
    }
    companion object {
        private val TAG = "OfflineActivity"
    }

    }


