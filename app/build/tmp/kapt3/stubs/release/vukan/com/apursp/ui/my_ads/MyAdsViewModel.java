package vukan.com.apursp.ui.my_ads;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lvukan/com/apursp/ui/my_ads/MyAdsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mComments", "Landroidx/lifecycle/MutableLiveData;", "", "Lvukan/com/apursp/models/Comment;", "mProduct", "Lvukan/com/apursp/models/Product;", "mUser", "Lvukan/com/apursp/models/User;", "mUserRating", "", "repository", "Lvukan/com/apursp/repository/Repository;", "addNewUserComment", "", "newComment", "addUser", "deleteUserData", "userID", "", "editUserInfo", "user", "getUser", "getUserComments", "getUserProducts", "getUserRating", "reportUser", "updateProfilePicture", "imageUrl", "Landroid/net/Uri;", "updateProfilePictureBitmap", "imageBitmap", "Landroid/graphics/Bitmap;", "app_release"})
public final class MyAdsViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    private androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> mUser;
    private androidx.lifecycle.MutableLiveData<java.lang.Float> mUserRating;
    private androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> mProduct;
    private androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Comment>> mComments;
    
    public final void reportUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUrl) {
    }
    
    public final void updateProfilePictureBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap imageBitmap) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> getUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Float> getUserRating(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    public final void deleteUserData(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public final void addNewUserComment(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Comment newComment) {
    }
    
    public final void addUser() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getUserProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Comment>> getUserComments(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    public final void editUserInfo(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.User user) {
    }
    
    public MyAdsViewModel() {
        super();
    }
}