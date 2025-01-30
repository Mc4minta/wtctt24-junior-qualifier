package com.journeyapps.barcodescanner.q;

import android.graphics.Rect;
import com.journeyapps.barcodescanner.n;

/* compiled from: FitXYStrategy.java */
/* loaded from: classes2.dex */
public class j extends l {
    private static float e(float f2) {
        return f2 < 1.0f ? 1.0f / f2 : f2;
    }

    @Override // com.journeyapps.barcodescanner.q.l
    protected float c(n nVar, n nVar2) {
        int i2 = nVar.a;
        if (i2 <= 0 || nVar.f10387b <= 0) {
            return 0.0f;
        }
        float e2 = (1.0f / e((i2 * 1.0f) / nVar2.a)) / e((nVar.f10387b * 1.0f) / nVar2.f10387b);
        float e3 = e(((nVar.a * 1.0f) / nVar.f10387b) / ((nVar2.a * 1.0f) / nVar2.f10387b));
        return e2 * (((1.0f / e3) / e3) / e3);
    }

    @Override // com.journeyapps.barcodescanner.q.l
    public Rect d(n nVar, n nVar2) {
        return new Rect(0, 0, nVar2.a, nVar2.f10387b);
    }
}