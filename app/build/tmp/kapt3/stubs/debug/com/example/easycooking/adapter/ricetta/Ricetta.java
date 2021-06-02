package com.example.easycooking.adapter.ricetta;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u00ef\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010@J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010P\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u00f8\u0001\u0010U\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00c6\u0001\u00a2\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00162\b\u0010X\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Y\u001a\u00020\bH\u00d6\u0001J\t\u0010Z\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001d\"\u0004\b(\u0010\u001fR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006["}, d2 = {"Lcom/example/easycooking/adapter/ricetta/Ricetta;", "", "Ingredienti", "", "", "cookTime", "descrizione", "id", "", "image", "intolleranze", "keywords", "nome", "porzioni", "prepTime", "preparazione", "quantita", "recipeCategory", "recipeCuisine", "totalTime", "unita", "vegano", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getIngredienti", "()Ljava/util/List;", "setIngredienti", "(Ljava/util/List;)V", "getCookTime", "()Ljava/lang/String;", "setCookTime", "(Ljava/lang/String;)V", "getDescrizione", "setDescrizione", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImage", "setImage", "getIntolleranze", "setIntolleranze", "getKeywords", "setKeywords", "getNome", "setNome", "getPorzioni", "setPorzioni", "getPrepTime", "setPrepTime", "getPreparazione", "setPreparazione", "getQuantita", "setQuantita", "getRecipeCategory", "setRecipeCategory", "getRecipeCuisine", "setRecipeCuisine", "getTotalTime", "setTotalTime", "getUnita", "setUnita", "getVegano", "()Ljava/lang/Boolean;", "setVegano", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/example/easycooking/adapter/ricetta/Ricetta;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Ricetta {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> Ingredienti;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String cookTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String descrizione;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String image;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> intolleranze;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> keywords;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String nome;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String porzioni;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String prepTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String preparazione;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> quantita;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String recipeCategory;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String recipeCuisine;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String totalTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> unita;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean vegano;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getIngredienti() {
        return null;
    }
    
    public final void setIngredienti(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCookTime() {
        return null;
    }
    
    public final void setCookTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescrizione() {
        return null;
    }
    
    public final void setDescrizione(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getIntolleranze() {
        return null;
    }
    
    public final void setIntolleranze(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getKeywords() {
        return null;
    }
    
    public final void setKeywords(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPorzioni() {
        return null;
    }
    
    public final void setPorzioni(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrepTime() {
        return null;
    }
    
    public final void setPrepTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreparazione() {
        return null;
    }
    
    public final void setPreparazione(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getQuantita() {
        return null;
    }
    
    public final void setQuantita(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecipeCategory() {
        return null;
    }
    
    public final void setRecipeCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecipeCuisine() {
        return null;
    }
    
    public final void setRecipeCuisine(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTotalTime() {
        return null;
    }
    
    public final void setTotalTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getUnita() {
        return null;
    }
    
    public final void setUnita(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getVegano() {
        return null;
    }
    
    public final void setVegano(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    public Ricetta(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> Ingredienti, @org.jetbrains.annotations.Nullable()
    java.lang.String cookTime, @org.jetbrains.annotations.Nullable()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> intolleranze, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> keywords, @org.jetbrains.annotations.Nullable()
    java.lang.String nome, @org.jetbrains.annotations.Nullable()
    java.lang.String porzioni, @org.jetbrains.annotations.Nullable()
    java.lang.String prepTime, @org.jetbrains.annotations.Nullable()
    java.lang.String preparazione, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> quantita, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCuisine, @org.jetbrains.annotations.Nullable()
    java.lang.String totalTime, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> unita, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean vegano) {
        super();
    }
    
    public Ricetta() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.adapter.ricetta.Ricetta copy(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> Ingredienti, @org.jetbrains.annotations.Nullable()
    java.lang.String cookTime, @org.jetbrains.annotations.Nullable()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> intolleranze, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> keywords, @org.jetbrains.annotations.Nullable()
    java.lang.String nome, @org.jetbrains.annotations.Nullable()
    java.lang.String porzioni, @org.jetbrains.annotations.Nullable()
    java.lang.String prepTime, @org.jetbrains.annotations.Nullable()
    java.lang.String preparazione, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> quantita, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCategory, @org.jetbrains.annotations.Nullable()
    java.lang.String recipeCuisine, @org.jetbrains.annotations.Nullable()
    java.lang.String totalTime, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> unita, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean vegano) {
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