package com.example.easycooking.auth


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

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

    //empty password
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

    //password contains less than 6 digits
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