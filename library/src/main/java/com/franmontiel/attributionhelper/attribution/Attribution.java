package com.franmontiel.attributionhelper.attribution;

import android.support.annotation.NonNull;

import com.franmontiel.attributionhelper.license.License;
import com.franmontiel.attributionhelper.license.LicenseFactory;
import com.franmontiel.attributionhelper.license.LicenseType;

import java.util.ArrayList;
import java.util.List;

public class Attribution implements Comparable<Attribution> {

    private String name;
    private List<String> copyrightNotices;
    private List<License> licenses;
    private String website;

    private Attribution(String name, List<String> copyrightNotices, List<License> licenses, String website) {
        this.name = name;
        this.copyrightNotices = copyrightNotices;
        this.licenses = licenses;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public List<String> getCopyrightNotices() {
        return copyrightNotices;
    }

    public String getFormattedCopyrightNotices() {
        StringBuilder builder = new StringBuilder();
        for (String copyrightNotice : copyrightNotices) {
            builder.append("\n").append(copyrightNotice);
        }
        return builder.toString().replaceFirst("\n", "");
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public int compareTo(@NonNull Attribution o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    public static class Builder {
        private String name;
        private List<String> copyrightNotices;
        private List<License> licenses;
        private String website;

        public Builder(String name) {
            this.name = name;
            this.copyrightNotices = new ArrayList<>();
            this.licenses = new ArrayList<>();
            this.website = "";
        }

        public Builder addCopyrightNotice(String notice) {
            copyrightNotices.add(notice);
            return this;
        }

        public Builder addCopyrightNotice(String copyrightHolder, String year) {
            copyrightNotices.add("Copyright " + year + " " + copyrightHolder);
            return this;
        }

        public Builder addLicense(License license) {
            licenses.add(license);
            return this;
        }

        public Builder addLicense(LicenseType licenseType) {
            licenses.add(LicenseFactory.getLicense(licenseType));
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Attribution build() {
            return new Attribution(name, copyrightNotices, licenses, website);
        }
    }
}
