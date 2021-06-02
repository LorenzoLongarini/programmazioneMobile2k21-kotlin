package com.example.easycooking.DB;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/easycooking/DB/DispensaViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/easycooking/adapter/dispensa/DispensaRepository;", "(Lcom/example/easycooking/adapter/dispensa/DispensaRepository;)V", "allprod", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/easycooking/DB/DispensaDBEntity;", "getAllprod", "()Landroidx/lifecycle/LiveData;", "delete", "Lkotlinx/coroutines/Job;", "dispensa", "insert", "DispensaViewModelFactory", "app_debug"})
public final class DispensaViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.easycooking.DB.DispensaDBEntity>> allprod = null;
    private final com.example.easycooking.adapter.dispensa.DispensaRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.easycooking.DB.DispensaDBEntity>> getAllprod() {
        return null;
    }
    
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.DB.DispensaDBEntity dispensa) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.DB.DispensaDBEntity dispensa) {
        return null;
    }
    
    public DispensaViewModel(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.adapter.dispensa.DispensaRepository repository) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/easycooking/DB/DispensaViewModel$DispensaViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/example/easycooking/adapter/dispensa/DispensaRepository;", "(Lcom/example/easycooking/adapter/dispensa/DispensaRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class DispensaViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        private final com.example.easycooking.adapter.dispensa.DispensaRepository repository = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
        
        public DispensaViewModelFactory(@org.jetbrains.annotations.NotNull()
        com.example.easycooking.adapter.dispensa.DispensaRepository repository) {
            super();
        }
    }
}