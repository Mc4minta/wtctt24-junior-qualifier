package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;

/* compiled from: RNGestureHandlerRegistry.java */
/* loaded from: classes2.dex */
public class f implements e.i.a.e {
    private final SparseArray<e.i.a.b> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<Integer> f10909b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<ArrayList<e.i.a.b>> f10910c = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNGestureHandlerRegistry.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ e.i.a.b a;

        a(e.i.a.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d();
        }
    }

    private synchronized void c(e.i.a.b bVar) {
        Integer num = this.f10909b.get(bVar.q());
        if (num != null) {
            this.f10909b.remove(bVar.q());
            ArrayList<e.i.a.b> arrayList = this.f10910c.get(num.intValue());
            if (arrayList != null) {
                arrayList.remove(bVar);
                if (arrayList.size() == 0) {
                    this.f10910c.remove(num.intValue());
                }
            }
        }
        if (bVar.r() != null) {
            UiThreadUtil.runOnUiThread(new a(bVar));
        }
    }

    private synchronized void i(int i2, e.i.a.b bVar) {
        if (this.f10909b.get(bVar.q()) == null) {
            this.f10909b.put(bVar.q(), Integer.valueOf(i2));
            ArrayList<e.i.a.b> arrayList = this.f10910c.get(i2);
            if (arrayList == null) {
                ArrayList<e.i.a.b> arrayList2 = new ArrayList<>(1);
                arrayList2.add(bVar);
                this.f10910c.put(i2, arrayList2);
            } else {
                arrayList.add(bVar);
            }
        } else {
            throw new IllegalStateException("Handler " + bVar + " already attached");
        }
    }

    @Override // e.i.a.e
    public synchronized ArrayList<e.i.a.b> a(View view) {
        return g(view.getId());
    }

    public synchronized boolean b(int i2, int i3) {
        e.i.a.b bVar = this.a.get(i2);
        if (bVar != null) {
            c(bVar);
            i(i3, bVar);
            return true;
        }
        return false;
    }

    public synchronized void d() {
        this.a.clear();
        this.f10909b.clear();
        this.f10910c.clear();
    }

    public synchronized void e(int i2) {
        e.i.a.b bVar = this.a.get(i2);
        if (bVar != null) {
            c(bVar);
            this.a.remove(i2);
        }
    }

    public synchronized e.i.a.b f(int i2) {
        return this.a.get(i2);
    }

    public synchronized ArrayList<e.i.a.b> g(int i2) {
        return this.f10910c.get(i2);
    }

    public synchronized void h(e.i.a.b bVar) {
        this.a.put(bVar.q(), bVar);
    }
}