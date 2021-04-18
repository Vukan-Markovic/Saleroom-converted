package vukan.com.apursp.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lvukan/com/apursp/firebase/Storage;", "", "()V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "storage", "Lcom/google/firebase/storage/StorageReference;", "getProductImage", "productID", "", "update", "", "userID", "imageUrl", "Landroid/net/Uri;", "updateProfilePicture", "updateProfilePictureBitmap", "imageBitmap", "Landroid/graphics/Bitmap;", "app_debug"})
public final class Storage {
    private final com.google.firebase.storage.StorageReference storage = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getProductImage(@org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
        return null;
    }
    
    public final void updateProfilePicture(@org.jetbrains.annotations.NotNull()
    java.lang.String userID, @org.jetbrains.annotations.Nullable()
    android.net.Uri imageUrl) {
    }
    
    public final void updateProfilePictureBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String userID, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap imageBitmap) {
    }
    
    private final void update(java.lang.String userID, android.net.Uri imageUrl) {
    }
    
    public Storage() {
        super();
    }
}