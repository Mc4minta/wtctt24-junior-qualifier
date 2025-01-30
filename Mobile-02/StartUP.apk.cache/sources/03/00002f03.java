package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: ShadowNodeRegistry.java */
/* loaded from: classes2.dex */
public class f0 {
    private final SparseArray<y> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseBooleanArray f5079b = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.react.common.d f5080c = new com.facebook.react.common.d();

    public void a(y yVar) {
        this.f5080c.a();
        this.a.put(yVar.q(), yVar);
    }

    public void b(y yVar) {
        this.f5080c.a();
        int q = yVar.q();
        this.a.put(q, yVar);
        this.f5079b.put(q, true);
    }

    public y c(int i2) {
        this.f5080c.a();
        return this.a.get(i2);
    }

    public int d() {
        this.f5080c.a();
        return this.f5079b.size();
    }

    public int e(int i2) {
        this.f5080c.a();
        return this.f5079b.keyAt(i2);
    }

    public boolean f(int i2) {
        this.f5080c.a();
        return this.f5079b.get(i2);
    }

    public void g(int i2) {
        this.f5080c.a();
        if (!this.f5079b.get(i2)) {
            this.a.remove(i2);
            return;
        }
        throw new IllegalViewOperationException("Trying to remove root node " + i2 + " without using removeRootNode!");
    }

    public void h(int i2) {
        this.f5080c.a();
        if (i2 == -1) {
            return;
        }
        if (this.f5079b.get(i2)) {
            this.a.remove(i2);
            this.f5079b.delete(i2);
            return;
        }
        throw new IllegalViewOperationException("View with tag " + i2 + " is not registered as a root view");
    }
}