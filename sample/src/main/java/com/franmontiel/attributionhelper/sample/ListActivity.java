package com.franmontiel.attributionhelper.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.franmontiel.attributionhelper.entities.Attribution;
import com.franmontiel.attributionhelper.entities.LicenseInfo;
import com.franmontiel.attributionhelper.listeners.OnAttributionClickListener;
import com.franmontiel.attributionhelper.listeners.OnLicenseClickListener;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(AttributionPresenterCreator.create(
                this,
                new OnAttributionClickListener() {
                    @Override
                    public boolean onAttributionClick(Attribution attribution) {
                        Toast.makeText(getApplicationContext(), "Attribution click: " + attribution.getName(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                },
                new OnLicenseClickListener() {
                    @Override
                    public boolean onLicenseClick(LicenseInfo licenseInfo) {
                        Toast.makeText(getApplicationContext(), "License click: " + licenseInfo.getName(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }).getAdapter());
    }
}
