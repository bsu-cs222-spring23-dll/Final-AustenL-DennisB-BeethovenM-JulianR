// Generated by view binder compiler. Do not edit!
package finals.project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import finals.project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLatestMessagesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button back;

  @NonNull
  public final Button home;

  @NonNull
  public final Button newMessage;

  @NonNull
  public final Button profile;

  @NonNull
  public final Toolbar toolbar5;

  private ActivityLatestMessagesBinding(@NonNull ConstraintLayout rootView, @NonNull Button back,
      @NonNull Button home, @NonNull Button newMessage, @NonNull Button profile,
      @NonNull Toolbar toolbar5) {
    this.rootView = rootView;
    this.back = back;
    this.home = home;
    this.newMessage = newMessage;
    this.profile = profile;
    this.toolbar5 = toolbar5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLatestMessagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLatestMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_latest_messages, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLatestMessagesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      Button back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.home;
      Button home = ViewBindings.findChildViewById(rootView, id);
      if (home == null) {
        break missingId;
      }

      id = R.id.new_message;
      Button newMessage = ViewBindings.findChildViewById(rootView, id);
      if (newMessage == null) {
        break missingId;
      }

      id = R.id.profile;
      Button profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.toolbar5;
      Toolbar toolbar5 = ViewBindings.findChildViewById(rootView, id);
      if (toolbar5 == null) {
        break missingId;
      }

      return new ActivityLatestMessagesBinding((ConstraintLayout) rootView, back, home, newMessage,
          profile, toolbar5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
