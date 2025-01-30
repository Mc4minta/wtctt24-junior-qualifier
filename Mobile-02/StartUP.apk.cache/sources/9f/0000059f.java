package c.h.k.f0;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public final class b {
    public static Interpolator a(float f2, float f3, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f2, f3, f4, f5);
        }
        return new a(f2, f3, f4, f5);
    }
}