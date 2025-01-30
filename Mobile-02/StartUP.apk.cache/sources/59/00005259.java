package kotlin.jvm.internal;

import kotlin.j0.j;
import kotlin.j0.o;

/* compiled from: MutablePropertyReference1.java */
/* loaded from: classes3.dex */
public abstract class q extends t implements kotlin.j0.j {
    public q(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.c
    protected kotlin.j0.c computeReflected() {
        return e0.f(this);
    }

    @Override // kotlin.j0.o
    public Object getDelegate(Object obj) {
        return ((kotlin.j0.j) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.e0.c.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // kotlin.j0.m
    public o.a getGetter() {
        return ((kotlin.j0.j) getReflected()).getGetter();
    }

    @Override // kotlin.j0.h
    public j.a getSetter() {
        return ((kotlin.j0.j) getReflected()).getSetter();
    }
}