package com.example.easycooking.DB;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lcom/example/easycooking/DB/DispensaApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/easycooking/DB/ChoiceDatabase;", "getDatabase", "()Lcom/example/easycooking/DB/ChoiceDatabase;", "database$delegate", "Lkotlin/Lazy;", "repositoryDispensa", "Lcom/example/easycooking/adapter/dispensa/DispensaRepository;", "getRepositoryDispensa", "()Lcom/example/easycooking/adapter/dispensa/DispensaRepository;", "repositoryDispensa$delegate", "repositoryRicetta", "Lcom/example/easycooking/adapter/ricetta/RicettaRepository;", "getRepositoryRicetta", "()Lcom/example/easycooking/adapter/ricetta/RicettaRepository;", "repositoryRicetta$delegate", "repositorySpesa", "Lcom/example/easycooking/spesa/SpesaRepository;", "getRepositorySpesa", "()Lcom/example/easycooking/spesa/SpesaRepository;", "repositorySpesa$delegate", "app_debug"})
public final class DispensaApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repositoryDispensa$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repositorySpesa$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repositoryRicetta$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getApplicationScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.DB.ChoiceDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.adapter.dispensa.DispensaRepository getRepositoryDispensa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.spesa.SpesaRepository getRepositorySpesa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.adapter.ricetta.RicettaRepository getRepositoryRicetta() {
        return null;
    }
    
    public DispensaApplication() {
        super();
    }
}