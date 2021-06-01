// Generated by view binder compiler. Do not edit!
package com.example.easycooking.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.easycooking.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentOfflineRicettaBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView Ingredienti1;

  @NonNull
  public final TextView Quantit1;

  @NonNull
  public final TextView UnitDimisura1;

  @NonNull
  public final TextView categoria1;

  @NonNull
  public final TextView immagineRicettaVista1;

  @NonNull
  public final TextView intolleranze1;

  @NonNull
  public final TextView origine1;

  @NonNull
  public final ImageView photo1;

  @NonNull
  public final TextView procedimentoVista1;

  @NonNull
  public final TableLayout tableLayout1;

  @NonNull
  public final TableLayout tableLayout21;

  @NonNull
  public final TableLayout tableLayout31;

  @NonNull
  public final TableLayout tableLayout41;

  @NonNull
  public final TextView tempoCottura1;

  @NonNull
  public final TextView tempoPreparazione1;

  @NonNull
  public final TextView tempoTotale1;

  @NonNull
  public final TextView textView271;

  @NonNull
  public final TextView textView281;

  @NonNull
  public final TextView textView291;

  @NonNull
  public final TextView textView331;

  @NonNull
  public final TextView textView341;

  @NonNull
  public final TextView textView351;

  @NonNull
  public final TextView textView361;

  @NonNull
  public final TextView textView411;

  @NonNull
  public final TextView textView431;

  @NonNull
  public final TextView vegano1;

  private FragmentOfflineRicettaBinding(@NonNull ScrollView rootView,
      @NonNull TextView Ingredienti1, @NonNull TextView Quantit1, @NonNull TextView UnitDimisura1,
      @NonNull TextView categoria1, @NonNull TextView immagineRicettaVista1,
      @NonNull TextView intolleranze1, @NonNull TextView origine1, @NonNull ImageView photo1,
      @NonNull TextView procedimentoVista1, @NonNull TableLayout tableLayout1,
      @NonNull TableLayout tableLayout21, @NonNull TableLayout tableLayout31,
      @NonNull TableLayout tableLayout41, @NonNull TextView tempoCottura1,
      @NonNull TextView tempoPreparazione1, @NonNull TextView tempoTotale1,
      @NonNull TextView textView271, @NonNull TextView textView281, @NonNull TextView textView291,
      @NonNull TextView textView331, @NonNull TextView textView341, @NonNull TextView textView351,
      @NonNull TextView textView361, @NonNull TextView textView411, @NonNull TextView textView431,
      @NonNull TextView vegano1) {
    this.rootView = rootView;
    this.Ingredienti1 = Ingredienti1;
    this.Quantit1 = Quantit1;
    this.UnitDimisura1 = UnitDimisura1;
    this.categoria1 = categoria1;
    this.immagineRicettaVista1 = immagineRicettaVista1;
    this.intolleranze1 = intolleranze1;
    this.origine1 = origine1;
    this.photo1 = photo1;
    this.procedimentoVista1 = procedimentoVista1;
    this.tableLayout1 = tableLayout1;
    this.tableLayout21 = tableLayout21;
    this.tableLayout31 = tableLayout31;
    this.tableLayout41 = tableLayout41;
    this.tempoCottura1 = tempoCottura1;
    this.tempoPreparazione1 = tempoPreparazione1;
    this.tempoTotale1 = tempoTotale1;
    this.textView271 = textView271;
    this.textView281 = textView281;
    this.textView291 = textView291;
    this.textView331 = textView331;
    this.textView341 = textView341;
    this.textView351 = textView351;
    this.textView361 = textView361;
    this.textView411 = textView411;
    this.textView431 = textView431;
    this.vegano1 = vegano1;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentOfflineRicettaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentOfflineRicettaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_offline_ricetta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentOfflineRicettaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Ingredienti1;
      TextView Ingredienti1 = rootView.findViewById(id);
      if (Ingredienti1 == null) {
        break missingId;
      }

      id = R.id.Quantità1;
      TextView Quantit1 = rootView.findViewById(id);
      if (Quantit1 == null) {
        break missingId;
      }

      id = R.id.Unitàdimisura1;
      TextView UnitDimisura1 = rootView.findViewById(id);
      if (UnitDimisura1 == null) {
        break missingId;
      }

      id = R.id.categoria1;
      TextView categoria1 = rootView.findViewById(id);
      if (categoria1 == null) {
        break missingId;
      }

      id = R.id.immagine_ricetta_vista1;
      TextView immagineRicettaVista1 = rootView.findViewById(id);
      if (immagineRicettaVista1 == null) {
        break missingId;
      }

      id = R.id.intolleranze1;
      TextView intolleranze1 = rootView.findViewById(id);
      if (intolleranze1 == null) {
        break missingId;
      }

      id = R.id.origine1;
      TextView origine1 = rootView.findViewById(id);
      if (origine1 == null) {
        break missingId;
      }

      id = R.id.photo1;
      ImageView photo1 = rootView.findViewById(id);
      if (photo1 == null) {
        break missingId;
      }

      id = R.id.procedimento_vista1;
      TextView procedimentoVista1 = rootView.findViewById(id);
      if (procedimentoVista1 == null) {
        break missingId;
      }

      id = R.id.tableLayout1;
      TableLayout tableLayout1 = rootView.findViewById(id);
      if (tableLayout1 == null) {
        break missingId;
      }

      id = R.id.tableLayout21;
      TableLayout tableLayout21 = rootView.findViewById(id);
      if (tableLayout21 == null) {
        break missingId;
      }

      id = R.id.tableLayout31;
      TableLayout tableLayout31 = rootView.findViewById(id);
      if (tableLayout31 == null) {
        break missingId;
      }

      id = R.id.tableLayout41;
      TableLayout tableLayout41 = rootView.findViewById(id);
      if (tableLayout41 == null) {
        break missingId;
      }

      id = R.id.tempo_cottura1;
      TextView tempoCottura1 = rootView.findViewById(id);
      if (tempoCottura1 == null) {
        break missingId;
      }

      id = R.id.tempo_preparazione1;
      TextView tempoPreparazione1 = rootView.findViewById(id);
      if (tempoPreparazione1 == null) {
        break missingId;
      }

      id = R.id.tempo_totale1;
      TextView tempoTotale1 = rootView.findViewById(id);
      if (tempoTotale1 == null) {
        break missingId;
      }

      id = R.id.textView271;
      TextView textView271 = rootView.findViewById(id);
      if (textView271 == null) {
        break missingId;
      }

      id = R.id.textView281;
      TextView textView281 = rootView.findViewById(id);
      if (textView281 == null) {
        break missingId;
      }

      id = R.id.textView291;
      TextView textView291 = rootView.findViewById(id);
      if (textView291 == null) {
        break missingId;
      }

      id = R.id.textView331;
      TextView textView331 = rootView.findViewById(id);
      if (textView331 == null) {
        break missingId;
      }

      id = R.id.textView341;
      TextView textView341 = rootView.findViewById(id);
      if (textView341 == null) {
        break missingId;
      }

      id = R.id.textView351;
      TextView textView351 = rootView.findViewById(id);
      if (textView351 == null) {
        break missingId;
      }

      id = R.id.textView361;
      TextView textView361 = rootView.findViewById(id);
      if (textView361 == null) {
        break missingId;
      }

      id = R.id.textView411;
      TextView textView411 = rootView.findViewById(id);
      if (textView411 == null) {
        break missingId;
      }

      id = R.id.textView431;
      TextView textView431 = rootView.findViewById(id);
      if (textView431 == null) {
        break missingId;
      }

      id = R.id.vegano1;
      TextView vegano1 = rootView.findViewById(id);
      if (vegano1 == null) {
        break missingId;
      }

      return new FragmentOfflineRicettaBinding((ScrollView) rootView, Ingredienti1, Quantit1,
          UnitDimisura1, categoria1, immagineRicettaVista1, intolleranze1, origine1, photo1,
          procedimentoVista1, tableLayout1, tableLayout21, tableLayout31, tableLayout41,
          tempoCottura1, tempoPreparazione1, tempoTotale1, textView271, textView281, textView291,
          textView331, textView341, textView351, textView361, textView411, textView431, vegano1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}