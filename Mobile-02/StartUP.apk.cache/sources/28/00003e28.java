package com.journeyapps.barcodescanner.q;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.n;

/* compiled from: CenterCropStrategy.java */
/* loaded from: classes2.dex */
public class g extends l {

    /* renamed from: b  reason: collision with root package name */
    private static final String f10445b = "g";

    @Override // com.journeyapps.barcodescanner.q.l
    protected float c(n nVar, n nVar2) {
        if (nVar.a <= 0 || nVar.f10387b <= 0) {
            return 0.0f;
        }
        n q = nVar.q(nVar2);
        float f2 = (q.a * 1.0f) / nVar.a;
        if (f2 > 1.0f) {
            f2 = (float) Math.pow(1.0f / f2, 1.1d);
        }
        float f3 = ((q.a * 1.0f) / nVar2.a) + ((q.f10387b * 1.0f) / nVar2.f10387b);
        return f2 * ((1.0f / f3) / f3);
    }

    @Override // com.journeyapps.barcodescanner.q.l
    public Rect d(n nVar, n nVar2) {
        n q = nVar.q(nVar2);
        String str = f10445b;
        Log.i(str, "Preview: " + nVar + "; Scaled: " + q + "; Want: " + nVar2);
        int i2 = (q.a - nVar2.a) / 2;
        int i3 = (q.f10387b - nVar2.f10387b) / 2;
        return new Rect(-i2, -i3, q.a - i2, q.f10387b - i3);
    }
}