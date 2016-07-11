package com.example.diegoinsua.uibestpracticesexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.fragment.InfoDialogFragment;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
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
                        InfoDialogFragment.newInstance(R.string.info_image_list_w);
                infoDialogFragment.show(getFragmentManager(), "Info dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
