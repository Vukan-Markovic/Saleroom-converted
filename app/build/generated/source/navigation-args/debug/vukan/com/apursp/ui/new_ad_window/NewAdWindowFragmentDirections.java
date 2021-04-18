package vukan.com.apursp.ui.new_ad_window;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import vukan.com.apursp.R;

public class NewAdWindowFragmentDirections {
  private NewAdWindowFragmentDirections() {
  }

  @NonNull
  public static NovioglasprozorToPocetnaFragmentAction novioglasprozorToPocetnaFragmentAction() {
    return new NovioglasprozorToPocetnaFragmentAction();
  }

  public static class NovioglasprozorToPocetnaFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private NovioglasprozorToPocetnaFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public NovioglasprozorToPocetnaFragmentAction setFilters(@Nullable String[] filters) {
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
      return R.id.novioglasprozorToPocetnaFragmentAction;
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
      NovioglasprozorToPocetnaFragmentAction that = (NovioglasprozorToPocetnaFragmentAction) object;
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
      return "NovioglasprozorToPocetnaFragmentAction(actionId=" + getActionId() + "){"
          + "filters=" + getFilters()
          + "}";
    }
  }
}
