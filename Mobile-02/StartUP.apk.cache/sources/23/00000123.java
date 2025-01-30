package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: b  reason: collision with root package name */
    private static i0 f816b;

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<Context, c.e.h<ColorStateList>> f818d;

    /* renamed from: e  reason: collision with root package name */
    private c.e.g<String, d> f819e;

    /* renamed from: f  reason: collision with root package name */
    private c.e.h<String> f820f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakHashMap<Context, c.e.d<WeakReference<Drawable.ConstantState>>> f821g = new WeakHashMap<>(0);

    /* renamed from: h  reason: collision with root package name */
    private TypedValue f822h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f823i;

    /* renamed from: j  reason: collision with root package name */
    private e f824j;
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static final c f817c = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.i0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.a.l.a.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.i0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.t.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class c extends c.e.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int i(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter j(int i2, PorterDuff.Mode mode) {
            return c(Integer.valueOf(i(i2, mode)));
        }

        PorterDuffColorFilter k(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(i(i2, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(Context context, int i2, Drawable drawable);

        PorterDuff.Mode b(int i2);

        Drawable c(i0 i0Var, Context context, int i2);

        ColorStateList d(Context context, int i2);

        boolean e(Context context, int i2, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.i0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.t.a.a.i.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(String str, d dVar) {
        if (this.f819e == null) {
            this.f819e = new c.e.g<>();
        }
        this.f819e.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f821g.get(context);
            if (dVar == null) {
                dVar = new c.e.d<>();
                this.f821g.put(context, dVar);
            }
            dVar.n(j2, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f818d == null) {
            this.f818d = new WeakHashMap<>();
        }
        c.e.h<ColorStateList> hVar = this.f818d.get(context);
        if (hVar == null) {
            hVar = new c.e.h<>();
            this.f818d.put(context, hVar);
        }
        hVar.b(i2, colorStateList);
    }

    private void d(Context context) {
        if (this.f823i) {
            return;
        }
        this.f823i = true;
        Drawable j2 = j(context, c.a.m.a.a);
        if (j2 == null || !q(j2)) {
            this.f823i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i2) {
        if (this.f822h == null) {
            this.f822h = new TypedValue();
        }
        TypedValue typedValue = this.f822h;
        context.getResources().getValue(i2, typedValue, true);
        long e2 = e(typedValue);
        Drawable i3 = i(context, e2);
        if (i3 != null) {
            return i3;
        }
        e eVar = this.f824j;
        Drawable c2 = eVar == null ? null : eVar.c(this, context, i2);
        if (c2 != null) {
            c2.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e2, c2);
        }
        return c2;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized i0 h() {
        i0 i0Var;
        synchronized (i0.class) {
            if (f816b == null) {
                i0 i0Var2 = new i0();
                f816b = i0Var2;
                p(i0Var2);
            }
            i0Var = f816b;
        }
        return i0Var;
    }

    private synchronized Drawable i(Context context, long j2) {
        c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f821g.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> h2 = dVar.h(j2);
        if (h2 != null) {
            Drawable.ConstantState constantState = h2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.o(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter j2;
        synchronized (i0.class) {
            c cVar = f817c;
            j2 = cVar.j(i2, mode);
            if (j2 == null) {
                j2 = new PorterDuffColorFilter(i2, mode);
                cVar.k(i2, mode, j2);
            }
        }
        return j2;
    }

    private ColorStateList n(Context context, int i2) {
        c.e.h<ColorStateList> hVar;
        WeakHashMap<Context, c.e.h<ColorStateList>> weakHashMap = this.f818d;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.f(i2);
    }

    private static void p(i0 i0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            i0Var.a("vector", new f());
            i0Var.a("animated-vector", new b());
            i0Var.a("animated-selector", new a());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof c.t.a.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i2) {
        int next;
        c.e.g<String, d> gVar = this.f819e;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        c.e.h<String> hVar = this.f820f;
        if (hVar != null) {
            String f2 = hVar.f(i2);
            if ("appcompat_skip_skip".equals(f2) || (f2 != null && this.f819e.get(f2) == null)) {
                return null;
            }
        } else {
            this.f820f = new c.e.h<>();
        }
        if (this.f822h == null) {
            this.f822h = new TypedValue();
        }
        TypedValue typedValue = this.f822h;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long e2 = e(typedValue);
        Drawable i3 = i(context, e2);
        if (i3 != null) {
            return i3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f820f.b(i2, name);
                    d dVar = this.f819e.get(name);
                    if (dVar != null) {
                        i3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (i3 != null) {
                        i3.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, e2, i3);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (i3 == null) {
            this.f820f.b(i2, "appcompat_skip_skip");
        }
        return i3;
    }

    private Drawable v(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList m = m(context, i2);
        if (m != null) {
            if (z.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.o(r, m);
            PorterDuff.Mode o = o(i2);
            if (o != null) {
                androidx.core.graphics.drawable.a.p(r, o);
                return r;
            }
            return r;
        }
        e eVar = this.f824j;
        if ((eVar == null || !eVar.e(context, i2, drawable)) && !x(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, q0 q0Var, int[] iArr) {
        if (z.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = q0Var.f876d;
        if (!z && !q0Var.f875c) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(g(z ? q0Var.a : null, q0Var.f875c ? q0Var.f874b : a, iArr));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i2, boolean z) {
        Drawable r;
        d(context);
        r = r(context, i2);
        if (r == null) {
            r = f(context, i2);
        }
        if (r == null) {
            r = androidx.core.content.a.f(context, i2);
        }
        if (r != null) {
            r = v(context, i2, z, r);
        }
        if (r != null) {
            z.b(r);
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i2) {
        ColorStateList n;
        n = n(context, i2);
        if (n == null) {
            e eVar = this.f824j;
            n = eVar == null ? null : eVar.d(context, i2);
            if (n != null) {
                c(context, i2, n);
            }
        }
        return n;
    }

    PorterDuff.Mode o(int i2) {
        e eVar = this.f824j;
        if (eVar == null) {
            return null;
        }
        return eVar.b(i2);
    }

    public synchronized void s(Context context) {
        c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f821g.get(context);
        if (dVar != null) {
            dVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, x0 x0Var, int i2) {
        Drawable r = r(context, i2);
        if (r == null) {
            r = x0Var.c(i2);
        }
        if (r != null) {
            return v(context, i2, false, r);
        }
        return null;
    }

    public synchronized void u(e eVar) {
        this.f824j = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i2, Drawable drawable) {
        e eVar = this.f824j;
        return eVar != null && eVar.a(context, i2, drawable);
    }
}