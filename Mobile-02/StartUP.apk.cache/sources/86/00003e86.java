package com.rd.b.d;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import com.rd.b.b.b;

/* compiled from: ScaleDownAnimation.java */
/* loaded from: classes2.dex */
public class g extends f {
    public g(b.a aVar) {
        super(aVar);
    }

    @Override // com.rd.b.d.f
    protected PropertyValuesHolder n(boolean z) {
        int i2;
        int i3;
        String str;
        if (z) {
            i3 = this.f10612g;
            i2 = (int) (i3 * this.f10613h);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i2 = this.f10612g;
            i3 = (int) (i2 * this.f10613h);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i3);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}