package com.example.diegoinsua.uibestpracticesexample.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.activities.ImageListActivity;
import com.example.diegoinsua.uibestpracticesexample.activities.NoteListActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoriesFragment extends Fragment {

    @InjectView(R.id.category_list)
    ListView categoryList;

    public CategoriesFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        ButterKnife.inject(this, view);

        final Intent notesIntent = new Intent(getContext(), NoteListActivity.class);
        final Intent imageListIntent = new Intent(getContext(), ImageListActivity.class);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates a dialog to choose navigate to the images or the notes
                builder
                        .setTitle(R.string.categories_wrong_dialog_title)
                        .setMessage(R.string.categories_wrong_dialog_message)
                        .setNeutralButton(R.string.categories_wrong_dialog_images,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(imageListIntent);
                                    }
                                })
                        .setPositiveButton(R.string.categories_wrong_dialog_notes,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(notesIntent);
                                    }
                                })
                        .setNegativeButton(R.string.categories_wrong_dialog_cancel, null);

                builder.create().show();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
