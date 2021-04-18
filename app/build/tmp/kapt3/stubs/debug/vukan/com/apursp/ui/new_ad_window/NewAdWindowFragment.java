package vukan.com.apursp.ui.new_ad_window;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u00103\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010\'2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u0002052\u0006\u0010@\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u0002052\b\u0010B\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010C\u001a\u0002052\b\u0010B\u001a\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lvukan/com/apursp/ui/new_ad_window/NewAdWindowFragment;", "Landroidx/fragment/app/Fragment;", "()V", "bitmap", "Landroid/graphics/Bitmap;", "bitmap1", "bitmap2", "bitmap3", "bitmap4", "category", "", "cena", "Landroid/widget/EditText;", "counter", "fiksna", "Landroid/widget/CheckBox;", "filePath", "Landroid/net/Uri;", "filePath1", "filePath2", "filePath3", "filePath4", "firebaseStorage", "Lvukan/com/apursp/firebase/Storage;", "imageView", "Landroid/widget/ImageView;", "imageView1", "imageView2", "imageView3", "imageView4", "mAnimation", "Landroid/view/animation/Animation;", "naslov", "newAdWindowViewModel", "Lvukan/com/apursp/ui/new_ad_window/NewAdWindowViewModel;", "newProduct", "Lvukan/com/apursp/models/Product;", "opis", "productID", "", "productId", "productImageList", "", "Lvukan/com/apursp/models/ProductImage;", "radioCurrentButton", "Landroid/widget/RadioButton;", "radioValutaGroup", "Landroid/widget/RadioGroup;", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "uuid", "addPI", "chooseImage", "", "deleteImage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "uploadImage", "fajl", "uploadImageBitmap", "app_debug"})
public final class NewAdWindowFragment extends androidx.fragment.app.Fragment {
    private android.widget.CheckBox fiksna;
    private android.widget.RadioGroup radioValutaGroup;
    private android.widget.RadioButton radioCurrentButton;
    private android.widget.ImageView imageView;
    private android.widget.ImageView imageView1;
    private android.widget.ImageView imageView2;
    private android.widget.ImageView imageView3;
    private android.widget.ImageView imageView4;
    private android.widget.EditText naslov;
    private android.widget.EditText cena;
    private android.widget.EditText opis;
    private int counter = 0;
    private android.net.Uri filePath;
    private android.net.Uri filePath1;
    private android.net.Uri filePath2;
    private android.view.animation.Animation mAnimation;
    private java.lang.String productId = "";
    private android.net.Uri filePath3;
    private android.net.Uri filePath4;
    private android.graphics.Bitmap bitmap;
    private android.graphics.Bitmap bitmap1;
    private android.graphics.Bitmap bitmap2;
    private vukan.com.apursp.firebase.Storage firebaseStorage;
    private android.graphics.Bitmap bitmap3;
    private android.graphics.Bitmap bitmap4;
    private java.lang.String uuid = "";
    private int category = 0;
    private java.lang.String productID = "";
    private com.google.firebase.storage.StorageReference storageReference;
    private vukan.com.apursp.models.Product newProduct;
    private java.util.List<vukan.com.apursp.models.ProductImage> productImageList;
    private vukan.com.apursp.ui.new_ad_window.NewAdWindowViewModel newAdWindowViewModel;
    
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
    
    private final vukan.com.apursp.models.ProductImage addPI(java.lang.String uuid, java.lang.String productID) {
        return null;
    }
    
    private final void deleteImage() {
    }
    
    private final void chooseImage() {
    }
    
    private final void uploadImage(android.net.Uri fajl) {
    }
    
    private final void uploadImageBitmap(android.graphics.Bitmap fajl) {
    }
    
    public NewAdWindowFragment() {
        super();
    }
}