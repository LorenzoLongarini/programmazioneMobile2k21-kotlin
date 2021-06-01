package com.example.easycooking.spesa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/easycooking/spesa/SpesaListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/easycooking/spesa/SpesaDBEntity;", "Lcom/example/easycooking/spesa/SpesaListAdapter$SpesaViewHolder;", "()V", "elems", "Ljava/util/ArrayList;", "getElems", "()Ljava/util/ArrayList;", "setElems", "(Ljava/util/ArrayList;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SpesaComparator", "SpesaViewHolder", "app_debug"})
public final class SpesaListAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.easycooking.spesa.SpesaDBEntity, com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.easycooking.spesa.SpesaDBEntity> elems;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.easycooking.spesa.SpesaDBEntity> getElems() {
        return null;
    }
    
    public final void setElems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.easycooking.spesa.SpesaDBEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder holder, int position) {
    }
    
    public SpesaListAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/easycooking/spesa/SpesaListAdapter$SpesaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "spesaItemView", "Landroid/widget/TextView;", "bind", "", "text", "", "Companion", "app_debug"})
    public static final class SpesaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView spesaItemView = null;
        public static final com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder.Companion Companion = null;
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String text) {
        }
        
        public SpesaViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/easycooking/spesa/SpesaListAdapter$SpesaViewHolder$Companion;", "", "()V", "create", "Lcom/example/easycooking/spesa/SpesaListAdapter$SpesaViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/easycooking/spesa/SpesaListAdapter$SpesaComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/easycooking/spesa/SpesaDBEntity;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class SpesaComparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.easycooking.spesa.SpesaDBEntity> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.easycooking.spesa.SpesaDBEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.example.easycooking.spesa.SpesaDBEntity newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.easycooking.spesa.SpesaDBEntity oldItem, @org.jetbrains.annotations.NotNull()
        com.example.easycooking.spesa.SpesaDBEntity newItem) {
            return false;
        }
        
        public SpesaComparator() {
            super();
        }
    }
}