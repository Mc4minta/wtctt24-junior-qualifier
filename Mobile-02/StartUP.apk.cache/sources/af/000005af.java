package c.h.k;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import c.h.k.a;
import c.h.k.d0;
import c.h.k.e0.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class v {

    /* renamed from: b  reason: collision with root package name */
    private static Field f3053b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3054c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f3055d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3056e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f3057f;

    /* renamed from: h  reason: collision with root package name */
    private static Field f3059h;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal<Rect> f3061j;
    private static final AtomicInteger a = new AtomicInteger(1);

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, z> f3058g = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f3060i = false;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f3062k = {c.h.c.f2903b, c.h.c.f2904c, c.h.c.n, c.h.c.y, c.h.c.B, c.h.c.C, c.h.c.D, c.h.c.E, c.h.c.F, c.h.c.G, c.h.c.f2905d, c.h.c.f2906e, c.h.c.f2907f, c.h.c.f2908g, c.h.c.f2909h, c.h.c.f2910i, c.h.c.f2911j, c.h.c.f2912k, c.h.c.f2913l, c.h.c.m, c.h.c.o, c.h.c.p, c.h.c.q, c.h.c.r, c.h.c.s, c.h.c.t, c.h.c.u, c.h.c.v, c.h.c.w, c.h.c.x, c.h.c.z, c.h.c.A};

    /* renamed from: l  reason: collision with root package name */
    private static final r f3063l = new a();
    private static f m = new f();

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    class a implements r {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class b extends g<Boolean> {
        b(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // c.h.k.v.g
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class c extends g<CharSequence> {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // c.h.k.v.g
        /* renamed from: e */
        public CharSequence c(View view) {
            return view.getAccessibilityPaneTitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class d extends g<CharSequence> {
        d(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // c.h.k.v.g
        /* renamed from: e */
        public CharSequence c(View view) {
            return view.getStateDescription();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class e extends g<Boolean> {
        e(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // c.h.k.v.g
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private WeakHashMap<View, Boolean> a = new WeakHashMap<>();

        f() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                v.W(view, z2 ? 16 : 32);
                this.a.put(view, Boolean.valueOf(z2));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.a.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static abstract class g<T> {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f3064b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3065c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3066d;

        g(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f3065c;
        }

        abstract T c(View view);

        T d(View view) {
            if (b()) {
                return c(view);
            }
            if (a()) {
                T t = (T) view.getTag(this.a);
                if (this.f3064b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        g(int i2, Class<T> cls, int i3, int i4) {
            this.a = i2;
            this.f3064b = cls;
            this.f3066d = i3;
            this.f3065c = i4;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class h {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ViewCompat.java */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {
            d0 a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f3067b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ q f3068c;

            a(View view, q qVar) {
                this.f3067b = view;
                this.f3068c = qVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                d0 w = d0.w(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    h.a(windowInsets, this.f3067b);
                    if (w.equals(this.a)) {
                        return this.f3068c.a(view, w).u();
                    }
                }
                this.a = w;
                d0 a = this.f3068c.a(view, w);
                if (i2 >= 30) {
                    return a.u();
                }
                v.h0(view);
                return a.u();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(c.h.c.R);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static d0 b(View view, d0 d0Var, Rect rect) {
            WindowInsets u = d0Var.u();
            if (u != null) {
                return d0.w(view.computeSystemWindowInsets(u, rect), view);
            }
            rect.setEmpty();
            return d0Var;
        }

        public static d0 c(View view) {
            return d0.a.a(view);
        }

        static void d(View view, q qVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(c.h.c.L, qVar);
            }
            if (qVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(c.h.c.R));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, qVar));
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class i {
        public static d0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            d0 v = d0.v(rootWindowInsets);
            v.s(v);
            v.d(view.getRootView());
            return v;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class j {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class l {
        private static final ArrayList<WeakReference<View>> a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f3069b = null;

        /* renamed from: c  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f3070c = null;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<KeyEvent> f3071d = null;

        l() {
        }

        static l a(View view) {
            int i2 = c.h.c.P;
            l lVar = (l) view.getTag(i2);
            if (lVar == null) {
                l lVar2 = new l();
                view.setTag(i2, lVar2);
                return lVar2;
            }
            return lVar;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f3069b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f3070c == null) {
                this.f3070c = new SparseArray<>();
            }
            return this.f3070c;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(c.h.c.Q);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((k) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f3069b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = a;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f3069b == null) {
                    this.f3069b = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = a;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f3069b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f3069b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c2));
                }
            }
            return c2 != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f3071d;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.f3071d = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> d2 = d();
                if (keyEvent.getAction() == 1 && (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = d2.valueAt(indexOfKey);
                    d2.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = d2.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && v.Q(view)) {
                        e(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f3054c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f3053b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3054c = true;
        }
        Field field = f3053b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static void A0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f3057f == null) {
            f3057f = new WeakHashMap<>();
        }
        f3057f.put(view, str);
    }

    static c.h.k.a B(View view) {
        c.h.k.a j2 = j(view);
        if (j2 == null) {
            j2 = new c.h.k.a();
        }
        k0(view, j2);
        return j2;
    }

    public static void B0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    private static void C0(View view) {
        if (w(view) == 0) {
            t0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (w((View) parent) == 4) {
                t0(view, 2);
                return;
            }
        }
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    private static g<CharSequence> D0() {
        return new d(c.h.c.N, CharSequence.class, 64, 30);
    }

    public static ViewParent E(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static void E0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof c.h.k.k) {
            ((c.h.k.k) view).stopNestedScroll();
        }
    }

    public static d0 F(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return i.a(view);
        }
        if (i2 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static void F0(View view, int i2) {
        if (view instanceof c.h.k.j) {
            ((c.h.k.j) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            E0(view);
        }
    }

    public static final CharSequence G(View view) {
        return D0().d(view);
    }

    private static void G0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static String H(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f3057f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static float I(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static int J(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean L(View view) {
        return k(view) != null;
    }

    public static boolean M(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean P(View view) {
        Boolean d2 = a().d(view);
        if (d2 == null) {
            return false;
        }
        return d2.booleanValue();
    }

    public static boolean Q(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof c.h.k.k) {
            return ((c.h.k.k) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean U(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean V(View view) {
        Boolean d2 = j0().d(view);
        if (d2 == null) {
            return false;
        }
        return d2.booleanValue();
    }

    static void W(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = n(view) != null && view.getVisibility() == 0;
            if (m(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : PKIFailureInfo.wrongIntegrity);
                obtain.setContentChangeTypes(i2);
                if (z) {
                    obtain.getText().add(n(view));
                    C0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void X(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect u = u();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                u.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !u.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            d(view, i2);
            if (z && u.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(u);
            }
        } else {
            d(view, i2);
        }
    }

    public static void Y(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect u = u();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                u.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !u.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            e(view, i2);
            if (z && u.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(u);
            }
        } else {
            e(view, i2);
        }
    }

    public static d0 Z(View view, d0 d0Var) {
        WindowInsets u;
        if (Build.VERSION.SDK_INT >= 21 && (u = d0Var.u()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(u);
            if (!onApplyWindowInsets.equals(u)) {
                return d0.w(onApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    private static g<Boolean> a() {
        return new e(c.h.c.J, Boolean.class, 28);
    }

    private static g<CharSequence> a0() {
        return new c(c.h.c.K, CharSequence.class, 8, 28);
    }

    private static void b(View view, d.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            B(view);
            f0(aVar.b(), view);
            o(view).add(aVar);
            W(view, 0);
        }
    }

    public static void b0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static z c(View view) {
        if (f3058g == null) {
            f3058g = new WeakHashMap<>();
        }
        z zVar = f3058g.get(view);
        if (zVar == null) {
            z zVar2 = new z(view);
            f3058g.put(view, zVar2);
            return zVar2;
        }
        return zVar;
    }

    public static void c0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    private static void d(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            G0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                G0((View) parent);
            }
        }
    }

    public static void d0(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    private static void e(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            G0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                G0((View) parent);
            }
        }
    }

    public static void e0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            f0(i2, view);
            W(view, 0);
        }
    }

    public static d0 f(View view, d0 d0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.b(view, d0Var, rect) : d0Var;
    }

    private static void f0(int i2, View view) {
        List<d.a> o = o(view);
        for (int i3 = 0; i3 < o.size(); i3++) {
            if (o.get(i3).b() == i2) {
                o.remove(i3);
                return;
            }
        }
    }

    public static d0 g(View view, d0 d0Var) {
        WindowInsets u;
        if (Build.VERSION.SDK_INT >= 21 && (u = d0Var.u()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(u);
            if (!dispatchApplyWindowInsets.equals(u)) {
                return d0.w(dispatchApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    public static void g0(View view, d.a aVar, CharSequence charSequence, c.h.k.e0.g gVar) {
        if (gVar == null && charSequence == null) {
            e0(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, gVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).b(view, keyEvent);
    }

    public static void h0(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).f(keyEvent);
    }

    public static void i0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static c.h.k.a j(View view) {
        View.AccessibilityDelegate k2 = k(view);
        if (k2 == null) {
            return null;
        }
        if (k2 instanceof a.C0067a) {
            return ((a.C0067a) k2).a;
        }
        return new c.h.k.a(k2);
    }

    private static g<Boolean> j0() {
        return new b(c.h.c.M, Boolean.class, 28);
    }

    private static View.AccessibilityDelegate k(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return l(view);
    }

    public static void k0(View view, c.h.k.a aVar) {
        if (aVar == null && (k(view) instanceof a.C0067a)) {
            aVar = new c.h.k.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    private static View.AccessibilityDelegate l(View view) {
        if (f3060i) {
            return null;
        }
        if (f3059h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3059h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f3060i = true;
                return null;
            }
        }
        try {
            Object obj = f3059h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f3060i = true;
            return null;
        }
    }

    public static void l0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void m0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static CharSequence n(View view) {
        return a0().d(view);
    }

    public static void n0(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof u) {
            ((u) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    private static List<d.a> o(View view) {
        int i2 = c.h.c.H;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i2, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void o0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof u) {
            ((u) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static ColorStateList p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void p0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static PorterDuff.Mode q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof u) {
            return ((u) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void q0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static Rect r(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    @Deprecated
    public static void r0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static Display s(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (Q(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void s0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static float t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void t0(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    private static Rect u() {
        if (f3061j == null) {
            f3061j = new ThreadLocal<>();
        }
        Rect rect = f3061j.get();
        if (rect == null) {
            rect = new Rect();
            f3061j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void u0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void v0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof c.h.k.k) {
            ((c.h.k.k) view).setNestedScrollingEnabled(z);
        }
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void w0(View view, q qVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(view, qVar);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void x0(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void y0(View view, t tVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (tVar != null ? tVar.a() : null));
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f3056e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f3055d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3056e = true;
        }
        Field field = f3055d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static void z0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }
}