package vukan.com.apursp.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012J\u0016\u0010#\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fJ\u0010\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0018J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010/\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\u000e\u00100\u001a\u00020!2\u0006\u0010&\u001a\u000201J3\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f042\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0004\u0012\u0004\u0012\u00020!06\u00a2\u0006\u0002\u00107J(\u00108\u001a\u00020!2\u0006\u0010&\u001a\u00020\u000f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020!06J \u00109\u001a\u00020!2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070:\u0012\u0004\u0012\u00020!06J$\u0010;\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020!06J\u0018\u0010=\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u00105\u001a\u00020>J\u0018\u0010?\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u00105\u001a\u00020@J$\u0010A\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020!06J*\u0010B\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120:\u0012\u0004\u0012\u00020!06J$\u0010C\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020!06J \u0010D\u001a\u00020!2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0004\u0012\u0004\u0012\u00020!06J$\u0010E\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020!06J*\u0010F\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180:\u0012\u0004\u0012\u00020!06J:\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0004\u0012\u0004\u0012\u00020!06J*\u0010J\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140:\u0012\u0004\u0012\u00020!06J$\u0010K\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020!06J\u0018\u0010M\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010N\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u00105\u001a\u00020OJ\u0016\u0010P\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fJ\u0010\u0010Q\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010R\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020\u001aJ\u0010\u0010U\u001a\u00020!2\b\u0010V\u001a\u0004\u0018\u00010WJ\u0010\u0010X\u001a\u00020!2\b\u0010Y\u001a\u0004\u0018\u00010ZR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lvukan/com/apursp/firebase/Database;", "", "()V", "allUserConv", "", "Lvukan/com/apursp/models/Conv;", "categories", "Lvukan/com/apursp/models/ProductCategory;", "favouritesProducts", "Lvukan/com/apursp/models/FavoriteProduct;", "firebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "listOfproductid", "", "listOfsenders", "productImages", "Lvukan/com/apursp/models/ProductImage;", "products", "Lvukan/com/apursp/models/Product;", "storage", "Lvukan/com/apursp/firebase/Storage;", "userComments", "Lvukan/com/apursp/models/Comment;", "userMessages", "Lvukan/com/apursp/models/Message;", "userProducts", "userallMessages", "addProduct", "p", "productID", "addProductImage", "", "pi", "addProductToFavourites", "userID", "addUser", "user", "addUserComment", "newComment", "deleteConversation", "conv", "deleteProduct", "id", "deleteProductImage", "url", "deleteUserData", "editUserInfo", "Lvukan/com/apursp/models/User;", "filterProducts", "filters", "", "callback", "Lkotlin/reflect/KFunction1;", "([Ljava/lang/String;Lkotlin/reflect/KFunction;)V", "getAllUserMessages", "getCategories", "", "getCategory", "categoryID", "getFavouriteProducts", "Lvukan/com/apursp/callbacks/FavoritesCallback;", "getProduct", "Lvukan/com/apursp/callbacks/ProductCallback;", "getProductDetails", "getProductImages", "getProductUser", "getProducts", "getUser", "getUserComments", "getUserMessages", "senderId", "receiverId", "getUserProducts", "getUserRating", "", "incrementCounter", "isFavourite", "Lvukan/com/apursp/callbacks/FavoriteCallback;", "removeProductFromFavourites", "reportAd", "reportUser", "sendMessage", "m", "updateProfilePicture", "imageUrl", "Landroid/net/Uri;", "updateProfilePictureBitmap", "imageBitmap", "Landroid/graphics/Bitmap;", "app_release"})
public final class Database {
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    private java.util.List<vukan.com.apursp.models.Product> products;
    private java.util.List<vukan.com.apursp.models.ProductCategory> categories;
    private java.util.List<vukan.com.apursp.models.FavoriteProduct> favouritesProducts;
    private java.util.List<vukan.com.apursp.models.ProductImage> productImages;
    private java.util.List<vukan.com.apursp.models.Product> userProducts;
    private java.util.List<vukan.com.apursp.models.Message> userMessages;
    private java.util.List<vukan.com.apursp.models.Message> userallMessages;
    private java.util.List<vukan.com.apursp.models.Conv> allUserConv;
    private java.util.List<vukan.com.apursp.models.Comment> userComments;
    private java.util.List<java.lang.String> listOfsenders;
    private java.util.List<java.lang.String> listOfproductid;
    private final com.google.firebase.auth.FirebaseUser firebaseUser = null;
    private final vukan.com.apursp.firebase.Storage storage = null;
    
    public final void deleteConversation(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Conv conv) {
    }
    
    public final void deleteProductImage(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.Nullable()
    android.net.Uri imageUrl) {
    }
    
    public final void updateProfilePictureBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap imageBitmap) {
    }
    
    public final void deleteUserData(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    public final void getProductUser(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void isFavourite(@org.jetbrains.annotations.NotNull()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    vukan.com.apursp.callbacks.FavoriteCallback callback) {
    }
    
    public final void addUser(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
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
    
    public final void getUserMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String senderId, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverId, @org.jetbrains.annotations.Nullable()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getAllUserMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String user, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getProducts(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String categoryID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    vukan.com.apursp.callbacks.ProductCallback callback) {
    }
    
    public final void getFavouriteProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    vukan.com.apursp.callbacks.FavoritesCallback callback) {
    }
    
    public final void filterProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String[] filters, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void incrementCounter(@org.jetbrains.annotations.Nullable()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void getProductImages(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getProductDetails(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getUserProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void addUserComment(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Comment newComment) {
    }
    
    public final void getUserComments(@org.jetbrains.annotations.Nullable()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void getUserRating(@org.jetbrains.annotations.Nullable()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KFunction<kotlin.Unit> callback) {
    }
    
    public final void addProductToFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    java.lang.String userID) {
    }
    
    public final void removeProductFromFavourites(@org.jetbrains.annotations.NotNull()
    java.lang.String productID, @org.jetbrains.annotations.NotNull()
    java.lang.String userID) {
    }
    
    public final void editUserInfo(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.User user) {
    }
    
    public final void reportAd(@org.jetbrains.annotations.Nullable()
    java.lang.String productID) {
    }
    
    public final void reportUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userID) {
    }
    
    public Database() {
        super();
    }
}