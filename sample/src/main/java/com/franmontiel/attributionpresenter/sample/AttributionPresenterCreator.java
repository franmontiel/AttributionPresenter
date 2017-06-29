package com.franmontiel.attributionpresenter.sample;

import android.content.Context;

import com.franmontiel.attributionpresenter.AttributionPresenter;
import com.franmontiel.attributionpresenter.entities.Attribution;
import com.franmontiel.attributionpresenter.entities.Library;
import com.franmontiel.attributionpresenter.entities.License;
import com.franmontiel.attributionpresenter.listeners.OnAttributionClickListener;
import com.franmontiel.attributionpresenter.listeners.OnLicenseClickListener;

public class AttributionPresenterCreator {

    private static AttributionPresenter.Builder createBaseAttributions(Context context) {
        return new AttributionPresenter.Builder(context)
                .addAttributions(
                        new Attribution.Builder("PersistentCookieJar")
                                .addCopyrightNotice("Copyright 2016 Francisco José Montiel Navarro")
                                .addLicense(License.APACHE)
                                .setWebsite("https://github.com/franmontiel/PersistentCookieJar")
                                .build()
                )
                .addAttributions(
                        Library.BUTTER_KNIFE,
                        Library.GLIDE,
                        Library.DAGGER_2,
                        Library.GSON,
                        Library.REALM);
    }

    public static AttributionPresenter create(Context context) {
        return createBaseAttributions(context).build();
    }

    public static AttributionPresenter create(Context context,
                                              OnAttributionClickListener onAttributionClickListener,
                                              OnLicenseClickListener onLicenseClickListener) {
        return createBaseAttributions(context)
                .setOnAttributionClickListener(onAttributionClickListener)
                .setOnLicenseClickListener(onLicenseClickListener)
                .build();
    }

    public static AttributionPresenter create(Context context, int itemLayout, int licenseLayout) {
        return createBaseAttributions(context)
                .setItemLayout(itemLayout)
                .setLicenseLayout(licenseLayout)
                .build();
    }
}
