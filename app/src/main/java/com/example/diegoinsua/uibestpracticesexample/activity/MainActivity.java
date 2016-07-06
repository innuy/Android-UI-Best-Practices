package com.example.diegoinsua.uibestpracticesexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diegoinsua.uibestpracticesexample.R;

import butterknife.InjectView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.right_way)
    Button rightWay;

    @InjectView(R.id.wrong_way)
    Button wrongWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        final Intent categoriesIntent = new Intent(this, CategoryListWActivity.class);
        final Intent notesIntent = new Intent(this, NoteListRActivity.class);

        // Set the buttons' actions
        wrongWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categoriesIntent);
            }
        });
        rightWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(notesIntent);
            }
        });
    }
}
