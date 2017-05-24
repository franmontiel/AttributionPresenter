package com.franmontiel.attributionhelper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.franmontiel.attributionhelper.attribution.Attribution;
import com.franmontiel.attributionhelper.license.License;
import com.franmontiel.attributionhelper.util.BrowserOpener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AttributionAdapter extends BaseAdapter {

    private List<Attribution> items;
    @LayoutRes
    private int itemLayout;
    @LayoutRes
    private int licenseLayout;

    public AttributionAdapter(@LayoutRes int itemLayout, @LayoutRes int licenseLayout) {
        this.items = new ArrayList<>();
        this.itemLayout = itemLayout;
        this.licenseLayout = licenseLayout;
    }

    public void setItems(Collection<Attribution> attributions) {
        this.items.clear();
        this.items.addAll(attributions);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.copyrightNotices = (TextView) convertView.findViewById(R.id.copyrightNotices);
            holder.licensesLayout = (ViewGroup) convertView.findViewById(R.id.licensesLayout);
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        Attribution attribution = (Attribution) getItem(position);

        holder.name.setText(attribution.getName());
        holder.copyrightNotices.setText(attribution.getFormattedCopyrightNotices());
        holder.licensesLayout.removeAllViews();
        for (License license : attribution.getLicenses()) {
            addLicense(parent.getContext(), holder.licensesLayout, license);
        }

        return convertView;
    }

    private void addLicense(final Context context, ViewGroup licensesLayout, final License license) {
        View inflatedView = LayoutInflater.from(context).inflate(licenseLayout, licensesLayout, false);
        TextView licenseTextView = (TextView) inflatedView.findViewById(R.id.license);
        licenseTextView.setText(license.getName());
        licenseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowserOpener.open(context, license.getTextUrl());
            }
        });
        licensesLayout.addView(inflatedView);
    }

    private static class ViewHolder {
        TextView name;
        TextView copyrightNotices;
        ViewGroup licensesLayout;
    }
}
