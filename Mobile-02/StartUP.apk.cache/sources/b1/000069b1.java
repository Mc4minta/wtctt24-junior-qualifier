package retrofit2.adapter.rxjava2;

import h.c.a0;
import java.lang.reflect.Type;

/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes3.dex */
final class f<R> implements retrofit2.e<R, Object> {
    private final Type a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f17890b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17891c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17892d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17893e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17894f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17895g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17896h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f17897i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Type type, a0 a0Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = type;
        this.f17890b = a0Var;
        this.f17891c = z;
        this.f17892d = z2;
        this.f17893e = z3;
        this.f17894f = z4;
        this.f17895g = z5;
        this.f17896h = z6;
        this.f17897i = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // retrofit2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object adapt(retrofit2.d<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.f17891c
            if (r0 == 0) goto La
            retrofit2.adapter.rxjava2.b r0 = new retrofit2.adapter.rxjava2.b
            r0.<init>(r2)
            goto Lf
        La:
            retrofit2.adapter.rxjava2.c r0 = new retrofit2.adapter.rxjava2.c
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.f17892d
            if (r2 == 0) goto L1a
            retrofit2.adapter.rxjava2.e r2 = new retrofit2.adapter.rxjava2.e
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.f17893e
            if (r2 == 0) goto L24
            retrofit2.adapter.rxjava2.a r2 = new retrofit2.adapter.rxjava2.a
            r2.<init>(r0)
            goto L18
        L24:
            h.c.a0 r2 = r1.f17890b
            if (r2 == 0) goto L2c
            h.c.s r0 = r0.subscribeOn(r2)
        L2c:
            boolean r2 = r1.f17894f
            if (r2 == 0) goto L37
            h.c.b r2 = h.c.b.LATEST
            h.c.h r2 = r0.toFlowable(r2)
            return r2
        L37:
            boolean r2 = r1.f17895g
            if (r2 == 0) goto L40
            h.c.b0 r2 = r0.singleOrError()
            return r2
        L40:
            boolean r2 = r1.f17896h
            if (r2 == 0) goto L49
            h.c.o r2 = r0.singleElement()
            return r2
        L49:
            boolean r2 = r1.f17897i
            if (r2 == 0) goto L52
            h.c.c r2 = r0.ignoreElements()
            return r2
        L52:
            h.c.s r2 = h.c.r0.a.n(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.f.adapt(retrofit2.d):java.lang.Object");
    }

    @Override // retrofit2.e
    public Type responseType() {
        return this.a;
    }
}