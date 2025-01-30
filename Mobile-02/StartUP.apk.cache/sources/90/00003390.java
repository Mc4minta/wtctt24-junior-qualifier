package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i8  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class i8<E> extends f8<E> implements Set<E> {
    @NullableDecl

    /* renamed from: b  reason: collision with root package name */
    private transient e8<E> f6764b;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return r8.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return r8.a(this);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public e8<E> k() {
        e8<E> e8Var = this.f6764b;
        if (e8Var == null) {
            e8<E> q = q();
            this.f6764b = q;
            return q;
        }
        return e8Var;
    }

    e8<E> q() {
        return e8.s(toArray());
    }
}