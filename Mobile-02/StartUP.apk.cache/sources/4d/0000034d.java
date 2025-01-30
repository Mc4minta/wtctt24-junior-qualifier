package androidx.navigation;

import android.os.Bundle;

/* compiled from: NavAction.java */
/* loaded from: classes.dex */
public final class c {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private p f1843b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f1844c;

    public c(int i2) {
        this(i2, null);
    }

    public Bundle a() {
        return this.f1844c;
    }

    public int b() {
        return this.a;
    }

    public p c() {
        return this.f1843b;
    }

    public void d(Bundle bundle) {
        this.f1844c = bundle;
    }

    public void e(p pVar) {
        this.f1843b = pVar;
    }

    public c(int i2, p pVar) {
        this(i2, pVar, null);
    }

    public c(int i2, p pVar, Bundle bundle) {
        this.a = i2;
        this.f1843b = pVar;
        this.f1844c = bundle;
    }
}