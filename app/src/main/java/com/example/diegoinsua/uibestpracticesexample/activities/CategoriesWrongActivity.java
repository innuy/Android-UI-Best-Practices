package com.example.diegoinsua.uibestpracticesexample.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.diegoinsua.uibestpracticesexample.fragments.InfoDialogFragment;
import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 4/7/16.
 * @author INNUY
 */

public class CategoriesWrongActivity extends AppCompatActivity {

    @InjectView(R.id.category_list)
    ListView categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_wrong);
        ButterKnife.inject(this);

        final Intent notesIntent = new Intent(this, NoteListActivity.class);
        final Intent imageListIntent = new Intent(this, ImageListActivity.class);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                InfoDialogFragment infoDialogFragment =
                        InfoDialogFragment.newInstance(R.string.info_categories_wrong);
                infoDialogFragment.show(getFragmentManager(), "Info dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}