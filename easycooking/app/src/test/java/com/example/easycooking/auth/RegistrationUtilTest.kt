package com.example.easycooking.auth


import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * classe utilizzata per effettuare i test
 */

class RegistrationUtilTest {

    /**
     * test per verificare se il campo email è vuoto
     */
    @Test
    fun `empty email returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Gino",
            "Dal Campo",
            "",
            "123456"
        )
        assertThat(result).isFalse()
    }

    /**
     * test per verificare se i campi sono tutti correttamente inseriti
     */
    @Test
    fun `valid nome cognome email password return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Giuseppe",
            "Verdi",
            "giuseppeverdi@gmail.com",
            "ciao123456",
        )
        assertThat(result).isTrue()
    }

    /**
     * test per verificare se l'email inserita è già presente
     */
    @Test
    fun `existing email`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Gino",
            "Campo",
            "gina.sorrisi@icloud.com",
            "123456"
        )
        assertThat(result).isFalse()
    }

    /**
     * test per verificare se il campo password è vuoto
     */
    @Test
    fun `empty password`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Gino",
            "Dal Campo",
            "gino.dalcampo@gmail.com",
            ""
        )
        assertThat(result).isFalse()
    }

    /**
     * test per verificare se il campo password contiene almento 6 numeri o lettere
     */
    @Test
    fun `less than 6 characters password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Gino",
            "Dal Campo",
            "gino.dalcampo@gmail.com",
            "ciao2"
        )
        assertThat(result).isFalse()
    }
}