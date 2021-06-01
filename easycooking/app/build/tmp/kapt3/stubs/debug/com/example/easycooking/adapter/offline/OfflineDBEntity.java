package com.example.easycooking.adapter.offline;

import java.lang.System;

@androidx.room.Entity(tableName = "offline_table")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\u00b6\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020<H\u00d6\u0001J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010\'\u00a8\u0006>"}, d2 = {"Lcom/example/easycooking/adapter/offline/OfflineDBEntity;", "", "nome", "", "Ingredienti", "cookTime", "descrizione", "image", "intolleranze", "", "porzioni", "prepTime", "preparazione", "quantita", "vegano", "", "unita", "recipeCategory", "recipeCuisine", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getIngredienti", "()Ljava/lang/String;", "setIngredienti", "(Ljava/lang/String;)V", "getCookTime", "getDescrizione", "getImage", "getIntolleranze", "()Ljava/util/List;", "getNome", "setNome", "getPorzioni", "getPrepTime", "getPreparazione", "getQuantita", "getRecipeCategory", "getRecipeCuisine", "getUnita", "getVegano", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/example/easycooking/adapter/offline/OfflineDBEntity;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class OfflineDBEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "nome_ricetta")
    @androidx.room.PrimaryKey()
    private java.lang.String nome;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ingredienti_ricetta")
    private java.lang.String Ingredienti;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "tempocott_ricetta")
    private final java.lang.String cookTime = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "descrizione_ricetta")
    private final java.lang.String descrizione = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "photo_ricetta")
    private final java.lang.String image = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "nome_ricetta")
    private final java.util.List<java.lang.String> intolleranze = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "porzioni_ricetta")
    private final java.lang.String porzioni = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "tempoprep_ricetta")
    private final java.lang.String prepTime = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "prep_ricetta")
    private final java.lang.String preparazione = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "nome_ricetta")
    private final java.util.List<java.lang.String> quantita = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "nome_ricetta")
    private final java.lang.Boolean vegano = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "nome_ricetta")
    private final java.util.List<java.lang.String> unita = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "category_ricetta")
    private final java.lang.String recipeCategory = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "cusine_ricetta")
    private final java.lang.String recipeCuisine = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIngredienti() {
        return null;
    }
    
    public final void setIngredienti(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCookTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescrizione() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getIntolleranze() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPorzioni() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrepTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPreparazione() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getQuantita() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getVegano() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getUnita() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecipeCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecipeCuisine() {
        return null;
    }
    
    public OfflineDBEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, @org.jetbrains.annotations.NotNull()
    java.lang.String Ingredienti, @org.jetbrains.annotations.NotNull()
    java.lang.String cookTime, @org.jetbrains.annotations.NotNull()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> intolleranze, @org.jetbrains.annotations.NotNull()
    java.lang.String porzioni, @org.jetbrains.annotations.NotNull()
    java.lang.String prepTime, @org.jetbrains.annotations.NotNull()
    java.lang.String preparazione, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> quantita, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean vegano, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> unita, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCuisine) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.adapter.offline.OfflineDBEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, @org.jetbrains.annotations.NotNull()
    java.lang.String Ingredienti, @org.jetbrains.annotations.NotNull()
    java.lang.String cookTime, @org.jetbrains.annotations.NotNull()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> intolleranze, @org.jetbrains.annotations.NotNull()
    java.lang.String porzioni, @org.jetbrains.annotations.NotNull()
    java.lang.String prepTime, @org.jetbrains.annotations.NotNull()
    java.lang.String preparazione, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> quantita, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean vegano, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> unita, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCuisine) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}