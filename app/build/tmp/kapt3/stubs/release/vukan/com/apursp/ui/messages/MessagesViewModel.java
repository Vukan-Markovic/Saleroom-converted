package vukan.com.apursp.ui.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lvukan/com/apursp/ui/messages/MessagesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "repository", "Lvukan/com/apursp/repository/Repository;", "getProductDetails", "Landroidx/lifecycle/MutableLiveData;", "Lvukan/com/apursp/models/Product;", "id", "", "getmMessages", "", "Lvukan/com/apursp/models/Message;", "sender", "receiver", "productID", "sendMessage", "", "m", "app_release"})
public final class MessagesViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Message>> getmMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String sender, @org.jetbrains.annotations.NotNull()
    java.lang.String receiver, @org.jetbrains.annotations.NotNull()
    java.lang.String productID) {
        return null;
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.models.Message m) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<vukan.com.apursp.models.Product> getProductDetails(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        return null;
    }
    
    public MessagesViewModel() {
        super();
    }
}