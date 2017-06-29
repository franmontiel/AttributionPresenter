package com.franmontiel.attributionhelper.listeners;

import com.franmontiel.attributionhelper.entities.LicenseInfo;

/**
 * Interface definition for a callback to be invoked when a license view is clicked.
 */
public interface OnLicenseClickListener {
    /**
     * Called when a license view is clicked.
     * @param licenseInfo object representing the clicked view
     * @return true if the event has been consumed, false otherwise
     */
    boolean onLicenseClick(LicenseInfo licenseInfo);
}
