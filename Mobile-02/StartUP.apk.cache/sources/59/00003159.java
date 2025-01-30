package com.google.android.gms.common.api;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {
    private final c.e.a<com.google.android.gms.common.api.internal.b<?>, com.google.android.gms.common.b> a;

    public AvailabilityException(c.e.a<com.google.android.gms.common.api.internal.b<?>, com.google.android.gms.common.b> aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (com.google.android.gms.common.api.internal.b<?> bVar : this.a.keySet()) {
            com.google.android.gms.common.b bVar2 = this.a.get(bVar);
            if (bVar2.m1()) {
                z = false;
            }
            String a = bVar.a();
            String valueOf = String.valueOf(bVar2);
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 2 + valueOf.length());
            sb.append(a);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}