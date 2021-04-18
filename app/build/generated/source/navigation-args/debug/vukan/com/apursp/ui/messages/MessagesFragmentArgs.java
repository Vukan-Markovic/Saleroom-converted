package vukan.com.apursp.ui.messages;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.HashMap;
import vukan.com.apursp.models.Message;

public class MessagesFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MessagesFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MessagesFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MessagesFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MessagesFragmentArgs __result = new MessagesFragmentArgs();
    bundle.setClassLoader(MessagesFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("product_id")) {
      String productId;
      productId = bundle.getString("product_id");
      if (productId == null) {
        throw new IllegalArgumentException("Argument \"product_id\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("product_id", productId);
    } else {
      __result.arguments.put("product_id", "0");
    }
    if (bundle.containsKey("messages")) {
      Message[] messages;
      Parcelable[] __array = bundle.getParcelableArray("messages");
      if (__array != null) {
        messages = new Message[__array.length];
        System.arraycopy(__array, 0, messages, 0, __array.length);
      } else {
        messages = null;
      }
      __result.arguments.put("messages", messages);
    } else {
      throw new IllegalArgumentException("Required argument \"messages\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    MessagesFragmentArgs that = (MessagesFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
    result = 31 * result + java.util.Arrays.hashCode(getMessages());
    return result;
  }

  @Override
  public String toString() {
    return "MessagesFragmentArgs{"
        + "productId=" + getProductId()
        + ", messages=" + getMessages()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(MessagesFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable Message[] messages) {
      this.arguments.put("messages", messages);
    }

    @NonNull
    public MessagesFragmentArgs build() {
      MessagesFragmentArgs result = new MessagesFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setProductId(@NonNull String productId) {
      if (productId == null) {
        throw new IllegalArgumentException("Argument \"product_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("product_id", productId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setMessages(@Nullable Message[] messages) {
      this.arguments.put("messages", messages);
      return this;
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
  }
}
