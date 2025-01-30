package c.h.k.e0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import c.h.k.e0.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class d {
    private static int a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f3030b;

    /* renamed from: c  reason: collision with root package name */
    public int f3031c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f3032d = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a a = new a(1, null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f3033b = new a(2, null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f3034c = new a(4, null);

        /* renamed from: d  reason: collision with root package name */
        public static final a f3035d = new a(8, null);

        /* renamed from: e  reason: collision with root package name */
        public static final a f3036e = new a(16, null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f3037f = new a(32, null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f3038g = new a(64, null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f3039h = new a(128, null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f3040i = new a(256, null, g.b.class);

        /* renamed from: j  reason: collision with root package name */
        public static final a f3041j = new a(512, null, g.b.class);

        /* renamed from: k  reason: collision with root package name */
        public static final a f3042k = new a(1024, null, g.c.class);

        /* renamed from: l  reason: collision with root package name */
        public static final a f3043l = new a(PKIFailureInfo.wrongIntegrity, null, g.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(PKIFailureInfo.certRevoked, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(PKIFailureInfo.unsupportedVersion, null, g.C0070g.class);
        public static final a s = new a(PKIFailureInfo.transactionIdInUse, null);
        public static final a t = new a(PKIFailureInfo.signerNotTrusted, null);
        public static final a u = new a(PKIFailureInfo.badCertTemplate, null);
        public static final a v = new a(PKIFailureInfo.badSenderNonce, null, g.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object N;
        private final int O;
        private final Class<? extends g.a> P;
        protected final g Q;

        static {
            int i2 = Build.VERSION.SDK_INT;
            w = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            x = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, g.e.class);
            y = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            z = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            A = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            B = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            C = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            D = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            E = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            F = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            G = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            H = new a(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, g.f.class);
            I = new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, g.d.class);
            J = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            K = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            L = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            M = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.O, charSequence, gVar, this.P);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            if (this.Q != null) {
                g.a aVar = null;
                Class<? extends g.a> cls = this.P;
                if (cls != null) {
                    try {
                        g.a newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            newInstance.a(bundle);
                            aVar = newInstance;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = newInstance;
                            Class<? extends g.a> cls2 = this.P;
                            String name = cls2 == null ? "null" : cls2.getName();
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                            return this.Q.a(view, aVar);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return this.Q.a(view, aVar);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                Object obj2 = this.N;
                return obj2 == null ? aVar.N == null : obj2.equals(aVar.N);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.N;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.O = i2;
            this.Q = gVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.N = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.N = obj;
            }
            this.P = cls;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        final Object a;

        b(Object obj) {
            this.a = obj;
        }

        public static b a(int i2, int i3, boolean z, int i4) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
            }
            if (i5 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new b(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        final Object a;

        c(Object obj) {
            this.a = obj;
        }

        public static c a(int i2, int i3, int i4, int i5, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new c(null);
        }

        public static c b(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
            }
            if (i6 >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new c(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: c.h.k.e0.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069d {
        final Object a;

        C0069d(Object obj) {
            this.a = obj;
        }

        public static C0069d a(int i2, float f2, float f3, float f4) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0069d(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4));
            }
            return new C0069d(null);
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3030b = accessibilityNodeInfo;
    }

    public static d J(d dVar) {
        return u0(AccessibilityNodeInfo.obtain(dVar.f3030b));
    }

    private void N(View view) {
        SparseArray<WeakReference<ClickableSpan>> s = s(view);
        if (s != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < s.size(); i2++) {
                if (s.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                s.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void P(int i2, boolean z) {
        Bundle p = p();
        if (p != null) {
            int i3 = p.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            p.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f3030b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f3030b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f3030b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f3030b.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f3030b.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    private static String i(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                switch (i2) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case PKIFailureInfo.wrongIntegrity /* 2048 */:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case PKIFailureInfo.certRevoked /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case PKIFailureInfo.unsupportedVersion /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    case PKIFailureInfo.transactionIdInUse /* 262144 */:
                        return "ACTION_EXPAND";
                    case PKIFailureInfo.signerNotTrusted /* 524288 */:
                        return "ACTION_COLLAPSE";
                    case PKIFailureInfo.badSenderNonce /* 2097152 */:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i2) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i2) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static ClickableSpan[] n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> q(View view) {
        SparseArray<WeakReference<ClickableSpan>> s = s(view);
        if (s == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(c.h.c.I, sparseArray);
            return sparseArray;
        }
        return s;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        return (SparseArray) view.getTag(c.h.c.I);
    }

    public static d u0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    private boolean v() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int w(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = a;
        a = i3 + 1;
        return i3;
    }

    public boolean A() {
        return this.f3030b.isClickable();
    }

    public boolean B() {
        return this.f3030b.isEnabled();
    }

    public boolean C() {
        return this.f3030b.isFocusable();
    }

    public boolean D() {
        return this.f3030b.isFocused();
    }

    public boolean E() {
        return this.f3030b.isLongClickable();
    }

    public boolean F() {
        return this.f3030b.isPassword();
    }

    public boolean G() {
        return this.f3030b.isScrollable();
    }

    public boolean H() {
        return this.f3030b.isSelected();
    }

    public boolean I() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3030b.isVisibleToUser();
        }
        return false;
    }

    public boolean K(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3030b.performAction(i2, bundle);
        }
        return false;
    }

    public void L() {
        this.f3030b.recycle();
    }

    public boolean M(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f3030b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.N);
        }
        return false;
    }

    public void O(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3030b.setAccessibilityFocused(z);
        }
    }

    public void Q(Rect rect) {
        this.f3030b.setBoundsInScreen(rect);
    }

    public void R(boolean z) {
        this.f3030b.setCheckable(z);
    }

    public void S(boolean z) {
        this.f3030b.setChecked(z);
    }

    public void T(CharSequence charSequence) {
        this.f3030b.setClassName(charSequence);
    }

    public void U(boolean z) {
        this.f3030b.setClickable(z);
    }

    public void V(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).a);
        }
    }

    public void W(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).a);
        }
    }

    public void X(CharSequence charSequence) {
        this.f3030b.setContentDescription(charSequence);
    }

    public void Y(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.setContentInvalid(z);
        }
    }

    public void Z(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.setDismissable(z);
        }
    }

    public void a(int i2) {
        this.f3030b.addAction(i2);
    }

    public void a0(boolean z) {
        this.f3030b.setEnabled(z);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3030b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.N);
        }
    }

    public void b0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3030b.setError(charSequence);
        }
    }

    public void c(View view) {
        this.f3030b.addChild(view);
    }

    public void c0(boolean z) {
        this.f3030b.setFocusable(z);
    }

    public void d0(boolean z) {
        this.f3030b.setFocused(z);
    }

    public void e(CharSequence charSequence, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 26) {
            return;
        }
        f();
        N(view);
        ClickableSpan[] n = n(charSequence);
        if (n == null || n.length <= 0) {
            return;
        }
        p().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", c.h.c.a);
        SparseArray<WeakReference<ClickableSpan>> q = q(view);
        for (int i3 = 0; i3 < n.length; i3++) {
            int w = w(n[i3], q);
            q.put(w, new WeakReference<>(n[i3]));
            d(n[i3], (Spanned) charSequence, w);
        }
    }

    public void e0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3030b.setHeading(z);
        } else {
            P(2, z);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f3030b;
            if (accessibilityNodeInfo == null) {
                if (dVar.f3030b != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(dVar.f3030b)) {
                return false;
            }
            return this.f3032d == dVar.f3032d && this.f3031c == dVar.f3031c;
        }
        return false;
    }

    public void f0(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f3030b.setHintText(charSequence);
        } else if (i2 >= 19) {
            this.f3030b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g0(CharSequence charSequence) {
        this.f3030b.setPackageName(charSequence);
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f3030b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new a(actionList.get(i2)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f3030b.setPaneTitle(charSequence);
        } else if (i2 >= 19) {
            this.f3030b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3030b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(View view) {
        this.f3031c = -1;
        this.f3030b.setParent(view);
    }

    public int j() {
        return this.f3030b.getActions();
    }

    public void j0(C0069d c0069d) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.setRangeInfo((AccessibilityNodeInfo.RangeInfo) c0069d.a);
        }
    }

    @Deprecated
    public void k(Rect rect) {
        this.f3030b.getBoundsInParent(rect);
    }

    public void k0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public void l(Rect rect) {
        this.f3030b.getBoundsInScreen(rect);
    }

    public void l0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3030b.setScreenReaderFocusable(z);
        } else {
            P(1, z);
        }
    }

    public CharSequence m() {
        return this.f3030b.getClassName();
    }

    public void m0(boolean z) {
        this.f3030b.setScrollable(z);
    }

    public void n0(boolean z) {
        this.f3030b.setSelected(z);
    }

    public CharSequence o() {
        return this.f3030b.getContentDescription();
    }

    public void o0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3030b.setShowingHintText(z);
        } else {
            P(4, z);
        }
    }

    public Bundle p() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f3030b.getExtras();
        }
        return new Bundle();
    }

    public void p0(View view) {
        this.f3032d = -1;
        this.f3030b.setSource(view);
    }

    public void q0(CharSequence charSequence) {
        if (androidx.core.os.a.a()) {
            this.f3030b.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f3030b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public CharSequence r() {
        return this.f3030b.getPackageName();
    }

    public void r0(CharSequence charSequence) {
        this.f3030b.setText(charSequence);
    }

    public void s0(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3030b.setVisibleToUser(z);
        }
    }

    public CharSequence t() {
        if (v()) {
            List<Integer> g2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> g3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> g4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> g5 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f3030b.getText(), 0, this.f3030b.getText().length()));
            for (int i2 = 0; i2 < g2.size(); i2++) {
                spannableString.setSpan(new c.h.k.e0.a(g5.get(i2).intValue(), this, p().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g2.get(i2).intValue(), g3.get(i2).intValue(), g4.get(i2).intValue());
            }
            return spannableString;
        }
        return this.f3030b.getText();
    }

    public AccessibilityNodeInfo t0() {
        return this.f3030b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb.append("; boundsInParent: " + rect);
        l(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(r());
        sb.append("; className: ");
        sb.append(m());
        sb.append("; text: ");
        sb.append(t());
        sb.append("; contentDescription: ");
        sb.append(o());
        sb.append("; viewId: ");
        sb.append(u());
        sb.append("; checkable: ");
        sb.append(y());
        sb.append("; checked: ");
        sb.append(z());
        sb.append("; focusable: ");
        sb.append(C());
        sb.append("; focused: ");
        sb.append(D());
        sb.append("; selected: ");
        sb.append(H());
        sb.append("; clickable: ");
        sb.append(A());
        sb.append("; longClickable: ");
        sb.append(E());
        sb.append("; enabled: ");
        sb.append(B());
        sb.append("; password: ");
        sb.append(F());
        sb.append("; scrollable: " + G());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> h2 = h();
            for (int i2 = 0; i2 < h2.size(); i2++) {
                a aVar = h2.get(i2);
                String i3 = i(aVar.b());
                if (i3.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    i3 = aVar.c().toString();
                }
                sb.append(i3);
                if (i2 != h2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int j2 = j();
            while (j2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(j2);
                j2 &= ~numberOfTrailingZeros;
                sb.append(i(numberOfTrailingZeros));
                if (j2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String u() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f3030b.getViewIdResourceName();
        }
        return null;
    }

    public boolean x() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f3030b.isAccessibilityFocused();
        }
        return false;
    }

    public boolean y() {
        return this.f3030b.isCheckable();
    }

    public boolean z() {
        return this.f3030b.isChecked();
    }
}