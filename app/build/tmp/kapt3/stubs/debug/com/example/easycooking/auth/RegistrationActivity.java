package com.example.easycooking.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/easycooking/auth/RegistrationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnRegistra", "Landroid/widget/Button;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "textCognome", "Lcom/google/android/material/textfield/TextInputEditText;", "textEmail", "textNome", "textPassword", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "writeUserToDb", "nome", "", "cognome", "uid", "app_debug"})
public final class RegistrationActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.material.textfield.TextInputEditText textNome;
    private com.google.android.material.textfield.TextInputEditText textCognome;
    private com.google.android.material.textfield.TextInputEditText textEmail;
    private com.google.android.material.textfield.TextInputEditText textPassword;
    private android.widget.Button btnRegistra;
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void writeUserToDb(java.lang.String nome, java.lang.String cognome, java.lang.String uid) {
    }
    
    public RegistrationActivity() {
        super();
    }
}