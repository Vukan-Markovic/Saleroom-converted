package vukan.com.apursp.ui.user_messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lvukan/com/apursp/ui/user_messages/UserMessagesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "repository", "Lvukan/com/apursp/repository/Repository;", "deleteConversation", "", "conv", "Lvukan/com/apursp/models/Conv;", "getAllUserMessages", "Landroidx/lifecycle/MutableLiveData;", "", "sender", "", "app_release"})
public final class UserMessagesViewModel extends androidx.lifecycle.ViewModel {
    private final vukan.com.apursp.repository.Repository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<vukan.com.apursp.models.Conv>> getAllUserMessages(@org.jetbrains.annotations.Nullable()
    java.lang.String sender) {
        return null;
    }
    
    public final void deleteConversation(@org.jetbrains.annotations.Nullable()
    vukan.com.apursp.models.Conv conv) {
    }
    
    public UserMessagesViewModel() {
        super();
    }
}