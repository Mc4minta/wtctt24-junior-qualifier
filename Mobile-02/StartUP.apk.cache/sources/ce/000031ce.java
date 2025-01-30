package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class b {
    public static ApiException a(Status status) {
        if (status.k1()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}