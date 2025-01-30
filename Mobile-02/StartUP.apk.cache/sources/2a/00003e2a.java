package com.journeyapps.barcodescanner.q;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.n;

/* compiled from: FitCenterStrategy.java */
/* loaded from: classes2.dex */
public class i extends l {

    /* renamed from: b  reason: collision with root package name */
    private static final String f10449b = "i";

    @Override // com.journeyapps.barcodescanner.q.l
    protected float c(n nVar, n nVar2) {
        if (nVar.a <= 0 || nVar.f10387b <= 0) {
            return 0.0f;
        }
        n s = nVar.s(nVar2);
        float f2 = (s.a * 1.0f) / nVar.a;
        if (f2 > 1.0f) {
            f2 = (float) Math.pow(1.0f / f2, 1.1d);
        }
        float f3 = ((nVar2.a * 1.0f) / s.a) * ((nVar2.f10387b * 1.0f) / s.f10387b);
        return f2 * (((1.0f / f3) / f3) / f3);
    }

    @Override // com.journeyapps.barcodescanner.q.l
    public Rect d(n nVar, n nVar2) {
        n s = nVar.s(nVar2);
        String str = f10449b;
        Log.i(str, "Preview: " + nVar + "; Scaled: " + s + "; Want: " + nVar2);
        int i2 = (s.a - nVar2.a) / 2;
        int i3 = (s.f10387b - nVar2.f10387b) / 2;
        return new Rect(-i2, -i3, s.a - i2, s.f10387b - i3);
    }
}