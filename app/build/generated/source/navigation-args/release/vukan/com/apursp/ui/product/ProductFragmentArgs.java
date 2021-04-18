package vukan.com.apursp.ui.product;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ProductFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ProductFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ProductFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ProductFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ProductFragmentArgs __result = new ProductFragmentArgs();
    bundle.setClassLoader(ProductFragmentArgs.class.getClassLoader());
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
  @NonNull
  public String getProductId() {
    return (String) arguments.get("product_id");
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
    ProductFragmentArgs that = (ProductFragmentArgs) object;
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
    result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProductFragmentArgs{"
        + "productId=" + getProductId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(ProductFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ProductFragmentArgs build() {
      ProductFragmentArgs result = new ProductFragmentArgs(arguments);
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

    @SuppressWarnings("unchecked")
    @NonNull
    public String getProductId() {
      return (String) arguments.get("product_id");
    }
  }
}
