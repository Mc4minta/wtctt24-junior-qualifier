package com.google.android.gms.auth;

import android.content.Intent;

/* loaded from: classes2.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: b  reason: collision with root package name */
    private final int f5944b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GooglePlayServicesAvailabilityException(int i2, String str, Intent intent) {
        super(str, intent);
        this.f5944b = i2;
    }
}