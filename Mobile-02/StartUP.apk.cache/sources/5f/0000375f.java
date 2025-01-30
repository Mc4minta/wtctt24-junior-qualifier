package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes2.dex */
class c<V extends View> extends CoordinatorLayout.c<V> {
    private d a;

    /* renamed from: b  reason: collision with root package name */
    private int f8061b;

    /* renamed from: c  reason: collision with root package name */
    private int f8062c;

    public c() {
        this.f8061b = 0;
        this.f8062c = 0;
    }

    public int D() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.C(v, i2);
    }

    public boolean F(int i2) {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.e(i2);
        }
        this.f8061b = i2;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        E(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new d(v);
        }
        this.a.c();
        int i3 = this.f8061b;
        if (i3 != 0) {
            this.a.e(i3);
            this.f8061b = 0;
        }
        int i4 = this.f8062c;
        if (i4 != 0) {
            this.a.d(i4);
            this.f8062c = 0;
            return true;
        }
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8061b = 0;
        this.f8062c = 0;
    }
}