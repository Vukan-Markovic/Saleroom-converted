package vukan.com.apursp.ui.user_messages;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import vukan.com.apursp.R;
import vukan.com.apursp.models.Message;

public class UserMessagesFragmentDirections {
  private UserMessagesFragmentDirections() {
  }

  @NonNull
  public static ObavestenjaToPorukeFragmentAction obavestenjaToPorukeFragmentAction(
      @Nullable Message[] messages) {
    return new ObavestenjaToPorukeFragmentAction(messages);
  }

  public static class ObavestenjaToPorukeFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ObavestenjaToPorukeFragmentAction(@Nullable Message[] messages) {
      this.arguments.put("messages", messages);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ObavestenjaToPorukeFragmentAction setProductId(@NonNull String productId) {
      if (productId == null) {
        throw new IllegalArgumentException("Argument \"product_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("product_id", productId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ObavestenjaToPorukeFragmentAction setMessages(@Nullable Message[] messages) {
      this.arguments.put("messages", messages);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("product_id")) {
        String productId = (String) arguments.get("product_id");
        __result.putString("product_id", productId);
      } else {
        __result.putString("product_id", "0");
      }
      if (arguments.containsKey("messages")) {
        Message[] messages = (Message[]) arguments.get("messages");
        __result.putParcelableArray("messages", messages);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.obavestenjaToPorukeFragmentAction;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getProductId() {
      return (String) arguments.get("product_id");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Message[] getMessages() {
      return (Message[]) arguments.get("messages");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ObavestenjaToPorukeFragmentAction that = (ObavestenjaToPorukeFragmentAction) object;
      if (arguments.containsKey("product_id") != that.arguments.containsKey("product_id")) {
        return false;
      }
      if (getProductId() != null ? !getProductId().equals(that.getProductId()) : that.getProductId() != null) {
        return false;
      }
      if (arguments.containsKey("messages") != that.arguments.containsKey("messages")) {
        return false;
      }
      if (getMessages() != null ? !getMessages().equals(that.getMessages()) : that.getMessages() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
      result = 31 * result + java.util.Arrays.hashCode(getMessages());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ObavestenjaToPorukeFragmentAction(actionId=" + getActionId() + "){"
          + "productId=" + getProductId()
          + ", messages=" + getMessages()
          + "}";
    }
  }
}
