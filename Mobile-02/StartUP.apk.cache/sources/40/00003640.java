package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class f7 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Uri f7586b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7587c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f7588d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ c7 f7589e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f7(c7 c7Var, boolean z, Uri uri, String str, String str2) {
        this.f7589e = c7Var;
        this.a = z;
        this.f7586b = uri;
        this.f7587c = str;
        this.f7588d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7589e.b(this.a, this.f7586b, this.f7587c, this.f7588d);
    }
}