package com.myapp.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.mvvm.adapter.RecyclerAdapter;
import com.myapp.mvvm.model.NicePlaces;
import com.myapp.mvvm.viewmodel.MainActViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter adapter;
    private MainActViewModel mainActViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        getSupportActionBar().hide();

        mainActViewModel = ViewModelProviders.of(this).get(MainActViewModel.class);
        mainActViewModel.init();
        mainActViewModel.getNicePlaces().observe(this, new Observer<List<NicePlaces>>() {
            @Override
            public void onChanged(List<NicePlaces> nicePlaces) {
                adapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    public void initRecyclerView() {
        adapter = new RecyclerAdapter(this, mainActViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}
