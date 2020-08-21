package com.fancy.android_utils;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fancy.androidutils.adapter.ArrayAdapter;
import com.fancy.androidutils.recyclerviewhelper.decoration.GridDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * file explain
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class GridActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        List<String> arrays = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrays.add("android" + i);
        }

        recyclerView.setAdapter(new ArrayAdapter(arrays));
        recyclerView.addItemDecoration(new GridDividerItemDecoration(this, 3, R.color.colorPrimary, 10));
    }
}
