package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;

/* compiled from: ImageMetaData.java */
/* loaded from: classes2.dex */
public class b {
    private final Pair<Integer, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorSpace f4665b;

    public b(int i2, int i3, ColorSpace colorSpace) {
        this.a = (i2 == -1 || i3 == -1) ? null : new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        this.f4665b = colorSpace;
    }

    public ColorSpace a() {
        return this.f4665b;
    }

    public Pair<Integer, Integer> b() {
        return this.a;
    }
}