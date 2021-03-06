// Generated by view binder compiler. Do not edit!
package com.example.easycooking.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.easycooking.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRicettetueBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button bottoneAggiungiRicetta;

  @NonNull
  public final RecyclerView rv;

  private FragmentRicettetueBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button bottoneAggiungiRicetta, @NonNull RecyclerView rv) {
    this.rootView = rootView;
    this.bottoneAggiungiRicetta = bottoneAggiungiRicetta;
    this.rv = rv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRicettetueBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRicettetueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_ricettetue, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRicettetueBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottone_aggiungi_ricetta;
      Button bottoneAggiungiRicetta = rootView.findViewById(id);
      if (bottoneAggiungiRicetta == null) {
        break missingId;
      }

      id = R.id.rv;
      RecyclerView rv = rootView.findViewById(id);
      if (rv == null) {
        break missingId;
      }

      return new FragmentRicettetueBinding((ConstraintLayout) rootView, bottoneAggiungiRicetta, rv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
