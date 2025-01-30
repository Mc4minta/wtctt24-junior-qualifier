package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class z0 implements Runnable {
    private final /* synthetic */ LifecycleCallback a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6150b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ y0 f6151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(y0 y0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f6151c = y0Var;
        this.a = lifecycleCallback;
        this.f6150b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i2 = this.f6151c.f6148c;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            bundle = this.f6151c.f6149d;
            if (bundle != null) {
                bundle3 = this.f6151c.f6149d;
                bundle2 = bundle3.getBundle(this.f6150b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i3 = this.f6151c.f6148c;
        if (i3 >= 2) {
            this.a.j();
        }
        i4 = this.f6151c.f6148c;
        if (i4 >= 3) {
            this.a.h();
        }
        i5 = this.f6151c.f6148c;
        if (i5 >= 4) {
            this.a.k();
        }
        i6 = this.f6151c.f6148c;
        if (i6 >= 5) {
            this.a.g();
        }
    }
}