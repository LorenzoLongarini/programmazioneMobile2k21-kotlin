package com.example.easycooking.database

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.R
import com.example.easycooking.database.model.Ingrediente
import com.example.easycooking.database.model.Ricetta
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


/**
 * Kotlin verison of {@link QueryActivity].
 */
abstract class QueryActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "KotlinQueryActivity"
    }

    private lateinit var ricetteRef: DatabaseReference
    private lateinit var databaseReference: DatabaseReference
    private lateinit var ricetteQuery: Query

    private lateinit var ricetteListener: ValueEventListener
    private lateinit var ricetteQueryListener: ChildEventListener

    //var uid: String = "42"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)

        databaseReference = Firebase.database.reference
    }

    private fun basicListen() {
        // [START basic_listen]
        // Get a reference to Ricette and attach a listener
        ricetteRef = databaseReference.child("ricette")
        ricetteListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // New data at this path. This method will be called after every change in the
                // data at this path or a subpath.

                Log.d(TAG, "Il numero di ricette presenti è: ${dataSnapshot.childrenCount}")
                dataSnapshot.children.forEach { child ->
                    // Extract Message object from the DataSnapshot
                    val ricetta: Ricetta? = child.getValue<Ricetta>()

                    // Use the message
                    // [START_EXCLUDE]
                    Log.d(TAG, "L'id della ricetta è: ${ricetta?.id}")
                    Log.d(TAG, "Il nome della ricetta è: ${ricetta?.nome}")
                    // [END_EXCLUDE]
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Could not successfully listen for data, log the error
                Log.e(TAG, "ricette:onCancelled: ${error.message}")
            }
        }
        ricetteRef.addValueEventListener(ricetteListener)
        // [END basic_listen]
    }


    private fun cleanBasicListener() {
        // Clean up value listener
        // [START clean_basic_listen]
        ricetteRef.removeEventListener(ricetteListener)
        // [END clean_basic_listen]
    }

    private fun cleanBasicQuery() {
        // Clean up query listener
        // [START clean_basic_query]
        ricetteQuery.removeEventListener(ricetteQueryListener)
        // [END clean_basic_query]
    }

    fun orderByNested() {
        // [START rtdb_order_by_nested]
        // Most viewed posts
        val RicettaConPiuIngrdentiQuery = databaseReference.child("ricette")
                .orderByChild("metrics/views")
        RicettaConPiuIngrdentiQuery.addChildEventListener(object : ChildEventListener {
            // TODO: implement the ChildEventListener methods as documented above
            // [START_EXCLUDE]
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {}

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}

            override fun onCancelled(databaseError: DatabaseError) {}
            // [END_EXCLUDE]
        })
        // [END rtdb_order_by_nested]
    }

    private fun childEventListenerRecycler() {
        val context = this
        // [START child_event_listener_recycler]
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.key!!)

                // A new comment has been added, add it to the displayed list
                val ingrediente = dataSnapshot.getValue<Ingrediente>()

                // ...
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildChanged: ${dataSnapshot.key}")

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                val newIngrdiente = dataSnapshot.getValue<Ingrediente>()
                val ingredienteKey = dataSnapshot.key

                // ...
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.key!!)

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                val ingredienteKey = dataSnapshot.key

                // ...
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.key!!)

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                val movedIngrediente = dataSnapshot.getValue<Ingrediente>()
                val ingredienteKey = dataSnapshot.key

                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException())
                Toast.makeText(context, "Non sono riuscito a scaricare gli ingredienti.",
                        Toast.LENGTH_SHORT).show()
            }
        }
        databaseReference.addChildEventListener(childEventListener)
        // [END child_event_listener_recycler]
    }

    private fun recentPostsQuery() {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys.
        databaseReference.child("ricette").limitToFirst(100)
        // [END recent_posts_query]
    }

    override fun onStart() {
        super.onStart()
        basicListen()

    }

    override fun onStop() {
        super.onStop()
        cleanBasicListener()
        cleanBasicQuery()
    }
}