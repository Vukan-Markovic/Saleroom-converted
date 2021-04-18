package vukan.com.apursp.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lvukan/com/apursp/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mProducts", "Landroidx/lifecycle/MutableLiveData;", "", "Lvukan/com/apursp/models/Product;", "products", "getProducts", "()Landroidx/lifecycle/MutableLiveData;", "repository", "Lvukan/com/apursp/repository/Repository;", "addProductToFavourites", "", "productID", "", "filterProducts", "filters", "", "([Ljava/lang/String;)Landroidx/lifecycle/MutableLiveData;", "removeProductFromFavourites", "app_release"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> mProducts;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> filterProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String[] filters) {
        return null;
    }
    
    public final void addProductToFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public final void removeProductFromFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public HomeViewModel() {
        super();
    }
}