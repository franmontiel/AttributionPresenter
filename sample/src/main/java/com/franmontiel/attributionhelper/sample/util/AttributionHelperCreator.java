package com.franmontiel.attributionhelper.sample.util;

import android.content.Context;

import com.franmontiel.attributionhelper.AttributionHelper;
import com.franmontiel.attributionhelper.attribution.Attribution;
import com.franmontiel.attributionhelper.attribution.Library;
import com.franmontiel.attributionhelper.license.LicenseType;

public class AttributionHelperCreator {

    public static AttributionHelper create(Context context) {
        final AttributionHelper attributionHelper = new AttributionHelper(context);
        attributionHelper.addAttributions(
                new Attribution.Builder("PersistentCookieJar")
                        .addCopyrightNotice("Copyright 2016 Francisco José Montiel Navarro")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/franmontiel/PersistentCookieJar")
                        .build()
        );
        attributionHelper.addAttributions(
                Library.BUTTER_KNIFE,
                Library.GLIDE,
                Library.DAGGER_2,
                Library.GSON,
                Library.REALM);

        return attributionHelper;
    }
}
