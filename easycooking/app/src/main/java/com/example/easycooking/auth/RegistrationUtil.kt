package com.example.easycooking.auth

/**
 * Utilizzata per ettuare i test sulla validazione dei campi per quanto concerne la registrazione dell'utente
 *
 */

object RegistrationUtil {

    private val existingUser = listOf("gina.sorrisi@icloud.com", "sandramilo@outlook.it")

    /**
     * funzione che controlla se i campi sono vuoti o l'email è già stata inserita o la password contiene almeno 6 numeri o lettere
     *
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