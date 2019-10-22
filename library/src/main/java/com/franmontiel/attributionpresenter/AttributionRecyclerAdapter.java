/*
 * Copyright (c)  2019 Simone Lampacrescia [PamposDev].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.franmontiel.attributionpresenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.franmontiel.attributionpresenter.entities.Attribution;
import com.franmontiel.attributionpresenter.entities.LicenseInfo;
import com.franmontiel.attributionpresenter.listeners.OnAttributionClickListener;
import com.franmontiel.attributionpresenter.listeners.OnLicenseClickListener;
import com.franmontiel.attributionpresenter.util.BrowserOpener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by @PamposDev on 22/09/2019.
 */
public class AttributionRecyclerAdapter extends RecyclerView.Adapter<AttributionRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Attribution> items;
    @LayoutRes
    private int itemLayout;
    @LayoutRes
    private int licenseLayout;
    @Nullable
    private final OnAttributionClickListener onAttributionClickListener;
    @Nullable
    private final OnLicenseClickListener onLicenseClickListener;

    AttributionRecyclerAdapter(Context context,
                               Collection<Attribution> attributions,
                               @LayoutRes int itemLayout,
                               @LayoutRes int licenseLayout,
                               @Nullable OnAttributionClickListener onAttributionClickListener,
                               @Nullable OnLicenseClickListener onLicenseClickListener) {
        this.context = context;
        this.items = new ArrayList<>(attributions.size());
        this.items.addAll(attributions);
        this.itemLayout = itemLayout;
        this.licenseLayout = licenseLayout;
        this.onAttributionClickListener = onAttributionClickListener;
        this.onLicenseClickListener = onLicenseClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Attribution attribution = items.get(position);

        holder.name.setText(attribution.getName());
        holder.copyrightNotices.setText(attribution.getFormattedCopyrightNotices());
        holder.licensesLayout.removeAllViews();
        for (LicenseInfo licenseInfo : attribution.getLicensesInfo()) {
            addLicense(holder.licensesLayout, licenseInfo);
        }

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onAttributionClickListener == null ||
                        !onAttributionClickListener.onAttributionClick(attribution)) {

                    BrowserOpener.open(context, attribution.getWebsite());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void addLicense(ViewGroup licensesLayout, final LicenseInfo licenseInfo) {
        View inflatedView = LayoutInflater.from(context).inflate(licenseLayout, licensesLayout, false);
        TextView licenseTextView = (TextView) inflatedView.findViewById(R.id.license);

        if (licenseTextView == null) {
            throw new IllegalStateException("LicenseInfo layout does not contain a required TextView with android:id=\"@+id/licenseInfo\"");
        }

        licenseTextView.setText(licenseInfo.getName());
        licenseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLicenseClickListener == null ||
                        !onLicenseClickListener.onLicenseClick(licenseInfo)) {

                    BrowserOpener.open(context, licenseInfo.getTextUrl());
                }
            }
        });
        licensesLayout.addView(inflatedView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View root;
        private TextView name;
        private TextView copyrightNotices;
        private ViewGroup licensesLayout;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            copyrightNotices = (TextView) itemView.findViewById(R.id.copyrightNotices);
            licensesLayout = (ViewGroup) itemView.findViewById(R.id.licensesLayout);
        }
    }
}
