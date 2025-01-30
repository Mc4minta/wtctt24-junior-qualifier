package com.rd.c.b;

import android.util.Pair;
import android.view.View;

/* compiled from: MeasureController.java */
/* loaded from: classes2.dex */
public class c {
    public Pair<Integer, Integer> a(com.rd.c.c.a aVar, int i2, int i3) {
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int c2 = aVar.c();
        int m = aVar.m();
        int s = aVar.s();
        int h2 = aVar.h();
        int j2 = aVar.j();
        int l2 = aVar.l();
        int k2 = aVar.k();
        int i6 = aVar.i();
        int i7 = m * 2;
        com.rd.c.c.b g2 = aVar.g();
        if (c2 != 0) {
            i5 = (i7 * c2) + (s * 2 * c2) + (h2 * (c2 - 1));
            i4 = i7 + s;
            if (g2 != com.rd.c.c.b.HORIZONTAL) {
                i5 = i4;
                i4 = i5;
            }
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (aVar.b() == com.rd.b.d.a.DROP) {
            if (g2 == com.rd.c.c.b.HORIZONTAL) {
                i4 *= 2;
            } else {
                i5 *= 2;
            }
        }
        com.rd.c.c.b bVar = com.rd.c.c.b.HORIZONTAL;
        int i8 = i5 + j2 + k2;
        int i9 = i4 + l2 + i6;
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i8, size) : i8;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i9, size2) : i9;
        }
        if (size < 0) {
            size = 0;
        }
        int i10 = size2 >= 0 ? size2 : 0;
        aVar.a0(size);
        aVar.G(i10);
        return new Pair<>(Integer.valueOf(size), Integer.valueOf(i10));
    }
}