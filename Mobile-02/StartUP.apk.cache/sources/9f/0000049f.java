package c.a.l.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.i0;
import c.a.l.a.b;
import c.a.l.a.d;
import c.e.h;
import c.t.a.a.i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends c.a.l.a.d implements androidx.core.graphics.drawable.b {
    private static final String q = a.class.getSimpleName();
    private c t;
    private g u;
    private int v;
    private int w;
    private boolean x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends g {
        private final Animatable a;

        b(Animatable animatable) {
            super();
            this.a = animatable;
        }

        @Override // c.a.l.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // c.a.l.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends d.a {
        c.e.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new c.e.d<>();
            this.L = new h<>();
        }

        private static long D(int i2, int i3) {
            return i3 | (i2 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i2) {
            int z = super.z(iArr, drawable);
            this.L.l(z, Integer.valueOf(i2));
            return z;
        }

        int C(int i2, int i3, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long D = D(i2, i3);
            long j2 = z ? 8589934592L : 0L;
            long j3 = a;
            this.K.b(D, Long.valueOf(j3 | j2));
            if (z) {
                this.K.b(D(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return a;
        }

        int E(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.h(i2, 0).intValue();
        }

        int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        int G(int i2, int i3) {
            return (int) this.K.i(D(i2, i3), -1L).longValue();
        }

        boolean H(int i2, int i3) {
            return (this.K.i(D(i2, i3), -1L).longValue() & 4294967296L) != 0;
        }

        boolean I(int i2, int i3) {
            return (this.K.i(D(i2, i3), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // c.a.l.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // c.a.l.a.d.a, c.a.l.a.b.c
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // c.a.l.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends g {
        private final c.t.a.a.c a;

        d(c.t.a.a.c cVar) {
            super();
            this.a = cVar;
        }

        @Override // c.a.l.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // c.a.l.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class e extends g {
        private final ObjectAnimator a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2511b;

        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f2511b = z2;
            this.a = ofInt;
        }

        @Override // c.a.l.a.a.g
        public boolean a() {
            return this.f2511b;
        }

        @Override // c.a.l.a.a.g
        public void b() {
            this.a.reverse();
        }

        @Override // c.a.l.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // c.a.l.a.a.g
        public void d() {
            this.a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {
        private int[] a;

        /* renamed from: b  reason: collision with root package name */
        private int f2512b;

        /* renamed from: c  reason: collision with root package name */
        private int f2513c;

        f(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        int a() {
            return this.f2513c;
        }

        int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f2512b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f2513c = i2;
            return i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * this.f2513c) + 0.5f);
            int i3 = this.f2512b;
            int[] iArr = this.a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (i4 / i3) + (i4 < i3 ? i2 / this.f2513c : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.a.m.b.f2541h);
        int resourceId = k2.getResourceId(c.a.m.b.f2542i, 0);
        int resourceId2 = k2.getResourceId(c.a.m.b.f2543j, -1);
        Drawable j2 = resourceId2 > 0 ? i0.h().j(context, resourceId2) : null;
        k2.recycle();
        int[] k3 = k(attributeSet);
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    j2 = i.c(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (j2 != null) {
            return this.t.B(k3, j2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.a.m.b.f2544k);
        int resourceId = k2.getResourceId(c.a.m.b.n, -1);
        int resourceId2 = k2.getResourceId(c.a.m.b.m, -1);
        int resourceId3 = k2.getResourceId(c.a.m.b.f2545l, -1);
        Drawable j2 = resourceId3 > 0 ? i0.h().j(context, resourceId3) : null;
        boolean z = k2.getBoolean(c.a.m.b.o, false);
        k2.recycle();
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    j2 = c.t.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    j2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (j2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.t.C(resourceId, resourceId2, j2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i2) {
        int c2;
        int G;
        g bVar;
        g gVar = this.u;
        if (gVar != null) {
            if (i2 == this.v) {
                return true;
            }
            if (i2 == this.w && gVar.a()) {
                gVar.b();
                this.v = this.w;
                this.w = i2;
                return true;
            }
            c2 = this.v;
            gVar.d();
        } else {
            c2 = c();
        }
        this.u = null;
        this.w = -1;
        this.v = -1;
        c cVar = this.t;
        int E = cVar.E(c2);
        int E2 = cVar.E(i2);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof c.t.a.a.c) {
            bVar = new d((c.t.a.a.c) current);
        } else {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        }
        bVar.c();
        this.u = bVar;
        this.w = c2;
        this.v = i2;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.t;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f2526d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(c.a.m.b.f2537d, cVar.f2531i));
        cVar.t(typedArray.getBoolean(c.a.m.b.f2538e, cVar.f2534l));
        cVar.u(typedArray.getInt(c.a.m.b.f2539f, cVar.A));
        cVar.v(typedArray.getInt(c.a.m.b.f2540g, cVar.B));
        setDither(typedArray.getBoolean(c.a.m.b.f2535b, cVar.x));
    }

    @Override // c.a.l.a.d, c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.a.l.a.d, c.a.l.a.b
    public void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof c) {
            this.t = (c) cVar;
        }
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // c.a.l.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.u;
        if (gVar != null) {
            gVar.d();
            this.u = null;
            g(this.v);
            this.v = -1;
            this.w = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.a.l.a.d
    /* renamed from: l */
    public c j() {
        return new c(this.t, this, null);
    }

    @Override // c.a.l.a.d, c.a.l.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.x && super.mutate() == this) {
            this.t.r();
            this.x = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.a.m.b.a);
        setVisible(k2.getBoolean(c.a.m.b.f2536c, true), true);
        t(k2);
        i(resources);
        k2.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.a.l.a.d, c.a.l.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int F = this.t.F(iArr);
        boolean z = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.u;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    a(c cVar, Resources resources) {
        super(null);
        this.v = -1;
        this.w = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}