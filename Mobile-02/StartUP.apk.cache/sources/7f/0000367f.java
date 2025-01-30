package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class k9 extends g9 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f7721c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k9(j9 j9Var) {
        super(j9Var);
        this.f7614b.t(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        return this.f7721c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (!this.f7721c) {
            w();
            this.f7614b.e0();
            this.f7721c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean w();
}