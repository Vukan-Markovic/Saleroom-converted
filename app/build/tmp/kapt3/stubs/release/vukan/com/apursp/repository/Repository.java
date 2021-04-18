package vukan.com.apursp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001fJ\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020)J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020&2\u0006\u0010+\u001a\u00020)J\u0006\u0010/\u001a\u00020&J\u0010\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010\u0011J\u0010\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010)J\u0010\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u00010)J\u0010\u00106\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u00010)J\u000e\u00108\u001a\u00020&2\u0006\u0010#\u001a\u00020\u001bJ%\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00042\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;\u00a2\u0006\u0002\u0010<J\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u00042\b\u0010>\u001a\u0004\u0018\u00010)J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\b\u00103\u001a\u0004\u0018\u00010)J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\u00103\u001a\u0004\u0018\u00010)J\u001c\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\b\u00103\u001a\u0004\u0018\u00010)J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\b\u00103\u001a\u0004\u0018\u00010)J\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\b\u00107\u001a\u0004\u0018\u00010)J\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u00042\b\u00107\u001a\u0004\u0018\u00010)J*\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00042\u0006\u0010>\u001a\u00020)2\u0006\u0010G\u001a\u00020)2\u0006\u0010+\u001a\u00020)J\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\b\u00107\u001a\u0004\u0018\u00010)J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\"0\u00042\b\u00107\u001a\u0004\u0018\u00010)J\u0010\u0010J\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010)J\u0018\u0010K\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020&2\u0006\u0010+\u001a\u00020)J\u000e\u0010O\u001a\u00020&2\u0006\u0010+\u001a\u00020)J\u0010\u0010P\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u00010)J\u000e\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020\u0015J\u0010\u0010S\u001a\u00020&2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0010\u0010V\u001a\u00020&2\b\u0010W\u001a\u0004\u0018\u00010XR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lvukan/com/apursp/repository/Repository;", "", "()V", "categories", "Landroidx/lifecycle/MutableLiveData;", "", "Lvukan/com/apursp/models/ProductCategory;", "getCategories", "()Landroidx/lifecycle/MutableLiveData;", "database", "Lvukan/com/apursp/firebase/Database;", "favouriteProducts", "", "Lvukan/com/apursp/models/Product;", "getFavouriteProducts", "mCategories", "mConv", "Lvukan/com/apursp/models/Conv;", "mFavouritesProducts", "Lvukan/com/apursp/models/FavoriteProduct;", "mMessages", "Lvukan/com/apursp/models/Message;", "mProduct", "mProductCategory", "mProductImages", "Lvukan/com/apursp/models/ProductImage;", "mProductUser", "Lvukan/com/apursp/models/User;", "mProducts", "mUser", "mUserComments", "Lvukan/com/apursp/models/Comment;", "mUserProducts", "mUserRating", "", "user", "Lcom/google/firebase/auth/FirebaseUser;", "addNewUserComment", "", "newComment", "addProduct", "", "p", "productID", "addProductImage", "pi", "addProductToFavourites", "addUser", "deleteConversation", "conv", "deleteProduct", "id", "deleteProductImage", "url", "deleteUserData", "userID", "editUserInfo", "filterProducts", "filters", "", "([Ljava/lang/String;)Landroidx/lifecycle/MutableLiveData;", "getAllUserMessages", "sender", "getCategory", "getProductDetails", "getProductImages", "getProductUser", "getProducts", "getUser", "getUserComments", "getUserMessages", "receiver", "getUserProducts", "getUserRating", "incrementCounter", "isFavourite", "v", "Landroid/view/View;", "removeProductFromFavourites", "reportAd", "reportUser", "sendMessage", "m", "updateProfilePicture", "imageUrl", "Landroid/net/Uri;", "updateProfilePictureBitmap", "imageBitmap", "Landroid/graphics/Bitmap;", "app_release"})
public final class Repository {
    private final vukan.com.apursp.firebase.Database database = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> mProducts = null;
    private java.util.List<vukan.com.apursp.models.FavoriteProduct> mFavouritesProducts;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductCategory>> mCategories = null;
    private final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.Product> mProduct = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductImage>> mProductImages = null;
    private final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.ProductCategory> mProductCategory = null;
    private final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> mUser = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Float> mUserRating = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> mUserProducts = null;
    private com.google.firebase.auth.FirebaseUser user;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Message>> mMessages = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Conv>> mConv = null;
    private final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> mProductUser = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Comment>> mUserComments = null;
    
    public final void reportUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public final void deleteConversation(@org.jetbrains.annotations.Nullable()
    vukan.com.apursp.models.Conv conv) {
    }
    
    public final void deleteProductImage(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public final void deleteUserData(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductCategory>> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.User> getProductUser(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    public final void addUser() {
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUrl) {
    }
    
    public final void updateProfilePictureBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap imageBitmap) {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Message m) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String addProduct(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Product p, @org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
        return null;
    }
    
    public final void addProductImage(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.ProductImage pi) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Message>> getUserMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sender, @org.jetbrains.annotations.NotNull()
    java.lang.String receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Conv>> getAllUserMessages(@org.jetbrains.annotations.Nullable()
    java.lang.String sender) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getFavouriteProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> filterProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String[] filters) {
        return null;
    }
    
    public final void isFavourite(@org.jetbrains.annotations.Nullable()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void incrementCounter(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.Product> getProductDetails(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.ProductImage>> getProductImages(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.ProductCategory> getCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Product>> getUserProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    public final void addNewUserComment(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Comment newComment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Comment>> getUserComments(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
        return null;
    }
    
    public final void addProductToFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public final void removeProductFromFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public final void editUserInfo(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.User user) {
    }
    
    public final void reportAd(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
    }
    
    public Repository() {
        super();
    }
}