package com.example.diegoinsua.uibestpracticesexample.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.example.diegoinsua.uibestpracticesexample.R;

/**
 * Created on 4/7/16.
 * @author INNUY
 *
 * This dialog contains a "close" button, the title "Information",
 * and a custom text defined by its resource value
 */

public class InfoDialogFragment extends DialogFragment {

    private static final String TEXT_RESOURCE_KEY = "textResource";

    /**
     * It creates a new instance of the dialog, which will show the text defined in the parameters
     *
     * @param textResource It is the resource used to create the message text
     * @return The dialog fragment created
     */

    public static InfoDialogFragment newInstance(int textResource) {

        Bundle args = new Bundle();
        args.putInt(TEXT_RESOURCE_KEY, textResource);

        InfoDialogFragment fragment = new InfoDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        int textResource = getArguments().getInt(TEXT_RESOURCE_KEY, R.string.info_empty_message);

        builder
                .setTitle(R.string.info)
                .setMessage(textResource)
                .setPositiveButton(R.string.info_close_btn, null);

        return builder.create();
    }
}
