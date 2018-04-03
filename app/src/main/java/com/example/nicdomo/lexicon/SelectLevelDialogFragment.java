package com.example.nicdomo.lexicon;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Nicdomo on 4/2/2018.
 */

public class SelectLevelDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_level, null));


//        builder.setMessage(R.string.dialog_fire_missiles)
//        builder.setMessage("test")

        // Create the AlertDialog object and return it
        return builder.create();
    }



}
