package com.journeyapps.barcodescanner.q;

import android.graphics.Rect;
import com.journeyapps.barcodescanner.n;
import java.util.List;

/* compiled from: DisplayConfiguration.java */
/* loaded from: classes2.dex */
public class h {
    private n a;

    /* renamed from: b  reason: collision with root package name */
    private int f10446b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10447c = false;

    /* renamed from: d  reason: collision with root package name */
    private l f10448d = new i();

    public h(int i2, n nVar) {
        this.f10446b = i2;
        this.a = nVar;
    }

    public n a(List<n> list, boolean z) {
        return this.f10448d.b(list, b(z));
    }

    public n b(boolean z) {
        n nVar = this.a;
        if (nVar == null) {
            return null;
        }
        return z ? nVar.n() : nVar;
    }

    public int c() {
        return this.f10446b;
    }

    public Rect d(n nVar) {
        return this.f10448d.d(nVar, this.a);
    }

    public void e(l lVar) {
        this.f10448d = lVar;
    }
}