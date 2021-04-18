package vukan.com.apursp.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u001c\u0010\u001f\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lvukan/com/apursp/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ListItemClickListener;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "adapter", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter;", "filters", "Landroid/widget/Button;", "homeViewModel", "Lvukan/com/apursp/ui/home/HomeViewModel;", "mSwipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "search", "Landroidx/appcompat/widget/SearchView;", "loadRecyclerViewData", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onListItemClick", "productID", "", "onRefresh", "onStarItemClick", "view", "onViewCreated", "app_release"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ListItemClickListener, androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {
    private vukan.com.apursp.adapters.ProductRecyclerViewAdapter adapter;
    private androidx.appcompat.widget.SearchView search;
    private android.widget.Button filters;
    private vukan.com.apursp.ui.home.HomeViewModel homeViewModel;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout mSwipeRefreshLayout;
    
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
    
    @java.lang.Override()
    public void onRefresh() {
    }
    
    private final void loadRecyclerViewData() {
    }
    
    public HomeFragment() {
        super();
    }
}