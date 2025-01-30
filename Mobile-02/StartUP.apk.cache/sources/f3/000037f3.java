package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;

/* loaded from: classes2.dex */
public class GooglePlayServicesAvailabilityIOException extends UserRecoverableAuthIOException {
    public GooglePlayServicesAvailabilityIOException(GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException) {
        super(googlePlayServicesAvailabilityException);
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    /* renamed from: d */
    public GooglePlayServicesAvailabilityException getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }
}