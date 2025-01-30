package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class a0<O extends a.d> extends t {

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.api.c<O> f6067c;

    public a0(com.google.android.gms.common.api.c<O> cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f6067c = cVar;
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, R extends com.google.android.gms.common.api.i, T extends d<R, A>> T a(T t) {
        return (T) this.f6067c.e(t);
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, T extends d<? extends com.google.android.gms.common.api.i, A>> T b(T t) {
        return (T) this.f6067c.f(t);
    }

    @Override // com.google.android.gms.common.api.d
    public final Looper d() {
        return this.f6067c.k();
    }
}