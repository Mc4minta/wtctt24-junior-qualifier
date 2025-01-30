package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import java.util.LinkedList;

/* compiled from: BucketMap.java */
/* loaded from: classes2.dex */
public class f<T> {
    protected final SparseArray<b<T>> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    b<T> f4607b;

    /* renamed from: c  reason: collision with root package name */
    b<T> f4608c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BucketMap.java */
    /* loaded from: classes2.dex */
    public static class b<I> {
        b<I> a;

        /* renamed from: b  reason: collision with root package name */
        int f4609b;

        /* renamed from: c  reason: collision with root package name */
        LinkedList<I> f4610c;

        /* renamed from: d  reason: collision with root package name */
        b<I> f4611d;

        public String toString() {
            return "LinkedEntry(key: " + this.f4609b + ")";
        }

        private b(b<I> bVar, int i2, LinkedList<I> linkedList, b<I> bVar2) {
            this.a = bVar;
            this.f4609b = i2;
            this.f4610c = linkedList;
            this.f4611d = bVar2;
        }
    }

    private void b(b<T> bVar) {
        if (bVar == null || !bVar.f4610c.isEmpty()) {
            return;
        }
        d(bVar);
        this.a.remove(bVar.f4609b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(b<T> bVar) {
        if (this.f4607b == bVar) {
            return;
        }
        d(bVar);
        b bVar2 = (b<T>) this.f4607b;
        if (bVar2 == null) {
            this.f4607b = bVar;
            this.f4608c = bVar;
            return;
        }
        bVar.f4611d = bVar2;
        bVar2.a = bVar;
        this.f4607b = bVar;
    }

    private synchronized void d(b<T> bVar) {
        b bVar2 = (b<T>) bVar.a;
        b bVar3 = (b<T>) bVar.f4611d;
        if (bVar2 != null) {
            bVar2.f4611d = bVar3;
        }
        if (bVar3 != null) {
            bVar3.a = bVar2;
        }
        bVar.a = null;
        bVar.f4611d = null;
        if (bVar == this.f4607b) {
            this.f4607b = bVar3;
        }
        if (bVar == this.f4608c) {
            this.f4608c = bVar2;
        }
    }

    public synchronized T a(int i2) {
        b<T> bVar = this.a.get(i2);
        if (bVar == null) {
            return null;
        }
        T pollFirst = bVar.f4610c.pollFirst();
        c(bVar);
        return pollFirst;
    }

    public synchronized void e(int i2, T t) {
        b<T> bVar = this.a.get(i2);
        if (bVar == null) {
            bVar = new b<>(null, i2, new LinkedList(), null);
            this.a.put(i2, bVar);
        }
        bVar.f4610c.addLast(t);
        c(bVar);
    }

    public synchronized T f() {
        b<T> bVar = this.f4608c;
        if (bVar == null) {
            return null;
        }
        T pollLast = bVar.f4610c.pollLast();
        b(bVar);
        return pollLast;
    }
}