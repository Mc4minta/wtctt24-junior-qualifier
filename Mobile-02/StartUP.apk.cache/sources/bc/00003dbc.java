package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.facebook.react.bridge.ReactContext;

/* compiled from: DefsView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
class e extends d {
    public e(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.d, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void O() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof x0) {
                ((x0) childAt).O();
            }
        }
    }
}