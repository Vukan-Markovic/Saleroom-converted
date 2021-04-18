package vukan.com.apursp.ui.home;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import vukan.com.apursp.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static PocetnaToProizvodFragmentAction pocetnaToProizvodFragmentAction() {
    return new PocetnaToProizvodFragmentAction();
  }

  @NonNull
  public static NavDirections pocetnaToFilteriFragmentAction() {
    return new ActionOnlyNavDirections(R.id.pocetnaToFilteriFragmentAction);
  }

  public static class PocetnaToProizvodFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private PocetnaToProizvodFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public PocetnaToProizvodFragmentAction setProductId(@NonNull String productId) {
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
      return R.id.pocetnaToProizvodFragmentAction;
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
      PocetnaToProizvodFragmentAction that = (PocetnaToProizvodFragmentAction) object;
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
      return "PocetnaToProizvodFragmentAction(actionId=" + getActionId() + "){"
          + "productId=" + getProductId()
          + "}";
    }
  }
}
