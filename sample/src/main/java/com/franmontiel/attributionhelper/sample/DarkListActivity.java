package com.franmontiel.attributionhelper.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class DarkListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(AttributionPresenterCreator.create(this).getAdapter());
    }
}
