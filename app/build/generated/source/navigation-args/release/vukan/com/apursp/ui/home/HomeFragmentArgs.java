package vukan.com.apursp.ui.home;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private HomeFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private HomeFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static HomeFragmentArgs fromBundle(@NonNull Bundle bundle) {
    HomeFragmentArgs __result = new HomeFragmentArgs();
    bundle.setClassLoader(HomeFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("filters")) {
      String[] filters;
      filters = bundle.getStringArray("filters");
      __result.arguments.put("filters", filters);
    } else {
      __result.arguments.put("filters", null);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String[] getFilters() {
    return (String[]) arguments.get("filters");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    HomeFragmentArgs that = (HomeFragmentArgs) object;
    if (arguments.containsKey("filters") != that.arguments.containsKey("filters")) {
      return false;
    }
    if (getFilters() != null ? !getFilters().equals(that.getFilters()) : that.getFilters() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + java.util.Arrays.hashCode(getFilters());
    return result;
  }

  @Override
  public String toString() {
    return "HomeFragmentArgs{"
        + "filters=" + getFilters()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(HomeFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public HomeFragmentArgs build() {
      HomeFragmentArgs result = new HomeFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setFilters(@Nullable String[] filters) {
      this.arguments.put("filters", filters);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String[] getFilters() {
      return (String[]) arguments.get("filters");
    }
  }
}
