package com.example.diegoinsua.uibestpracticesexample.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.diegoinsua.uibestpracticesexample.fragment.CategoryListWFragment;
import com.example.diegoinsua.uibestpracticesexample.fragment.InfoDialogFragment;
import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;

/**
 * Created on 4/7/16.
 * @author INNUY
 */

public class CategoryListWActivity extends AppCompatActivity implements CategoryListWFragment.CategoryWFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list_w);
        ButterKnife.inject(this);
    }

    @Override
    public void onCategoryClick(int categoryId) {
        final Intent notesIntent = new Intent(this, NoteListWActivity.class);
        final Intent imageListIntent = new Intent(this, ImageListActivity.class);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setTitle(R.string.category_list_w_dialog_title)
                .setMessage(R.string.category_list_w_dialog_message)
                .setNeutralButton(R.string.category_list_w_dialog_images,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(imageListIntent);
                            }
                        })
                .setPositiveButton(R.string.category_list_w_dialog_notes,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(notesIntent);
                            }
                        })
                .setNegativeButton(R.string.category_list_w_dialog_cancel, null);

        builder.create().show();
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
                        InfoDialogFragment.newInstance(R.string.info_category_list_w);
                infoDialogFragment.show(getFragmentManager(), "Info dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}