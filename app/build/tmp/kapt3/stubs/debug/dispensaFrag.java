
import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\"\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"LdispensaFrag;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/easycooking/adapter/dispensa/DispensaListAdapter;", "getAdapter", "()Lcom/example/easycooking/adapter/dispensa/DispensaListAdapter;", "dbref", "Lcom/google/firebase/database/DatabaseReference;", "dispensaViewModel", "Lcom/example/easycooking/DB/DispensaViewModel;", "getDispensaViewModel", "()Lcom/example/easycooking/DB/DispensaViewModel;", "dispensaViewModel$delegate", "Lkotlin/Lazy;", "newDispensaActivityRequestCode", "", "recView", "Landroidx/recyclerview/widget/RecyclerView;", "ricettaArray", "Ljava/util/ArrayList;", "Lcom/example/easycooking/adapter/ricetta/Ricetta;", "getRicetteFiltrate", "", "ingr", "", "", "onActivityResult", "requestCode", "resultCode", "intentData", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "itemView", "Companion", "app_debug"})
public final class dispensaFrag extends androidx.fragment.app.Fragment {
    private final int newDispensaActivityRequestCode = 1;
    private com.google.firebase.database.DatabaseReference dbref;
    private androidx.recyclerview.widget.RecyclerView recView;
    private java.util.ArrayList<com.example.easycooking.adapter.ricetta.Ricetta> ricettaArray;
    private final kotlin.Lazy dispensaViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.easycooking.adapter.dispensa.DispensaListAdapter adapter = null;
    public static final dispensaFrag.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.example.easycooking.DB.DispensaViewModel getDispensaViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.easycooking.adapter.dispensa.DispensaListAdapter getAdapter() {
        return null;
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
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent intentData) {
    }
    
    public final void getRicetteFiltrate(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> ingr) {
    }
    
    public dispensaFrag() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"LdispensaFrag$Companion;", "", "()V", "newInstance", "LdispensaFrag;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final dispensaFrag newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}