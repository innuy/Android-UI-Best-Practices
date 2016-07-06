package com.example.diegoinsua.uibestpracticesexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.diegoinsua.uibestpracticesexample.adapter.NoteListAdapter;
import com.example.diegoinsua.uibestpracticesexample.fragments.InfoDialogFragment;
import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NoteListWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
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
