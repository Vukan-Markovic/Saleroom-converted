package vukan.com.apursp.ui.favorites;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lvukan/com/apursp/ui/favorites/FavoritesFragment;", "Landroidx/fragment/app/Fragment;", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ListItemClickListener;", "()V", "adapter", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter;", "favoritesViewModel", "Lvukan/com/apursp/ui/favorites/FavoritesViewModel;", "products", "", "getProducts", "()Lkotlin/Unit;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onListItemClick", "productID", "", "onStarItemClick", "view", "onViewCreated", "app_release"})
public final class FavoritesFragment extends androidx.fragment.app.Fragment implements vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ListItemClickListener {
    private vukan.com.apursp.adapters.ProductRecyclerViewAdapter adapter;
    private vukan.com.apursp.ui.favorites.FavoritesViewModel favoritesViewModel;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    
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
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onListItemClick(@org.jetbrains.annotations.Nullable()
    java.lang.String productID) {
    }
    
    @java.lang.Override()
    public void onStarItemClick(@org.jetbrains.annotations.Nullable()
    java.lang.String productID, @org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    private final kotlin.Unit getProducts() {
        return null;
    }
    
    public FavoritesFragment() {
        super();
    }
}