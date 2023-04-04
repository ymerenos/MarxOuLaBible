package com.example.marxoulabible;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddQuote extends DialogFragment {

    private EditText quoteEditText;
    private RadioGroup categoryRadioGroup;
    private RadioButton positiveRadioButton, negativeRadioButton;
    private String category;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.add_quote, null);
        builder.setView(view)
                // Set title
                .setTitle("Ajouter une citation")
                // Add action buttons
                .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Add quote
                        String quote = quoteEditText.getText().toString();
                        int checkedRadioButtonId = categoryRadioGroup.getCheckedRadioButtonId();
                        if (checkedRadioButtonId == R.id.btn_jesus) {
                            category = "bible_quotes";
                        } else if (checkedRadioButtonId == R.id.btn_marx) {
                            category = "marx_quotes";
                        }
                        // Call method in the activity to add quote
                        //((MainMenuActivity) getActivity()).addQuote(quote, category);
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        AddQuote.this.getDialog().cancel();
                    }
                });

        // Get references to views in the dialog
        quoteEditText = view.findViewById(R.id.edittext_quote);
        categoryRadioGroup = view.findViewById(R.id.radioGroup);
        positiveRadioButton = view.findViewById(R.id.btn_jesus);
        negativeRadioButton = view.findViewById(R.id.btn_marx);

        // Set default selected radio button
        positiveRadioButton.setChecked(true);

        // Return the created dialog
        return builder.create();
    }
}