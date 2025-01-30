package com.facebook.react.animated;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AnimatedNode.java */
/* loaded from: classes2.dex */
abstract class b {
    List<b> a;

    /* renamed from: b  reason: collision with root package name */
    int f4706b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f4707c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f4708d = -1;

    public final void a(b bVar) {
        if (this.a == null) {
            this.a = new ArrayList(1);
        }
        ((List) e.f.k.a.a.c(this.a)).add(bVar);
        bVar.b(this);
    }

    public void b(b bVar) {
    }

    public void c(b bVar) {
    }

    public final void d(b bVar) {
        if (this.a == null) {
            return;
        }
        bVar.c(this);
        this.a.remove(bVar);
    }

    public void e() {
    }
}