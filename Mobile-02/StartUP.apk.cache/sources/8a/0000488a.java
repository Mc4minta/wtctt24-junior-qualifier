package e.g.a.f.r;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

/* compiled from: RippleUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13327b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13328c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13329d;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f13330e;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f13331f;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f13332g;

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f13333h;

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f13334i;

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f13335j;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        f13327b = new int[]{16842919};
        f13328c = new int[]{16843623, 16842908};
        f13329d = new int[]{16842908};
        f13330e = new int[]{16843623};
        f13331f = new int[]{16842913, 16842919};
        f13332g = new int[]{16842913, 16843623, 16842908};
        f13333h = new int[]{16842913, 16842908};
        f13334i = new int[]{16842913, 16843623};
        f13335j = new int[]{16842913};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{f13335j, StateSet.NOTHING}, new int[]{c(colorStateList, f13331f), c(colorStateList, f13327b)});
        }
        int[] iArr = f13331f;
        int[] iArr2 = f13332g;
        int[] iArr3 = f13333h;
        int[] iArr4 = f13334i;
        int[] iArr5 = f13327b;
        int[] iArr6 = f13328c;
        int[] iArr7 = f13329d;
        int[] iArr8 = f13330e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f13335j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i2) {
        return c.h.e.a.h(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }
}