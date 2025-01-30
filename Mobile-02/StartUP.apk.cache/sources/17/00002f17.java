package com.facebook.react.uimanager.f1;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimpleSpringInterpolator.java */
/* loaded from: classes2.dex */
public class n implements Interpolator {
    private final float a;

    public n(float f2) {
        this.a = f2;
    }

    public static float a(ReadableMap readableMap) {
        if (readableMap.getType("springDamping").equals(ReadableType.Number)) {
            return (float) readableMap.getDouble("springDamping");
        }
        return 0.5f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        double pow = Math.pow(2.0d, (-10.0f) * f2);
        float f3 = this.a;
        return (float) ((pow * Math.sin((((f2 - (f3 / 4.0f)) * 3.141592653589793d) * 2.0d) / f3)) + 1.0d);
    }
}