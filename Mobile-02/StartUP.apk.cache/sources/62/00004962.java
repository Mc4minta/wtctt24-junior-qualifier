package e.j.f;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;

/* compiled from: AnimationExtensions.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final void a(View view, long j2, kotlin.e0.c.p<? super View, ? super Boolean, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        View_CommonKt.fadeIn(view, j2, pVar);
    }

    public static /* synthetic */ void b(View view, long j2, kotlin.e0.c.p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pVar = null;
        }
        a(view, j2, pVar);
    }

    public static final void c(View view, long j2, kotlin.e0.c.p<? super View, ? super Boolean, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        View_CommonKt.fadeOut(view, j2, pVar);
    }

    public static final void d(View view, long j2, int i2, int i3, kotlin.e0.c.p<? super View, ? super Animation, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        e.j.l.m.c cVar = new e.j.l.m.c(view, i3, i2, 0, 0, pVar, 24, null);
        cVar.setDuration(j2);
        cVar.setInterpolator(new AccelerateDecelerateInterpolator());
        view.startAnimation(cVar);
    }

    public static /* synthetic */ void e(View view, long j2, int i2, int i3, kotlin.e0.c.p pVar, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = view.getWidth();
        }
        int i5 = i3;
        if ((i4 & 8) != 0) {
            pVar = null;
        }
        d(view, j2, i2, i5, pVar);
    }

    public static final void f(View view, long j2, float f2, boolean z, kotlin.e0.c.p<? super View, ? super Boolean, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        e.j.l.m.b a = e.j.l.m.b.a.a(view, pVar);
        if (z) {
            view.setRotation(-f2);
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(1.0f).rotationBy(f2).setDuration(j2).setListener(a);
    }

    public static /* synthetic */ void g(View view, long j2, float f2, boolean z, kotlin.e0.c.p pVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            pVar = null;
        }
        f(view, j2, f2, z2, pVar);
    }

    public static final void h(View view, long j2, float f2, float f3, kotlin.e0.c.p<? super View, ? super Boolean, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        e.j.l.m.b a = e.j.l.m.b.a.a(view, pVar);
        view.setRotation(f3);
        view.animate().setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f).rotationBy(f2).setDuration(j2).setListener(a);
    }

    public static /* synthetic */ void i(View view, long j2, float f2, float f3, kotlin.e0.c.p pVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        float f4 = f3;
        if ((i2 & 8) != 0) {
            pVar = null;
        }
        h(view, j2, f2, f4, pVar);
    }

    public static final void j(View view, long j2, float f2, float f3, boolean z, kotlin.e0.c.p<? super View, ? super Boolean, kotlin.x> pVar) {
        kotlin.jvm.internal.m.g(view, "<this>");
        e.j.l.m.b a = e.j.l.m.b.a.a(view, pVar);
        if (z) {
            view.setTranslationX(-f2);
            view.setTranslationY(-f3);
        }
        view.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(j2).translationXBy(f2).translationYBy(f3).setListener(a);
    }
}