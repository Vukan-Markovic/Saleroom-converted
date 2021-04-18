package vukan.com.apursp.ui.new_ad_window;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NewAdWindowFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private NewAdWindowFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private NewAdWindowFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static NewAdWindowFragmentArgs fromBundle(@NonNull Bundle bundle) {
    NewAdWindowFragmentArgs __result = new NewAdWindowFragmentArgs();
    bundle.setClassLoader(NewAdWindowFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("id")) {
      int id;
      id = bundle.getInt("id");
      __result.arguments.put("id", id);
    } else {
      __result.arguments.put("id", 0);
    }
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
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    NewAdWindowFragmentArgs that = (NewAdWindowFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getId();
    result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "NewAdWindowFragmentArgs{"
        + "id=" + getId()
        + ", productId=" + getProductId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(NewAdWindowFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public NewAdWindowFragmentArgs build() {
      NewAdWindowFragmentArgs result = new NewAdWindowFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setId(int id) {
      this.arguments.put("id", id);
      return this;
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

    @SuppressWarnings("unchecked")
    public int getId() {
      return (int) arguments.get("id");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getProductId() {
      return (String) arguments.get("product_id");
    }
  }
}
