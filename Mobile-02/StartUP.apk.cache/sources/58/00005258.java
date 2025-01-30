package kotlin.jvm.internal;

import kotlin.j0.i;
import kotlin.j0.n;

/* compiled from: MutablePropertyReference0.java */
/* loaded from: classes3.dex */
public abstract class p extends t implements kotlin.j0.i {
    public p() {
    }

    @Override // kotlin.jvm.internal.c
    protected kotlin.j0.c computeReflected() {
        return e0.e(this);
    }

    @Override // kotlin.j0.n
    public Object getDelegate() {
        return ((kotlin.j0.i) getReflected()).getDelegate();
    }

    @Override // kotlin.e0.c.a
    public Object invoke() {
        return get();
    }

    public p(Object obj) {
        super(obj);
    }

    @Override // kotlin.j0.m
    public n.a getGetter() {
        return ((kotlin.j0.i) getReflected()).getGetter();
    }

    @Override // kotlin.j0.h
    public i.a getSetter() {
        return ((kotlin.j0.i) getReflected()).getSetter();
    }

    public p(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}