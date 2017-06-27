package com.franmontiel.attributionhelper;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;

import com.franmontiel.attributionhelper.attribution.Attribution;
import com.franmontiel.attributionhelper.attribution.Library;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class AttributionHelper {

    private Context context;
    private SortedSet<Attribution> attributions;

    public AttributionHelper(Context context) {
        this.context = context;
        this.attributions = new TreeSet<>();
    }

    public void addAttributions(Attribution... attributions) {
        this.attributions.addAll(Arrays.asList(attributions));
    }

    public void addAttributions(Library... libraries) {
        for (Library library : libraries) {
            this.attributions.add(library.getAttribution());
        }
    }

    public Dialog getDialog() {
        return getDialog(0, 0);
    }

    public Dialog getDialog(@LayoutRes int itemLayout, @LayoutRes int licenseLayout) {
        return new AlertDialog.Builder(context)
                .setAdapter(getAdapter(itemLayout, licenseLayout), null)
                .create();
    }

    public AttributionAdapter getAdapter() {
        return getAdapter(0, 0);
    }

    public AttributionAdapter getAdapter(@LayoutRes int itemLayout, @LayoutRes int licenseLayout) {
        if (itemLayout == 0) {
            itemLayout = R.layout.default_item_attribution;
        }
        if (licenseLayout == 0) {
            licenseLayout = R.layout.default_license_text;
        }

        AttributionAdapter attributionAdapter = new AttributionAdapter(
                itemLayout,
                licenseLayout
        );

        attributionAdapter.setItems(this.attributions);

        return attributionAdapter;
    }
}
