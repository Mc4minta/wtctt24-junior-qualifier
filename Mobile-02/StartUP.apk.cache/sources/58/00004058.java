package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.m;
import com.facebook.react.uimanager.o;
import java.util.EnumSet;

/* compiled from: SafeAreaViewShadowNode.java */
/* loaded from: classes2.dex */
public class k extends com.facebook.react.uimanager.h {
    private i E;
    private float[] F;
    private float[] G;
    private boolean H = false;

    public k() {
        int[] iArr = a1.f5044b;
        this.F = new float[iArr.length];
        this.G = new float[iArr.length];
        for (int i2 = 0; i2 < a1.f5044b.length; i2++) {
            this.F[i2] = Float.NaN;
            this.G[i2] = Float.NaN;
        }
    }

    private void o1(j jVar) {
        if (jVar == j.PADDING) {
            super.T0(1, this.F[1]);
            super.T0(2, this.F[1]);
            super.T0(3, this.F[3]);
            super.T0(0, this.F[0]);
            return;
        }
        super.O0(1, this.G[1]);
        super.O0(2, this.G[1]);
        super.O0(3, this.G[3]);
        super.O0(0, this.G[0]);
    }

    private void p1() {
        float f2;
        float f3;
        float f4;
        i iVar = this.E;
        if (iVar == null) {
            return;
        }
        j c2 = iVar.c();
        j jVar = j.PADDING;
        float[] fArr = c2 == jVar ? this.F : this.G;
        float f5 = fArr[8];
        if (Float.isNaN(f5)) {
            f5 = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
        } else {
            f2 = f5;
            f3 = f2;
            f4 = f3;
        }
        float f6 = fArr[7];
        if (!Float.isNaN(f6)) {
            f5 = f6;
            f3 = f5;
        }
        float f7 = fArr[6];
        if (!Float.isNaN(f7)) {
            f2 = f7;
            f4 = f2;
        }
        float f8 = fArr[1];
        if (!Float.isNaN(f8)) {
            f5 = f8;
        }
        float f9 = fArr[2];
        if (!Float.isNaN(f9)) {
            f2 = f9;
        }
        float f10 = fArr[3];
        if (!Float.isNaN(f10)) {
            f3 = f10;
        }
        float f11 = fArr[0];
        if (!Float.isNaN(f11)) {
            f4 = f11;
        }
        float c3 = o.c(f5);
        float c4 = o.c(f2);
        float c5 = o.c(f3);
        float c6 = o.c(f4);
        EnumSet<h> a = this.E.a();
        a b2 = this.E.b();
        float f12 = a.contains(h.TOP) ? b2.a : 0.0f;
        float f13 = a.contains(h.RIGHT) ? b2.f11051b : 0.0f;
        float f14 = a.contains(h.BOTTOM) ? b2.f11052c : 0.0f;
        float f15 = a.contains(h.LEFT) ? b2.f11053d : 0.0f;
        if (this.E.c() == jVar) {
            super.T0(1, f12 + c3);
            super.T0(2, f13 + c4);
            super.T0(3, f14 + c5);
            super.T0(0, f15 + c6);
            return;
        }
        super.O0(1, f12 + c3);
        super.O0(2, f13 + c4);
        super.O0(3, f14 + c5);
        super.O0(0, f15 + c6);
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void E(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            i iVar2 = this.E;
            if (iVar2 != null && iVar2.c() != iVar.c()) {
                o1(this.E.c());
            }
            this.E = iVar;
            this.H = false;
            p1();
        }
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void U(m mVar) {
        if (this.H) {
            this.H = false;
            p1();
        }
    }

    @Override // com.facebook.react.uimanager.h
    @com.facebook.react.uimanager.c1.b(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i2, Dynamic dynamic) {
        this.G[a1.f5044b[i2]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setMargins(i2, dynamic);
        this.H = true;
    }

    @Override // com.facebook.react.uimanager.h
    @com.facebook.react.uimanager.c1.b(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i2, Dynamic dynamic) {
        this.F[a1.f5044b[i2]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setPaddings(i2, dynamic);
        this.H = true;
    }
}