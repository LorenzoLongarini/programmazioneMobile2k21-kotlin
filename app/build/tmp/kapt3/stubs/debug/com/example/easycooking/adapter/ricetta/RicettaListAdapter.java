package com.example.easycooking.adapter.ricetta;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/easycooking/adapter/ricetta/RicettaDBEntity;", "Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter$RicettaViewHolder;", "()V", "elemo", "Ljava/util/ArrayList;", "getElemo", "()Ljava/util/ArrayList;", "setElemo", "(Ljava/util/ArrayList;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RicettaComparator", "RicettaViewHolder", "app_debug"})
public final class RicettaListAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.easycooking.adapter.ricetta.RicettaDBEntity, com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.easycooking.adapter.ricetta.RicettaDBEntity> elemo;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.easycooking.adapter.ricetta.RicettaDBEntity> getElemo() {
        return null;
    }
    
    public final void setElemo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.easycooking.adapter.ricetta.RicettaDBEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder holder, int position) {
    }
    
    public RicettaListAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter$RicettaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ricettaItemView", "Landroid/widget/TextView;", "ricettaPhoto", "Landroid/widget/ImageView;", "bind", "", "text", "", "foto", "Companion", "app_debug"})
    public static final class RicettaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView ricettaItemView = null;
        private final android.widget.ImageView ricettaPhoto = null;
        public static final com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder.Companion Companion = null;
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String text, @org.jetbrains.annotations.Nullable()
        java.lang.String foto) {
        }
        
        public RicettaViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter$RicettaViewHolder$Companion;", "", "()V", "create", "Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter$RicettaViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/easycooking/adapter/ricetta/RicettaListAdapter$RicettaComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/easycooking/adapter/ricetta/RicettaDBEntity;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class RicettaComparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.easycooking.adapter.ricetta.RicettaDBEntity> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.easycooking.adapter.ricetta.RicettaDBEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.example.easycooking.adapter.ricetta.RicettaDBEntity newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.easycooking.adapter.ricetta.RicettaDBEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.example.easycooking.adapter.ricetta.RicettaDBEntity newItem) {
            return false;
        }
        
        public RicettaComparator() {
            super();
        }
    }
}