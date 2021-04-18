package vukan.com.apursp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0015J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u000eH\u0014J\b\u0010\u0019\u001a\u00020\u000eH\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lvukan/com/apursp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mAuthStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "mFirebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mFirebaseUser", "Lcom/google/firebase/auth/FirebaseUser;", "myAdsViewModel", "Lvukan/com/apursp/ui/my_ads/MyAdsViewModel;", "sharedPref", "Landroid/content/SharedPreferences;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "openWebPage", "url", "", "saveTheme", "data", "setLocale", "langCode", "flag", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final com.google.firebase.auth.FirebaseAuth mFirebaseAuth = null;
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener mAuthStateListener;
    private com.google.firebase.auth.FirebaseUser mFirebaseUser;
    private vukan.com.apursp.ui.my_ads.MyAdsViewModel myAdsViewModel;
    private android.content.SharedPreferences sharedPref;
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void openWebPage(java.lang.String url) {
    }
    
    private final void saveTheme(java.lang.String data) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.JELLY_BEAN_MR1)
    public final void setLocale(@org.jetbrains.annotations.NotNull()
    java.lang.String langCode, boolean flag) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    public MainActivity() {
        super();
    }
}