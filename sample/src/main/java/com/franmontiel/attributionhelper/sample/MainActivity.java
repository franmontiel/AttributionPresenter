package com.franmontiel.attributionhelper.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.franmontiel.attributionhelper.AttributionPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AttributionPresenter attributionHelper = AttributionPresenterCreator.create(this);

        Button openDialog = (Button) findViewById(R.id.openDialog);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attributionHelper.showDialog(getString(R.string.attributions));
            }
        });

        Button openActivity = (Button) findViewById(R.id.openActivity);
        openActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        Button openDarkActivity = (Button) findViewById(R.id.openDarkActivity);
        openDarkActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DarkListActivity.class);
                startActivity(intent);
            }
        });

        Button openCustomActivity = (Button) findViewById(R.id.openCustomActivity);
        openCustomActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
                startActivity(intent);
            }
        });
    }
}
