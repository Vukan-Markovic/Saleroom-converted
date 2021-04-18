package vukan.com.apursp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0014\u0010\u001c\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ProductViewHolder;", "listener", "Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ListItemClickListener;", "(Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ListItemClickListener;)V", "mOnClickListener", "products", "", "Lvukan/com/apursp/models/Product;", "productsCopy", "repository", "Lvukan/com/apursp/repository/Repository;", "storage", "Lvukan/com/apursp/firebase/Storage;", "filter", "", "t", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setProducts", "ListItemClickListener", "ProductViewHolder", "app_release"})
public final class ProductRecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ProductViewHolder> {
    private final vukan.com.apursp.firebase.Storage storage = null;
    private final vukan.com.apursp.repository.Repository repository = null;
    private java.util.List<vukan.com.apursp.models.Product> products;
    private final java.util.List<vukan.com.apursp.models.Product> productsCopy = null;
    private final vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ListItemClickListener mOnClickListener = null;
    
    public final void setProducts(@org.jetbrains.annotations.NotNull()
    java.util.List<vukan.com.apursp.models.Product> products) {
    }
    
    public final void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String t) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ProductViewHolder holder, int position) {
    }
    
    public ProductRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.adapters.ProductRecyclerViewAdapter.ListItemClickListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter;Landroid/view/View;)V", "productImage", "Landroid/widget/ImageView;", "productName", "Landroid/widget/TextView;", "star", "Landroid/widget/CheckBox;", "bind", "", "index", "", "onClick", "v", "app_release"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        private final android.widget.TextView productName = null;
        private final android.widget.ImageView productImage = null;
        private final android.widget.CheckBox star = null;
        
        public final void bind(int index) {
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lvukan/com/apursp/adapters/ProductRecyclerViewAdapter$ListItemClickListener;", "", "onListItemClick", "", "productID", "", "onStarItemClick", "view", "Landroid/view/View;", "app_release"})
    public static abstract interface ListItemClickListener {
        
        public abstract void onListItemClick(@org.jetbrains.annotations.Nullable()
        java.lang.String productID);
        
        public abstract void onStarItemClick(@org.jetbrains.annotations.Nullable()
        java.lang.String productID, @org.jetbrains.annotations.Nullable()
        android.view.View view);
    }
}