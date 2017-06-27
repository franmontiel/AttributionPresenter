package com.franmontiel.attributionhelper.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.franmontiel.attributionhelper.sample.util.AttributionHelperCreator;

public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(AttributionHelperCreator.create(this).getAdapter(R.layout.custom_item_attribution, R.layout.custom_license_text));
    }
}
