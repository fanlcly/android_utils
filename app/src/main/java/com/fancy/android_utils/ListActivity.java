package com.fancy.android_utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fancy.androidutils.adapter.ArrayAdapter;
import com.fancy.androidutils.recyclerviewhelper.decoration.LinearDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * file explain
 *
 * @author fanlei
 * @version 1.0 2018\12\7 0007
 * @since JDK 1.7
 */
public class ListActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> arrays = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrays.add("android" + i);
        }

        recyclerView.setAdapter(new ArrayAdapter(arrays));
        recyclerView.addItemDecoration(new LinearDividerItemDecoration(this, R.color.red, 5));
    }
}
