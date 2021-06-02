package com.example.easycooking.spesa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/easycooking/spesa/SpesaRepository;", "", "spesaDao", "Lcom/example/easycooking/spesa/SpesaDAO;", "(Lcom/example/easycooking/spesa/SpesaDAO;)V", "allprod", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/easycooking/spesa/SpesaDBEntity;", "getAllprod", "()Lkotlinx/coroutines/flow/Flow;", "delete", "", "spesa", "(Lcom/example/easycooking/spesa/SpesaDBEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
public final class SpesaRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.easycooking.spesa.SpesaDBEntity>> allprod = null;
    private final com.example.easycooking.spesa.SpesaDAO spesaDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.easycooking.spesa.SpesaDBEntity>> getAllprod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.spesa.SpesaDBEntity spesa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.spesa.SpesaDBEntity spesa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public SpesaRepository(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.spesa.SpesaDAO spesaDao) {
        super();
    }
}