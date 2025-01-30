package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.rnscreens.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ScreenStack.java */
/* loaded from: classes2.dex */
public class h extends com.swmansion.rnscreens.d<i> {

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<i> f11030l;
    private final Set<i> m;
    private i n;
    private boolean p;
    private final m.g q;
    private final m.f t;

    /* compiled from: ScreenStack.java */
    /* loaded from: classes2.dex */
    class a implements m.g {
        a() {
        }

        @Override // androidx.fragment.app.m.g
        public void a() {
            if (h.this.f11017b.d0() == 0) {
                h hVar = h.this;
                hVar.A(hVar.n);
            }
        }
    }

    /* compiled from: ScreenStack.java */
    /* loaded from: classes2.dex */
    class b extends m.f {
        b() {
        }

        @Override // androidx.fragment.app.m.f
        public void onFragmentResumed(androidx.fragment.app.m mVar, Fragment fragment) {
            if (h.this.n == fragment) {
                h hVar = h.this;
                hVar.setupBackHandlerIfNeeded(hVar.n);
            }
        }
    }

    /* compiled from: ScreenStack.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ i a;

        c(i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h().bringToFront();
        }
    }

    /* compiled from: ScreenStack.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.d.values().length];
            a = iArr;
            try {
                iArr[b.d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.d.FADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f11030l = new ArrayList<>();
        this.m = new HashSet();
        this.n = null;
        this.p = false;
        this.q = new a();
        this.t = new b();
    }

    private void B() {
        ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new n(getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupBackHandlerIfNeeded(i iVar) {
        if (this.n.isResumed()) {
            this.f11017b.P0(this.q);
            this.f11017b.H0("RN_SCREEN_LAST", 1);
            i iVar2 = null;
            int i2 = 0;
            int size = this.f11030l.size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                i iVar3 = this.f11030l.get(i2);
                if (!this.m.contains(iVar3)) {
                    iVar2 = iVar3;
                    break;
                }
                i2++;
            }
            if (iVar == iVar2 || !iVar.o()) {
                return;
            }
            this.f11017b.j().A(iVar).h("RN_SCREEN_LAST").x(iVar).k();
            this.f11017b.e(this.q);
        }
    }

    public void A(i iVar) {
        this.m.add(iVar);
        m();
    }

    public void C() {
        if (this.p) {
            return;
        }
        B();
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        super.endViewTransition(view);
        if (this.p) {
            this.p = false;
            B();
        }
    }

    public com.swmansion.rnscreens.b getRootScreen() {
        int screenCount = getScreenCount();
        for (int i2 = 0; i2 < screenCount; i2++) {
            com.swmansion.rnscreens.b i3 = i(i2);
            if (!this.m.contains(i3.getFragment())) {
                return i3;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    public com.swmansion.rnscreens.b getTopScreen() {
        i iVar = this.n;
        if (iVar != null) {
            return iVar.h();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d
    public boolean j(g gVar) {
        return super.j(gVar) && !this.m.contains(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11017b.M0(this.t, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.fragment.app.m mVar = this.f11017b;
        if (mVar != null) {
            mVar.P0(this.q);
            this.f11017b.d1(this.t);
            if (!this.f11017b.v0()) {
                this.f11017b.H0("RN_SCREEN_LAST", 1);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // com.swmansion.rnscreens.d
    protected void q() {
        Iterator<i> it = this.f11030l.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!this.a.contains(next) || this.m.contains(next)) {
                getOrCreateTransaction().r(next);
            }
        }
        int size = this.a.size() - 1;
        i iVar = null;
        i iVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            i iVar3 = (i) this.a.get(size);
            if (!this.m.contains(iVar3)) {
                if (iVar2 != null) {
                    iVar = iVar3;
                    break;
                } else if (iVar3.h().getStackPresentation() != b.e.TRANSPARENT_MODAL) {
                    iVar2 = iVar3;
                    break;
                } else {
                    iVar2 = iVar3;
                }
            }
            size--;
        }
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            i iVar4 = (i) it2.next();
            if (iVar4 != iVar2 && iVar4 != iVar && !this.m.contains(iVar4)) {
                getOrCreateTransaction().r(iVar4);
            }
        }
        if (iVar != null && !iVar.isAdded()) {
            getOrCreateTransaction().b(getId(), iVar).u(new c(iVar2));
        }
        if (iVar2 != null && !iVar2.isAdded()) {
            getOrCreateTransaction().b(getId(), iVar2);
        }
        int i2 = 4099;
        int i3 = 8194;
        if (!this.f11030l.contains(iVar2)) {
            i iVar5 = this.n;
            if (iVar5 != null && iVar2 != null) {
                if (this.a.contains(iVar5) || iVar2.h().getReplaceAnimation() != b.c.POP) {
                    i3 = 4097;
                }
                int i4 = d.a[iVar2.h().getStackAnimation().ordinal()];
                if (i4 == 1) {
                    i2 = 0;
                } else if (i4 != 2) {
                    i2 = i3;
                }
                getOrCreateTransaction().z(i2);
            }
        } else {
            i iVar6 = this.n;
            if (iVar6 != null && !iVar6.equals(iVar2)) {
                int i5 = d.a[this.n.h().getStackAnimation().ordinal()];
                if (i5 == 1) {
                    i2 = 0;
                } else if (i5 != 2) {
                    i2 = 8194;
                }
                getOrCreateTransaction().z(i2);
            }
        }
        this.n = iVar2;
        this.f11030l.clear();
        this.f11030l.addAll(this.a);
        v();
        i iVar7 = this.n;
        if (iVar7 != null) {
            setupBackHandlerIfNeeded(iVar7);
        }
        Iterator<i> it3 = this.f11030l.iterator();
        while (it3.hasNext()) {
            it3.next().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d
    public void r() {
        this.m.clear();
        super.r();
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        super.startViewTransition(view);
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d
    public void t(int i2) {
        this.m.remove(i(i2).getFragment());
        super.t(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.d
    /* renamed from: z */
    public i e(com.swmansion.rnscreens.b bVar) {
        return new i(bVar);
    }
}