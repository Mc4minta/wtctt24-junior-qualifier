package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zc;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class e6 {
    final Context a;

    /* renamed from: b  reason: collision with root package name */
    String f7556b;

    /* renamed from: c  reason: collision with root package name */
    String f7557c;

    /* renamed from: d  reason: collision with root package name */
    String f7558d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f7559e;

    /* renamed from: f  reason: collision with root package name */
    long f7560f;

    /* renamed from: g  reason: collision with root package name */
    zc f7561g;

    /* renamed from: h  reason: collision with root package name */
    boolean f7562h;

    /* renamed from: i  reason: collision with root package name */
    Long f7563i;

    public e6(Context context, zc zcVar, Long l2) {
        this.f7562h = true;
        com.google.android.gms.common.internal.t.k(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.t.k(applicationContext);
        this.a = applicationContext;
        this.f7563i = l2;
        if (zcVar != null) {
            this.f7561g = zcVar;
            this.f7556b = zcVar.f7462f;
            this.f7557c = zcVar.f7461e;
            this.f7558d = zcVar.f7460d;
            this.f7562h = zcVar.f7459c;
            this.f7560f = zcVar.f7458b;
            Bundle bundle = zcVar.f7463g;
            if (bundle != null) {
                this.f7559e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}