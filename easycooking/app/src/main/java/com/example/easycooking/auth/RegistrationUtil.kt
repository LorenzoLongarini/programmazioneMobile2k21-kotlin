package com.example.easycooking.auth

object RegistrationUtil {

    private val existingUser = listOf("gina.sorrisi@icloud.com", "sandramilo@outlook.it")

    /*
     input non valido se i campi sono vuoti o l'email è gia stata inserita
     o la password non è lunga abbastanza
    */

    fun validateRegistrationInput(
        nome: String,
        cognome: String,
        email: String,
        password: String
    ):Boolean {
       if(nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || password.isEmpty()) {
           return false
       }
        if(email in existingUser){
            return false
        }
        if(password.count { it.isLetterOrDigit() } < 6) {
            return false
        }
        return true
    }
}