package vukan.com.apursp.ui.product_image;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ProductImageFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ProductImageFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ProductImageFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ProductImageFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ProductImageFragmentArgs __result = new ProductImageFragmentArgs();
    bundle.setClassLoader(ProductImageFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("imageUrl")) {
      String imageUrl;
      imageUrl = bundle.getString("imageUrl");
      if (imageUrl == null) {
        throw new IllegalArgumentException("Argument \"imageUrl\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("imageUrl", imageUrl);
    } else {
      __result.arguments.put("imageUrl", "url");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getImageUrl() {
    return (String) arguments.get("imageUrl");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ProductImageFragmentArgs that = (ProductImageFragmentArgs) object;
    if (arguments.containsKey("imageUrl") != that.arguments.containsKey("imageUrl")) {
      return false;
    }
    if (getImageUrl() != null ? !getImageUrl().equals(that.getImageUrl()) : that.getImageUrl() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProductImageFragmentArgs{"
        + "imageUrl=" + getImageUrl()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(ProductImageFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ProductImageFragmentArgs build() {
      ProductImageFragmentArgs result = new ProductImageFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setImageUrl(@NonNull String imageUrl) {
      if (imageUrl == null) {
        throw new IllegalArgumentException("Argument \"imageUrl\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("imageUrl", imageUrl);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getImageUrl() {
      return (String) arguments.get("imageUrl");
    }
  }
}
