package com.google.common.collect;

import java.io.Serializable;

/* compiled from: ByFunctionOrdering.java */
/* loaded from: classes2.dex */
final class c<F, T> extends z<F> implements Serializable {
    final com.google.common.base.f<F, ? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final z<T> f8459b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.common.base.f<F, ? extends T> fVar, z<T> zVar) {
        this.a = (com.google.common.base.f) com.google.common.base.l.i(fVar);
        this.f8459b = (z) com.google.common.base.l.i(zVar);
    }

    @Override // com.google.common.collect.z, java.util.Comparator
    public int compare(F f2, F f3) {
        return this.f8459b.compare(this.a.apply(f2), this.a.apply(f3));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.f8459b.equals(cVar.f8459b);
        }
        return false;
    }

    public int hashCode() {
        return com.google.common.base.i.b(this.a, this.f8459b);
    }

    public String toString() {
        return this.f8459b + ".onResultOf(" + this.a + ")";
    }
}