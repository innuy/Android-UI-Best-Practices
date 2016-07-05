package com.example.diegoinsua.uibestpracticesexample.activities;

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

        final Intent notesIntent = new Intent(this, NotesWrongActivity.class);

        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(notesIntent);
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