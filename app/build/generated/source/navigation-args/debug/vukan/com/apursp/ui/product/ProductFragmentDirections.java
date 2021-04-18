package vukan.com.apursp.ui.product;

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

public class ProductFragmentDirections {
  private ProductFragmentDirections() {
  }

  @NonNull
  public static ProizvodToSlikaFragmentAction proizvodToSlikaFragmentAction() {
    return new ProizvodToSlikaFragmentAction();
  }

  @NonNull
  public static ProizvodToPorukeFragmentAction proizvodToPorukeFragmentAction(
      @Nullable Message[] messages) {
    return new ProizvodToPorukeFragmentAction(messages);
  }

  @NonNull
  public static ProizvodToMojiOglasiFragmentAction proizvodToMojiOglasiFragmentAction() {
    return new ProizvodToMojiOglasiFragmentAction();
  }

  @NonNull
  public static ProizvodToNoviOglasProzorFragmentAction proizvodToNoviOglasProzorFragmentAction() {
    return new ProizvodToNoviOglasProzorFragmentAction();
  }

  public static class ProizvodToSlikaFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ProizvodToSlikaFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToSlikaFragmentAction setImageUrl(@NonNull String imageUrl) {
      if (imageUrl == null) {
        throw new IllegalArgumentException("Argument \"imageUrl\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("imageUrl", imageUrl);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("imageUrl")) {
        String imageUrl = (String) arguments.get("imageUrl");
        __result.putString("imageUrl", imageUrl);
      } else {
        __result.putString("imageUrl", "url");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.proizvodToSlikaFragmentAction;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getImageUrl() {
      return (String) arguments.get("imageUrl");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ProizvodToSlikaFragmentAction that = (ProizvodToSlikaFragmentAction) object;
      if (arguments.containsKey("imageUrl") != that.arguments.containsKey("imageUrl")) {
        return false;
      }
      if (getImageUrl() != null ? !getImageUrl().equals(that.getImageUrl()) : that.getImageUrl() != null) {
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
      result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ProizvodToSlikaFragmentAction(actionId=" + getActionId() + "){"
          + "imageUrl=" + getImageUrl()
          + "}";
    }
  }

  public static class ProizvodToPorukeFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ProizvodToPorukeFragmentAction(@Nullable Message[] messages) {
      this.arguments.put("messages", messages);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToPorukeFragmentAction setProductId(@NonNull String productId) {
      if (productId == null) {
        throw new IllegalArgumentException("Argument \"product_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("product_id", productId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToPorukeFragmentAction setMessages(@Nullable Message[] messages) {
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
      return R.id.proizvodToPorukeFragmentAction;
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
      ProizvodToPorukeFragmentAction that = (ProizvodToPorukeFragmentAction) object;
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
      return "ProizvodToPorukeFragmentAction(actionId=" + getActionId() + "){"
          + "productId=" + getProductId()
          + ", messages=" + getMessages()
          + "}";
    }
  }

  public static class ProizvodToMojiOglasiFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ProizvodToMojiOglasiFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToMojiOglasiFragmentAction setUserId(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"user_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user_id", userId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("user_id")) {
        String userId = (String) arguments.get("user_id");
        __result.putString("user_id", userId);
      } else {
        __result.putString("user_id", "0");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.proizvodToMojiOglasiFragmentAction;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUserId() {
      return (String) arguments.get("user_id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ProizvodToMojiOglasiFragmentAction that = (ProizvodToMojiOglasiFragmentAction) object;
      if (arguments.containsKey("user_id") != that.arguments.containsKey("user_id")) {
        return false;
      }
      if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) {
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
      result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ProizvodToMojiOglasiFragmentAction(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }

  public static class ProizvodToNoviOglasProzorFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ProizvodToNoviOglasProzorFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToNoviOglasProzorFragmentAction setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ProizvodToNoviOglasProzorFragmentAction setProductId(@NonNull String productId) {
      if (productId == null) {
        throw new IllegalArgumentException("Argument \"product_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("product_id", productId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("id")) {
        int id = (int) arguments.get("id");
        __result.putInt("id", id);
      } else {
        __result.putInt("id", 0);
      }
      if (arguments.containsKey("product_id")) {
        String productId = (String) arguments.get("product_id");
        __result.putString("product_id", productId);
      } else {
        __result.putString("product_id", "0");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.proizvodToNoviOglasProzorFragmentAction;
    }

    @SuppressWarnings("unchecked")
    public int getId() {
      return (int) arguments.get("id");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getProductId() {
      return (String) arguments.get("product_id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ProizvodToNoviOglasProzorFragmentAction that = (ProizvodToNoviOglasProzorFragmentAction) object;
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != that.getId()) {
        return false;
      }
      if (arguments.containsKey("product_id") != that.arguments.containsKey("product_id")) {
        return false;
      }
      if (getProductId() != null ? !getProductId().equals(that.getProductId()) : that.getProductId() != null) {
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
      result = 31 * result + getId();
      result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ProizvodToNoviOglasProzorFragmentAction(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + ", productId=" + getProductId()
          + "}";
    }
  }
}
