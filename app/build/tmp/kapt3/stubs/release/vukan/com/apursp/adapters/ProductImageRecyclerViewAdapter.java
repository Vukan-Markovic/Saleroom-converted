package vukan.com.apursp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lvukan/com/apursp/adapters/ProductImageRecyclerViewAdapter;", "Lcom/smarteist/autoimageslider/SliderViewAdapter;", "Lvukan/com/apursp/adapters/ProductImageRecyclerViewAdapter$ProductViewHolder;", "products", "", "Lvukan/com/apursp/models/ProductImage;", "(Ljava/util/List;)V", "storage", "Lvukan/com/apursp/firebase/Storage;", "getCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "ProductViewHolder", "app_release"})
public final class ProductImageRecyclerViewAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<vukan.com.apursp.adapters.ProductImageRecyclerViewAdapter.ProductViewHolder> {
    private final vukan.com.apursp.firebase.Storage storage = null;
    private final java.util.List<vukan.com.apursp.models.ProductImage> products = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public vukan.com.apursp.adapters.ProductImageRecyclerViewAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.adapters.ProductImageRecyclerViewAdapter.ProductViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    public ProductImageRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<vukan.com.apursp.models.ProductImage> products) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lvukan/com/apursp/adapters/ProductImageRecyclerViewAdapter$ProductViewHolder;", "Lcom/smarteist/autoimageslider/SliderViewAdapter$ViewHolder;", "itemView", "Landroid/view/View;", "(Lvukan/com/apursp/adapters/ProductImageRecyclerViewAdapter;Landroid/view/View;)V", "productImage", "Landroid/widget/ImageView;", "bind", "", "index", "", "app_release"})
    public final class ProductViewHolder extends com.smarteist.autoimageslider.SliderViewAdapter.ViewHolder {
        private final android.widget.ImageView productImage = null;
        
        public final void bind(int index) {
        }
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}