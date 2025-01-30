package e.g.a.f.s;

import c.a.l.a.c;

/* compiled from: ShadowDrawableWrapper.java */
/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    static final double f13336b = Math.cos(Math.toRadians(45.0d));

    public static float c(float f2, float f3, boolean z) {
        return z ? (float) (f2 + ((1.0d - f13336b) * f3)) : f2;
    }

    public static float d(float f2, float f3, boolean z) {
        return z ? (float) ((f2 * 1.5f) + ((1.0d - f13336b) * f3)) : f2 * 1.5f;
    }
}