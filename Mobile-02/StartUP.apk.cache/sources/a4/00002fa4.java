package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import e.f.h.e.q;

/* compiled from: ScaleTypeStartInside.java */
/* loaded from: classes2.dex */
public class h extends q.a {

    /* renamed from: j  reason: collision with root package name */
    public static final q.b f5317j = new h();

    @Override // e.f.h.e.q.a
    public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
        float min = Math.min(Math.min(f4, f5), 1.0f);
        matrix.setScale(min, min);
        matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
    }

    public String toString() {
        return "start_inside";
    }
}