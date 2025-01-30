package e.g.a.f.l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f13292b = new c.m.a.a.b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f13293c = new c.m.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f13294d = new c.m.a.a.c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f13295e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int b(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }
}