package vukan.com.apursp.ui.favorites;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lvukan/com/apursp/ui/favorites/FavoritesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "favouriteProducts", "Landroidx/lifecycle/MutableLiveData;", "", "Lvukan/com/apursp/models/Product;", "getFavouriteProducts", "()Landroidx/lifecycle/MutableLiveData;", "mProducts", "repository", "Lvukan/com/apursp/repository/Repository;", "removeProductFromFavourites", "", "productID", "", "app_release"})
public final class FavoritesViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> mProducts;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getFavouriteProducts() {
        return null;
    }
    
    public final void removeProductFromFavourites(@org.jetbrains.annotations.Nullable()
    java.lang.String productID) {
    }
    
    public FavoritesViewModel() {
        super();
    }
}