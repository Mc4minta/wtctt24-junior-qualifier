package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class k {
    private final SparseIntArray a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private com.google.android.gms.common.f f6248b;

    public k(com.google.android.gms.common.f fVar) {
        t.k(fVar);
        this.f6248b = fVar;
    }

    public void a() {
        this.a.clear();
    }

    public int b(Context context, a.f fVar) {
        t.k(context);
        t.k(fVar);
        int i2 = 0;
        if (fVar.m()) {
            int n = fVar.n();
            int i3 = this.a.get(n, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.a.size()) {
                    i2 = i3;
                    break;
                }
                int keyAt = this.a.keyAt(i4);
                if (keyAt > n && this.a.get(keyAt) == 0) {
                    break;
                }
                i4++;
            }
            if (i2 == -1) {
                i2 = this.f6248b.h(context, n);
            }
            this.a.put(n, i2);
            return i2;
        }
        return 0;
    }
}