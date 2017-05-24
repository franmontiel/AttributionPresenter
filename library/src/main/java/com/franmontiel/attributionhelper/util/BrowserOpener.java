package com.franmontiel.attributionhelper.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class BrowserOpener {

    private BrowserOpener() {
    }

    public static void open(Context context, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;

        Intent toBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        toBrowser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startIntent(context, toBrowser);
    }

    private static void startIntent(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Nothing to do...
        }
    }
}
