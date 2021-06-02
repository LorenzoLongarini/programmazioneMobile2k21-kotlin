package com.example.easycooking.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J.\u0010\u001f\u001a\u00020\u00122\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!2\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0016J\u001a\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/easycooking/view/RicetteCerca;", "Landroidx/fragment/app/Fragment;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "()V", "LOGIN_REQUEST", "", "getLOGIN_REQUEST", "()I", "dbref", "Lcom/google/firebase/database/DatabaseReference;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "recView", "Landroidx/recyclerview/widget/RecyclerView;", "ricettaArray", "Ljava/util/ArrayList;", "Lcom/example/easycooking/adapter/ricetta/Ricetta;", "getRicetteFiltrate", "", "origin", "", "categ", "nomeRic", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "position", "id", "", "onNothingSelected", "onViewCreated", "itemView", "Companion", "app_debug"})
public final class RicetteCerca extends androidx.fragment.app.Fragment implements android.widget.AdapterView.OnItemSelectedListener {
    private final int LOGIN_REQUEST = 101;
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.firebase.database.DatabaseReference dbref;
    private androidx.recyclerview.widget.RecyclerView recView;
    private java.util.ArrayList<com.example.easycooking.adapter.ricetta.Ricetta> ricettaArray;
    public static final com.example.easycooking.view.RicetteCerca.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public final int getLOGIN_REQUEST() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View itemView, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onItemSelected(@org.jetbrains.annotations.NotNull()
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long id) {
    }
    
    @java.lang.Override()
    public void onNothingSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent) {
    }
    
    public final void getRicetteFiltrate(@org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String categ, @org.jetbrains.annotations.NotNull()
    java.lang.String nomeRic) {
    }
    
    public RicetteCerca() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/easycooking/view/RicetteCerca$Companion;", "", "()V", "newInstance", "Lcom/example/easycooking/view/RicetteTue;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.easycooking.view.RicetteTue newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}