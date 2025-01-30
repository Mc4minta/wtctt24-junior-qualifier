package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.z;

/* compiled from: ARTVirtualNode.java */
/* loaded from: classes2.dex */
public abstract class f extends z {
    private static final float[] C = new float[9];
    private static final float[] D = new float[9];
    protected float E = 1.0f;
    private Matrix F = new Matrix();
    protected final float G = com.facebook.react.uimanager.c.f().density;

    public abstract void n1(Canvas canvas, Paint paint, float f2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void o1(Canvas canvas) {
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p1(Canvas canvas) {
        canvas.save();
        Matrix matrix = this.F;
        if (matrix != null) {
            canvas.concat(matrix);
        }
    }

    protected void q1() {
        float[] fArr = D;
        float[] fArr2 = C;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[2];
        float f2 = fArr2[4];
        float f3 = this.G;
        fArr[2] = f2 * f3;
        fArr[3] = fArr2[1];
        fArr[4] = fArr2[3];
        fArr[5] = fArr2[5] * f3;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        if (this.F == null) {
            this.F = new Matrix();
        }
        this.F.setValues(fArr);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f2) {
        this.E = f2;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "transform")
    public void setTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int a = g.a(readableArray, C);
            if (a == 6) {
                q1();
            } else if (a != -1) {
                throw new JSApplicationIllegalArgumentException("Transform matrices must be of size 6");
            }
        } else {
            this.F = null;
        }
        w0();
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public boolean t() {
        return true;
    }
}