package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: ARTGroupShadowNode.java */
/* loaded from: classes2.dex */
public class a extends f {
    protected RectF H;

    private static RectF r1(float[] fArr) {
        if (fArr.length == 4) {
            return new RectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[1] + fArr[3]);
        }
        throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    }

    @Override // com.facebook.react.views.art.f
    public void n1(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.E;
        if (f3 > 0.01f) {
            p1(canvas);
            RectF rectF = this.H;
            if (rectF != null) {
                float f4 = rectF.left;
                float f5 = this.G;
                canvas.clipRect(f4 * f5, rectF.top * f5, rectF.right * f5, rectF.bottom * f5);
            }
            for (int i2 = 0; i2 < b(); i2++) {
                f fVar = (f) a(i2);
                fVar.n1(canvas, paint, f3);
                fVar.d();
            }
            o1(canvas);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "clipping")
    public void setClipping(ReadableArray readableArray) {
        float[] b2 = g.b(readableArray);
        if (b2 != null) {
            this.H = r1(b2);
            w0();
        }
    }

    @Override // com.facebook.react.views.art.f, com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public boolean t() {
        return true;
    }
}