package com.example.easycooking.database.model

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://gino-49a3d-default-rtdb.firebaseio.com/.json?auth=hjzX17Km02W8odPD3Tw2nBSKaR3oRFd5NzmHzZdr"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface RicetteApiService {

    //coroutine
    @GET(".json?auth=hjzX17Km02W8odPD3Tw2nBSKaR3oRFd5NzmHzZdr")
    suspend fun getProperties(): List<Ricetta>
}

object RicettaApi {
    val retrofitService : RicetteApiService by lazy {
        retrofit.create(RicetteApiService::class.java) }
}
