package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import java.util.Map;

/* compiled from: UIImplementation.java */
/* loaded from: classes2.dex */
public class m0 {
    protected Object a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.facebook.react.uimanager.events.d f5160b;

    /* renamed from: c  reason: collision with root package name */
    protected final ReactApplicationContext f5161c;

    /* renamed from: d  reason: collision with root package name */
    protected final f0 f5162d;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f5163e;

    /* renamed from: f  reason: collision with root package name */
    private final t0 f5164f;

    /* renamed from: g  reason: collision with root package name */
    private final m f5165g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f5166h;

    /* renamed from: i  reason: collision with root package name */
    private long f5167i;

    /* renamed from: j  reason: collision with root package name */
    protected b f5168j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIImplementation.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ y a;

        a(y yVar) {
            this.a = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m0.this.f5162d.b(this.a);
        }
    }

    /* compiled from: UIImplementation.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(y yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(ReactApplicationContext reactApplicationContext, y0 y0Var, com.facebook.react.uimanager.events.d dVar, int i2) {
        this(reactApplicationContext, y0Var, new t0(reactApplicationContext, new l(y0Var), i2), dVar);
    }

    private void A(int i2, int[] iArr) {
        y c2 = this.f5162d.c(i2);
        if (c2 != null) {
            y parent = c2.getParent();
            if (parent != null) {
                B(c2, parent, iArr);
                return;
            }
            throw new IllegalViewOperationException("View with tag " + i2 + " doesn't have a parent!");
        }
        throw new IllegalViewOperationException("No native view for tag " + i2 + " exists!");
    }

    private void B(y yVar, y yVar2, int[] iArr) {
        int i2;
        int i3;
        if (yVar != yVar2) {
            i2 = Math.round(yVar.S());
            i3 = Math.round(yVar.O());
            for (y parent = yVar.getParent(); parent != yVar2; parent = parent.getParent()) {
                e.f.k.a.a.c(parent);
                c(parent);
                i2 += Math.round(parent.S());
                i3 += Math.round(parent.O());
            }
            c(yVar2);
        } else {
            i2 = 0;
            i3 = 0;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = yVar.B();
        iArr[3] = yVar.c();
    }

    private void C(y yVar) {
        if (yVar.l()) {
            for (int i2 = 0; i2 < yVar.b(); i2++) {
                C(yVar.a(i2));
            }
            yVar.U(this.f5165g);
        }
    }

    private void M(y yVar) {
        m.j(yVar);
        this.f5162d.g(yVar.q());
        for (int b2 = yVar.b() - 1; b2 >= 0; b2--) {
            M(yVar.a(b2));
        }
        yVar.p();
    }

    private void c(y yVar) {
        ViewManager viewManager = (ViewManager) e.f.k.a.a.c(this.f5163e.a(yVar.L()));
        if (viewManager instanceof f) {
            f fVar = (f) viewManager;
            if (fVar == null || !fVar.needsCustomLayoutForChildren()) {
                return;
            }
            throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + yVar.L() + "). Use measure instead.");
        }
        throw new IllegalViewOperationException("Trying to use view " + yVar.L() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }

    private void d(int i2, String str) {
        if (this.f5162d.c(i2) != null) {
            return;
        }
        throw new IllegalViewOperationException("Unable to execute operation " + str + " on view with tag: " + i2 + ", since the view does not exists");
    }

    private void o() {
        if (this.f5164f.X()) {
            n(-1);
        }
    }

    private void y(int i2, int i3, int[] iArr) {
        y c2 = this.f5162d.c(i2);
        y c3 = this.f5162d.c(i3);
        if (c2 != null && c3 != null) {
            if (c2 != c3) {
                for (y parent = c2.getParent(); parent != c3; parent = parent.getParent()) {
                    if (parent == null) {
                        throw new IllegalViewOperationException("Tag " + i3 + " is not an ancestor of tag " + i2);
                    }
                }
            }
            B(c2, c3, iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Tag ");
        if (c2 != null) {
            i2 = i3;
        }
        sb.append(i2);
        sb.append(" does not exist");
        throw new IllegalViewOperationException(sb.toString());
    }

    public void D() {
    }

    public void E() {
        this.f5164f.Y();
    }

    public void F() {
        this.f5164f.b0();
    }

    public void G(l0 l0Var) {
        this.f5164f.Z(l0Var);
    }

    public void H() {
        this.f5164f.a0();
    }

    public <T extends View> void I(T t, int i2, i0 i0Var) {
        synchronized (this.a) {
            y h2 = h();
            h2.N(i2);
            h2.z(i0Var);
            i0Var.runOnNativeModulesQueueThread(new a(h2));
            this.f5164f.y(i2, t);
        }
    }

    public void J(int i2) {
        synchronized (this.a) {
            this.f5162d.h(i2);
        }
    }

    public void K(int i2) {
        J(i2);
        this.f5164f.L(i2);
    }

    protected final void L(y yVar) {
        M(yVar);
        yVar.dispose();
    }

    public void N(int i2) {
        y c2 = this.f5162d.c(i2);
        if (c2 != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i3 = 0; i3 < c2.b(); i3++) {
                createArray.pushInt(i3);
            }
            u(i2, null, null, null, null, createArray);
            return;
        }
        throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + i2);
    }

    public void O(int i2, int i3) {
        if (!this.f5162d.f(i2) && !this.f5162d.f(i3)) {
            y c2 = this.f5162d.c(i2);
            if (c2 != null) {
                y parent = c2.getParent();
                if (parent != null) {
                    int K = parent.K(c2);
                    if (K >= 0) {
                        WritableArray createArray = Arguments.createArray();
                        createArray.pushInt(i3);
                        WritableArray createArray2 = Arguments.createArray();
                        createArray2.pushInt(K);
                        WritableArray createArray3 = Arguments.createArray();
                        createArray3.pushInt(K);
                        u(parent.q(), null, null, createArray, createArray2, createArray3);
                        return;
                    }
                    throw new IllegalStateException("Didn't find child tag in parent");
                }
                throw new IllegalViewOperationException("Node is not attached to a parent: " + i2);
            }
            throw new IllegalViewOperationException("Trying to replace unknown view tag: " + i2);
        }
        throw new IllegalViewOperationException("Trying to add or replace a root tag!");
    }

    public int P(int i2) {
        if (this.f5162d.f(i2)) {
            return i2;
        }
        y Q = Q(i2);
        if (Q != null) {
            return Q.H();
        }
        e.f.d.d.a.A("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i2);
        return 0;
    }

    public final y Q(int i2) {
        return this.f5162d.c(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewManager R(String str) {
        return this.f5163e.c(str);
    }

    public void S(int i2, int i3) {
        this.f5164f.M(i2, i3);
    }

    public void T(int i2, ReadableArray readableArray) {
        synchronized (this.a) {
            y c2 = this.f5162d.c(i2);
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                y c3 = this.f5162d.c(readableArray.getInt(i3));
                if (c3 != null) {
                    c2.I(c3, i3);
                } else {
                    throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i3));
                }
            }
            this.f5165g.k(c2, readableArray);
        }
    }

    public void U(int i2, boolean z) {
        y c2 = this.f5162d.c(i2);
        if (c2 == null) {
            return;
        }
        while (c2.G() == k.NONE) {
            c2 = c2.getParent();
        }
        this.f5164f.N(c2.q(), i2, z);
    }

    public void V(boolean z) {
        this.f5164f.O(z);
    }

    public void W(com.facebook.react.uimanager.e1.a aVar) {
        this.f5164f.c0(aVar);
    }

    public void X(int i2, Object obj) {
        y c2 = this.f5162d.c(i2);
        if (c2 == null) {
            e.f.d.d.a.A("ReactNative", "Attempt to set local data for view with unknown tag: " + i2);
            return;
        }
        c2.E(obj);
        o();
    }

    public void Y(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        d(i2, "showPopupMenu");
        this.f5164f.P(i2, readableArray, callback, callback2);
    }

    public void Z(int i2, a0 a0Var) {
        UiThreadUtil.assertOnUiThread();
        this.f5164f.V().E(i2, a0Var);
    }

    public void a(l0 l0Var) {
        this.f5164f.Q(l0Var);
    }

    public void a0(int i2, int i3, int i4) {
        y c2 = this.f5162d.c(i2);
        if (c2 == null) {
            e.f.d.d.a.A("ReactNative", "Tried to update size of non-existent tag: " + i2);
            return;
        }
        c2.A(i3);
        c2.f(i4);
        o();
    }

    protected void b(y yVar, float f2, float f3) {
        if (yVar.l()) {
            Iterable<? extends y> n = yVar.n();
            if (n != null) {
                for (y yVar2 : n) {
                    b(yVar2, yVar.S() + f2, yVar.O() + f3);
                }
            }
            int q = yVar.q();
            if (!this.f5162d.f(q) && yVar.o(f2, f3, this.f5164f, this.f5165g) && yVar.J()) {
                this.f5160b.v(n.n(q, yVar.Q(), yVar.D(), yVar.B(), yVar.c()));
            }
            yVar.d();
            if (e.f.m.v.a.f12894h) {
                this.f5165g.p(yVar);
            }
        }
    }

    public void b0(int i2, int i3, int i4) {
        y c2 = this.f5162d.c(i2);
        if (c2 == null) {
            e.f.d.d.a.A("ReactNative", "Tried to update non-existent root tag: " + i2);
            return;
        }
        c0(c2, i3, i4);
    }

    public void c0(y yVar, int i2, int i3) {
        yVar.g(i2, i3);
    }

    public void d0(int i2, String str, ReadableMap readableMap) {
        if (this.f5163e.a(str) != null) {
            y c2 = this.f5162d.c(i2);
            if (c2 == null) {
                throw new IllegalViewOperationException("Trying to update non-existent view with tag " + i2);
            } else if (readableMap != null) {
                a0 a0Var = new a0(readableMap);
                c2.Z(a0Var);
                t(c2, str, a0Var);
                return;
            } else {
                return;
            }
        }
        throw new IllegalViewOperationException("Got unknown view type: " + str);
    }

    protected void e(y yVar) {
        com.facebook.systrace.b.a(0L, "cssRoot.calculateLayout").a("rootTag", yVar.q()).c();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            int intValue = yVar.getWidthMeasureSpec().intValue();
            int intValue2 = yVar.getHeightMeasureSpec().intValue();
            float f2 = Float.NaN;
            float size = View.MeasureSpec.getMode(intValue) == 0 ? Float.NaN : View.MeasureSpec.getSize(intValue);
            if (View.MeasureSpec.getMode(intValue2) != 0) {
                f2 = View.MeasureSpec.getSize(intValue2);
            }
            yVar.P(size, f2);
        } finally {
            com.facebook.systrace.a.g(0L);
            this.f5167i = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    protected void e0() {
        com.facebook.systrace.a.c(0L, "UIImplementation.updateViewHierarchy");
        for (int i2 = 0; i2 < this.f5162d.d(); i2++) {
            try {
                y c2 = this.f5162d.c(this.f5162d.e(i2));
                if (c2.getWidthMeasureSpec() != null && c2.getHeightMeasureSpec() != null) {
                    com.facebook.systrace.b.a(0L, "UIImplementation.notifyOnBeforeLayoutRecursive").a("rootTag", c2.q()).c();
                    C(c2);
                    com.facebook.systrace.a.g(0L);
                    e(c2);
                    com.facebook.systrace.b.a(0L, "UIImplementation.applyUpdatesRecursive").a("rootTag", c2.q()).c();
                    b(c2, 0.0f, 0.0f);
                    com.facebook.systrace.a.g(0L);
                    b bVar = this.f5168j;
                    if (bVar != null) {
                        this.f5164f.H(c2, bVar);
                    }
                }
            } finally {
                com.facebook.systrace.a.g(0L);
            }
        }
    }

    public void f() {
        this.f5164f.A();
    }

    @Deprecated
    public void f0(int i2, int i3, Callback callback) {
        y c2 = this.f5162d.c(i2);
        y c3 = this.f5162d.c(i3);
        if (c2 == null || c3 == null) {
            callback.invoke(Boolean.FALSE);
        } else {
            callback.invoke(Boolean.valueOf(c2.W(c3)));
        }
    }

    public void g(ReadableMap readableMap, Callback callback) {
        this.f5164f.B(readableMap, callback);
    }

    protected y h() {
        z zVar = new z();
        if (com.facebook.react.modules.i18nmanager.a.d().g(this.f5161c)) {
            zVar.j(com.facebook.yoga.h.RTL);
        }
        zVar.i("Root");
        return zVar;
    }

    protected y i(String str) {
        return this.f5163e.a(str).createShadowNodeInstance(this.f5161c);
    }

    public void j(int i2, String str, int i3, ReadableMap readableMap) {
        synchronized (this.a) {
            y i4 = i(str);
            y c2 = this.f5162d.c(i3);
            e.f.k.a.a.d(c2, "Root node with tag " + i3 + " doesn't exist");
            i4.N(i2);
            i4.i(str);
            i4.y(c2.q());
            i4.z(c2.F());
            this.f5162d.a(i4);
            a0 a0Var = null;
            if (readableMap != null) {
                a0Var = new a0(readableMap);
                i4.Z(a0Var);
            }
            s(i4, i3, a0Var);
        }
    }

    public void k() {
        this.f5164f.D();
    }

    @Deprecated
    public void l(int i2, int i3, ReadableArray readableArray) {
        d(i2, "dispatchViewManagerCommand");
        this.f5164f.E(i2, i3, readableArray);
    }

    public void m(int i2, String str, ReadableArray readableArray) {
        d(i2, "dispatchViewManagerCommand");
        this.f5164f.F(i2, str, readableArray);
    }

    public void n(int i2) {
        com.facebook.systrace.b.a(0L, "UIImplementation.dispatchViewUpdates").a("batchId", i2).c();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            e0();
            this.f5165g.o();
            this.f5164f.z(i2, uptimeMillis, this.f5167i);
        } finally {
            com.facebook.systrace.a.g(0L);
        }
    }

    public void p(int i2, float f2, float f3, Callback callback) {
        this.f5164f.G(i2, f2, f3, callback);
    }

    public Map<String, Long> q() {
        return this.f5164f.W();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0 r() {
        return this.f5164f;
    }

    protected void s(y yVar, int i2, a0 a0Var) {
        if (yVar.t()) {
            return;
        }
        this.f5165g.g(yVar, yVar.F(), a0Var);
    }

    protected void t(y yVar, String str, a0 a0Var) {
        if (yVar.t()) {
            return;
        }
        this.f5165g.m(yVar, str, a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r25 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r11 != r25.size()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        throw new com.facebook.react.uimanager.IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void u(int r21, com.facebook.react.bridge.ReadableArray r22, com.facebook.react.bridge.ReadableArray r23, com.facebook.react.bridge.ReadableArray r24, com.facebook.react.bridge.ReadableArray r25, com.facebook.react.bridge.ReadableArray r26) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.m0.u(int, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray):void");
    }

    public void v(int i2, Callback callback) {
        this.f5164f.J(i2, callback);
    }

    public void w(int i2, Callback callback) {
        this.f5164f.K(i2, callback);
    }

    public void x(int i2, int i3, Callback callback, Callback callback2) {
        try {
            y(i2, i3, this.f5166h);
            callback2.invoke(Float.valueOf(o.a(this.f5166h[0])), Float.valueOf(o.a(this.f5166h[1])), Float.valueOf(o.a(this.f5166h[2])), Float.valueOf(o.a(this.f5166h[3])));
        } catch (IllegalViewOperationException e2) {
            callback.invoke(e2.getMessage());
        }
    }

    public void z(int i2, Callback callback, Callback callback2) {
        try {
            A(i2, this.f5166h);
            callback2.invoke(Float.valueOf(o.a(this.f5166h[0])), Float.valueOf(o.a(this.f5166h[1])), Float.valueOf(o.a(this.f5166h[2])), Float.valueOf(o.a(this.f5166h[3])));
        } catch (IllegalViewOperationException e2) {
            callback.invoke(e2.getMessage());
        }
    }

    protected m0(ReactApplicationContext reactApplicationContext, y0 y0Var, t0 t0Var, com.facebook.react.uimanager.events.d dVar) {
        this.a = new Object();
        f0 f0Var = new f0();
        this.f5162d = f0Var;
        this.f5166h = new int[4];
        this.f5167i = 0L;
        this.f5161c = reactApplicationContext;
        this.f5163e = y0Var;
        this.f5164f = t0Var;
        this.f5165g = new m(t0Var, f0Var);
        this.f5160b = dVar;
    }
}