package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class w5 extends x5 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f7926b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w5(b5 b5Var) {
        super(b5Var);
        this.a.j(this);
    }

    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (!u()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void r() {
        if (!this.f7926b) {
            if (t()) {
                return;
            }
            this.a.u();
            this.f7926b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void s() {
        if (!this.f7926b) {
            p();
            this.a.u();
            this.f7926b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean t();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean u() {
        return this.f7926b;
    }
}