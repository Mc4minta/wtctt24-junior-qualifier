package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: b  reason: collision with root package name */
    private final int f6030b;

    public GooglePlayServicesRepairableException(int i2, String str, Intent intent) {
        super(str, intent);
        this.f6030b = i2;
    }

    public int b() {
        return this.f6030b;
    }
}