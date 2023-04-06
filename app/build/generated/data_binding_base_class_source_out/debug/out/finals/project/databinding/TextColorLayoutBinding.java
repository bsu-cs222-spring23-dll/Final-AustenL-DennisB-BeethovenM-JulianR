// Generated by view binder compiler. Do not edit!
package finals.project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import finals.project.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class TextColorLayoutBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  @NonNull
  public final TextView itemText;

  private TextColorLayoutBinding(@NonNull TextView rootView, @NonNull TextView itemText) {
    this.rootView = rootView;
    this.itemText = itemText;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static TextColorLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TextColorLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.text_color_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TextColorLayoutBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    TextView itemText = (TextView) rootView;

    return new TextColorLayoutBinding((TextView) rootView, itemText);
  }
}
