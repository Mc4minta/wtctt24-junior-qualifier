package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class a1 implements Runnable {
    private final /* synthetic */ LifecycleCallback a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6068b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ b1 f6069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(b1 b1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f6069c = b1Var;
        this.a = lifecycleCallback;
        this.f6068b = str;
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
        i2 = this.f6069c.f6075c;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            bundle = this.f6069c.f6076d;
            if (bundle != null) {
                bundle3 = this.f6069c.f6076d;
                bundle2 = bundle3.getBundle(this.f6068b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i3 = this.f6069c.f6075c;
        if (i3 >= 2) {
            this.a.j();
        }
        i4 = this.f6069c.f6075c;
        if (i4 >= 3) {
            this.a.h();
        }
        i5 = this.f6069c.f6075c;
        if (i5 >= 4) {
            this.a.k();
        }
        i6 = this.f6069c.f6075c;
        if (i6 >= 5) {
            this.a.g();
        }
    }
}