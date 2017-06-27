package com.franmontiel.attributionhelper;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.franmontiel.attributionhelper.entities.Attribution;
import com.franmontiel.attributionhelper.entities.Library;
import com.franmontiel.attributionhelper.listeners.OnAttributionClickListener;
import com.franmontiel.attributionhelper.listeners.OnLicenseClickListener;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public final class AttributionPresenter {

    private Context context;
    private SortedSet<Attribution> attributions;
    private final int itemLayout;
    private final int licenseLayout;
    private OnAttributionClickListener onAttributionClickListener;
    private OnLicenseClickListener onLicenseClickListener;

    private AttributionAdapter attributionAdapter;

    private AttributionPresenter(Context context,
                                 SortedSet<Attribution> attributions,
                                 @LayoutRes int itemLayout,
                                 @LayoutRes int licenseLayout,
                                 @Nullable OnAttributionClickListener onAttributionClickListener,
                                 @Nullable OnLicenseClickListener onLicenseClickListener) {
        this.context = context;
        this.attributions = attributions;
        this.itemLayout = itemLayout == 0 ? R.layout.default_item_attribution : itemLayout;
        this.licenseLayout = licenseLayout == 0 ? R.layout.default_license_text : licenseLayout;
        this.onAttributionClickListener = onAttributionClickListener;
        this.onLicenseClickListener = onLicenseClickListener;
    }

    public Dialog showDialog(@Nullable String title) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setAdapter(getAdapter(), null)
                .show();
    }

    public AttributionAdapter getAdapter() {
        if (attributionAdapter == null) {
            attributionAdapter = new AttributionAdapter(
                    attributions,
                    itemLayout,
                    licenseLayout,
                    onAttributionClickListener,
                    onLicenseClickListener
            );
        }
        return attributionAdapter;
    }

    public static class Builder {
        private Context context;
        private SortedSet<Attribution> attributions;
        @LayoutRes
        private int itemLayout;
        @LayoutRes
        private int licenseLayout;
        private OnAttributionClickListener onAttributionClickListener;
        private OnLicenseClickListener onLicenseClickListener;

        public Builder(Context context) {
            this.context = context;
            this.attributions = new TreeSet<>();
        }

        public Builder addAttributions(Attribution... attributions) {
            this.attributions.addAll(Arrays.asList(attributions));
            return this;
        }

        public Builder addAttributions(Library... libraries) {
            for (Library library : libraries) {
                this.attributions.add(library.getAttribution());
            }
            return this;
        }

        public Builder setItemLayout(@LayoutRes int itemLayoutResId) {
            this.itemLayout = itemLayoutResId;
            return this;
        }

        public Builder setLicenseLayout(@LayoutRes int licenseLayoutResId) {
            this.licenseLayout = licenseLayoutResId;
            return this;
        }

        public Builder setOnAttributionClickListener(OnAttributionClickListener onAttributionClickListener) {
            this.onAttributionClickListener = onAttributionClickListener;
            return this;
        }

        public Builder setOnLicenseClickListener(OnLicenseClickListener onLicenseClickListener) {
            this.onLicenseClickListener = onLicenseClickListener;
            return this;
        }

        public AttributionPresenter build() {
            return new AttributionPresenter(context,
                    attributions,
                    itemLayout,
                    licenseLayout,
                    onAttributionClickListener,
                    onLicenseClickListener);
        }
    }
}
