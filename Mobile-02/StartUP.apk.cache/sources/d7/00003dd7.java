package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaskView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class q extends l {
    private static final float[] P0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    c0 Q0;
    c0 R0;
    c0 S0;
    c0 T0;
    private a.b U0;
    private a.b V0;
    private Matrix W0;

    public q(ReactContext reactContext) {
        super(reactContext);
        this.W0 = null;
    }

    @Override // com.horcrux.svg.l, com.horcrux.svg.x0
    void O() {
        if (this.T != null) {
            getSvgView().C(this, this.T);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.T0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "maskContentUnits")
    public void setMaskContentUnits(int i2) {
        if (i2 == 0) {
            this.V0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.V0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "maskTransform")
    public void setMaskTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = P0;
            int c2 = w.c(readableArray, fArr, this.P);
            if (c2 == 6) {
                if (this.W0 == null) {
                    this.W0 = new Matrix();
                }
                this.W0.setValues(fArr);
            } else if (c2 != -1) {
                e.f.d.d.a.A("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.W0 = null;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "maskUnits")
    public void setMaskUnits(int i2) {
        if (i2 == 0) {
            this.U0 = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.U0 = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.S0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }
}