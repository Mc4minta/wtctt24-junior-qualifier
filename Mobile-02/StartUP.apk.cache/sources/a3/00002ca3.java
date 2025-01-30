package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Bucket.java */
/* loaded from: classes2.dex */
class e<V> {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4597b;

    /* renamed from: c  reason: collision with root package name */
    final Queue f4598c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4599d;

    /* renamed from: e  reason: collision with root package name */
    private int f4600e;

    public e(int i2, int i3, int i4, boolean z) {
        e.f.d.c.i.i(i2 > 0);
        e.f.d.c.i.i(i3 >= 0);
        e.f.d.c.i.i(i4 >= 0);
        this.a = i2;
        this.f4597b = i3;
        this.f4598c = new LinkedList();
        this.f4600e = i4;
        this.f4599d = z;
    }

    void a(V v) {
        this.f4598c.add(v);
    }

    public void b() {
        e.f.d.c.i.i(this.f4600e > 0);
        this.f4600e--;
    }

    @Deprecated
    public V c() {
        V g2 = g();
        if (g2 != null) {
            this.f4600e++;
        }
        return g2;
    }

    int d() {
        return this.f4598c.size();
    }

    public void e() {
        this.f4600e++;
    }

    public boolean f() {
        return this.f4600e + d() > this.f4597b;
    }

    public V g() {
        return (V) this.f4598c.poll();
    }

    public void h(V v) {
        e.f.d.c.i.g(v);
        if (this.f4599d) {
            e.f.d.c.i.i(this.f4600e > 0);
            this.f4600e--;
            a(v);
            return;
        }
        int i2 = this.f4600e;
        if (i2 > 0) {
            this.f4600e = i2 - 1;
            a(v);
            return;
        }
        e.f.d.d.a.k("BUCKET", "Tried to release value %s from an empty bucket!", v);
    }
}