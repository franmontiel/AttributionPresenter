package com.franmontiel.attributionhelper.attribution;

import com.franmontiel.attributionhelper.license.LicenseType;

public class AttributionFactory {

    public static Attribution getAttribution(Library library) {
        switch (library) {
            case BUTTER_KNIFE:
                return new Attribution.Builder("Butter Knife")
                        .addCopyrightNotice("Copyright 2013 Jake Wharton")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://jakewharton.github.io/butterknife/")
                        .build();
            case PICASSO:
                return new Attribution.Builder("Picasso")
                        .addCopyrightNotice("Copyright 2013 Square, Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://square.github.io/picasso/")
                        .build();
            case GLIDE:
                return new Attribution.Builder("Glide")
                        .addCopyrightNotice("Copyright 2014 Google, Inc. All rights reserved.")
                        .addLicense(LicenseType.BSD_3)
                        .addLicense(LicenseType.MIT)
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/bumptech/glide")
                        .build();
            case DAGGER:
                return new Attribution.Builder("Dagger")
                        .addCopyrightNotice("Copyright 2013 Square, Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://square.github.io/dagger/")
                        .build();
            case DAGGER_2:
                return new Attribution.Builder("Dagger 2")
                        .addCopyrightNotice("Copyright 2012 The Dagger Authors")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://google.github.io/dagger/")
                        .build();
            case EVENT_BUS:
                return new Attribution.Builder("EventBus")
                        .addCopyrightNotice("Copyright (C) 2012-2016 Markus Junginger, greenrobot")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://greenrobot.org/eventbus/")
                        .build();
            case RX_JAVA:
                return new Attribution.Builder("RxJava")
                        .addCopyrightNotice("Copyright (c) 2016-present, RxJava Contributors")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/ReactiveX/RxJava")
                        .build();
            case RX_ANDROID:
                return new Attribution.Builder("RxAndroid")
                        .addCopyrightNotice("Copyright 2015 The RxAndroid authors")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/ReactiveX/RxAndroid")
                        .build();
            case OK_HTTP:
                return new Attribution.Builder("OkHttp")
                        .addCopyrightNotice("Copyright 2016 Square, Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://square.github.io/okhttp/")
                        .build();
            case RETROFIT:
                return new Attribution.Builder("Retrofit")
                        .addCopyrightNotice("Copyright 2013 Square, Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("http://square.github.io/retrofit/")
                        .build();
            case GSON:
                return new Attribution.Builder("Gson")
                        .addCopyrightNotice("Copyright 2008 Google Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/google/gson")
                        .build();
            case REALM:
                return new Attribution.Builder("Realm")
                        .addCopyrightNotice("Copyright 2016 Realm Inc.")
                        .addLicense(LicenseType.APACHE)
                        .setWebsite("https://github.com/realm/realm-java")
                        .build();
        }
        return null;
    }
}
