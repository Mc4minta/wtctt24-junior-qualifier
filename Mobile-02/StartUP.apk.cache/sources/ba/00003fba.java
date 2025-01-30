package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: RNGestureHandlerInteractionManager.java */
/* loaded from: classes2.dex */
public class d implements e.i.a.c {
    private SparseArray<int[]> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<int[]> f10908b = new SparseArray<>();

    private int[] f(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = array.getInt(i2);
        }
        return iArr;
    }

    @Override // e.i.a.c
    public boolean a(e.i.a.b bVar, e.i.a.b bVar2) {
        return false;
    }

    @Override // e.i.a.c
    public boolean b(e.i.a.b bVar, e.i.a.b bVar2) {
        int[] iArr = this.f10908b.get(bVar.q());
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == bVar2.q()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // e.i.a.c
    public boolean c(e.i.a.b bVar, e.i.a.b bVar2) {
        int[] iArr = this.a.get(bVar.q());
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == bVar2.q()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // e.i.a.c
    public boolean d(e.i.a.b bVar, e.i.a.b bVar2) {
        return false;
    }

    public void e(e.i.a.b bVar, ReadableMap readableMap) {
        bVar.J(this);
        if (readableMap.hasKey("waitFor")) {
            this.a.put(bVar.q(), f(readableMap, "waitFor"));
        }
        if (readableMap.hasKey("simultaneousHandlers")) {
            this.f10908b.put(bVar.q(), f(readableMap, "simultaneousHandlers"));
        }
    }

    public void g(int i2) {
        this.a.remove(i2);
        this.f10908b.remove(i2);
    }

    public void h() {
        this.a.clear();
        this.f10908b.clear();
    }
}