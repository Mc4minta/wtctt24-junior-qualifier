package h.a.a.a;

import h.c.d0;
import kotlin.jvm.internal.m;

/* compiled from: SingleTaskListenerFactory.kt */
/* loaded from: classes2.dex */
public final class d<Result> implements f<Result, d0<Result>> {
    @Override // h.a.a.a.f
    /* renamed from: c */
    public b<Result> b(d0<Result> emitter) {
        m.h(emitter, "emitter");
        return new b<>(emitter);
    }

    @Override // h.a.a.a.f
    /* renamed from: d */
    public c<Result> a(d0<Result> emitter) {
        m.h(emitter, "emitter");
        return new c<>(emitter);
    }
}