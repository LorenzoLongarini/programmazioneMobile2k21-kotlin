package com.example.easycooking.adapter.offline;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/easycooking/adapter/offline/OfflineRepository;", "", "offDao", "Lcom/example/easycooking/adapter/offline/OfflineDAO;", "(Lcom/example/easycooking/adapter/offline/OfflineDAO;)V", "offprod", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/easycooking/adapter/offline/OfflineDBEntity;", "getOffprod", "()Lkotlinx/coroutines/flow/Flow;", "delete", "", "ricetta", "(Lcom/example/easycooking/adapter/offline/OfflineDBEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
public final class OfflineRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.easycooking.adapter.offline.OfflineDBEntity>> offprod = null;
    private final com.example.easycooking.adapter.offline.OfflineDAO offDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.easycooking.adapter.offline.OfflineDBEntity>> getOffprod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.adapter.offline.OfflineDBEntity ricetta, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.adapter.offline.OfflineDBEntity ricetta, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public OfflineRepository(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.adapter.offline.OfflineDAO offDao) {
        super();
    }
}