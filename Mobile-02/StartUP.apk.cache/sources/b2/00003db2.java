package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RectView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class a0 extends b0 {
    private c0 N0;
    private c0 O0;
    private c0 P0;
    private c0 Q0;
    private c0 R0;
    private c0 S0;

    public a0(ReactContext reactContext) {
        super(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    @Override // com.horcrux.svg.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Path F(android.graphics.Canvas r20, android.graphics.Paint r21) {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Path r9 = new android.graphics.Path
            r9.<init>()
            com.horcrux.svg.c0 r1 = r0.N0
            double r1 = r0.K(r1)
            com.horcrux.svg.c0 r3 = r0.O0
            double r3 = r0.I(r3)
            com.horcrux.svg.c0 r5 = r0.P0
            double r5 = r0.K(r5)
            com.horcrux.svg.c0 r7 = r0.Q0
            double r7 = r0.I(r7)
            com.horcrux.svg.c0 r10 = r0.R0
            if (r10 != 0) goto L3d
            com.horcrux.svg.c0 r11 = r0.S0
            if (r11 == 0) goto L28
            goto L3d
        L28:
            float r10 = (float) r1
            float r11 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r6
            r6 = r7
            r1.addRect(r2, r3, r4, r5, r6)
            r9.close()
            goto L99
        L3d:
            if (r10 != 0) goto L47
            com.horcrux.svg.c0 r10 = r0.S0
            double r10 = r0.I(r10)
        L45:
            r12 = r10
            goto L5a
        L47:
            com.horcrux.svg.c0 r11 = r0.S0
            if (r11 != 0) goto L50
            double r10 = r0.K(r10)
            goto L45
        L50:
            double r10 = r0.K(r10)
            com.horcrux.svg.c0 r12 = r0.S0
            double r12 = r0.I(r12)
        L5a:
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = r5 / r14
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L64
            r10 = r16
        L64:
            double r14 = r7 / r14
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L6b
            r12 = r14
        L6b:
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 21
            if (r14 < r15) goto L87
            float r14 = (float) r1
            float r15 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            float r7 = (float) r10
            float r8 = (float) r12
            android.graphics.Path$Direction r10 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r14
            r3 = r15
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r1.addRoundRect(r2, r3, r4, r5, r6, r7, r8)
            goto L99
        L87:
            android.graphics.RectF r14 = new android.graphics.RectF
            float r15 = (float) r1
            float r0 = (float) r3
            double r1 = r1 + r5
            float r1 = (float) r1
            double r3 = r3 + r7
            float r2 = (float) r3
            r14.<init>(r15, r0, r1, r2)
            float r0 = (float) r10
            float r1 = (float) r12
            android.graphics.Path$Direction r2 = android.graphics.Path.Direction.CW
            r9.addRoundRect(r14, r0, r1, r2)
        L99:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.a0.F(android.graphics.Canvas, android.graphics.Paint):android.graphics.Path");
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.R0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.S0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.N0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.O0 = c0.b(dynamic);
        invalidate();
    }
}