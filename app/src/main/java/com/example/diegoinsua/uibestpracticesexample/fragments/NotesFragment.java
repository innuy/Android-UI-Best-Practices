package com.example.diegoinsua.uibestpracticesexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegoinsua.uibestpracticesexample.R;
import com.example.diegoinsua.uibestpracticesexample.adapter.NoteListAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created on 6/7/16.
 * @author INNUY
 */
public class NotesFragment extends Fragment {

    @InjectView(R.id.notes_list)
    RecyclerView notesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        ButterKnife.inject(this, view);

        notesList.setAdapter(new NoteListAdapter(getActivity()));
        notesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
