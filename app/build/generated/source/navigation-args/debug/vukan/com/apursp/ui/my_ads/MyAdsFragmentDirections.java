package vukan.com.apursp.ui.my_ads;

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

public class MyAdsFragmentDirections {
  private MyAdsFragmentDirections() {
  }

  @NonNull
  public static MojioglasiToProizvodFragmentAction mojioglasiToProizvodFragmentAction() {
    return new MojioglasiToProizvodFragmentAction();
  }

  @NonNull
  public static MojioglasiToPocetnaFragmentAction mojioglasiToPocetnaFragmentAction() {
    return new MojioglasiToPocetnaFragmentAction();
  }

  public static class MojioglasiToProizvodFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private MojioglasiToProizvodFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public MojioglasiToProizvodFragmentAction setProductId(@NonNull String productId) {
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
      return R.id.mojioglasiToProizvodFragmentAction;
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
      MojioglasiToProizvodFragmentAction that = (MojioglasiToProizvodFragmentAction) object;
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
      result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "MojioglasiToProizvodFragmentAction(actionId=" + getActionId() + "){"
          + "productId=" + getProductId()
          + "}";
    }
  }

  public static class MojioglasiToPocetnaFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private MojioglasiToPocetnaFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public MojioglasiToPocetnaFragmentAction setFilters(@Nullable String[] filters) {
      this.arguments.put("filters", filters);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("filters")) {
        String[] filters = (String[]) arguments.get("filters");
        __result.putStringArray("filters", filters);
      } else {
        __result.putStringArray("filters", null);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.mojioglasiToPocetnaFragmentAction;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String[] getFilters() {
      return (String[]) arguments.get("filters");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      MojioglasiToPocetnaFragmentAction that = (MojioglasiToPocetnaFragmentAction) object;
      if (arguments.containsKey("filters") != that.arguments.containsKey("filters")) {
        return false;
      }
      if (getFilters() != null ? !getFilters().equals(that.getFilters()) : that.getFilters() != null) {
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
      result = 31 * result + java.util.Arrays.hashCode(getFilters());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "MojioglasiToPocetnaFragmentAction(actionId=" + getActionId() + "){"
          + "filters=" + getFilters()
          + "}";
    }
  }
}
