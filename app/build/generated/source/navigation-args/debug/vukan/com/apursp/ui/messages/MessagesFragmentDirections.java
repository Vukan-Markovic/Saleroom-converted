package vukan.com.apursp.ui.messages;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import vukan.com.apursp.R;

public class MessagesFragmentDirections {
  private MessagesFragmentDirections() {
  }

  @NonNull
  public static PorukeToMojiOglasiFragmentAction porukeToMojiOglasiFragmentAction() {
    return new PorukeToMojiOglasiFragmentAction();
  }

  public static class PorukeToMojiOglasiFragmentAction implements NavDirections {
    private final HashMap arguments = new HashMap();

    private PorukeToMojiOglasiFragmentAction() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public PorukeToMojiOglasiFragmentAction setUserId(@NonNull String userId) {
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
      return R.id.porukeToMojiOglasiFragmentAction;
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
      PorukeToMojiOglasiFragmentAction that = (PorukeToMojiOglasiFragmentAction) object;
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
      return "PorukeToMojiOglasiFragmentAction(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }
}
