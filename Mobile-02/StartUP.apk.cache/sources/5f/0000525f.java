package kotlin.jvm.internal;

import kotlin.j0.o;

/* compiled from: PropertyReference1.java */
/* loaded from: classes3.dex */
public abstract class w extends z implements kotlin.j0.o {
    public w() {
    }

    @Override // kotlin.jvm.internal.c
    protected kotlin.j0.c computeReflected() {
        return e0.h(this);
    }

    @Override // kotlin.j0.o
    public Object getDelegate(Object obj) {
        return ((kotlin.j0.o) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.e0.c.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public w(Object obj) {
        super(obj);
    }

    @Override // kotlin.j0.m
    public o.a getGetter() {
        return ((kotlin.j0.o) getReflected()).getGetter();
    }

    public w(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}