package androidx.coordinatorlayout.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.core.util.f;
import c.e.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {
    private final f<ArrayList<T>> a = new Pools$SimplePool(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f1377b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f1378c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f1379d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f1377b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList<T> f() {
        ArrayList<T> acquire = this.a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.release(arrayList);
    }

    public void a(T t, T t2) {
        if (this.f1377b.containsKey(t) && this.f1377b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f1377b.get(t);
            if (arrayList == null) {
                arrayList = f();
                this.f1377b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(T t) {
        if (this.f1377b.containsKey(t)) {
            return;
        }
        this.f1377b.put(t, null);
    }

    public void c() {
        int size = this.f1377b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1377b.valueAt(i2);
            if (valueAt != null) {
                k(valueAt);
            }
        }
        this.f1377b.clear();
    }

    public boolean d(T t) {
        return this.f1377b.containsKey(t);
    }

    public List g(T t) {
        return this.f1377b.get(t);
    }

    public List<T> h(T t) {
        int size = this.f1377b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1377b.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1377b.keyAt(i2));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f1378c.clear();
        this.f1379d.clear();
        int size = this.f1377b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f1377b.keyAt(i2), this.f1378c, this.f1379d);
        }
        return this.f1378c;
    }

    public boolean j(T t) {
        int size = this.f1377b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1377b.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }
}