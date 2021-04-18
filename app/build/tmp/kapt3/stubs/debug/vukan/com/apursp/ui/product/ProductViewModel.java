package vukan.com.apursp.ui.product;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lvukan/com/apursp/ui/product/ProductViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mProductCategory", "Landroidx/lifecycle/MutableLiveData;", "Lvukan/com/apursp/models/ProductCategory;", "mProductDetails", "Lvukan/com/apursp/models/Product;", "mProductImages", "", "Lvukan/com/apursp/models/ProductImage;", "mProductUser", "Lvukan/com/apursp/models/User;", "repository", "Lvukan/com/apursp/repository/Repository;", "deleteProduct", "", "id", "", "getCategory", "getProductDetails", "getProductImages", "getProductUser", "incrementCounter", "reportAd", "productID", "app_debug"})
public final class ProductViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductImage>> mProductImages;
    private androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.Product> mProductDetails;
    private androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.ProductCategory> mProductCategory;
    private androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> mProductUser;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductImage>> getProductImages(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.Product> getProductDetails(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> getProductUser(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.ProductCategory> getCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    public final void incrementCounter(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    public final void reportAd(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public ProductViewModel() {
        super();
    }
}