package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class f5 extends d2 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f7585b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f5(b5 b5Var) {
        super(b5Var);
        this.a.e(this);
    }

    public final void A() {
        if (!this.f7585b) {
            w();
            this.a.u();
            this.f7585b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean B();

    protected void w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean x() {
        return this.f7585b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y() {
        if (!x()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void z() {
        if (!this.f7585b) {
            if (B()) {
                return;
            }
            this.a.u();
            this.f7585b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}