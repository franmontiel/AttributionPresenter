package com.franmontiel.attributionhelper;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;

import com.franmontiel.attributionhelper.attribution.Attribution;
import com.franmontiel.attributionhelper.attribution.AttributionFactory;
import com.franmontiel.attributionhelper.attribution.Library;
import com.franmontiel.attributionhelper.util.BrowserOpener;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class AttributionHelper {

    private Context context;
    private SortedSet<Attribution> attributions;
    private AttributionAdapter attributionAdapter;

    public AttributionHelper(Context context) {
        this.context = context;
        this.attributionAdapter = new AttributionAdapter(
                R.layout.item_attribution,
                R.layout.sublayout_license_text
        );
        this.attributions = new TreeSet<>();
    }

    public void setAttributions(Attribution... attributions) {
        this.attributions.addAll(Arrays.asList(attributions));
        this.attributionAdapter.setItems(this.attributions);
    }

    public void setAttributions(Library... libraries) {
        for (Library library : libraries) {
            this.attributions.add(AttributionFactory.getAttribution(library));
        }
        this.attributionAdapter.setItems(this.attributions);
    }

    public AttributionAdapter getAdapter() {
        return attributionAdapter;
    }

    public Dialog getDialog() {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setAdapter(attributionAdapter, null)
                .create();

        dialog.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attribution item = (Attribution) attributionAdapter.getItem(position);
                BrowserOpener.open(context, item.getWebsite());
            }
        });
        return dialog;
    }
}
