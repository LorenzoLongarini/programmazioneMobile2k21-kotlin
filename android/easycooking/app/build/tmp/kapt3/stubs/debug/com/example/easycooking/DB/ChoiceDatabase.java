package com.example.easycooking.DB;

import java.lang.System;

@androidx.room.Database(entities = {com.example.easycooking.DB.DispensaDBEntity.class, com.example.easycooking.spesa.SpesaDBEntity.class, com.example.easycooking.adapter.ricetta.RicettaDBEntity.class}, version = 6, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/easycooking/DB/ChoiceDatabase;", "Landroidx/room/RoomDatabase;", "()V", "DispensaDAO", "Lcom/example/easycooking/DB/DispensaDAO;", "RicettaDAO", "Lcom/example/easycooking/adapter/ricetta/RicettaDAO;", "SpesaDAO", "Lcom/example/easycooking/spesa/SpesaDAO;", "ChoiceDatabaseCallback", "Companion", "app_debug"})
public abstract class ChoiceDatabase extends androidx.room.RoomDatabase {
    private static volatile com.example.easycooking.DB.ChoiceDatabase INSTANCE;
    public static final com.example.easycooking.DB.ChoiceDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.easycooking.DB.DispensaDAO DispensaDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.easycooking.spesa.SpesaDAO SpesaDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.easycooking.adapter.ricetta.RicettaDAO RicettaDAO();
    
    public ChoiceDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/easycooking/DB/ChoiceDatabase$ChoiceDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
    static final class ChoiceDatabaseCallback extends androidx.room.RoomDatabase.Callback {
        private final kotlinx.coroutines.CoroutineScope scope = null;
        
        /**
         * Override the onCreate method to populate the database.
         */
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        public ChoiceDatabaseCallback(@org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/easycooking/DB/ChoiceDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/easycooking/DB/ChoiceDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.easycooking.DB.ChoiceDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}