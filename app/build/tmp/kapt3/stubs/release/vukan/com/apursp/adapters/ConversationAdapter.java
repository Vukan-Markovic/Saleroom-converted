package vukan.com.apursp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0014\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lvukan/com/apursp/adapters/ConversationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lvukan/com/apursp/adapters/ConversationAdapter$ConversationViewHolder;", "listener", "Lvukan/com/apursp/adapters/ConversationAdapter$ListItemClickListener;", "(Lvukan/com/apursp/adapters/ConversationAdapter$ListItemClickListener;)V", "conversations", "", "Lvukan/com/apursp/models/Conv;", "mOnClickListener", "sfd", "Ljava/text/SimpleDateFormat;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setConversations", "ConversationViewHolder", "ListItemClickListener", "app_release"})
public final class ConversationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<vukan.com.apursp.adapters.ConversationAdapter.ConversationViewHolder> {
    private java.util.List<vukan.com.apursp.models.Conv> conversations;
    private final java.text.SimpleDateFormat sfd = null;
    private final vukan.com.apursp.adapters.ConversationAdapter.ListItemClickListener mOnClickListener = null;
    
    public final void setConversations(@org.jetbrains.annotations.NotNull()
    java.util.List<vukan.com.apursp.models.Conv> conversations) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public vukan.com.apursp.adapters.ConversationAdapter.ConversationViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.adapters.ConversationAdapter.ConversationViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public ConversationAdapter(@org.jetbrains.annotations.NotNull()
    vukan.com.apursp.adapters.ConversationAdapter.ListItemClickListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lvukan/com/apursp/adapters/ConversationAdapter$ConversationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lvukan/com/apursp/adapters/ConversationAdapter;Landroid/view/View;)V", "adName", "Landroid/widget/TextView;", "date", "lastMessage", "senderName", "bind", "", "index", "", "app_release"})
    public final class ConversationViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView senderName = null;
        private final android.widget.TextView adName = null;
        private final android.widget.TextView lastMessage = null;
        private final android.widget.TextView date = null;
        
        public final void bind(int index) {
        }
        
        public ConversationViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lvukan/com/apursp/adapters/ConversationAdapter$ListItemClickListener;", "", "onListItemClick", "", "conv", "Lvukan/com/apursp/models/Conv;", "view", "Landroid/view/View;", "app_release"})
    public static abstract interface ListItemClickListener {
        
        public abstract void onListItemClick(@org.jetbrains.annotations.Nullable()
        vukan.com.apursp.models.Conv conv, @org.jetbrains.annotations.Nullable()
        android.view.View view);
    }
}