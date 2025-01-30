package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
public class h<TResult> {
    private final b0<TResult> a = new b0<>();

    public g<TResult> a() {
        return this.a;
    }

    public void b(Exception exc) {
        this.a.t(exc);
    }

    public void c(TResult tresult) {
        this.a.u(tresult);
    }

    public boolean d(Exception exc) {
        return this.a.v(exc);
    }

    public boolean e(TResult tresult) {
        return this.a.w(tresult);
    }
}