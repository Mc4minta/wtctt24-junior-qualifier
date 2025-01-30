package c.h.k;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import c.h.k.e0.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f2998b;

    /* renamed from: c  reason: collision with root package name */
    private final View.AccessibilityDelegate f2999c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: c.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0067a extends View.AccessibilityDelegate {
        final a a;

        C0067a(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c.h.k.e0.e b2 = this.a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c.h.k.e0.d u0 = c.h.k.e0.d.u0(accessibilityNodeInfo);
            u0.l0(v.V(view));
            u0.e0(v.P(view));
            u0.h0(v.n(view));
            u0.q0(v.G(view));
            this.a.g(view, u0);
            u0.e(accessibilityNodeInfo.getText(), view);
            List<d.a> c2 = a.c(view);
            for (int i2 = 0; i2 < c2.size(); i2++) {
                u0.b(c2.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.a.j(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.a.l(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(a);
    }

    static List<d.a> c(View view) {
        List<d.a> list = (List) view.getTag(c.h.c.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] n = c.h.k.e0.d.n(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; n != null && i2 < n.length; i2++) {
                if (clickableSpan.equals(n[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(c.h.c.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (e(clickableSpan, view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2998b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c.h.k.e0.e b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f2998b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new c.h.k.e0.e(accessibilityNodeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f2999c;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f2998b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, c.h.k.e0.d dVar) {
        this.f2998b.onInitializeAccessibilityNodeInfo(view, dVar.t0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f2998b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2998b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i2, Bundle bundle) {
        List<d.a> c2 = c(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= c2.size()) {
                break;
            }
            d.a aVar = c2.get(i3);
            if (aVar.b() == i2) {
                z = aVar.d(view, bundle);
                break;
            }
            i3++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f2998b.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != c.h.c.a) ? z : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i2) {
        this.f2998b.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f2998b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2998b = accessibilityDelegate;
        this.f2999c = new C0067a(this);
    }
}