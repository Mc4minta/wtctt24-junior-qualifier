package com.rd.c.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.rd.c.c.d;
import org.apache.http.protocol.HttpRequestExecutor;

/* compiled from: AttributeController.java */
/* loaded from: classes2.dex */
public class a {
    private com.rd.c.c.a a;

    public a(com.rd.c.c.a aVar) {
        this.a = aVar;
    }

    private com.rd.b.d.a a(int i2) {
        switch (i2) {
            case 0:
                return com.rd.b.d.a.NONE;
            case 1:
                return com.rd.b.d.a.COLOR;
            case 2:
                return com.rd.b.d.a.SCALE;
            case 3:
                return com.rd.b.d.a.WORM;
            case 4:
                return com.rd.b.d.a.SLIDE;
            case 5:
                return com.rd.b.d.a.FILL;
            case 6:
                return com.rd.b.d.a.THIN_WORM;
            case 7:
                return com.rd.b.d.a.DROP;
            case 8:
                return com.rd.b.d.a.SWAP;
            case 9:
                return com.rd.b.d.a.SCALE_DOWN;
            default:
                return com.rd.b.d.a.NONE;
        }
    }

    private d b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return d.Auto;
                }
                return d.Auto;
            }
            return d.Off;
        }
        return d.On;
    }

    private void d(TypedArray typedArray) {
        boolean z = typedArray.getBoolean(com.rd.d.a.n, false);
        long j2 = typedArray.getInt(com.rd.d.a.f10679g, 350);
        if (j2 < 0) {
            j2 = 0;
        }
        com.rd.b.d.a a = a(typedArray.getInt(com.rd.d.a.f10680h, com.rd.b.d.a.NONE.ordinal()));
        d b2 = b(typedArray.getInt(com.rd.d.a.r, d.Off.ordinal()));
        boolean z2 = typedArray.getBoolean(com.rd.d.a.f10684l, false);
        long j3 = typedArray.getInt(com.rd.d.a.m, HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
        this.a.A(j2);
        this.a.J(z);
        this.a.B(a);
        this.a.S(b2);
        this.a.F(z2);
        this.a.I(j3);
    }

    private void e(TypedArray typedArray) {
        int color = typedArray.getColor(com.rd.d.a.w, Color.parseColor("#33ffffff"));
        int color2 = typedArray.getColor(com.rd.d.a.u, Color.parseColor("#ffffff"));
        this.a.Y(color);
        this.a.U(color2);
    }

    private void f(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(com.rd.d.a.x, -1);
        boolean z = typedArray.getBoolean(com.rd.d.a.f10681i, true);
        int i2 = 0;
        boolean z2 = typedArray.getBoolean(com.rd.d.a.f10683k, false);
        int i3 = typedArray.getInt(com.rd.d.a.f10682j, -1);
        if (i3 == -1) {
            i3 = 3;
        }
        int i4 = typedArray.getInt(com.rd.d.a.t, 0);
        if (i4 >= 0 && (i3 <= 0 || i4 <= i3 - 1)) {
            i2 = i4;
        }
        this.a.Z(resourceId);
        this.a.C(z);
        this.a.E(z2);
        this.a.D(i3);
        this.a.V(i2);
        this.a.W(i2);
        this.a.K(i2);
    }

    private void g(TypedArray typedArray) {
        int i2 = com.rd.d.a.o;
        com.rd.c.c.b bVar = com.rd.c.c.b.HORIZONTAL;
        if (typedArray.getInt(i2, bVar.ordinal()) != 0) {
            bVar = com.rd.c.c.b.VERTICAL;
        }
        int dimension = (int) typedArray.getDimension(com.rd.d.a.q, com.rd.e.b.a(6));
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) typedArray.getDimension(com.rd.d.a.p, com.rd.e.b.a(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f2 = typedArray.getFloat(com.rd.d.a.s, 0.7f);
        if (f2 < 0.3f) {
            f2 = 0.3f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int dimension3 = (int) typedArray.getDimension(com.rd.d.a.v, com.rd.e.b.a(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        int i3 = this.a.b() == com.rd.b.d.a.FILL ? dimension3 : 0;
        this.a.R(dimension);
        this.a.L(bVar);
        this.a.M(dimension2);
        this.a.T(f2);
        this.a.X(i3);
    }

    public void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.rd.d.a.f10678f, 0, 0);
        f(obtainStyledAttributes);
        e(obtainStyledAttributes);
        d(obtainStyledAttributes);
        g(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}