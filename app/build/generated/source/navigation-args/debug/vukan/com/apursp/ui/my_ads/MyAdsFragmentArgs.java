package vukan.com.apursp.ui.my_ads;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MyAdsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MyAdsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MyAdsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MyAdsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MyAdsFragmentArgs __result = new MyAdsFragmentArgs();
    bundle.setClassLoader(MyAdsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("user_id")) {
      String userId;
      userId = bundle.getString("user_id");
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"user_id\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("user_id", userId);
    } else {
      __result.arguments.put("user_id", "0");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUserId() {
    return (String) arguments.get("user_id");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    MyAdsFragmentArgs that = (MyAdsFragmentArgs) object;
    if (arguments.containsKey("user_id") != that.arguments.containsKey("user_id")) {
      return false;
    }
    if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MyAdsFragmentArgs{"
        + "userId=" + getUserId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(MyAdsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public MyAdsFragmentArgs build() {
      MyAdsFragmentArgs result = new MyAdsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUserId(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"user_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user_id", userId);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUserId() {
      return (String) arguments.get("user_id");
    }
  }
}
