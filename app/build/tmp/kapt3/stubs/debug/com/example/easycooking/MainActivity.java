package com.example.easycooking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\"\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010$\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/easycooking/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "RC_SIGN_IN", "", "TAG", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/example/easycooking/databinding/ActivityMainBinding;", "forgotPassword", "Landroid/widget/TextView;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "signInButton", "Lcom/google/android/gms/common/SignInButton;", "createRequest", "", "firebaseAuthWithGoogle", "idToken", "login", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "registratiView", "senzaReg", "signIn", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private com.google.firebase.auth.FirebaseAuth auth;
    private com.google.android.gms.common.SignInButton signInButton;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private android.widget.TextView forgotPassword;
    private final java.lang.String TAG = "SignInActivity";
    private final int RC_SIGN_IN = 9001;
    private com.example.easycooking.databinding.ActivityMainBinding binding;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void createRequest() {
    }
    
    private final void signIn() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void firebaseAuthWithGoogle(java.lang.String idToken) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void login() {
    }
    
    public final void senzaReg(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void registratiView(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public MainActivity() {
        super();
    }
}